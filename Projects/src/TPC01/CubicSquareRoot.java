package TPC01;
public class CubicSquareRoot {
	double x0;
	double number;
	int max = 8;
	boolean negative = false;

	//initializes variables
	public CubicSquareRoot(double number) {
		if(number < 0) {
			negative = true;
		}
		this.number = Math.abs(number);
		x0 = interval(this.number);
	}

	//Calculates approximation value
	public double interval(double number) {
		int val = (int) Math.pow(number, 0.333);
		return (double)((val + val + 1) / 2);
	}

	//Calculates function
	public double fn(double x) {
		return Math.pow(x, 3)-number;

	}
	//Calculates derivative function
	public double derfn(double x) {
		return 3 * Math.pow(x, 2);
	}

	//Calculates next iteration of the Newton - Raphson method
	public double fnnext(double x) {
		return x - fn(x) / derfn(x);
	}

	//Calculates and prints cubic root result
	public void calcRoot() {
		for(int i = 0; i < 8; i++) {
			x0 = fnnext(x0);
		}
		if(!negative) {
			System.out.println("A raiz cúbica de " + number + " é: " + x0);
		}else {
			x0 = -1*x0;
			this.number = -1* this.number;
			System.out.println("A raiz cúbica de " + number + " é: " + x0);
		}
	}

	public static void main(String[] args) {
		CubicSquareRoot b = new CubicSquareRoot(3);
		b.calcRoot();
	}
}

