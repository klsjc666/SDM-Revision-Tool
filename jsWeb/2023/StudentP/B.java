public class B {
    public A a;

    public void init(A a) {
        this.a = a;
    }

    public B bar() {
        a.foo();
        return this;
    }
}