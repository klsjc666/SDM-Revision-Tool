public class A{

private A a = new A();

public B foo(){
    B b2 = new B();
    b2.init(a);
    return b2;
}

}