package ejer1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = null;
		byte[] bufer = null;
		byte[] mensaje = null;	
		DatagramPacket recibo = null;
		String texto = "Soy el servidor";
		String paquete = "";
		InetAddress direccion = null;
		DatagramPacket envio = null;
		System.out.println("Creando socket servidor... ");
		do {
			socket = new DatagramSocket(12345);
			
			direccion = InetAddress.getLocalHost();
			bufer = new byte[1024];
			recibo = new DatagramPacket(bufer, bufer.length);
			socket.receive(recibo);
			paquete = new String(recibo.getData());
			 System.out.println("Mensaje recibido...");

			//--------------------------------------------------------------------------------------
				mensaje = new byte[1024];
				mensaje = texto.getBytes();
				envio = new DatagramPacket(mensaje, mensaje.length, direccion, recibo.getPort());
				socket.send(envio);
				System.out.println("Enviando mensaje desde el servidor");
				System.out.println("");
				socket.close();
		} while (paquete.trim().equals("Identificate"));
	}
}