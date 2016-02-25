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

}
