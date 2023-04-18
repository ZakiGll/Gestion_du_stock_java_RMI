package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Intefaces.ClientInterface;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface{

	protected ClientImpl() throws RemoteException {}


	public void alerte() throws RemoteException {
		System.out.println("Une modification a �t� effectu� sur le stock !");
	}

}
