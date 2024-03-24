public class A {


    public A()
    {

    }

    //foo Creates and returns new B object
    public B foo(){
        B b2 = new B(this);
        return b2.init(this);
    }
}
