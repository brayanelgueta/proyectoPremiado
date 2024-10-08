package com.bootcamp.curso.principal.clases;
import com.bootcamp.curso.principal.interfaces.IProyecto;
/**
 *
 * @author Felipe Cuevas
 */
public class Evaluacion implements IProyecto{
    private Double nota, notaIngresada;
    
    public Evaluacion(){
        setNota();
    }

    public Double getNota() {
        return nota;
    }

    public void setNota() {
	    try {
	    	notaIngresada = leer.nextDouble();
	        leer.nextLine();
	        if(notaIngresada >= 1 && notaIngresada <= 7) {
	        	nota = notaIngresada;
	        }else {
	        	throw new ArithmeticException("Debe ingresar una nota entre 1 y 7");
	        }
	    }catch(ArithmeticException e) {
	    	System.out.println("Error: " + e.getMessage());
	    }catch(Exception e) {
	    	System.out.println("Error: " + e.getMessage());
	    }
	        
        
    }
    
    public Boolean validarNota(Double n){
        Boolean validacion = false;
        
        return validacion;
    }
}
