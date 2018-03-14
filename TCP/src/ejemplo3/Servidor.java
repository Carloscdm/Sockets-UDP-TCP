package ejemplo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Servidor {

	public static void main(String[] args) throws IOException {
		/*
		 * En el siguiente ejemplo el programa cliente envía el texto tecleado
		 * en su entrada estándar al servidor, el servidor lee del socket y
		 * devuelve de nuevo al cliente el texto recibido escribiendo en el
		 * socket. El programa cliente lee del socket lo que le envía el
		 * servidor de vuelta y lo muestra en pantalla. El programa servidor
		 * finaliza cuando el cliente termine la entra por teclado o cuando
		 * recibe como cadena un asterisco. El cliente finaliza cuando se
		 * detiene la entrada de datos mediante las teclas CTRL+C o CTRL+Z
		 */
		int numeroPuerto = 6000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		String cad = "";

		System.out.println("Esperando conexión...");
		Socket clienteConectado = servidor.accept();

		System.out.println("Cliente conectado");

		// Se crea flujo de salida al cliente

		PrintWriter fsalida = new PrintWriter(
				clienteConectado.getOutputStream(), true);

		// Se crea flujo de entrada al cliente

		BufferedReader fentrada = new BufferedReader(new InputStreamReader(
				clienteConectado.getInputStream()));

		while ((cad= fentrada.readLine()) != null  && !cad.equals("*")) {
			fsalida.println(cad); // Envío de cadena al cliente
			System.out.println("Recibiendo: " + cad);
			//if (cad.equals("*"))
				//break;

		}

		System.out.println("SERVIDOR FINALIZADO...");
		// Cerrar streams y sockets

		System.out.println("Cerrando conexión...");
		fentrada.close();
		fsalida.close();
		clienteConectado.close();
		servidor.close();

	}

}