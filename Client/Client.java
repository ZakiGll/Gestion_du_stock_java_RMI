package Client;

import java.rmi.Naming;
import java.util.*;

import Intefaces.*;
import Model.Produit;
public class Client {
	
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		try {
			StockInterface obj = (StockInterface) Naming.lookup("//:2000/stock");
			obj.enregistrerClient(new ClientImpl());
			int continuer = 0;
			while (continuer != 1) {
				System.out.println("Que voulez-vous faire ? ");
				System.out.println("1- Consultez la liste des produits \n2- Ajoutez un produit \n"
						+ "3- Ajoutez une quantité d'un produit \n4- Retirez une quantité d'un produit "
						+ "\n5- Consultez la quantité d'un produit \n6- Quittez");
				int opp = scanner.nextInt();
				switch(opp) {
				case 1:
					System.out.println("------------------------------------------------");
					ArrayList<Produit> produits = obj.getProduits();
					for (Produit produit : produits) {
						System.out.println("Produit: "+produit.getNom()+" Quantité: "+produit.getQuantite());
					}
					System.out.println("------------------------------------------------");
					break;
				case 2:
					System.out.println("------------------------------------------------");
					System.out.print("Le nom: ");
					scanner.nextLine();
					String nom = scanner.nextLine();
					System.out.print("La quantité: ");
					int quantite = scanner.nextInt();
					obj.addProduit(new Produit(nom,quantite));
					System.out.println("------------------------------------------------");
					break;
				case 3:
					System.out.println("------------------------------------------------");
					System.out.print("Le nom du produit: ");
					scanner.nextLine();
					String nom1 = scanner.nextLine();
					System.out.println("La quantité à ajouter: ");
					int quantite1 = scanner.nextInt();
					obj.ajouterQuantite(nom1, quantite1);
					System.out.println("------------------------------------------------");
					break;
				case 4:
					System.out.println("------------------------------------------------");
					System.out.print("Le nom du produit: ");
					scanner.nextLine();
					String nom2 = scanner.nextLine();
					System.out.println("La quantité à retirer: ");
					int quantite2 = scanner.nextInt();
					obj.retirerQuantite(nom2, quantite2);
					System.out.println("------------------------------------------------");
					break;
				case 5:
					System.out.println("------------------------------------------------");
					System.out.print("Le nom du produit: ");
					scanner.nextLine();
					String nom3 = scanner.nextLine();
					System.out.println("La quantité de "+nom3+" est: "+obj.getQuantite(nom3));
					System.out.println("------------------------------------------------");
					break;
				case 6:
					continuer = 1;
					System.out.print("Merci pour votre visite !");
					break;
				default:
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
