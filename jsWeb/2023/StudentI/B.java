public class B {
	
	A a1; 
	void init(A a) { 
		return;
	}
	//called by actor
	B bar() {
		return a1.foo(); 
	}
	
}
