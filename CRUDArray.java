import java.util.Date;

public class CRUDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selector = 0;
		int contador = -1;
		int posiciones = 3;
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
		String busqueda = new String();
		boolean esnumero = false;

		do {
			selector = menu();
			switch (selector) {
			case 1: {
				// Aqui se listan todas las tareas
				System.out.println("\n\n LISTA DE\n TAREAS\n-----------------\n\n");
				contador = 0;
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
						System.out.println(titulo[contador] + " ha sido añadido para el " + fechaLimite[contador]);
					}

				} else {
					// aqui va un switch para modificar o borrar
					selector = submenu();
					switch (selector) {
					case 1: {
						busqueda = Utilidades.PedirString("¿Qué quieres modificar?");
						esnumero = Utilidades.sonNumeros(busqueda);
						if (esnumero) {
							contador = Integer.parseInt(busqueda);
							if (contador < posiciones) {
								System.out.println("Modificando " + titulo[contador] + " del " + fechaLimite[contador]);
								nuevoTitulo = anadirTitulo();
								titulo[contador] = nuevoTitulo;
								nuevaDescripcion = anadirDescripcion();
								descripcion[contador] = nuevaDescripcion;
								nuevaFecha = anadirFecha();
								fechaLimite[contador] = nuevaFecha;
								System.out.println(
										titulo[contador] + " ha sido modificado para el " + fechaLimite[contador]);
							}
						} else if (!esnumero) {
							contador = buscarPosicionNombre(titulo, busqueda);
							System.out.println("Modificando " + titulo[contador] + " del " + fechaLimite[contador]);
							nuevoTitulo = anadirTitulo();
							titulo[contador] = nuevoTitulo;
							nuevaDescripcion = anadirDescripcion();
							descripcion[contador] = nuevaDescripcion;
							nuevaFecha = anadirFecha();
							fechaLimite[contador] = nuevaFecha;
							System.out
									.println(titulo[contador] + " ha sido modificado para el " + fechaLimite[contador]);
						} else {
							System.out.println("Lo siento, no encuentro lo que buscas");
						}
					}
					case 2: {
						busqueda = Utilidades.PedirString("¿Qué quieres modificar?");
						esnumero = Utilidades.sonNumeros(busqueda);
						if (esnumero) {
							contador = Integer.parseInt(busqueda);
							if (contador < posiciones) {
								sino = Utilidades.PedirChar("Seguro que quieres borrar " + titulo[contador] + " del " + fechaLimite[contador] + "? (S/N)\nEste cambio no se podrá deshacer");
								if (sino == 's') {

									nuevoTitulo = null;
									titulo[contador] = nuevoTitulo;
									nuevaDescripcion = null;
									descripcion[contador] = nuevaDescripcion;
									nuevaFecha = null;
									fechaLimite[contador] = nuevaFecha;
									System.out.println("Tarea borrada con éxito");
								}else {
									break;
								}
							}
						}
					}
					default:
						break;
					}
				}
				Utilidades.pausa();
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
					System.out.println(titulo[contador] + " ha sido añadido para el " + fechaLimite[contador]);
					Utilidades.pausa();
				} else if (lleno) {
					errorLleno(posiciones);
				}
				break;
			}
			case 3: {
				busqueda = Utilidades.PedirString("¿Qué quieres modificar?");
				esnumero = Utilidades.sonNumeros(busqueda);
				if (esnumero) {
					contador = Integer.parseInt(busqueda);
					if (contador < posiciones) {
						System.out.println("Modificando " + titulo[contador] + " del " + fechaLimite[contador]);
						nuevoTitulo = anadirTitulo();
						titulo[contador] = nuevoTitulo;
						nuevaDescripcion = anadirDescripcion();
						descripcion[contador] = nuevaDescripcion;
						nuevaFecha = anadirFecha();
						fechaLimite[contador] = nuevaFecha;
						System.out.println(titulo[contador] + " ha sido modificado para el " + fechaLimite[contador]);
					}
				} else if (!esnumero) {
					contador = buscarPosicionNombre(titulo, busqueda);
					System.out.println("Modificando " + titulo[contador] + " del " + fechaLimite[contador]);
					nuevoTitulo = anadirTitulo();
					titulo[contador] = nuevoTitulo;
					nuevaDescripcion = anadirDescripcion();
					descripcion[contador] = nuevaDescripcion;
					nuevaFecha = anadirFecha();
					fechaLimite[contador] = nuevaFecha;
					System.out.println(titulo[contador] + " ha sido modificado para el " + fechaLimite[contador]);
				} else {
					System.out.println("Lo siento, no encuentro lo que buscas");
				}
			}

			default:

			}
		} while (selector != 6);

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
				"\n¿Qué quieres hacer?\n1. Modificar una tarea\n2. Borrar una tarea\n3. Atrás\n-----------------\n\n   Selecciona \n   una opción\n\n-----------------");
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
				if (lista[i].equals(nombre)) {
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
