package util;


/**
 * @Description SnowFlake算法
 *              UUID: 过长(36位),无序, 数据库查询效率不高. eg:47302f37-a80d-4bb1-90fd-bb5eb50857f5
 *              雪花: 仅18位, 按时间升序. eg:496014348603633738
 * @date 2020-08-26 15:03
 */
public class SnowFlakeUtil {
    /**
     * 起始的时间戳 2020.01.01 01:01:01
     */
    private final static long START_STMP = 1580490061347L;

    /**
     * 每一部分占用的位数
     * 上面的 数据中心和机器位可以根据实际情况调整, 合并成10位
     * java long 占8字节, 共64 bit 位（每部分用-分开）：
     * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 0000000000 00
     * 【0~41位时间戳+(5位数据中心标识+5位机器标识)+12位序列号】=64bit 可转换成18个字符
     * 1位标识，0表示正数
     * 41位时间戳，当前时间的毫秒减去开始时间的毫秒数。可用 (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69年
     * 5位数据中心标识，可支持(1L << 5) = 32个数据中心
     * 5位机器标识，每个数据中心可支持(1L << 5) = 32个机器标识
     * 12位序列号，每个节点每一毫秒支持(1L << 12) = 4096个序列号
     *
     * SnowFlake的优点：
     * 1.整体上按照时间自增排序
     * 2.整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)
     * 3.效率高,每秒能够产生26万ID左右
     * SnowFlake的缺点：
     * 1.依赖机器时钟，如果机器时钟回拨，会导致重复ID生成
     * 2.在单机上是递增的，但是由于设计到分布式环境，每台机器上的时钟不可能完全同步，
     *   有时候会出现不是全局递增的情况（此缺点可以认为无所谓，一般分布式ID只要求趋势递增，
     *   并不会严格要求递增～90%的需求都只要求趋势递增
     */
    private final static long MACHINE_BIT = 5;   // 机器标识占用的位数
    private final static long DATACENTER_BIT = 5;// 数据中心占用的位数
    private final static long SEQUENCE_BIT = 12; // 序列号占用的位数


    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    /**
     * 数据中心 占5位
     */
    private long datacenterId;

    /**
     * 机器标识 占5位
     */
    private long machineId;

    /**
     * 12位序列号
     */
    private long sequence = 0L;

    /**
     * 上一次时间戳
     */
    private long lastStmp = -1L;

    /**
     * 初始化SnowFlake
     * @param datacenterId 数据中心, 最大5bit, MAX=31
     * @param machineId 机器标识, 最大5bit, MAX=31
     */
    public SnowFlakeUtil(long datacenterId, long machineId) {
        // 整数最大不能超过31
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        // 整数最大不能超过31
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStmp = System.currentTimeMillis();
        if (currStmp < lastStmp) {
            throw new RuntimeException(String.format("雪花算法发生回调，当前时间%d,上次时间:%d", currStmp, lastStmp));
        }

        if (currStmp == lastStmp) {
            // 相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            // 同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            // 不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STMP) << TIMESTMP_LEFT // 时间戳部分
                | datacenterId << DATACENTER_LEFT       // 数据中心部分
                | machineId << MACHINE_LEFT             // 机器标识部分
                | sequence;                             // 序列号部分
    }

    /**
     * 等到下一个毫秒开始
     */
    private long getNextMill() {
        // 获取当前毫秒数
        long mill = System.currentTimeMillis();
        // 只要当前的毫秒数小于上次的时间戳，就一直循环，大于上次时间戳
        while (mill <= lastStmp) {
            // 获取当前毫秒数
            mill = System.currentTimeMillis();
        }
        return mill;
    }

    public static void main(String[] args) {
        // 模拟4个不同实例
        SnowFlakeUtil snowFlake1 = new SnowFlakeUtil(1, 1);
        SnowFlakeUtil snowFlake2 = new SnowFlakeUtil(1, 2);
        SnowFlakeUtil snowFlake3 = new SnowFlakeUtil(31, 3);
        SnowFlakeUtil snowFlake4 = new SnowFlakeUtil(31, 4);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            System.out.println(snowFlake1.nextId());
            System.out.println(snowFlake2.nextId());
            System.out.println(snowFlake3.nextId());
            System.out.println(snowFlake4.nextId());
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}
