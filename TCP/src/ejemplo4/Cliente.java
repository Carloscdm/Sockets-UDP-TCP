package ejemplo4;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		String Host = "localhost";
		int Puerto = 6000; // puerto remoto

		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente = new Socket(Host, Puerto);

		// Crear flujo de entrada al servidor

		DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());

		// El servidor me envía un mensaje

		String mensaje = flujoEntrada.readUTF();
		System.out.println("Recibiendo del servidor: \n\t"
				+ mensaje);
		
		// Crear flujo de salida al servidor

		DataOutputStream flujoSalida = new DataOutputStream(
				Cliente.getOutputStream());

		// Reenvío el mensaje  al servidor
		
		System.out.println("Reenvío el mensaje al servidor...");

		flujoSalida.writeUTF(mensaje);

		// Cerrar streams y sockets

		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();

	}

}
