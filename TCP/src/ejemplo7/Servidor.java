package ejemplo7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int numeroPuerto = 6000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		System.out.println("Esperando al cliente...");
		Socket cliente = servidor.accept();
		
		// Se prepara un flujo de salida para objetos
		
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		
		// Se prepara un objeto y se env�a
		
		Persona per = new Persona("Juan", 20);
		outObjeto.writeObject(per);
		System.out.println("Env�o: " + per.getNombre() + "*" + per.getEdad());
		
		// Se obtine un stream para leer objetos
		
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Persona dato = (Persona) inObjeto.readObject();
		System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());
		
		// CERRAR STREAMS Y SOCKETS
		
		outObjeto.close();
		inObjeto.close();
		cliente.close();
		servidor.close();
		
		
	}

}