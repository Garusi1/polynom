
package myMath;

import javax.management.RuntimeErrorException;



/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and b is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	
//	constructors
	
	
	public Monom(double a, int b){ //full constructor
		this.set_coefficient(a);
		try {
			this.set_power(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Monom(Monom ot) { // copy constructor
		this.set_coefficient(ot._coefficient);
		try {
			this.set_power(ot._power);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double get_coefficient() {
		return _coefficient;
	}

	
	// ***************** add your code below **********************

	// return the value of the function at the point x
	public double f (double x) {
		return (this._coefficient*(Math.pow(x, this._power)));
	}
	
	// return the derivative of the function

	public Monom derivative() {
		if(this._power==0)
			return new Monom(0, 0);
		return new Monom((this._coefficient*(this._power)), (this._power-1));
		
	}
	
	// multiply those tow monoms

	public void multiply (Monom m) {
		
		this._coefficient=this._coefficient*m._coefficient;
		this._power=this._power+m._power;
		
		}
	public boolean equals(Monom m){
		return(this._coefficient==m._coefficient&&this._power==m._power);
	}


	//add one monon to another
	public void add (Monom m) {
		if(this._power!= m._power)
			throw new RuntimeErrorException (null, "Eror: differente powers");
		this._coefficient+=m._coefficient;
	}
	
 	@Override
 	public String toString() // is will be used at the polynom class
 	{
 		if(this._coefficient==0)
 			return ("0");
 		// TODO Auto-generated method stub
 		return (this._coefficient +"*x^"+this._power);
 	}
	

	//****************** Private Methods and Data *****************
	
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) throws Exception {
		if (p<0) throw new Exception ("wrong power");
		_power = p;
	}
	
	private double _coefficient;
	private int _power;
	public int get_power() {
		return _power;
	} 
}
