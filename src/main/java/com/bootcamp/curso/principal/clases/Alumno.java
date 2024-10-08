package com.bootcamp.curso.principal.clases;
import java.util.ArrayList;
/**
 *
 * @author Felipe Cuevas
 */
public class Alumno extends Persona{
    private Integer asistencia;
    private ArrayList <Evaluacion> evaluaciones;
    private Double sumaNotas;
    private Double promedio;
    public Alumno(){
        super();
        evaluaciones = new ArrayList<Evaluacion>();
        sumaNotas = 0.0;
        setAsistencia();
        setEvaluaciones();
    }

    public Integer getAsistencia() {
        return asistencia;
    }

    public void setAsistencia() {
        System.out.println("Ingrese la asistencia: ");
        asistencia = leer.nextInt(); leer.nextLine();
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones() {
    	
    	
    	System.out.println("---Ingreso de notas---");
    	for( int i = 0; i < 3; i++) {
    		System.out.println("Ingrese la nota " + (i+1) + ": ");
    		Evaluacion e = new Evaluacion();
            evaluaciones.add(e);
            sumaNotas = sumaNotas + e.getNota();
    	}
        
    }
    
    public Double getPromedio() {
    	return promedio = sumaNotas / 3;
    }

	@Override
	public String toString() {
		return "Alumno [Run: " + run + ", Nombre: "+ nombre +", Asistencia: " + asistencia + ", evaluaciones: " + evaluaciones + "]";
	}
    
}
