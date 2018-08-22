package javacore;

/** 该enum对应 PoolInitialStatistics.type_code。我们只选取了希望显示的统计指标。
 * 枚举值的顺序是特意安排的，统计结果会按照以下枚举顺序返回给前端。
 */
public enum Measure {
    _544002001("借款人数量"), _544003008("借款人数量占比"),
    _544002002("贷款笔数"), _544003009("贷款笔数占比"),
    _544002003("合同数量"), _544003010("合同数量占比"),
    _544001002("合同金额"), _544003007("合同金额占比"),
    _544001001("本金余额"), _544003006("本金余额占比"),
    _544001003("单笔贷款最高本金金额"),_544001004("单笔贷款平均本金金额"),
    _544003003("单笔贷款最高贷款年利率"),_544003002("加权平均贷款年利率"),
    _544004004("单笔贷款最长剩余期限"),_544004001("加权平均贷款合同期限"),
    _544004002("加权平均贷款剩余期限");

    public final String cn;

    private Measure(String name) {
        this.cn = name;
    }

    public static void main(String[] args) {
        Measure m=Measure.valueOf("_544002003");
        System.out.println(Measure.valueOf("_544002003"));
        System.out.println(m.cn);
    }
}
