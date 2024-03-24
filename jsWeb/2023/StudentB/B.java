public class B {
    A refToA; //reference to a:A called to by b1:B in diagram
    public String init(A a){
        return "";
    }
    public B bar(){
        B b2 = refToA.foo();
        return b2;
    }
}
