package ejemplo6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejemplo1Cliente {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		String Host = "localhost";
		int Puerto = 6000; // puerto remoto

		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente = new Socket(Host, Puerto);

		// Crear flujo de salida al servidor

		DataOutputStream flujoSalida = new DataOutputStream(
				Cliente.getOutputStream());

		// Env�o de un saludo al servidor

		flujoSalida.writeUTF("Saludos al servidor desde el cliente");

		// Crear flujo de entrada al servidor

		DataInputStream flujoEntrada = new DataInputStream(
				Cliente.getInputStream());

		// El servidor me env�a un mensaje

		System.out.println("Recibiendo del servidor: \n\t"
				+ flujoEntrada.readUTF());

		// Cerrar streams y sockets

		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();

	}

}
