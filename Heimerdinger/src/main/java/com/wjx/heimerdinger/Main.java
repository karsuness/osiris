package com.wjx.heimerdinger;

/**
 * @author wangjinxin
 * @date 2021/1/13 18:35
 * @mail wjxScott@163.com
 * @description
 */
public class Main {
    public static void main1(String[] args) {
//        JavaClass javaClass = new JavaClass();
//        javaClass.method1();
//        SupClass supClass = new SupClass(500);
//        supClass.setC(500);
//        Riven riven = new Riven();
//        System.out.println(riven.getA());
////        System.out.println(riven.getB());
////        System.out.println(riven.getC());
//        riven.setA(5000);
//        Map map = new HashMap();
//        map.put("a",riven);
//        Riven a = (Riven)map.get("a");
//        System.out.println(((Riven)map.get("a")).toString());
//        a.setA(777);
//        System.out.println(((Riven)map.get("a")).toString());

        double a = 25 / 2;
        System.out.println(a);

    }

    public static void main(String[] args) {
        System.out.println(method());
    }

    public static int method() {
        int a = 10;
        try {
            a = a / 0;
            System.out.println("this is try code");
        } catch (Exception e) {
            a = 20;
            System.out.println("this is catch code");
            return a; //☆
        } finally {
            a = 30;
            System.out.println("this is finally code");
        }
        return a;
    }
}
