package appli.calculadora;

public class Calculadora {
	public static double somar(double n1, double n2) {
		return n1 + n2;
	}
	public static double subtrair(double n1, double n2) {
		return n1 - n2;
	}
	public static double dividir(double n1, double n2) {
		if (n2 == 0 ) {
			throw new ArithmeticException("Não é possível calcular divisão por números negativos.");
	}else{
		return n1 / n2;
		}
	}
	public static double multiplicar(double n1, double n2) {
		return n1 * n2;
	}
	public static double media(double n1, double n2) {
		return (n1 + n2)/2;
	}
	
	public static double potencia(double n1, double n2) {
		return Math.pow(n1, n2);
	}
	public static double raiz(double n1) {
	if (n1 < 0) {
		throw new ArithmeticException("Não é possível calcular raiz de números negativos.");
	}else{
		return Math.sqrt(n1);
	}
	
	}
}
