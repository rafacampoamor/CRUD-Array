import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utilidades {
	/**
	 * Solicita al usuario un entero por consola.
	 *
	 * @param texto el texto a mostrar al solicitar el número
	 * @return el entero ingresado por el usuario
	 */

	public static int pedirInt(String texto) {
		int numero = 0;
		boolean valido = false;

		Scanner lector = new Scanner(System.in);

		System.out.println(texto);
		while (!lector.hasNextInt()) {
			System.out.println("Por favor ingresa un número entero válido.");
			lector.nextLine();
		}
		numero = lector.nextInt();
		lector.close();
		return numero;
	}

	/**
	 * Pide al usuario que introduzca una cadena de caracteres por consola y la
	 * devuelve.
	 *
	 * @param texto El texto a mostrar al usuario como indicación de lo que debe
	 *              introducir.
	 * @return La cadena de caracteres introducida por el usuario.
	 */

	public static String PedirString(String texto) {
		String cadena;
		Scanner lector = new Scanner(System.in);
		System.out.println(texto);
		while (!lector.hasNextLine()) {
			System.out.println("Por favor, ingrese un valor válido");
			lector.next();
		}
		cadena = lector.nextLine();
		lector.close();
		return cadena;
	}

	/**
	 * 
	 * Pedir un caracter al usuario.
	 * 
	 * @param texto Texto a mostrar al usuario antes de pedir el caracter.
	 * @return El caracter introducido por el usuario.
	 */
	public static char PedirChar(String texto) {
		char caracter;
		Scanner lector = new Scanner(System.in);
		System.out.println(texto);
		caracter = lector.next().charAt(0);
		lector.close();
		return caracter;
	}

	/**
	 * 
	 * Pedir una fecha al usuario y devolverla en formato Date
	 * 
	 * @param texto El texto a mostrar al usuario para pedir la fecha
	 * @return fecha La fecha introducida por el usuario en formato Date. Si la
	 *         fecha introducida no es válida, devuelve null.
	 */
	public static Date pedirFecha(String texto) {
		Date fecha = null;
		Scanner lector = new Scanner(System.in);
		System.out.println(texto);
		String fechaString = lector.nextLine();
		try {
			fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);
		} catch (ParseException e) {
			System.out
					.println("La fecha introducida no es válida. Por favor, introduce una fecha en formato dd/MM/yyyy");
		}
		lector.close();
		return fecha;
	}

	/**
	 * 
	 * Generar una pausa en la ejecución del programa y esperar a que el usuario
	 * presione cualquier tecla para continuar. Utiliza un objeto Scanner para leer
	 * la entrada del usuario.
	 */
	public static void pausa() {
		Scanner lector = new Scanner(System.in);
		System.out.println("\nPresiona ENTER para continuar...");
		lector.nextLine();
		lector.close();
	}

	/**
	 * Permite determinar si una cadena de caracteres contiene únicamente números.
	 * 
	 * @param cadena Cadena de caracteres a evaluar.
	 * @return Verdadero si la cadena contiene únicamente números, falso en caso
	 *         contrario.
	 */
	public static boolean sonNumeros(String cadena) {

		boolean valido = true;
		int longitud = cadena.length();
		int contador = 0;
		String numeros = "0123456789";
		// LA MANERA CORRECTA DE BUSCAR UN VALOR DENTRO DE UN ARRAY O DE UNA CADENA
		while (contador < longitud && valido) {
			if (numeros.indexOf(cadena.charAt(contador)) == -1) {
				valido = false;
			} else {
				contador++;
			}

		}
		return valido;

	}

	/**
	 * Recibe un número entero y muestra por pantalla el número de dígitos que
	 * tiene. Si el número es cero, muestra por pantalla que tiene un dígito.
	 * 
	 * @param numero un entero que representa el número a evaluar.
	 * @return un entero que representa el número de dígitos del número dado.
	 */

	public static int contadorDigitos(int numero) {
		int digitos = 0;
		for (int i = numero; i > 0; i /= 10) {
			digitos++;
		}

		return digitos;
	}

	/**
	 * Convierte una cadena de texto a su representación ASCII.
	 * 
	 * @param cadena La cadena de texto a convertir.
	 * @return La representación ASCII de la cadena de texto.
	 */

	public static int[] conversorASCII(String cadena) {
		int caracterAscii;

		int[] cadenaASCII = new int[cadena.length()];
		for (int i = 0; i < cadena.length(); i++) {
			caracterAscii = (int) cadena.charAt(i);
			cadenaASCII[i] = caracterAscii;
		}
		return cadenaASCII;
	}

}