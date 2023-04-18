package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import Intefaces.ClientInterface;
import Intefaces.StockInterface;
import Model.Produit;

public class StockImpl  extends UnicastRemoteObject implements StockInterface{

	HashMap<String,Produit> produits;
	ArrayList<ClientInterface> clients;
	
	protected StockImpl() throws RemoteException {
		super();
		produits = new HashMap<>();
		clients = new ArrayList<>();
		produits.put("Lait", new Produit("Lait",50));
		produits.put("Farine", new Produit("Farine",30));
		produits.put("Sucre", new Produit("Sucre",75));
		produits.put("Caffe", new Produit("Caffe",45));
	}


	public ArrayList<Produit> getProduits() throws RemoteException {
		if (produits.isEmpty()) return null;
		else return new ArrayList<>(produits.values());
	}


	public int getQuantite(String nomProduit) throws RemoteException {
		if (produits.containsKey(nomProduit)) {
			return produits.get(nomProduit).getQuantite();
		}
		else return 0;
	}


	public void addProduit(Produit produit) throws RemoteException {
		if (!produits.containsKey(produit.getNom())) {
			produits.put(produit.getNom(), produit);
			System.out.println("Produit ajouté !");
			notifierClients();
		}
		else System.out.println("Produit existe deja !");
	}
	
	public void ajouterQuantite(String nomProduit ,int quantite) throws RemoteException {
		if (produits.containsKey(nomProduit)) {
			produits.put(nomProduit, new Produit(nomProduit,getQuantite(nomProduit)+quantite));
			notifierClients();
		}
		else System.out.println("Produit n'existe pas !");
	}
	
	public void retirerQuantite(String nomProduit ,int quantite) throws RemoteException {
		if (produits.containsKey(nomProduit)) {
			if(getQuantite(nomProduit) < quantite) {
				produits.put(nomProduit, new Produit(nomProduit,0));
			}
			else{
				produits.put(nomProduit, new Produit(nomProduit,getQuantite(nomProduit)-quantite));
			}
			notifierClients();
		}
		else System.out.println("Produit n'existe pas !");
	}


	public void enregistrerClient(ClientInterface client) throws RemoteException {
		clients.add(client);	
	}


	public void notifierClients() throws RemoteException {
		for (ClientInterface client : clients) {
			client.alerte();
		}
		
	}
	
}
