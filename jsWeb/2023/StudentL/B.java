public class B {
	A a;

	public void init(A a) {
		this.a = a;
	}

	public B bar() {
		return this.a.foo();
	}
}