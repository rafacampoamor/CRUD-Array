import java.util.Date;

public class CRUDArray extends Tarea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selector = 0;
		
		Tarea nuevaTarea = new Tarea();

		do {
			selector = menu();
			switch (selector) {
			case 1: {

				// Aqui se listan todas las tareas y se añade una si el Array está vacío
				listarTareas(nuevaTarea);
				// aqui va un switch para modificar o borrar
				selector = submenu();
				switch (selector) {
				case 1: {
					modificarTarea(nuevaTarea);
					break;
				}
				case 2: {
					borrarTarea(nuevaTarea);
					break;
				}

				default:
					break;
				}

			}

			case 2: {
				crearTarea(nuevaTarea);
				break;
			}
			case 3: {
				modificarTarea(nuevaTarea);
				break;
			}
			case 4: {
				borrarTarea(nuevaTarea);
				break;
			}
			case 5: {
				buscarTarea(nuevaTarea);
				
				break;
			}

			default:
				break;
			}
		} while (selector != 6);

	}

	private static void buscarTarea(Tarea nuevaTarea) {
		// TODO Auto-generated method stub
	
		
		String busqueda = Utilidades.PedirString("\nBuscar Tarea:");
		int contador = buscarPosicionNombre(nuevaTarea.getTitulo(), busqueda);
		if (contador >= 0 && contador < nuevaTarea.getPosiciones()) {
			System.out.println(
					nuevaTarea.getTitulo()[contador] + " -- " + nuevaTarea.getDescripcion()[contador] + " -- " + nuevaTarea.getFechaLimite()[contador]);
		}
		Utilidades.pausa();
	}

	private static void borrarTarea(Tarea nuevaTarea) {
		// TODO Auto-generated method stub
		int contador = 0;
		boolean esnumero = false;
		char sino = 'n';

		String busqueda = Utilidades.PedirString("\n¿Qué quieres borrar?");
		esnumero = Utilidades.sonNumeros(busqueda);
		if (esnumero) {
			contador = Integer.parseInt(busqueda);
			if (contador >= 0 && contador < nuevaTarea.getPosiciones() && nuevaTarea.getTitulo()[contador] != null) {
				sino = Utilidades.PedirChar("\n¿Seguro que quieres borrar " + nuevaTarea.getTitulo()[contador] + " del "
						+ nuevaTarea.getFechaLimite()[contador] + "? (S/N)\nEste cambio no se podrá deshacer");
				if (sino == 's') {

					nuevaTarea.getTitulo()[contador] = null;
					nuevaTarea.getDescripcion()[contador] = null;
					nuevaTarea.getFechaLimite()[contador] = null;
					System.out.println("\nTarea borrada con éxito");
				} else {

				}
				Utilidades.pausa();
			} else {
				System.out.println("No encuentro lo que quieres borrar");
				Utilidades.pausa();
			}
		} else if (!esnumero) {
			contador = buscarPosicionNombre(nuevaTarea.getTitulo(), busqueda);
			if (contador >= 0 && contador < nuevaTarea.getPosiciones() && nuevaTarea.getTitulo()[contador] != null) {
				System.out.println("Modificando " + nuevaTarea.getTitulo()[contador] + " del "
						+ nuevaTarea.getFechaLimite()[contador]);

				nuevaTarea.getTitulo()[contador] = anadirTitulo();
				nuevaTarea.getDescripcion()[contador] = anadirDescripcion();
				nuevaTarea.getFechaLimite()[contador] = anadirFecha();
				System.out.println("\n" + nuevaTarea.getTitulo()[contador] + " ha sido modificado para el "
						+ nuevaTarea.getFechaLimite()[contador]);

			} else {
				System.out.println("No encuentro lo que quieres modificar");
				Utilidades.pausa();
			}
		} else if (!esnumero) {
			contador = buscarPosicionNombre(nuevaTarea.getTitulo(), busqueda);
			if (contador >= 0 && contador < nuevaTarea.getPosiciones() && nuevaTarea.getTitulo()[contador] != null) {
				sino = Utilidades.PedirChar("\n¿Seguro que quieres borrar " + nuevaTarea.getTitulo()[contador] + " del "
						+ nuevaTarea.getFechaLimite()[contador] + "? (S/N)\nEste cambio no se podrá deshacer");
				if (sino == 's') {

					nuevaTarea.getTitulo()[contador] = null;
					nuevaTarea.getDescripcion()[contador] = null;
					nuevaTarea.getFechaLimite()[contador] = null;
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

	private static void modificarTarea(Tarea nuevaTarea) {
		// TODO Auto-generated method stub
		int contador = 0;

		String busqueda = Utilidades.PedirString("¿Qué quieres modificar?");
		boolean esnumero = Utilidades.sonNumeros(busqueda);
		if (esnumero) {
			contador = Integer.parseInt(busqueda);
			if (contador >= 0 && contador < nuevaTarea.getPosiciones() && nuevaTarea.getTitulo()[contador] != null) {
				System.out.println("Modificando " + nuevaTarea.getTitulo()[contador] + " del "
						+ nuevaTarea.getFechaLimite()[contador]);

				nuevaTarea.getTitulo()[contador] = anadirTitulo();
				nuevaTarea.getDescripcion()[contador] = anadirDescripcion();
				nuevaTarea.getFechaLimite()[contador] = anadirFecha();
				System.out.println(nuevaTarea.getTitulo()[contador] + " ha sido modificado para el "
						+ nuevaTarea.getFechaLimite()[contador]);
			} else {
				System.out.println("Lo siento, no encuentro lo que quieres modificar");
				Utilidades.pausa();

			}
		}
	}

	private static void listarTareas(Tarea nuevaTarea) {
		// TODO Auto-generated method stub
		// Aqui se listan todas las tareas
		System.out.println("\n\n LISTA DE\n TAREAS\n-----------------\n\n");
		int contador = 0;
		boolean ListaVacia = true;
		char sino = 'n';
		while (contador < nuevaTarea.getPosiciones() && nuevaTarea.getTitulo()[0] != null) {
			if (nuevaTarea.getTitulo()[contador] != null) {
				ListaVacia = false;
				System.out.println(contador + ". " + nuevaTarea.getTitulo()[contador] + " -- "
						+ nuevaTarea.getDescripcion()[contador] + " -- " + nuevaTarea.getFechaLimite()[contador]);
			}
			contador++;
		}
		if (ListaVacia) {
			// si no hay tareas, se añade una
			System.out.println("La lista está vacía");
			sino = Utilidades.PedirChar("Añadir tarea? (S/N)");
			if (sino == 's') {
				crearTarea(nuevaTarea);
			}
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
		String titulo, descripcion;
		Date fechaLimite;

		do {
			if (nuevaTarea.getTitulo()[contador] == null) {
				encontrado = true;
			} else {
				contador++;
				if (contador == nuevaTarea.getTitulo().length) {
					lleno = true;
					errorLleno(nuevaTarea.getTitulo().length);
					break;
				}
			}
		} while (contador < nuevaTarea.getTitulo().length && !encontrado);

		if (encontrado && !lleno) {
			titulo = anadirTitulo();
			descripcion = anadirDescripcion();
			fechaLimite = anadirFecha();
			nuevaTarea.getTitulo()[contador] = titulo;
			nuevaTarea.getDescripcion()[contador] = descripcion;
			nuevaTarea.getFechaLimite()[contador] = fechaLimite;
			System.out.println("\n" + nuevaTarea.getTitulo()[contador] + " ha sido añadido para el "
					+ nuevaTarea.getFechaLimite()[contador]);
			Utilidades.pausa();
		} else if (lleno) {
			errorLleno(nuevaTarea.getTitulo().length);
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

}
