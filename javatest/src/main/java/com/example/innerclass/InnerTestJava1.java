package com.example.innerclass;

/**
 * Created by gzhenk on 16-2-25.
 */
public class InnerTestJava1 {

    public void out(){
        InnerTestJava inJava = new InnerTestJava();
        InnerTestJava.Bean1 b1= inJava.new Bean1();
        b1.i++;
        b1.out();

        InnerTestJava.Bean2 b2 = new InnerTestJava.Bean2();
        b2.i++;
        b2.out();
    }



}
