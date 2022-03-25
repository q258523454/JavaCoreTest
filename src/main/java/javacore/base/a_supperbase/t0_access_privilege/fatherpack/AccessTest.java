package javacore.base.a_supperbase.t0_access_privilege.fatherpack;


import lombok.ToString;

@ToString
public class AccessTest {

    /**
     *             类内部  本包    子类    外部包
     *  public      Y     Y       Y       Y
     *  protected   Y     Y      [Y]      N
     *  default     Y     Y      [N]      N
     *  private     Y     N       N       N
     */

    /**
     * 私有变量
     */
    private int privateAttribute = 1;

    /**
     * default: 子类和外部package无法访问
     */
    int defalutAttribute = 2;

    /**
     * protected: 外部package无法访问
     */
    protected int protectedAttribute = 3;

    /**
     * public
     */
    public int publicAttribute = 4;
}
