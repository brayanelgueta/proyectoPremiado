package com.bootcamp.curso.principal;

import com.bootcamp.curso.principal.interfaces.IProyecto;
import com.bootcamp.curso.principal.clases.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ffeli
 */
public class Proyecto_Maven_CursoIntensivo implements IProyecto {

    private static ArrayList<CursoIntensivo> cursos = new ArrayList<CursoIntensivo>();

    public static void main(String[] args) {
        int op = 0;
        try {
            do {
                System.out.println("MENU - CURSOS INTENSIVOS");
                System.out.println("------------------------");
                System.out.println("1) Ingresar un nuevo curso intensivo.");
                System.out.println("2) Mostrar todos los relatores con sus sueldos.");
                System.out.println("3) Mostrar la SF de cada alumno de un curso especifico.");
                System.out.println("4) Buscar un alumno por RUN en un curso especifico.");
                System.out.println("5) Eliminar un alumno por RUN en un curso especifico.");
                System.out.println("6) Exportar toda la informacion a un fichero.");
                System.out.println("7) Salir.");
                System.out.println("------------------------");
                System.out.println("Ingrese su opcion: ");
                op = leer.nextInt();
                leer.nextLine();
                switch (op) {
                    case 1:
                        CursoIntensivo c = new CursoIntensivo();
                        cursos.add(c);
                        break;
                    case 2:
                    	if(!cursos.isEmpty()) {
                    		System.out.println("Lista de Relatores");
                       	 for (int i = 0; i < cursos.size(); i++) {
                                CursoIntensivo cursoIntensivo = cursos.get(i);
                                Relator relator = cursoIntensivo.getRelator();
                                if (relator != null) {
                                    System.out.println("Curso " + (i + 1) + ":");
                                    System.out.println("  Nombre del Relator: " + relator.getNombre());
                                    System.out.println("  Sueldo del Relator: $" + relator.getSueldo());
                                } else {
                                    System.out.println("Curso " + (i + 1) + ": No tiene relator asignado.");
                                }
                            }
                    	}else {
                    		System.out.println("Aun no hay cursos inscritos");
                    	}
                    	
                        break;
                    case 3:
                    	if(!cursos.isEmpty()) {
                    		System.out.println("Seleccione el curso");
                        	for(CursoIntensivo aux : cursos){
                        		System.out.println("Codigo curso: " + aux.getCodigo());
                        		System.out.println("Nombre curso: " + aux.getNombre());
                        	}
                        	System.out.println("Ingrese el código del curso para ver la situación final de los alumnos: ");
                            int codigoCurso = leer.nextInt();
                            leer.nextLine(); 
                            boolean cursoEncontrado = false;
                            for (CursoIntensivo cursoIntensivo : cursos) {
                                if (cursoIntensivo.getCodigo().equals(codigoCurso)) {
                                    cursoIntensivo.mostrarSF(); 
                                    cursoEncontrado = true;
                                    break;
                                }
                            }
                            if (!cursoEncontrado) {
                                System.out.println("No se encontró un curso con ese código.");
                            }
                    	}else {
                    		System.out.println("No hay cursos Inscritos");
                    	}

                        break;
                    case 4:
                    	if(!cursos.isEmpty()) {
                    		System.out.println("Seleccione el curso");
                        	for(CursoIntensivo aux : cursos){
                        		System.out.println("Codigo curso: " + aux.getCodigo());
                        		System.out.println("Nombre curso: " + aux.getNombre());
                        	}
                        	System.out.println("Ingrese el código del curso para buscar el alumno: ");
                            int codigoCurso = leer.nextInt();
                            leer.nextLine(); 
                            boolean cursoEncontrado = false;
                            for (CursoIntensivo cursoIntensivo : cursos) {
                                if (cursoIntensivo.getCodigo().equals(codigoCurso)) {
                                    cursoIntensivo.buscarAlumno(); 
                                    cursoEncontrado = true;
                                    break;
                                }
                            }
                            if (!cursoEncontrado) {
                                System.out.println("No se encontró un curso con ese código.");
                            }
                    	}else {
                    		System.out.println("No hay cursos Inscritos");
                    	}
                        break;
                    case 5:
                    	if(!cursos.isEmpty()) {
                    		System.out.println("Seleccione el curso");
                        	for(CursoIntensivo aux : cursos){
                        		System.out.println("Codigo curso: " + aux.getCodigo());
                        		System.out.println("Nombre curso: " + aux.getNombre());
                        	}
                        	System.out.println("Ingrese el código del curso para eliminar el alumno: ");
                            int codigoCurso = leer.nextInt();
                            leer.nextLine(); 
                            boolean cursoEncontrado = false;
                            for (CursoIntensivo cursoIntensivo : cursos) {
                                if (cursoIntensivo.getCodigo().equals(codigoCurso)) {
                                    cursoIntensivo.eliminarAlumno(); 
                                    cursoEncontrado = true;
                                    break;
                                }
                            }
                            if (!cursoEncontrado) {
                                System.out.println("No se encontró un curso con ese código.");
                            }
                    	}else {
                    		System.out.println("No hay cursos Inscritos");
                    	}
                        break;
                    case 6:
                    	try{
                            System.out.println("Ingrese el nombre del archivo que desea crear");
                            String nombreArchivo = leer.nextLine();
                            String rutaDirectorio = "src/ficheros/";
                            File directorio = new File(rutaDirectorio);
                            if(!directorio.exists()) {
                            	directorio.mkdirs();
                            }
                            
                            String rutaArchivo = rutaDirectorio + nombreArchivo + ".xlsx";
                            Workbook excel = new XSSFWorkbook();
                            Sheet hojaExcel = excel.createSheet("Curso 1");
                           
                            Row fila = hojaExcel.createRow(0); 
                          
                            Cell celda = fila.createCell(2);
                            celda.setCellValue("Hola profe, se intento, si lo logro despues le hago un push a este repo "); 
                        
                            FileOutputStream salidaArchivo = new FileOutputStream(new File(rutaArchivo));
                            excel.write(salidaArchivo);
                            salidaArchivo.close();
                            excel.close();
                            
                            System.out.println("Archivo creado correctamente en: " + rutaArchivo);
                            
                        }catch(IOException e){
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;
                    case 7:
                        System.out.println("Finalizando el algoritmo.");
                        break;
                    default:
                        System.err.println("Opcion inválida.");
                        break;
                }
            } while (op < 7);
        } catch (Exception e) {
            System.err.println("Error de la aplicacion: " + e.getMessage());
        }
    }
    
    
}
