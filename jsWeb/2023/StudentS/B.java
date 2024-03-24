public class B {

    //B sends a message to a:A, therefore it needs to know a
    private A a;

    //the diagram didn't pass a on creation but in a separate init
    //this is not safe as can get null pointer exception, but this is the closest to the given diagram
    public void init (A a) {
        this.a = a;
    }
    public B bar() {
        return a.foo();
    }
}
