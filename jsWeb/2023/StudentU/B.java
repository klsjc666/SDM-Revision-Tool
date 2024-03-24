public class B {

    private A a;
    public B bar() {
        B b2 = a.foo();
        return b2;
    }

    public void init(A a) {}

}