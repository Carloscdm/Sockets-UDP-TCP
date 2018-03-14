/* La clase 


*/
package ejemplo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServidorMC1 {

	public static void main(String[] args) throws IOException {
		
		/* Construimos un servidor multicast que lee datos por teclado y los envía a todos
		 * los clientes que pertenecen al grupo multicast, el proceso terminará cuando se 
		 * introduzca un *
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// Se crea el socket multicast
		MulticastSocket ms = new MulticastSocket();
		
		// Se crea el puerto multicast
		
		int Puerto = 12345;
		
		InetAddress grupo = InetAddress.getByName("225.0.0.1");
		
		// Creamos el grupo multicast
		
		String cadena="";
		
		while(!cadena.trim().equals("*")){
			System.out.print("Vamos a enviar datos al grupo:");
			cadena = in.readLine();
			
			// Construyendo un datagrama para enviar al grupo
			
			DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, Puerto);
			
			ms.send(paquete);
		
		}
		
		// Se cierra el socket
		
		ms.close();
	
	
	}

}
