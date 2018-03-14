package ejer1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
	//udp
	public static void main(String[] args) throws IOException {
		InetAddress destino = InetAddress.getLocalHost();
		byte[] bufer = new byte[1024];		 
	    int port = 12345;
	    byte[] mensaje = new byte[1024];   
	    
	    String texto="Identificate";
	    mensaje = texto.getBytes();  
	    
	   
	    DatagramPacket envio = new DatagramPacket
		   (mensaje, mensaje.length, destino, port);
	    DatagramSocket socket = new DatagramSocket(34567);
	    
	    System.out.println("Creando socket servidor...");
		System.out.println("Enviando pregunta...");
	   	
	    socket.send(envio);
	    
	 // --------------------------------------------------------------------------------------

	 		DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
	 		socket.receive(recibo);

	 		String paquete = new String(recibo.getData());
	 		System.out.println("Respuesta recibida: "+paquete);
	 		System.out.println("");
	 		System.out.println("Finalizando...");
	 		socket.close();
	  }
	}