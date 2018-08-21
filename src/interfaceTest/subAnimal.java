package interfaceTest;

/**
 * Created by mac on 17/8/18.
 */
/* 文件名 : MammalInt.java */
public class subAnimal implements Animal{

    public void eat(){
        System.out.println("Mammal eats");
    }

    public void travel(){
        System.out.println("Mammal travels");
    }

    public int noOfLegs(){
        return 0;
    }

    public static void main(String args[]) {

    }
}