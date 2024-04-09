package com.methodoverloading;

//Method Overloading
//Case Study1 - Automatic Type Promotion
//Exact match will get the highest priority in overloading.
//type promotion/automatic type promotion on method overloading.
//byte --> short --> int --> long --> float --> double
//char --> int
class A
{
	public void m1(int i)
	{
		System.out.println("int-arg method");
	}
	
	public void m1(float f)
	{
		System.out.println("float-arg method");
	}
}


//Case Study2 - Objects as arguments - Parent and Child class argument 
//Object (parent) --> String (child)
class B
{
	
	public void m1(Object o)
	{
		System.out.println("Object Version");
	}
	
	public void m1(String s)
	{
		System.out.println("String Version");
	}
}


//Case Study3 - child class objects as arguments
//Object (parent) --> String (child)
//Object (parent) --> StringBuffer (child)
class C
{
	public void m1(String S)
	{
		System.out.println("String Version");
	}
	
	public void m1(StringBuffer Sb)
	{
		System.out.println("StringBufer Version");
	}
}


//Case Study4 - Var-args method and General method
//Var-args Concept (New concept comes from !.5 version)
class D
{
	public void m1(int i)
	{
		System.out.println("General Method");
	}
	
	public void m1(int... i)
	{
		System.out.println("Var-args Method");
	}
}


//Case Study5 - Compile-time error -  reference to method ambiguity because Both methods are manageable 
class E
{
	public void m1(int i,float f)
	{
		System.out.println("int-float version");
	}
	
	public void m1(float f,int i)
	{
		System.out.println("float-int version");
	}
}


//Case Study6 - Parent reference with Child Object
class Animal
{
	public void m1(Animal a1)
	{
		System.out.println("Animal Version");
	}
}

class Monkey extends Animal
{
	public void m1(Monkey m1)
	{
		System.out.println("Monkey Version");
	}
}


public class LaunchDemo 
{

	public static void main(String[] args) 
	{
		
		A a = new A();
		
		a.m1(10);       //invokes int-arg method
		a.m1(10.5f);    //invokes float-arg method
		a.m1('c');      //char --> int, type promotion, it will invokes the int-arg method because char type is promoted to int type, so int-arg method invokes.
        a.m1(20L);      //long --> float, type promotion, it invokes the float-arg method
		//a.m1(30.5);     //compile-time error beacuse it is default value, there is no next level type promotion 
		
		B b = new B();
		
		b.m1(new Object());   //Object version method invokes.
		b.m1("Naveen");       //String Version method invokes.
		//child class argument will get invoked that is String argument method invoked.
		b.m1(null);           //String version method invokes, because in overloading object are involved in arguments, if both parent and child class argument matches, then child class argument gets the highest priority, if the child class argument is not there then the parent class argument will het invoked.
		
		C c = new C();
		
		c.m1("Naveen");       //String version method invokes.
		c.m1(new StringBuffer("Nakka"));   //StringBuffer version method invokes.
		//Object (parent)--> String (child)--> StringBuffer(child)
		//c.m1(null);      //compile-time error because both are child class arguments there is ambiguity between the two child class arguments methods.
		
		D d = new D();
	
		d.m1();         //var-args method invokes
		d.m1(10,20);    //var-args method invokes
		//compiler will always gives the least priority to the var-args if exact method is not there.
		d.m1(10);       //both are matched but general method invokes because old version of method gets the chance first compared to new concept(var-args concept).
		
		E e = new E();
		
		e.m1(10, 20.5f);    //int-float method invokes
		e.m1(30.5f, 10);    //float-int method invokes
		//e.m1(10, 10);     //compile-time error as reference to m1 is ambiguous because both are manageable, ambiguity between two methods.
		//e.m1(20.5f, 20.5);  //Compile-time error as no suitable method for m1(float,float) because no method matched.
		
		Animal a1 = new Animal();
		a1.m1(a1);                //Animal Version
		
		Monkey m1 = new Monkey();
		m1.m1(m1);                //Monkey Version
		
		//Resolution done at compile-time polymorphism
		Animal a2 = new Monkey(); 
		a2.m1(new Monkey());      //Animal Version because method resolution done at compile-time not run time in Overloading.
		
	}
	

}
