package presentacion;

import java.util.Iterator;
import java.util.Scanner;

import negocio.Negocio;
import negocio.Recurso;
import negocio.TipoRecurso;

public class Presentacion {

	static Negocio ipN = new Negocio();
	
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
		
	}
	
	
	private static void menu() {
	 	int opcion = 0;
	 	do {
	 	System.out.println("\n********* MENU ********* ");
	    System.out.println("Seleccione una opción");
	    System.out.println("1. Agregar recurso");
	    System.out.println("2. Listar recursos");
	    System.out.println("3. Listar tipos de recursos");
	    System.out.println("4. Listar recursos de tipo de recurso");
	    System.out.println("5. Salir");
		opcion = entrada.nextInt();
		
		switch (opcion) {
			case 1: addRecurso();
			break;
			
			case 2: getRecursos();
			break;
			
			case 3: getTipoRecursos();
			break;
			
			case 4: getRecursoTipoRecurso();
			break;
			
			case 5: System.out.println("Saliendo...");
			break;
			
			default: System.out.println("Seleccione una opción correcta");
		}
	 } while(opcion != 5);
		
	 }
	
	private static void addRecurso(){
		 System.out.println("Codigo: ");
		 String codigo = entrada.next();
		 System.out.println("Precio ");
		 double precio = entrada.nextInt();
		 System.out.println("Cantidad");
		 int cantidad = entrada.nextInt();
		 System.out.println("Tipo de recurso: ");
		 String tipo = entrada.next();
		 
		 if ( ipN.consultaTRecurso(tipo) ) {
			 if( ipN.precioMaximo(tipo, precio) ) {
				 ipN.newRecurso(codigo, precio, cantidad, tipo);
			 }
			 else  System.out.println("El precio no puede ser 10% mayor al precio del tipo de recurso"); 
		 }
		 else System.out.println("El tipo de recurso no existe");
	 }
	 
	 private static void getTipoRecursos(){
		 Iterator<TipoRecurso> it = ipN.getTipoRecursos().iterator();
		 while(it.hasNext()){
			 TipoRecurso i = it.next();
			 System.out.print("\n+Nombre: "+ i.getNombre() +"\n+Descripción: "+ i.getDescripcion() +"\n+Precio Referencia: "+i.getPrecioReferencia());	 
			 System.out.print("\n---------------------------------------------");	 
		 }
	 }
	 
	 private static void getRecursos(){
		 if( ipN.getRecursos().size() > 0 ) {
		 Iterator<Recurso> it = ipN.getRecursos().iterator();
			 while(it.hasNext()){
				 Recurso i = it.next();
				 System.out.print("\n+Codigo: "+ i.getCodigo() +"\n+Cantidad: "+ i.getCantidad() +"\n+Precio: "+i.getPrecioUnitario());	 	 
				 System.out.print("\n---------------------------------------------");	 
			 }
		 }
		 else System.out.println("NO hay recursos creados.");
	 }
	 
	 
	 private static void getRecursoTipoRecurso()  {
		 System.out.println("Ingrese nombre del tipo de recurso");
		 String nombre = entrada.next();
		 if( ipN.getRecursoTipoRecurso(nombre).size() > 0 ) {
			 Iterator<Recurso> it = ipN.getRecursoTipoRecurso(nombre).iterator();
				 while(it.hasNext()){
					 Recurso i = it.next();
					 System.out.print("\n+Codigo: "+ i.getCodigo() +"\n+Cantidad: "+ i.getCantidad() +"\n+Precio: "+i.getPrecioUnitario());	 
					 System.out.print("\n---------------------------------------------");	 
				 }
		}
		else System.out.println("NO hay recursos creados para el tipo de recurso ingresado");
	 }
	 
	 

}

