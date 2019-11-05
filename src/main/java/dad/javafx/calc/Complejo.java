package dad.javafx.calc;


public class Complejo {

	private Double real;
	private Double imaginario;

	public Complejo() {

	}

	private Complejo(double a, double b) {
		setReal(a);
		setImaginario(b);
	}

	public Double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public Double getImaginario() {
		return imaginario;
	}

	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}

	public Complejo add(Complejo otro) {
		return new Complejo(this.getReal() + otro.getReal(), // real
				this.getImaginario() + otro.getImaginario() // imaginario
		);
	}

	public Complejo sustract(Complejo otro) {
		return new Complejo(this.getReal() - otro.getReal(), //real
				this.getImaginario() - otro.getImaginario());//imaginario
	}

	public Complejo multiply(Complejo otro) {
		double ab = this.getReal()*otro.getReal();
		double cd = this.getImaginario()*otro.getImaginario();
		return new Complejo(ab+cd,ab-cd);
	}
	
	
	public Complejo divide(Complejo otro) {
		double divisor = (Math.pow(otro.getReal(), 2) + Math.pow(otro.getImaginario(), 2));
		double ab = this.getReal() * otro.getReal();
		double cd = this.getImaginario() * otro.getImaginario();
		return new Complejo((ab + cd)/divisor,(ab - cd)/ divisor);

	}
}
