package Intefaces;

import java.rmi.*;
import java.util.*;

import Model.Produit;

public interface StockInterface extends Remote{
	
	public ArrayList<Produit> getProduits() throws RemoteException;
	public int getQuantite(String nomProduit) throws RemoteException;
	public void ajouterQuantite(String nomProduit ,int quantite) throws RemoteException;
	public void retirerQuantite(String nomProduit ,int quantite) throws RemoteException;
	public void addProduit(Produit produit) throws RemoteException;
	public void enregistrerClient(ClientInterface client) throws RemoteException;
	public void notifierClients() throws RemoteException;
}
