package ejemplo4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class clienteMC1 {

	public static void main(String[] args) throws IOException {
		
		
		// Creamos el socket multicast
		
		int Puerto = 12345;
		MulticastSocket ms = new MulticastSocket(Puerto);
		InetAddress grupo = InetAddress.getByName("225.0.0.1");
		
		// El cliente se une al grupo, con el método de la clase MulticastSocket: joinGroup que permite
		// al socket multicast unirse al grupo de multicast
		
		ms.joinGroup(grupo);
		
		String msg = "";
		
		
		// el cliente visualiza los paquetes que recibe del servidor y finaliza cuando recibe un *
		
		while (!msg.trim().equals("*")){
			// Recibe el paquete del servidor multicast
			byte [] buf = new byte[1000];
			DatagramPacket paquete = new DatagramPacket(buf, buf.length);
			ms.receive(paquete);
			msg = new String(paquete.getData());
			System.out.println("Recibo: " + msg.trim());
			
			
		}
		
		// El cliente abandona el grupo
		ms.leaveGroup(grupo);
		
		// Cerramos el socket
		
		ms.close();
		System.out.println("Socket cerrado...");
		
	}

}
