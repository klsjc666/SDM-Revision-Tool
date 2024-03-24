public class B {

    // B calls a method from A, thus it must contain an A object
    private A a;

    //Overloading to allow B to be created with or without an existing A
    //Called By a.foo()
    public B(A a)
    {
        this.a = a;
    }
    public B()
    {
        this.a = new A();
    }

    //Bar returns new B object by calling method from A, an A object
    public B bar()
    {
        return a.foo();
    }
    //Called by A in foo method after object creation;
    public B init(A a)
    {
        return this;
    }
}
