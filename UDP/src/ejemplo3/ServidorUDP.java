package ejemplo3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
  public static void main(String[] argv) throws Exception {
    byte[] bufer = new byte[1024];//para recibir el datagrama 

    // Asocio el socket para escuchar peticiones de conexi�n al puerto UDP 12345
    
    DatagramSocket socket = new DatagramSocket(12345);
    
    System.out.println("Esperando Datagrama .......... ");    
    DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
    socket.receive(recibo);//recibo datagrama

    int bytesRec = recibo.getLength();//obtengo numero de bytes
    String paquete= new String(recibo.getData());//obtengo String
    
    System.out.println("N�mero de Bytes recibidos: "+ bytesRec);    
	System.out.println("Contenido del Paquete    : " + paquete.trim() );
	System.out.println("Puerto origen del mensaje: " + recibo.getPort());	
	System.out.println("IP de origen             :" + recibo.getAddress().getHostAddress());	
	System.out.println("Puerto destino del mensaje:" +socket.getLocalPort());
	
	socket.close(); //cierro el socket
  }
}
