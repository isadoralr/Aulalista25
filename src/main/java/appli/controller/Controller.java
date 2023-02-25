package appli.controller;


import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import appli.calculadora.Calculadora;
import appli.converter.ConversorNumerico;

@RestController
@RequestMapping("/api/calculos")
public class Controller {
	private Logger logger = Logger.getLogger(Controller.class.getName()); 
    
    @GetMapping("/somar-query")
    public Double somarQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1,
    						 @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	return Calculadora.somar(n1,n2);
    }
    
    @RequestMapping(value = "/somar-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double somarPath(@PathVariable("n1") String n1,
    					    @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando... " + n1 + " + " + n2);
    	
    	if (!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	
    	return Calculadora.somar(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    
    @GetMapping("/subtrair-query")
    public Double subtrairQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1,
    						 @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	return Calculadora.subtrair(n1,n2);
    }
    
    @RequestMapping(value = "/subtrair-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double subtrairPath(@PathVariable("n1") String n1,
    					    @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando " + n1 + " - " + n2);
    	
    	if (!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	
    	return Calculadora.subtrair(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    
    @GetMapping("/dividir-query")
    public Double dividirQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1,
    						 @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	try {return Calculadora.dividir(n1, n2);}
    	catch(ArithmeticException e) {
    		logger.warning("Número igual a 0");
        	return 0d;
    	}
    }
    
    @RequestMapping(value = "/dividir-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double dividirPath(@PathVariable("n1") String n1,
    					    @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando " + n1 + " / " + n2);
    	
    	if (!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	
    	try {return Calculadora.dividir(ConversorNumerico.converterParaDouble(n1),ConversorNumerico.converterParaDouble(n2));}
    	catch(ArithmeticException e) {
    		logger.warning("Número igual a 0");
        	return 0d;
    	}
    }
    
    @GetMapping("/multiplicar-query")
    public Double multiplicarQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1,
    						 @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	return Calculadora.multiplicar(n1, n2);
    }
    
    @RequestMapping(value = "/multiplicar-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double multiplicarPath(@PathVariable("n1") String n1,
    					    @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando " + n1 + " * " + n2);
    	
    	if (!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	
    	return Calculadora.multiplicar(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    
    @GetMapping("/media-query")
    public Double mediaQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1,
    						 @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	return Calculadora.media(n1, n2);
    }
    
    @RequestMapping(value = "/media-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double mediaPath(@PathVariable("n1") String n1,
    					    @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando média de " + n1 + " e " + n2);
    	
    	if (!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	
    	return Calculadora.media(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    
    @GetMapping("/potencia-query")
    public Double potenciaQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1,
    						 @RequestParam(value = "n2", defaultValue = "0") Double n2) {
    	return Calculadora.potencia(n1, n2);
    }
    
    @RequestMapping(value = "/potencia-path/{n1}/{n2}", method = RequestMethod.GET)
    public Double potenciaPath(@PathVariable("n1") String n1,
    					    @PathVariable(value = "n2") String n2) {
    	logger.info("Calculando " + n1 + " elevado a " + n2);
    	
    	if (!ConversorNumerico.ehNumerico(n1) || !ConversorNumerico.ehNumerico(n2)) {
    		return 0d;
    	}
    	
    	return Calculadora.potencia(ConversorNumerico.converterParaDouble(n1), ConversorNumerico.converterParaDouble(n2));
    }
    
    @GetMapping("/raiz-query")
    public Double raizQuery(@RequestParam(value = "n1", defaultValue = "0") Double n1    						 ) {
    	try {return Calculadora.raiz(n1);}
    	catch(ArithmeticException e) {
    	logger.warning("Número negativo");
        return 0d;
    	}
    }
    
    
    @RequestMapping(value = "/raiz-path/{n1}", method = RequestMethod.GET)
    public Double raizPath(@PathVariable("n1") String n1
    					    ) {
    	logger.info("Calculando √" + n1);
    	
    	if (!ConversorNumerico.ehNumerico(n1)) {
    		return 0d;
    	}
    	try {
    	return Calculadora.raiz(ConversorNumerico.converterParaDouble(n1));
    }catch (ArithmeticException e) {
    	logger.warning("Número negativo");
    	
    	return 0d;
    	
    }
    }
}












