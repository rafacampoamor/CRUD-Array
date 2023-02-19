
public class Main {

	public static void main(String[] args) {
		int selector = 0;
		Tarea unaTarea = new Tarea();

		do {
			selector = metodos.menu();
			switch (selector) {
				case 1: {
					metodos.listarTareas(unaTarea);
					break;
				}
				case 2: {
					metodos.crearTarea(unaTarea);
					break;
				}
				case 3: {
					metodos.modificarTarea(unaTarea);
					break;
				}
				case 4: {
					metodos.borrarTarea(unaTarea);
					break;
				}
				case 5: {
					metodos.buscarTarea(unaTarea);
					break;
				}

				default:
					break;
			}
		} while (selector != 6);

	}

}