import java.util.Date;

public class MetodosCRUD {

	/**
	 * Añade una tarea a los Arrays en la misma posición si queda espac io libre
	 * @param posiciones el numero de posiciones que tienen los Arrays
	 * @param titulo el titulo de la tarea
	 * @param descripcion la descripción de la tarea
	 * @param fechaLimite la fecha límite de la tarea
	 */
	public static void addTarea(int posiciones, String[] titulo, String[] descripcion, Date[] fechaLimite) {
		int contador = 0;
		boolean lleno = false;
		boolean encontrado = false;
		String nuevoTitulo;
		String nuevaDescripcion;
		Date nuevaFecha;

		do {
			if (titulo[contador] == null) {
				encontrado = true;
			} else {
				contador++;
				if (contador == posiciones) {
					lleno = true;
					errorLleno(posiciones);
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
			System.out.println("\n" + titulo[contador] + " ha sido añadido para el " + fechaLimite[contador]);
			Utilidades.pausa();
		} else if (lleno) {
			errorLleno(posiciones);
		}
	}

	/**
	 * Lista las tareas y permite modificarlas o eliminarlas
	 * @param posiciones
	 * @param titulo
	 * @param descripcion
	 * @param fechaLimite
	 */
	public static void listar(int posiciones, String[] titulo, String[] descripcion, Date[] fechaLimite) {
		int contador = 0;
		String nuevoTitulo;
		String nuevaDescripcion;
		Date nuevaFecha;
		boolean ListaVacia;
		char sino;
		int selector;

		// Aqui se listan todas las tareas
		System.out.println("\n\n LISTA DE\n TAREAS\n-----------------\n\n");
		contador = 0;
		ListaVacia = true;
		while (contador < posiciones && titulo[0] != null) {
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
				System.out
						.println("\n" + titulo[contador] + " ha sido añadido para el " + fechaLimite[contador]);
			}

		} else {
			// aqui va un switch para modificar o borrar
			selector = submenu();
			switch (selector) {
				case 1: {
					ModificarTarea(posiciones, titulo, descripcion, fechaLimite);
					break;
				}
				case 2: {
					eliminarTarea(posiciones, titulo, descripcion, fechaLimite);
					break;
				}
				default:
					break;
			}
		}
	}

	public static void ModificarTarea(int posiciones, String[] titulo, String[] descripcion, Date[] fechaLimite) {
		String busqueda;
		boolean esnumero;
		int contador = -1;
		String nuevoTitulo;
		String nuevaDescripcion;
		Date nuevaFecha;

		busqueda = Utilidades.PedirString("¿Qué quieres modificar?");
		esnumero = Utilidades.sonNumeros(busqueda);
		if (esnumero) {
			contador = Integer.parseInt(busqueda);
			if (contador >= 0 && contador < posiciones && titulo[contador] != null) {
				System.out.println("Modificando " + titulo[contador] + " del " + fechaLimite[contador]);
				nuevoTitulo = anadirTitulo();
				titulo[contador] = nuevoTitulo;
				nuevaDescripcion = anadirDescripcion();
				descripcion[contador] = nuevaDescripcion;
				nuevaFecha = anadirFecha();
				fechaLimite[contador] = nuevaFecha;
				System.out.println(titulo[contador] + " ha sido modificado para el " + fechaLimite[contador]);
			} else {
				System.out.println("Lo siento, no encuentro lo que quieres modificar");
				Utilidades.pausa();
			}
		} else if (!esnumero) {
			contador = buscarPosicionNombre(titulo, busqueda);
			if (contador >= 0 && contador < posiciones && titulo[contador] != null) {
				System.out.println("Modificando " + titulo[contador] + " del " + fechaLimite[contador]);
				nuevoTitulo = anadirTitulo();
				titulo[contador] = nuevoTitulo;
				nuevaDescripcion = anadirDescripcion();
				descripcion[contador] = nuevaDescripcion;
				nuevaFecha = anadirFecha();
				fechaLimite[contador] = nuevaFecha;
				System.out.println(
						"\n" + titulo[contador] + " ha sido modificado para el " + fechaLimite[contador]);

			} else {
				System.out.println("No encuentro lo que quieres modificar");
				Utilidades.pausa();
			}
		}
	}

	public static void eliminarTarea(int posiciones, String[] titulo, String[] descripcion, Date[] fechaLimite) {
		String busqueda;
		boolean esnumero;
		int contador = -1;
		char sino;

		busqueda = Utilidades.PedirString("\n¿Qué quieres borrar?");
		esnumero = Utilidades.sonNumeros(busqueda);
		if (esnumero) {
			contador = Integer.parseInt(busqueda);
			if (contador >= 0 && contador < posiciones && titulo[contador] != null) {
				sino = Utilidades.PedirChar("\n¿Seguro que quieres borrar " + titulo[contador] + " del "
						+ fechaLimite[contador] + "? (S/N)\nEste cambio no se podrá deshacer");
				if (sino == 's') {

					titulo[contador] = null;
					descripcion[contador] = null;
					fechaLimite[contador] = null;
					System.out.println("\nTarea borrada con éxito");
				} else {

				}
				Utilidades.pausa();
			} else {
				System.out.println("No encuentro lo que quieres borrar");
				Utilidades.pausa();
			}
		} else if (!esnumero) {
			contador = buscarPosicionNombre(titulo, busqueda);
			if (contador >= 0 && contador < posiciones && titulo[contador] != null) {
				sino = Utilidades.PedirChar("\n¿Seguro que quieres borrar " + titulo[contador] + " del "
						+ fechaLimite[contador] + "? (S/N)\nEste cambio no se podrá deshacer");
				if (sino == 's') {

					titulo[contador] = null;
					descripcion[contador] = null;
					fechaLimite[contador] = null;
					System.out.println("\nTarea borrada con éxito");
					Utilidades.pausa();

				} else {
					Utilidades.pausa();
				}
			}
		}

	}

	public static void Buscar(int posiciones, String[] titulo, String[] descripcion, Date[] fechaLimite) {
		int contador = -1;
		String busqueda = Utilidades.PedirString("\nBuscar Tarea:");
		contador = buscarPosicionNombre(titulo, busqueda);
		if (contador >= 0 && contador < posiciones) {
			System.out.println(
					titulo[contador] + " -- " + descripcion[contador] + " -- " + fechaLimite[contador]);

		}
	}

	/**
	 * Muestra un mensaje de error en pantalla indicando que la memoria está llena y
	 * pregunta al usuario si desea borrar algo.
	 * 
	 * @param posiciones Es un entero que indica cuantas tareas han sido añadidas
	 *                   antes de que ocurra el error de memoria llena.
	 */
	private static void errorLleno(int posiciones) {
		System.out.println("\n\n     ERROR\nLa memoria está llena\n" + posiciones
				+ " tareas han sido añadidas.\nDeberías borrar algo \n-----------------\n\n");
		Utilidades.pausa();

	}

	/**
	 * 
	 * Muestra un mensaje de bienvenida y solicita al usuario que introduzca el
	 * título de la tarea a añadir.
	 * 
	 * @return el título de la tarea introducido por el usuario.
	 */
	private static String anadirTitulo() {
		System.out.println("" + "\n\n     AÑADIR TAREA\n-----------------\n\n");
		String nuevoTitulo = Utilidades.PedirString("Titulo de la tarea:");

		return nuevoTitulo;
	}

	/**
	 * 
	 * Muestra un mensaje de bienvenida y solicita al usuario que introduzca la
	 * descripción de la tarea a añadir.
	 * 
	 * @return la descripción de la tarea introducida por el usuario.
	 */
	private static String anadirDescripcion() {
		System.out.println("\n\n     AÑADIR DESCRIPCIÓN\n-----------------\n\n");
		String nuevaDescripcion = Utilidades.PedirString("Descripción de la tarea");

		return nuevaDescripcion;
	}

	/**
	 * 
	 * Muestra un mensaje de bienvenida y solicita al usuario que introduzca la
	 * fecha de la tarea a añadir.
	 * 
	 * @return la fecha de la tarea introducida por el usuario.
	 */
	private static Date anadirFecha() {
		System.out.println("\n\n     AÑADIR FECHA\n-----------------\n\n");
		Date nuevaFecha = Utilidades.pedirFecha("Fecha límite:");
		return nuevaFecha;
	}

	/**
	 * 
	 * Busca la posición en un array de un nombre específico.
	 * 
	 * @param lista  Es el array en el que se buscará la posición del nombre
	 *               específico.
	 * @param nombre Es el nombre que se buscará en el array.
	 * @return La posición del nombre específico en el array, o -1 si no se
	 *         encuentra.
	 */
	private static int buscarPosicionNombre(String[] lista, String nombre) {

		int longitud = lista.length;
		int i = 0;
		int posicion = -1;
		boolean encontrado = false;

		if (longitud > 0) {
			do {
				if (lista[i] != null && lista[i].equals(nombre)) {
					posicion = i;
					encontrado = true;
				}
				i++;
			} while (i < longitud && !encontrado);
		}
		if (!encontrado) {
			System.out.println("Lo siento, no encuentro " + nombre + ".");
		}

		return posicion;

	}

	/**
	 * 
	 * Muestra un menú con opciones para interactuar con una lista de tareas y
	 * devuelve la opción seleccionada por el usuario.
	 * 
	 * @return int - La opción seleccionada por el usuario
	 */
	public static int menu() {

		int selector = Utilidades.pedirInt(
				"\n====EVIL CORP====\n   TAREAS 0.1    \n-----------------\n\n1. Lista Tareas\n2. Añadir Tarea\n3. Modificar Tarea\n4. Eliminar Tarea\n5. Buscar Tarea\n6. Salir\n-----------------\n\n   Selecciona \n   una opción\n\n-----------------");
		return selector;
	}

	/**
	 * 
	 * Muestra un menú con las opciones de modificar una tarea, borrar una tarea o
	 * salir. El usuario selecciona una opción y el método devuelve el número de la
	 * opción seleccionada.
	 * 
	 * @return int La opción seleccionada por el usuario.
	 */
	private static int submenu() {

		int selector = Utilidades.pedirInt(
				"\n¿Qué quieres hacer?\n\n1. Modificar una tarea\n2. Borrar una tarea\n3. Atrás\n-----------------\n\n   Selecciona \n   una opción\n\n-----------------");
		return selector;
	}

}
