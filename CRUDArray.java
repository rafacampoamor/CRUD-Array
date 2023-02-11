import java.util.Date;

public class CRUDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selector = 0;
		int posiciones = 20;
		String[] titulo = new String[posiciones];
		String[] descripcion = new String[posiciones];
		Date[] fechaLimite = new Date[posiciones];

		do {
			selector = MetodosCRUD.menu();
			switch (selector) {
				case 1: {
					MetodosCRUD.listar(posiciones, titulo, descripcion, fechaLimite);
					break;
				}

				case 2: {
					MetodosCRUD.addTarea(posiciones, titulo, descripcion, fechaLimite);
					break;
				}
				case 3: {
					MetodosCRUD.ModificarTarea(posiciones, titulo, descripcion, fechaLimite);
					break;
				}
				case 4: {
					MetodosCRUD.eliminarTarea(posiciones, titulo, descripcion, fechaLimite);
				}
				case 5: {
					MetodosCRUD.Buscar(posiciones, titulo, descripcion, fechaLimite);
					Utilidades.pausa();
					break;
				}
				default:
					break;
			}
		} while (selector != 6);

	}

}
