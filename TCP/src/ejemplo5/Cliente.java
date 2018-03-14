package ejemplo5;


	import java.io.*;
	import java.net.*;

	public class Cliente {
	  public static void main(String[] args) throws Exception {
		String Host = "localhost";
		int Puerto = 6000;
		System.out.println("Conectando con el servidor...");

		// ABRIR SOCKET
		Socket Cliente = new Socket(Host, Puerto);

		// RECIBO SALUDO DEL SERVIDOR
		InputStream aux = Cliente.getInputStream();
		DataInputStream flujo = new DataInputStream(aux);
		System.out.println("Recibiendo del servidor: " + 
	                           flujo.readUTF());

		Cliente.close();// Cierra el socket
	  }// main
	}//

