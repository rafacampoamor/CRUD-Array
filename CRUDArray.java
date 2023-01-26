import java.util.Date;

public class CRUDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selector = 0;
		int contador = -1;
		int posiciones = 2;
		boolean encontrado = false;
		String[] titulo = new String[posiciones];
		String[] descripcion = new String[posiciones];
		Date[] fechaLimite = new Date[posiciones];
		String nuevoTitulo = new String();
		String nuevaDescripcion = new String();
		Date nuevaFecha = null;
		int longitud = titulo.length;
		char sino = 'n';
		boolean ListaVacia = true;
		boolean lleno = false;

		do {
			selector = menu();
			switch (selector) {
			case 1: {
				// Aqui se listan todas las tareas
				System.out.println("\n\n LISTA DE\n TAREAS\n-----------------\n\n");
				contador = 0;
				while (contador < posiciones) {
					if (titulo[contador] != null) {
						ListaVacia = false;
						System.out.println(contador + ". " + titulo[contador] + " -- " + descripcion[contador] + " -- "
								+ fechaLimite[contador]);
					}
					contador++;
				}
				if (ListaVacia) {
					// si no hay tareas, se añade una
					System.out.println("La lista está vacía");
					sino = Utilidades.PedirChar("Añadir tarea? (S/N)");
					if (sino == 's') {

						nuevoTitulo = anadirTitulo();
						titulo[contador] = nuevoTitulo;
						nuevaDescripcion = anadirDescripcion();
						descripcion[contador] = nuevaDescripcion;
						nuevaFecha = anadirFecha();
						fechaLimite[contador] = nuevaFecha;
						System.out.println(titulo[contador] + " ha sido añadido para el " + fechaLimite[contador]);
					}

				}
				break;
			}

			case 2: {
				contador = 0;
				lleno = false;
				encontrado = false;
				do {
					if (titulo[contador] == null) {
						encontrado = true;
					} else {
						contador++;
						if (contador == posiciones) {
							lleno = true;
							System.out.println("\n\n     ERROR\nLa memoria está llena\n" + posiciones
									+ " tareas han sido añadidas.\n¿Quieres borrar algo? (S/N)\n-----------------\n\n");
							break;
						}
					}
				} while (contador < posiciones && !encontrado);
				if (encontrado && !lleno) {
					nuevoTitulo = anadirTitulo();
					titulo[contador] = nuevoTitulo;
					nuevaDescripcion = anadirDescripcion();
					descripcion[contador] = nuevaDescripcion;
					nuevaFecha = anadirFecha();
					fechaLimite[contador] = nuevaFecha;
					System.out.println(titulo[contador] + " ha sido añadido para el " + fechaLimite[contador]);
				} else if (lleno) {
					System.out.println("\n\n     ERROR\nLa memoria está llena\n" + posiciones
							+ " tareas han sido añadidas.\n¿Quieres borrar algo? (S/N)\n-----------------\n\n");
				}
				break;
			}

			default:

			}
		} while (selector != 6);

	}

	private static int menu() {

		int selector = Utilidades.pedirInt(
				"\n====EVIL CORP====\n   TAREAS 0.1    \n-----------------\n\n1. Lista Tareas\n2. Añadir Tarea\n3. Modificar Tarea\n4. Eliminar Tarea\n5. Buscar Tarea\n6. Salir\n-----------------\n\n   Selecciona \n   una opción\n\n-----------------");
		return selector;
	}

	private static String anadirTitulo() {
		System.out.println("" + "\n\n     AÑADIR TAREA\n-----------------\n\n");
		String nuevoTitulo = Utilidades.PedirString("Titulo de la tarea:");

		return nuevoTitulo;
	}

	private static String anadirDescripcion() {
		System.out.println("\n\n     AÑADIR DESCRIPCIÓN\n-----------------\n\n");
		String nuevaDescripcion = Utilidades.PedirString("Descripción de la tarea");

		return nuevaDescripcion;
	}

	private static Date anadirFecha() {
		System.out.println("\n\n     AÑADIR FECHA\n-----------------\n\n");
		Date nuevaFecha = Utilidades.pedirFecha("Fecha límite:");
		return nuevaFecha;
	}

	private static void errorLleno() {
		System.out
				.println("\n\n     ERROR\nLa memoria está llena\n\n¿Quieres borrar algo? (S/N)\n-----------------\n\n");

	}

}
