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
		int numero;
		Scanner lector = new Scanner(System.in);
		System.out.println(texto);
		numero = lector.nextInt();
		lector.nextLine();
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
		cadena = lector.nextLine();
		return cadena;
	}

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
		return fecha;
	}

	/**
	 * Método que permite determinar si una cadena de caracteres contiene únicamente
	 * números.
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