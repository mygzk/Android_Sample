package com.example.innerclass;

/**
 * Created by gzhenk on 16-2-25.
 * 内部类测试
 */
public class InnerTestJava {

    public static void main(String[] args) {
        InnerTestJava test = new InnerTestJava();

        Bean1 b1 = test.new Bean1();
        b1.out();

        Bean2 bean2 = new Bean2();
        bean2.out();


        InnerTestJava1 test1 = new InnerTestJava1();
        test1.out();

        int e = test.tryTest();

        System.out.println("tryTest 1 e=" + e);
    }

    private int tryTest() {
        int a = 0;
        try {
            System.out.println("tryTest 1 a=" + a);
            return 1;
        } catch (Exception e) {
            System.out.println("tryTest 2 a=" + a);
            System.out.println("tryTest 2");
            e.printStackTrace();
        } finally {
            System.out.println("tryTest 3 a=" + a);
            System.out.println("tryTest 3");
        }

        System.out.println("tryTest 4");

        return 0;
    }


    class Bean1 {
        public int i = 1;

        public void out() {
            System.out.println("Bean1: i=" + i);
        }
    }

    static class Bean2 {
        public int i = 2;

        public void out() {
            System.out.println("Bean2: i=" + i);
        }
    }



    public int method1(int a, int b) { return 0; }
    //private int method1(int a, int b) { return 0; }
    private int method1(int a, long b) { return 0; }
    //public short method1(int a, int b) { return 0; }
    //static protected int method1(int a, int b) { return 0; }

}
