public class A {
    public B foo(){
        B b2 = new B();
        b2.init(this); //this = a:A
        return b2;
    }
}
