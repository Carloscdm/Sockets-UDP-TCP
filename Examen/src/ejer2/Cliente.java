package ejer2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		String Host = "localhost";
		int Puerto = 6000; // puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket cliente = new Socket(Host, Puerto);
		
		ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
		
		Pais pais = (Pais) perEnt.readObject();
		System.out.println("Recibo: " + pais.getNombre() + "*" + pais.getHabitantes()+ "*" + pais.getContinente());
		
		pais.setNombre("EEUU");
		pais.setHabitantes(2131331);
		pais.setContinente("America");
		
		ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
		
		perSal.writeObject(pais);
		System.out.println("Envío: " + pais.getNombre() + "*" + pais.getHabitantes()+ "*" + pais.getContinente());
		
		perEnt.close();
		perSal.close();
		cliente.close();	
	
	}

}