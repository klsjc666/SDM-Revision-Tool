public class B {

  private A a;

  public void bar() {
    a.foo();
  }

  public A init(A a){
    return a;
  }
}
