package Server;

import java.rmi.*;


public class Serveur {
	public static void main(String[] argv){
		try {
			StockImpl object = new StockImpl();
			java.rmi.registry.LocateRegistry.createRegistry(2000);
			Naming.rebind("//:2000/stock", object);
			System.out.println("Serveur en attente ");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
