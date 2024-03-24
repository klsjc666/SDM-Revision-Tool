public class B{

    private B b1 = new B(); //not sure what values should be
    private A a = new A(); //not sure what values should be

public B bar(){
    b1 = a.foo();
    return b1;
}

public void init(A a){}
    //not sure what the init does
}