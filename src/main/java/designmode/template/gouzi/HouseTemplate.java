package designmode.template.gouzi;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public abstract class HouseTemplate {
    protected String name;

    protected boolean is_buildPool;

    public HouseTemplate(String name) {
        this.name = name;
    }

    public HouseTemplate(String name, boolean is_buildPool) {
        this.name = name;
        this.is_buildPool = is_buildPool;
    }

    protected abstract void buildBase();

    protected abstract void buildWall();

    protected abstract void buildDoor();

    protected abstract void buildPool();

    protected void build() {
        buildBase();
        buildWall();
        buildDoor();

        // 这里就是钩子
        if (is_buildPool) {
            buildPool();
        }
    }
}
