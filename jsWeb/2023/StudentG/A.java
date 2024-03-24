package com.example.demo;

public class A {
    public B foo(){
        var b2 = new B();
        b2.init(this);
        return b2;
    }
}
