package ejer2;

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
		
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		
		Pais pais = new Pais("España", 20000,"Europa");
		outObjeto.writeObject(pais);
		System.out.println("Envío: " + pais.getNombre() + "*" + pais.getHabitantes()+ "*" + pais.getContinente());
		
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Pais dato = (Pais) inObjeto.readObject();
		System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getHabitantes()+ "*" + dato.getContinente());
		
		outObjeto.close();
		inObjeto.close();
		cliente.close();
		servidor.close();		
	}
}
