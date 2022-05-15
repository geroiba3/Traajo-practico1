package IU;

import java.util.Scanner;

import Datos.Producto;
import Negocios.Listado;

public class Interfaz {
	
		static Scanner entrada = new Scanner(System.in);
		
		static Listado auto_parte = new Listado();
		
		public void Login() {
			
			SobreCarga();
			System.out.println("Bienvenido");
			imprimirMenu();
		}
		
		private void SobreCarga() {
			Producto producto = new Producto();
			producto.setCategoria("Puerta");
			producto.setNombre("puerta mariposa");
			producto.setId_parte("12345679");
			auto_parte.add(producto);
		}
		
		private void imprimirMenu() {
			System.out.println("Por favor escoja una de las siguientes opciones");
			System.out.println("Para acceder a la opción escriba el numero que corresponda");
			System.out.println("1.Ingresar auto parte ");
			System.out.println("2.Ver registro");
			System.out.println("3.Buscar auto parte");
			System.out.println("4.Salir");
			
			int opcion = entrada.nextInt();
			switch (opcion) {
			case 1: Ingresar();
				break;
			case 2: verPerfiles();
				break;
			case 3: Buscar();
				break;
			case 4: Salir();
				break;
				default: System.out.println("Se eligio una opción incorrecta volver a intentar");
					break;
				}
		}
		
		
		private void menuAlter(Producto producto) {
			System.out.println("1.Borrar producto ");
			System.out.println("2.Editar producto");
			System.out.println("3.Menu principal");
			
			int opcion = entrada.nextInt();
			switch (opcion) {
			case 1: Borrar(producto);
				break;
			case 2: Editar(producto);
				break;
			case 3: imprimirMenu();
				break;
				default: System.out.println("Se eligio una opción incorrecta volver a intentar");
					break;
				}
		}
		private void Borrar(Producto producto) {
			System.out.println("Esta seguro de querer borrar a "+ producto+ "?");
			System.out.println("si esta seguro presione 1");
			int aux = entrada.nextInt();
			if(aux ==1) {
				if(auto_parte.Borrar(producto)) {
					System.out.println("se borro exitosamente");
				}
			}else {
				imprimirMenu();
			}
		}
		private void Editar(Producto producto) {
			System.out.println("Ingrese el nombre del producto");		
			System.out.println("Debe ser un nombre de minimo 3 letras y maximo 60");
			producto.setNombre(entrada.next());
			System.out.println("Ingrese apellido");
			System.out.println("Debe ser un apellido de minimo 3 letras y maximo 60");
			producto.setApellido(entrada.next());
			if(auto_parte.Editar(producto)) {
				System.out.println("la auto parte  se pudo editar correctamente");
			}else {
				System.out.println("no se pudo editar el alumno");
			}
			
			 imprimirMenu();
		}
		
		private void Ingresar() {
			System.out.println("Ingrese el nombre de la auto parte");		
			System.out.println("Debe ser un nombre de minimo 3 letras y maximo 60");
			Producto producto = new Producto();
			producto.setNombre(entrada.next());
			System.out.println("Ingrese apellido");
			System.out.println("Debe ser un apellido de minimo 3 letras y maximo 60");
			producto.setApellido(entrada.next());
			System.out.println("Ingrese el DNI: ");
			producto.setId_parte(entrada.next());
			 if(auto_parte.add(producto)== true) {
				 System.out.println("Se agrego correctamente el alumno");
			 }else {
				 System.out.println("no se pudo agregar correctamente");
					System.out.println("si deseas agregar nuevamente un contacto ");
					System.out.println("seleccionar opcion 1");	
			 }
			 imprimirMenu();
			 
		}
		private void Buscar() {
			System.out.println("Ingrese dni de alumno a buscar");
			String dni = entrada.next();
			Producto producto = new Producto();
			producto = auto_parte.buscar(dni); 
			if(producto.getId_parte() == "0" ) {
				System.out.println("la auto parte  no se encontro");
			}else {
				System.out.println("El auto parte es");
				System.out.println(producto);
				menuAlter(producto);
			}
			 imprimirMenu();
		}
		
		private void verPerfiles() {
			System.out.println(auto_parte);
			imprimirMenu();
			
		}
		
		private void Salir() {
			System.out.println("El programa finalizo");
			System.exit(0);
		}
		

}
