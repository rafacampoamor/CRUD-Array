import java.util.Date;

public class MetodosCRUD {

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
}
