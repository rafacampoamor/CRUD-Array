import java.util.Date;

public class CRUDArray extends Tarea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selector = 0;
		Tarea unaTarea = new Tarea();

		do {
			selector = menu();
			switch (selector) {
				case 1: {
					listarTareas(unaTarea);
					break;
				}
				case 2: {
					crearTarea(unaTarea);
					break;
				}
				case 3: {
					modificarTarea(unaTarea);
					break;
				}
				case 4: {
					borrarTarea(unaTarea);
					break;
				}
				case 5: {
					buscarTarea(unaTarea);
					break;
				}

				default:
					break;
			}
		} while (selector != 6);

	}

	/**
	 * 
	 * Permite buscar una tarea específica en la lista de tareas.
	 * 
	 * @param unaTarea objeto de tipo Tarea que contiene la lista de tareas.
	 */
	private static void buscarTarea(Tarea unaTarea) {
		boolean ListaVacia = true;
		int selector;
		// Pedimos una inserción de texto para buscar
		String busqueda = Utilidades.PedirString("\nBuscar Tarea:");
		int contador = buscarPosicionNombre(unaTarea.getTitulo(), busqueda);
		// Si encuentra algo, lo muestra por pantalla junto a un menú contextual
		if (contador >= 0 && contador < unaTarea.getPosiciones()) {
			ListaVacia = false;
			System.out.println(unaTarea.getTitulo()[contador] + " -- " + unaTarea.getDescripcion()[contador] + " -- "
					+ unaTarea.getFechaLimite()[contador]);
		}
		// aqui va un menú contextual para modificar o borrar en el caso de que muestre
		// lista
		if (!ListaVacia) {
			do {
				selector = submenu();
				switch (selector) {
					case 1: {
						modificarTarea(unaTarea);
						selector = 3;
						Utilidades.pausa();
						break;
					}
					case 2: {
						borrarTarea(unaTarea);
						selector = 3;
						Utilidades.pausa();
						break;
					}

					default:
						break;
				}
			} while (selector != 3);
		}

	}

	/**
	 * 
	 * Recibe una tarea y permite al usuario borrar una tarea existente. El usuario
	 * debe ingresar el nombre o el número de la tarea que desea borrar. Si el
	 * nombre o número ingresado corresponde a una tarea existente, se le preguntará
	 * al usuario si está seguro de querer borrar la tarea. Si el usuario confirma,
	 * la tarea será borrada. En caso contrario, la tarea no será borrada. Si el
	 * nombre o número ingresado no corresponde a una tarea existente, se informará
	 * al usuario de que no se pudo encontrar la tarea.
	 * 
	 * @param unaTarea La tarea a ser borrada.
	 */
	private static void borrarTarea(Tarea unaTarea) {
		// TODO Auto-generated method stub
		int contador = 0;
		boolean esnumero = false;
		char sino = 'n';

		// Se pide un comando de búsqueda por consola. Posteriormente se determina si se
		// trata de una posición del Array o del título de una tarea
		String busqueda = Utilidades.PedirString("\n¿Qué quieres borrar?");
		esnumero = Utilidades.sonNumeros(busqueda);
		// Si se trata de un número, busca esa posición en el Array
		if (esnumero) {
			contador = Integer.parseInt(busqueda);
			// Si esa posición existe y no está vacía, vacía la posición en los tres arrays
			if (contador >= 0 && contador < unaTarea.getPosiciones() && unaTarea.getTitulo()[contador] != null) {
				sino = Utilidades.PedirChar("\n¿Seguro que quieres borrar " + unaTarea.getTitulo()[contador] + " del "
						+ unaTarea.getFechaLimite()[contador] + "? (S/N)\nEste cambio no se podrá deshacer");
				// Se pide confirmación antes de borrar
				if (sino == 's') {

					unaTarea.getTitulo()[contador] = null;
					unaTarea.getDescripcion()[contador] = null;
					unaTarea.getFechaLimite()[contador] = null;
					System.out.println("\nTarea borrada con éxito");
				} else {

				}
				Utilidades.pausa();
				// En caso contrario, muestra un error
			} else {
				System.out.println("No encuentro lo que quieres borrar");
				Utilidades.pausa();
			}
			// Si no es un número, busca en el Array de título y repite el proceso una vez
			// encontrada la posición con el match
		} else if (!esnumero) {
			contador = buscarPosicionNombre(unaTarea.getTitulo(), busqueda);
			if (contador >= 0 && contador < unaTarea.getPosiciones() && unaTarea.getTitulo()[contador] != null) {
				sino = Utilidades.PedirChar("\n¿Seguro que quieres borrar " + unaTarea.getTitulo()[contador] + " del "
						+ unaTarea.getFechaLimite()[contador] + "? (S/N)\nEste cambio no se podrá deshacer");
				// Se pide confirmación antes de borrar
				if (sino == 's') {

					unaTarea.getTitulo()[contador] = null;
					unaTarea.getDescripcion()[contador] = null;
					unaTarea.getFechaLimite()[contador] = null;
					System.out.println("\nTarea borrada con éxito");
					Utilidades.pausa();

				} else {
					Utilidades.pausa();
				}
			} else {
				Utilidades.pausa();
			}
		}
	}

	/**
	 * Recibe una tarea y permite al usuario modificar una tarea existente. El
	 * usuario debe ingresar el nombre o el número de la tarea que desea modificar.
	 * Si el nombre o número ingresado no corresponde a una tarea existente, se
	 * informará al usuario de que no se pudo encontrar la tarea.
	 * 
	 * @param nuevaTareaLa tarea a modificar
	 */
	private static void modificarTarea(Tarea unaTarea) {

		int contador = 0;

		// Se pide un comando de búsqueda por consola. Posteriormente se determina si se
		// trata de una posición del Array o del título de una tarea
		String busqueda = Utilidades.PedirString("¿Qué quieres modificar?");
		boolean esnumero = Utilidades.sonNumeros(busqueda);
		// Si el comando introducido es número, busca esa posición en la consola y
		// tenermina que no esté vacía
		if (esnumero) {
			contador = Integer.parseInt(busqueda);
			if (contador >= 0 && contador < unaTarea.getPosiciones() && unaTarea.getTitulo()[contador] != null) {
				System.out.println("Modificando " + unaTarea.getTitulo()[contador] + " del "
						+ unaTarea.getFechaLimite()[contador]);
				// En caso de que no esté vacía, empieza la secuencia de modificación

				unaTarea.getTitulo()[contador] = anadirTitulo();
				unaTarea.getDescripcion()[contador] = anadirDescripcion();
				unaTarea.getFechaLimite()[contador] = anadirFecha();
				System.out.println(unaTarea.getTitulo()[contador] + " ha sido modificado para el "
						+ unaTarea.getFechaLimite()[contador]);
				// En caso de que esa posición no exista o esté vacía, muestra un error
			} else {
				System.out.println("Lo siento, no encuentro lo que quieres modificar");
				Utilidades.pausa();

			}
			// Si no se trata de un número, busca en el Array titulo una coincidencia
		} else if (!esnumero) {
			contador = buscarPosicionNombre(unaTarea.getTitulo(), busqueda);
			// En caso de que encuentre coincidencia, incia la secuencia de modificación
			if (contador >= 0) {
				System.out.println("Modificando " + unaTarea.getTitulo()[contador] + " del "
						+ unaTarea.getFechaLimite()[contador]);

				unaTarea.getTitulo()[contador] = anadirTitulo();
				unaTarea.getDescripcion()[contador] = anadirDescripcion();
				unaTarea.getFechaLimite()[contador] = anadirFecha();
				System.out.println("\n" + unaTarea.getTitulo()[contador] + " ha sido modificado para el "
						+ unaTarea.getFechaLimite()[contador]);
				// En caso de no encontrar la tarea, muestra un error
			} else {
				System.out.println("No encuentro lo que quieres modificar");
				Utilidades.pausa();
			}
		}
	}

	/**
	 * 
	 * Muestra una lista de todas las tareas existentes en la lista de tareas. Si la
	 * lista está vacía, se pregunta al usuario si desea añadir una nueva tarea.
	 * 
	 * @param unaTarea Objeto Tarea que contiene las tareas existentes.
	 */
	private static void listarTareas(Tarea unaTarea) {
		int selector;

		// Aqui se listan todas las tareas en caso de que las haya
		System.out.println("\n\n LISTA DE\n TAREAS\n-----------------\n\n");
		int contador = 0;
		boolean ListaVacia = true;
		char sino = 'n';
		while (contador < unaTarea.getPosiciones() && unaTarea.getTitulo()[0] != null) {
			if (unaTarea.getTitulo()[contador] != null) {
				ListaVacia = false;
				System.out.println(contador + ". " + unaTarea.getTitulo()[contador] + " -- "
						+ unaTarea.getDescripcion()[contador] + " -- " + unaTarea.getFechaLimite()[contador]);
			}
			contador++;
		}
		if (ListaVacia) {
			// si no hay tareas, se añade una
			System.out.println("La lista está vacía");
			sino = Utilidades.PedirChar("Añadir tarea? (S/N)");
			if (sino == 's') {
				crearTarea(unaTarea);

			}
		}
		// aqui va un menú contextual para modificar o borrar en el caso de que muestre
		// lista
		if (!ListaVacia) {
			do {
				selector = submenu();
				switch (selector) {
					case 1: {
						modificarTarea(unaTarea);
						selector = 3;
						break;
					}
					case 2: {
						borrarTarea(unaTarea);
						selector = 3;
						break;
					}

					default:
						break;
				}
			} while (selector != 3);
		}
	}

	/**
	 * 
	 * El método 'crearTarea' se encarga de crear una nueva tarea en el array de
	 * tareas. Si el array está lleno, se mostrará un mensaje de error. Si el array
	 * no está lleno, se pedirá al usuario que ingrese el título, descripción y
	 * fecha límite de la tarea.
	 * 
	 * @param nuevaTarea es la tarea que se va a crear
	 */
	private static void crearTarea(Tarea nuevaTarea) {
		int contador = 0;
		boolean lleno = false;
		boolean encontrado = false;

		// Se busca la primera posición vacía del array. En caso contrario, se valida
		// como lleno.
		do {
			if (nuevaTarea.getTitulo()[contador] == null) {
				encontrado = true;
			} else {
				contador++;
				if (contador == nuevaTarea.getTitulo().length) {
					lleno = true;
					errorLleno(nuevaTarea.getTitulo().length);

				}
			}
		} while (contador < nuevaTarea.getTitulo().length && !encontrado);

		// Si hay posiciones libres en el array, se coge la primera y se piden datos
		// para ingresar. Confirmando parte de los datos al final del proceso
		if (encontrado && !lleno) {

			nuevaTarea.getTitulo()[contador] = anadirTitulo();
			nuevaTarea.getDescripcion()[contador] = anadirDescripcion();
			nuevaTarea.getFechaLimite()[contador] = anadirFecha();
			System.out.println("\n" + nuevaTarea.getTitulo()[contador] + " ha sido añadido para el "
					+ nuevaTarea.getFechaLimite()[contador]);
			Utilidades.pausa();

		}
	}

	/**
	 * 
	 * Muestra un menú con opciones para interactuar con una lista de tareas y
	 * devuelve la opción seleccionada por el usuario.
	 * 
	 * @return int - La opción seleccionada por el usuario
	 */
	private static int menu() {

		int selector = Utilidades.pedirInt(
				"\n====EVIL CORP====\n   TAREAS 0.1    \n-----------------\n\n[1] Lista Tareas\n[2] Añadir Tarea\n[3] Modificar Tarea\n[4] Eliminar Tarea\n[5] Buscar Tarea\n[6] Salir\n-----------------\n\n   Selecciona \n   una opción\n\n-----------------");
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
				"\n¿Qué quieres hacer?\n\n[1] Modificar una tarea\n[2] Borrar una tarea\n[3] Atrás\n-----------------\n\n   Selecciona \n   una opción\n\n-----------------");
		return selector;
	}

	/**
	 * 
	 * Muestra un mensaje de bienvenida y solicita al usuario que introduzca el
	 * título de la tarea a añadir.
	 * 
	 * @return el título de la tarea introducido por el usuario.
	 */
	private static String anadirTitulo() {
		String nuevoTitulo;
		System.out.println("" + "\n\n     AÑADIR TAREA\n-----------------\n\n");
		nuevoTitulo = Utilidades.PedirString("Titulo de la tarea:");

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
		String nuevaDescripcion;
		System.out.println("\n\n     AÑADIR DESCRIPCIÓN\n-----------------\n\n");
		nuevaDescripcion = Utilidades.PedirString("Descripción de la tarea");

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
		Date nuevaFecha;
		System.out.println("\n\n     AÑADIR FECHA\n-----------------\n\n");
		nuevaFecha = Utilidades.pedirFecha("Fecha límite:");
		return nuevaFecha;
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

		// se recorre el array buscando el texto introducido
		if (longitud > 0) {
			do {
				if (lista[i] != null && lista[i].equals(nombre)) {
					posicion = i;
					encontrado = true;
				}
				i++;
			} while (i < longitud && !encontrado);
		}

		// si no se encuentra tras recorrer todo el Array, se devuelve un error y da un
		// return de -1 para detener el proceso que llame a este méotodo.
		if (!encontrado) {
			System.out.println("Lo siento, no encuentro " + nombre + ".");
		}

		return posicion;

	}

}
