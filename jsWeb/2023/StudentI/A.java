public class A {
	B foo() { 
		B b2 = new B(); //creates new B object 
		b2.init(this);  //runs init() method parsing self
		return b2;	  // returns new B object 
	}
}
