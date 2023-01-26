import java.util.Date;

public class CRUDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selector=0;
		String[] titulo = new String[20];
		String[] descripcion = new String[20];
		Date[] fechalimite = new Date[20];
		
		do {
		selector=menu();
			switch (selector) {
			case 1: {
				anadir();
			}
			default:
				
			}
		}	
		
	
	}

	private static int menu() {

		int selector = Utilidades.pedirInt(
				"====EVIL CORP====\n   TAREAS 0.1    \n-----------------\n1. Añadir Tarea\n2. Modificar Tarea\n3. Eliminar Tarea\n4. Buscar Tarea\n5. Salir\n-----------------\n\n   Selecciona \n   una opción\n\n-----------------");
		return selector;
	}

	private static void anadir() {
		System.out.println("====EVIL CORP====\n\n     AÑADIR\n     TAREA\n-----------------\n\n");
		String nuevoTitulo = Utilidades.PedirString("Titulo de la tarea:");
		String nuevaDescripcion = Utilidades.PedirString("Descripción de la tarea");
		Date nuevaFecha = Utilidades.pedirFecha("Fecha límite:");
		
		for (int i = 0; i < titulo.length; i++) {
	        if (titulo[i] == null) {
	            titulo[i] = nuevoTitulo;
	            break;
	        }
	}

}
}