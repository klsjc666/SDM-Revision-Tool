public class B {
    A a = new A();

    public void init(A a) {
    }

    public B bar() {
        B b2 = a.foo();
        return b2;
    }
}
