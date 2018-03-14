package ejemplo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int puerto = 6000; // puerto remoto
		Socket cliente = new Socket(host, puerto);

		// Se crea el flujo de salida al servidor

		PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(), true);

		// Se crea el flujo de entrada al servidor

		BufferedReader fentrada = new BufferedReader(new InputStreamReader(
				cliente.getInputStream()));

		// Se crea el flujo para la entrada estándar

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String cadena, eco = "xx";
		System.out.println("Introduce cadena:");
		cadena = in.readLine();

		while (cadena != null && !cadena.equals("*")) {
			fsalida.println(cadena); // envío de cadena al servidor
			eco = fentrada.readLine(); // se recibe cadena desde el servidor
			System.out.println("   =>ECO: " + eco);
			System.out.print("Introduce cadena:");
			cadena = in.readLine();

		}
		System.out.println("CLIENTE FINALIZADO...");
		fsalida.close();
		fentrada.close();
		System.out.println("Fin del envío... ");
		in.close();
		cliente.close();

	}

}
