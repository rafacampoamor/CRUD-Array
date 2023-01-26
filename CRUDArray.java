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
		Date nuevaFecha = null;
		int longitud = titulo.length;
		char sino = 'n';

		System.out.println("====EVIL CORP====\n   TAREAS 0.1    \n-----------------");
		do {
			selector = menu();
			switch (selector) {
			case 1: {
				// Aqui se listan todas las tareas
				System.out.println("\n\n     LISTA DE\n     TAREAS\n-----------------\n\n");
				contador = 0;
				if (titulo[0] != null) {
					do {
						System.out.println(contador + ". " + titulo[contador] + " -- " + fechaLimite[contador]);
					} while (contador <= longitud && titulo[contador] != null);
				} else {
					System.out.println("La lista está vacía");
					sino = Utilidades.PedirChar("Añadir tarea? (S/N)");
					switch (sino) {
					case 's': {
						nuevoTitulo = anadirTitulo();
						contador = 0;
						do {
							if (titulo[contador] == null) {
								titulo[contador] = nuevoTitulo;
								encontrado = true;
							} else {
								errorLleno();
							}

						} while (contador < titulo.length && !encontrado);
						nuevaDescripcion = anadirDescripcion();
						descripcion[contador] = nuevaDescripcion;

						nuevaFecha = anadirFecha();
						fechaLimite[contador] = nuevaFecha;
						System.out
								.println("\n" + titulo[contador] + " ha sido añadido para el " + fechaLimite[contador]);
						break;
						
						// Aquí vuelve a pedir otra tarea y no debería: PURGAR
					}
					default:
						break;
					}
				}

			}
			case 2: {
				nuevoTitulo = anadirTitulo();
				contador = 0;
				do {
					if (titulo[contador] == null) {
						titulo[contador] = nuevoTitulo;
						encontrado = true;
					} else {
						errorLleno();
					}

				} while (contador < titulo.length && !encontrado);
				nuevaDescripcion = anadirDescripcion();
				descripcion[contador] = nuevaDescripcion;

				nuevaFecha = anadirFecha();
				fechaLimite[contador] = nuevaFecha;
				System.out.println(titulo[contador] + " ha sido añadido para el " + fechaLimite[contador]);
				break;
			}
			default:

			}
		} while (selector != 6);

	}

	private static int menu() {

		int selector = Utilidades.pedirInt(
				"1. Lista Tareas\n2. Añadir Tarea\n3. Modificar Tarea\n4. Eliminar Tarea\n5. Buscar Tarea\n6. Salir\n-----------------\n\n   Selecciona \n   una opción\n\n-----------------");
		return selector;
	}

	private static String anadirTitulo() {
		System.out.println("" + "\n\n     AÑADIR\n     TAREA\n-----------------\n\n");
		String nuevoTitulo = Utilidades.PedirString("Titulo de la tarea:");

		return nuevoTitulo;
	}

	private static String anadirDescripcion() {
		System.out.println("\n\n     AÑADIR\n     DESCRIPCIÓN\n-----------------\n\n");
		String nuevaDescripcion = Utilidades.PedirString("Descripción de la tarea");

		return nuevaDescripcion;
	}

	private static Date anadirFecha() {
		System.out.println("\n\n     AÑADIR\n     FECHA\n-----------------\n\n");
		Date nuevaFecha = Utilidades.pedirFecha("Fecha límite:");
		return nuevaFecha;
	}

	private static void errorLleno() {
		System.out
				.println("\n\n     ERROR\nLa memoria está llena\n\n¿Quieres borrar algo? (S/N)\n-----------------\n\n");

	}

	private static void anadirTarea() {

	}
}
