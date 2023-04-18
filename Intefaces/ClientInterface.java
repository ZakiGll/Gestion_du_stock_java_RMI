package Intefaces;

import java.rmi.*;

public interface ClientInterface extends Remote{
	
	public void alerte() throws RemoteException;
	
}
