
public class B {
	A a;
	
	public void init(A a) {
	}
	
	public B bar()
	{
		B b2 = a.foo();
		return b2;
	}
}
