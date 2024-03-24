package lab_ass;

public class B {
	private A a;
	
	public void init(A a) {
		this.a = a;
	}
	
	public B bar() {
		B b2 = a.foo();
		return b2;
	}
}
