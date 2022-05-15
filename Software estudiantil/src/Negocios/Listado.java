package Negocios;

import IU.Interfaz;
import java.util.LinkedList;

import Datos.Producto;

public class Listado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interfaz i1 = new Interfaz();
		i1.Login();
	}
	LinkedList<Producto> Estudiante = new LinkedList<Producto>();
	
	public boolean add(Producto producto) {
		char [] letras = producto.getNombre().toCharArray();
		if(letras.length >= 3 && letras.length <= 60 ) {
			String categoria = producto.getCategoria();
			letras= categoria.toCharArray();
			if(letras.length>= 3 && letras.length<= 60) {
				String Id_parte = producto.getId_parte();
				letras = Id_parte.toCharArray();
				if(letras.length == 8) {
				Estudiante.add(producto);
				return true;
				}
			}
		}
		return false;
	}
	
	public Producto buscar(String Id_parte) {
		Producto producto = new Producto();
		for (int i = 0; i < Estudiante.size(); i++) {
			System.out.println(Estudiante.get(i));
           producto=Estudiante.get(i);
           //System.out.println(alumno.getDni());
           //System.out.println("Dni ");
           //System.out.println(dni);
           String aux = producto.getDni();
  
           if(aux.equals(Id_parte)) {
        	   //System.out.println("Lo encontré");
        	   return producto ;        	   
           }
		}
		String aux = "0";
		producto.setId_parte(aux);
		//System.out.println("no encontre");
		return producto ;
	}
	
	public boolean Borrar(Producto producto) {
		
		if(Estudiante.remove(producto)) {			
			return true; 
		}else {			
			return false;
		}
	}
	public boolean Editar(Producto producto){
		int index = IndexProducto(producto);
		Estudiante.set(index, producto);
		return true;
	}
	

	private int IndexProducto(Producto producto) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int IndexAlumno(Producto producto){
		Producto aux2 = new Producto();
		for (int i = 0; i < Estudiante.size(); i++) {
			System.out.println(Estudiante.get(i));
           aux2=Estudiante.get(i);
           String aux = aux2.getId_parte();
           if(aux.equals(producto.getId_parte())) {
        	   return i ;   
           }
		}
		return 0;
	
	}

	public LinkedList<Producto> getUsuarios() {
		return Estudiante;
	}

	public void setUsuarios(LinkedList<Producto> usuarios) {
		Estudiante = usuarios;
	}

	@Override
	public String toString() {
		return "Listado [Estudiantes=" + Estudiante + "]";
	}
	
	

}
