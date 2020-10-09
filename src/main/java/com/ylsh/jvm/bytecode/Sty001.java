package com.ylsh.jvm.bytecode;

public class Sty001 {

    private int a = 1;

    public int getA(){
        return a;
    }

    public void setA(int a){
        this.a = a;
    }

    public static void main(String[] args) {
        Sty001 sty001 = new Sty001();
    }

}
class Parent001{
    public static String pStr = "p hello";

    static{
        System.out.println("parent001 static block");
    }
}
class Child001 extends Parent001{
    public static String cStr = "c hello";

    static{
        System.out.println("child001 static block");
    }
}
