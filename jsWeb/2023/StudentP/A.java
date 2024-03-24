public class A {
    public A a;

    public B foo() {
        B b2 = new B();
        b2.init(a);
        return b2.bar();
    }
}
