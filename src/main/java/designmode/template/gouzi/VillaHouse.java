package designmode.template.gouzi;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class VillaHouse extends HouseTemplate {
    public VillaHouse(String name) {
        super(name);
    }

    public VillaHouse(String name, boolean is_buildPool) {
        super(name, is_buildPool);
    }

    @Override
    protected void buildBase() {
        System.out.println(name + "建造基地");
    }

    @Override
    protected void buildWall() {
        System.out.println(name + "建造围墙");
    }

    @Override
    protected void buildDoor() {
        System.out.println(name + "建造门");
    }

    @Override
    protected void buildPool() {
        System.out.println(name + "建造游泳池");
    }

}
