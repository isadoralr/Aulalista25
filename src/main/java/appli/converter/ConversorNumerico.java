package appli.converter;

import java.util.logging.Logger;

import appli.controller.Controller;

public class ConversorNumerico {
	public static boolean ehNumerico(String strNumero) {
		Logger logger = Logger.getLogger(Controller.class.getName()); 
		if (strNumero == null) {
			logger.info("Valor ausente!");
			return false;
		}
		
		String numero = strNumero.replaceAll(",", ".");
		
		try {
			System.out.println(Double.parseDouble(numero));
			return true; 
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	public static Double converterParaDouble(String strNumero) {
		if (strNumero == null) {
			return 0d;
		}
		
		String numero = strNumero.replaceAll(",", ".");
		if (ehNumerico(numero)) {
			return Double.parseDouble(numero);
		}
		
		return 0d;
	}
}
