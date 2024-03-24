package com.example.demo;

public class B {
    private A a = new A();
    public void init(A a){

    }
    public B bar(){
        var b2 = a.foo();
        return b2;
    }
}
