package com.example.innerclass;


import com.example.Fruite;

/**
 * Created by gzhenk on 16-2-25.
 */
public class Banena extends Fruite {


    public void setName() {
        System.out.println("" + name);
    }

    @Override
    public void changeName() {

    }

    short s1 = 1;

    public void changeName(int q) {
        //s1 = s1+1;
        s1 += 1;
    }
    @Override
    public int changeName(int q, String s) {
        return 0;
    }


}
