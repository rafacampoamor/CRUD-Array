import java.util.Date;

public class CRUDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selector = 0;
		int contador = -1;
		boolean encontrado = false;
		String[] titulo = new String[20];
		String[] descripcion = new String[20];
		Date[] fechaLimite = new Date[20];
		String nuevoTitulo = new String();
		String nuevaDescripcion = new String();
		Date nuevaFecha=null;

		do {
			selector = menu();
			switch (selector) {
			case 1: {
				nuevoTitulo= anadirTitulo();
				contador = -1;
				do {
					if (titulo[contador] == null) {
						titulo[contador] = nuevoTitulo;
						encontrado = true;
					}

				} while (contador < titulo.length && !encontrado);
				nuevaDescripcion= anadirDescripcion();
				contador = -1;
				do {
					if (descripcion[contador] == null) {
						descripcion[contador] = nuevaDescripcion;
						encontrado = true;
					}

				} while (contador < titulo.length && !encontrado);
			nuevaFecha= anadirFecha();
			do {
				if (fechaLimite[contador] == null) {
					fechaLimite[contador] = nuevaFecha;
					encontrado = true;
				}

			} while (contador < titulo.length && !encontrado);
			}
			default:

			}
		} while (selector != 5);

	}

	private static int menu() {

		int selector = Utilidades.pedirInt(
				"====EVIL CORP====\n   TAREAS 0.1    \n-----------------\n1. Añadir Tarea\n2. Modificar Tarea\n3. Eliminar Tarea\n4. Buscar Tarea\n5. Salir\n-----------------\n\n   Selecciona \n   una opción\n\n-----------------");
		return selector;
	}

	private static String anadirTitulo() {
		System.out.println("====EVIL CORP====\n\n     AÑADIR\n     TAREA\n-----------------\n\n");
		String nuevoTitulo = Utilidades.PedirString("Titulo de la tarea:");
		

		return nuevoTitulo;
	}

	private static String anadirDescripcion() {
		System.out.println("====EVIL CORP====\n\n     AÑADIR\n     DESCRIPCIÓN\n-----------------\n\n");
		String nuevaDescripcion = Utilidades.PedirString("Descripción de la tarea");

		return nuevaDescripcion;
	}
	private static Date anadirFecha() {
		System.out.println("====EVIL CORP====\n\n     AÑADIR\n     FECHA\n-----------------\n\n");
		Date nuevaFecha = Utilidades.pedirFecha("Fecha límite:");
		return nuevaFecha;
	}
	private void anadirTarea() {
		
		
	}

}
