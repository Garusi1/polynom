package myMath;
import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers	
/**
 * The test object (main) contains tests of the important the functions, divided by tow types of tests: 
1.	positive  – should run, and return correct calculation or answer.
2.	negative -  should return an error or 0.

 * @author mgaru
 *
 */

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
for (int i = 0; i < args.length; i++) {
	String string = args[i];
}
		//monoms test:
		Monom m = new Monom(2,0); //
		Monom n = new Monom(m);
		System.out.println("print monom= "+m.f(6));		    //print monom 2.0
		System.out.println("print monoms derivative= "+m.derivative()); // print monoms derivative= 0
		
		//constractors test:
		Polynom  p  = new Polynom("-1*x^1+1.4+5x^5"); 		// string to polynom constructor
		Polynom  b  = new Polynom(p); 						// copy polynom
		System.out.println("does the copy constructor works? "+p.equals(b));  //tests the copy constructor the ans should be true
		Polynom  v  = new Polynom(); 						// empty polynom
		v.add(m);											// add monom to polynom
		
//		Polynom  eror  = new Polynom("jf80x^3"); 	   	   // should return runtime eror
//		Polynom  eror1  = new Polynom("5x"); 		       // should return runtime eror no '^' 
//		Polynom  err2 = new Polynom("x^4"); 				// no coefficent before x
//		Polynom  eror2 = new Polynom("5x^-5"); 		       // should return runtime eror negative power
		
		System.out.println("polynom v="+v +"  sholde be equals to monom m= " +m);

		
		//function test:
		System.out.println("p value at point: "+p.f(0));							//value of polynom p test, the ans should be: 1.4
		System.out.println("p tostring: " +p.toString()); 					//to string test the ans should be: 1.4*x^0+-1.0*x^1+5.0*x^5
		System.out.println("p derivative: "+p.derivative());				 	//derivative test the ans should be: -1.0*x^0+25.0*x^4
		System.out.println("p area: "+p.area(0, 5, 0.001)); 			//area test the correct answer should be: 13015.3 depends on the epsilon
		p.multiply(b); 
		b.substract(p); 
		System.out.println("b substract p*b: "+b);								//substract test, the ans: -0.56*x^0+1.8*x^1-1.0*x^2-9.0*x^5+10.0*x^6-25.0*x^10
		System.out.println("p multiplied b substract p*b"+p);					//multiply test, 1.96*x^0-2.8*x^1+1.0*x^2+14.0*x^5-10.0*x^6+25.0*x^10
		
//		root test
		Polynom  c  = new Polynom("1*x^1-2");
		System.out.println("root =2 test: "+c.root(1, 5, 0.01));		//the correct answer should be: 2
		Polynom rootErr = new Polynom ("22");
		System.out.println( "no root test: "+rootErr.root(0, 100, 0.001));	// no root 
		
//		area test
		Polynom  areaEmpt  = new Polynom("-3"); 					// all of the function is below the x
		System.out.println("area 0.0 test: " +areaEmpt.area(0, 100, 0.001));	// no area should return 0.0


		
		Polynom  a  = new Polynom("1x^1-2*x^0");			//same input as c different strings
		
		System.out.println(a.equals(c)); 					// true

		// action on zero polynom
		
		Polynom  emp  = new Polynom();						
		Polynom  notEmp = new Polynom("1*x^2"); 			
		notEmp.add(emp);					
		System.out.println("the ans should be notemp= " +notEmp);
		notEmp.multiply(emp);
		System.out.println("the ans should be nothing " +notEmp);
		

		
		
		
	}

}
