package com.company;
import java.util.*;

/* 
 * Classe che definisce una batteria di test con la quale è possibile verificare il fuznionamento
 *  delle 2 implementazioni dell'interfaccia Databord. 
 * La batteria di test è pronta per testare la prima implementazione di Databoard.
 * Se si vuole testare la seconda implementazione è neccessario commentare la prima e decommentare la seconda
 */


public class Main {
	
	public static void main (String [] args) {
		
		String passw = "test";
		DataBoard<Data> bacheca = new MyDataBoard<>(passw);		//oggetto di tipo Data istaziato con la 1a implementazione
		//DataBoard<Data> bacheca = new MyDataBoardV2<Data>(passw);		//oggetti di tipo Data istanziato con la seconda implementazione

		
		//oggetti di tipo Photo
		Photo foto1 = new Photo(4, "Il mare di pozzallo", "Pozzallo", 2018, 11, 30);
		Photo foto2 = new Photo(5, "Quanto è sporco l'Arno!!", "Pisa", 2019, 11, 24);
		Photo foto3 = new Photo(3, "Le piagge", "Pisa", 2019, 07, 15);
		Photo foto4 = new Photo(2, "L'inverno a Torino", "Torino", 2019, 01, 30);
		Photo foto5 = new Photo(7, "Che confusione a Lucca!!", "Lucca", 2019, 11, 01);
		Photo foto6 = new Photo(2, "Aiuto!! Ho troppi libri", "Pisa", 2019, 07, 31);
		
		
		//Categorie
		String Categoria1 = "Libri";
		String Categoria2 = "Città";
		String Categoria3 = "Eventi";
		String Categoria4 = "Temporanea";
		
		//amici
		String amico1 = "Giorgio";
		String amico2 = "Ignazio";
		String amico3 = "Carmela";
		String amico4 = "Temporaneo";

		
		//Aggiunta della categoria Libri che va a buon fine
		try {
			bacheca.createCategory(Categoria1, passw);
			System.out.println("Categoria " + Categoria1 + " aggiunta\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryExistenceException e) {
			System.out.println("La categoria che si vuole aggiungere è stata aggiunta in precedenza\n");
		}
		
		//Aggiunta della categoria Città con password errata:
		//viene sollevata WrongPasswordException
		try {
			bacheca.createCategory(Categoria2, "ciao");
			System.out.println("Categoria " + Categoria2 + " aggiunta\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryExistenceException e) {
			System.out.println("La categoria che si vuole aggiungere è stata aggiunta in precedenza\n");
		}
		
		//Aggiunta della categoria Città che va a buon fine
		try {
			bacheca.createCategory(Categoria2, passw);
			System.out.println("Categoria " + Categoria2 + " aggiunta\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryExistenceException e) {
			System.out.println("La categoria che si vuole aggiungere è stata aggiunta in precedenza\n");
		}
		
		//Aggiunta della categoria Eventi che non va a buon fine poichè la password inserita è null:
		// solleva NullPointerException
		try {
			bacheca.createCategory(Categoria3, null);
			System.out.println("Categoria " + Categoria3 + " aggiunta\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryExistenceException e) {
			System.out.println("La categoria che si vuole aggiungere è stata aggiunta in precedenza\n");
		}

		//Aggiunta della categoria Eventi che va a buon fine
		try {
			bacheca.createCategory(Categoria3, passw);
			System.out.println("Categoria " + Categoria3 + " aggiunta\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryExistenceException e) {
			System.out.println("La categoria che si vuole aggiungere è stata aggiunta in precedenza\n");
		}
		
		//Aggiunta della categoria temporanea che va a buon fine
		try {
			bacheca.createCategory(Categoria4, passw);
			System.out.println("Categoria " + Categoria4 + " aggiunta\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryExistenceException e) {
			System.out.println("La categoria che si vuole aggiungere è stata aggiunta in precedenza\n");
		}
		
		//Aggiunta della categoria Città che non va a buon fine perchè aggiunta in precedenza:
		// solleva CategoryExistenceException
		try {
			bacheca.createCategory(Categoria2, passw);
			System.out.println("Categoria " + Categoria2 + " aggiunta\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryExistenceException e) {
			System.out.println("La categoria che si vuole aggiungere è stata aggiunta in precedenza\n");
		}
		
		//Rimozione della categoria temporanea che va a buon fine
		try {
			bacheca.removeCategory(Categoria4, passw);
			System.out.println("Categoria " + Categoria4 + " rimossa\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}

		//Rimozione della categoria temporanea che non va a buon fine perchè rimossa in precedenza:
		// solleva CategoryNotExistException
		try {
			bacheca.removeCategory(Categoria4, passw);
			System.out.println("Categoria " + Categoria4 + " Rimossa\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		
		// Aggiunta dell'amico Giorgio alla categoria Libri che va a buon fine
		try {
			bacheca.addFriend(Categoria1, passw, amico1);
			System.out.println(amico1 + "  è stato aggiunto alla categoria  " + Categoria1 + "\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, un amico e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		catch (FriendExistException e) {
			System.out.println("L'amico inserito  è già presente\n");
		}
		
		// Aggiunta dell'amico Giorgio alla categoria Eventi che va a buon fine
		try {
			bacheca.addFriend(Categoria3, passw, amico1);
			System.out.println(amico1 + "  è stato aggiunto alla categoria  " + Categoria3 + "\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, un amico e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		catch (FriendExistException e) {
			System.out.println("L'amico inserito  è già presente\n");
		}
		
		// Aggiunta dell'amico Ignazio alla categoria Libri che va a buon fine
		try {
			bacheca.addFriend(Categoria1, passw, amico2);
			System.out.println(amico2 + "  è stato aggiunto alla categoria  " + Categoria1 + "\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, un amico e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		catch (FriendExistException e) {
			System.out.println("L'amico inserito  è già presente\n");
		}
		
		// Aggiunta dell'amico Carmela alla categoria Libri che va a buon fine
		try {
			bacheca.addFriend(Categoria1, passw, amico3);
			System.out.println(amico3 + "  è stato aggiunto alla categoria  " + Categoria1 + "\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, un amico e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		catch (FriendExistException e) {
			System.out.println("L'amico inserito  è già presente\n");
		}
		
		// Aggiunta dell'amico temporaneo alla categoria Libri che va a buon fine
		try {
			bacheca.addFriend(Categoria1, passw, amico4);
			System.out.println(amico4 + "  è stato aggiunto alla categoria  " + Categoria1 + "\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, un amico e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		catch (FriendExistException e) {
			System.out.println("L'amico inserito  è già presente\n");
		}
		
		// Rimozione dell'amico temporaneo alla categoria Libri che va a buon fine
		try {
			bacheca.removeFriend(Categoria1, passw, amico4);
			System.out.println(amico4 + " è stato rimosso dalla categoria " + Categoria1 + "\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, un amico e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		catch (FriendNotExistException e) {
			System.out.println("L'amico inserito non è stato trovato\n");
		}
		
		// Rimozione dell'amico temporaneo alla categoria Libri che non va va a buon fine
		//poche già rimosso: solleva FriendNotExistException
		try {
			bacheca.removeFriend(Categoria1, passw, amico4);
			System.out.println(amico4 + " è stato rimosso dalla categoria " + Categoria1 + "\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, un amico e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		catch (FriendNotExistException e) {
			System.out.println("L'amico inserito non è stato trovato\n");
		}
		
		
		
		// Aggiunta dell'amico Carmela alla categoria Città che va a buon fine
		try {
			bacheca.addFriend(Categoria2, passw, amico3);
			System.out.println(amico3 + "  è stato aggiunto alla categoria  " + Categoria2 + "\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, un amico e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		catch (FriendExistException e) {
			System.out.println("L'amico inserito  è già presente\n");
		}
		

		// Aggiunta dell'amico Giorgio alla categoria Libri che non va a buon fine poichè già aggiunto alla categoria:
		// solleva FriendExistException
		try {
			bacheca.addFriend(Categoria1, passw, amico1);
			System.out.println(amico1 + " è stato aggiunto alla categoria " + Categoria1 + "\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, un amico e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		catch (FriendExistException e) {
			System.out.println("L'amico inserito  è già presente\n");
		}

		//Aggiunta di foto1 alla categoria città
		try {
			bacheca.put(passw, foto1, Categoria2);
			System.out.println("La foto:\n" + foto1 + "\nè stata aggiunta con successo\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, una foto e una password\n");
		}
		catch (DataExistException e) {
			System.out.println("La foto è già stata aggiunta in precedenza\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		
		//Aggiunta di foto2 alla categoria città
		try {
			bacheca.put(passw, foto2, Categoria2);
			System.out.println("La foto:\n" + foto2 + "\nè stata aggiunta con successo\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, una foto e una password\n");
		}
		catch (DataExistException e) {
			System.out.println("La foto è già stata aggiunta in precedenza\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		
		//Aggiunta di foto3 alla categoria città
		try {
			bacheca.put(passw, foto3, Categoria2);
			System.out.println("La foto:\n" + foto3 + "\nè stata aggiunta con successo\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, una foto e una password\n");
		}
		catch (DataExistException e) {
			System.out.println("La foto è già stata aggiunta in precedenza\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		
		//Aggiunta di foto4 alla categoria città
		try {
			bacheca.put(passw, foto4, Categoria2);
			System.out.println("La foto:\n" + foto4 + "\nè stata aggiunta con successo\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, una foto e una password\n");
		}
		catch (DataExistException e) {
			System.out.println("La foto è già stata aggiunta in precedenza\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		
		//Aggiunta di foto5 alla categoria Eventi
		try {
			bacheca.put(passw, foto5, Categoria3);
			System.out.println("La foto:\n" + foto5 + "\nè stata aggiunta con successo\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, una foto e una password\n");
		}
		catch (DataExistException e) {
			System.out.println("La foto è già stata aggiunta in precedenza\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		
		//Aggiunta di foto6 alla categoria Libri
		try {
			bacheca.put(passw, foto6, Categoria1);
			System.out.println("La foto:\n" + foto6 + "\nè stata aggiunta con successo\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, una foto e una password\n");
		}
		catch (DataExistException e) {
			System.out.println("La foto è già stata aggiunta in precedenza\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		
		//Aggiunta della foto6 alla categoria eventi che non va a buon fine perchè foto6 
		//è già stata aggiunta: solleva DataExistException
		
		try {
			bacheca.put(passw, foto6, Categoria1);
			System.out.println("La foto:\n" + foto6 + "\nè stata aggiunta con successo\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria, una foto e una password\n");
		}
		catch (DataExistException e) {
			System.out.println("La foto è già stata aggiunta in precedenza\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		
		//Clona e stampa la copia di foto1
		try {
			Data temp = bacheca.get(passw, foto1);
			System.out.println("Ecco la copia di foto1!");
			temp.Display();
			System.out.println("\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci  una foto e una password\n");
		}
		catch (DataNotFoundException e) {
			System.out.println("La foto non è stata trovata\n");
		}
		
		//Elimina la foto2 con successo
		try {
			bacheca.remove(passw, foto2);
			System.out.println("La foto è stata rimossa con successo\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una foto e una password\n");
		}
		catch (DataNotFoundException e) {
			System.out.println("La foto non è stata trovata\n");
		}
		
		//Prova a clonare e stampare foto2 ma non ha successo perchè il dato è stato eliminato:
		//solleva: DataNotFoundException
		try {
			Data temp = bacheca.get(passw, foto2);
			System.out.println("Ecco la copia di foto1!");
			temp.Display();
			System.out.println("\n");
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una foto e una password\n");
		}
		catch (DataNotFoundException e) {
			System.out.println("La foto non è stata trovata\n");
		}
		
		//Crea e stampa la lista dei dati associati a Città
		try {
			List <Data> temp = bacheca.getDataCategory(passw, Categoria2);
			System.out.println("Ecco i dati presenti in "+ Categoria2 + "\n");
	        for (int i=0; i<temp.size(); i++) { 
	        	temp.get(i).Display();
	        	System.out.println("\n");
	        }
		}
		catch (WrongPasswordException e) {
			System.out.println("La password immessa è errata\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci una categoria e una password\n");
		}
		catch (CategoryNotExistException e) {
			System.out.println("La categoria inserita non è stata trovata\n");
		}
		
		//Carmela aggiunge un like a foto1
		try {
			bacheca.insertLike(amico3, foto1);
			System.out.println("Like aggiunto con successo!\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci un amico e una foto \n");
		}
		catch (DataNotFoundException e) {
			System.out.println("La foto non è stata trovata\n");
		}
		catch (FriendNotExistException e) {
			System.out.println("Non hai i permessi per mettere like a questa foto");
		}
		catch (TooMuchLikeException e) {
			System.out.println("Non puoi aggiungere più di un like!\n");
		}
		
		//Carmela aggiunge un like a foto6
		try {
			bacheca.insertLike(amico3, foto6);
			System.out.println("Like aggiunto con successo!\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci un amico e una foto \n");
		}
		catch (DataNotFoundException e) {
			System.out.println("La foto non è stata trovata\n");
		}
		catch (FriendNotExistException e) {
			System.out.println("Non hai i permessi per mettere like a questa foto");
		}
		catch (TooMuchLikeException e) {
			System.out.println("Non puoi aggiungere più di un like!\n");
		}
		
		//Giorgio aggiunge un like a foto6
		try {
			bacheca.insertLike(amico1, foto6);
			System.out.println("Like aggiunto con successo!\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci un amico e una foto \n");
		}
		catch (DataNotFoundException e) {
			System.out.println("La foto non è stata trovata\n");
		}
		catch (FriendNotExistException e) {
			System.out.println("Non hai i permessi per mettere like a questa foto");
		}
		catch (TooMuchLikeException e) {
			System.out.println("Non puoi aggiungere più di un like!\n");
		}
		
		//Ignazio prova ad aggiungere like alla foto 5 senza successo poichè non può
		//accedere a quella categoria: solleva FriendNotExistException
		try {
			bacheca.insertLike(amico2, foto6);
			System.out.println("Like aggiunto con successo!\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci un amico e una foto \n");
		}
		catch (DataNotFoundException e) {
			System.out.println("La foto non è stata trovata\n");
		}
		catch (FriendNotExistException e) {
			System.out.println("Non hai i permessi per mettere like a questa foto");
		}
		catch (TooMuchLikeException e) {
			System.out.println("Non puoi aggiungere più di un like!\n");
		}
		
		//Carmela aggiunge un like a foto6 senza successo perchè l'ha già messo una volta:
		//solleva TooMuchLikeException
		try {
			bacheca.insertLike(amico3, foto6);
			System.out.println("Like aggiunto con successo!\n");
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci un amico e una foto \n");
		}
		catch (DataNotFoundException e) {
			System.out.println("La foto non è stata trovata\n ");
		}
		catch (FriendNotExistException e) {
			System.out.println(amico3 + "non può mettere like");
		}
		catch (TooMuchLikeException e) {
			System.out.println("Non puoi aggiungere più di un like!\n");
		}
		
		//Stampa tutti i dati in bacheca per numero di like
		try {
			Iterator <Data> it = bacheca.getIterator(passw);
			System.out.println("Ecco i dati ordinati per like!\n");
	        while (it.hasNext()) {
	        	Data temp = it.next();
	        	temp.Display();
				System.out.println("\n");
	        }
		}
	    catch (WrongPasswordException e) {
				System.out.println("La password immessa è errata\n");
			}
		catch (NullPointerException e) {
			System.out.println("Inserisci una password\n");
		}
		
		//Stampa tutti i dati condivisi a Giorgio
		try {
			Iterator <Data> it = bacheca.getFriendIterator(amico1);
			System.out.println("Ecco i dati condivisi da Giorgio\n");
	        while (it.hasNext()) {
	        	Data temp = it.next();
	        	temp.Display();
				System.out.println("\n");
	        }
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci un amico\n");
		}
		catch (FriendNotExistException e) {
			System.out.println("L'amico inserito non è stato trovato\n");
		}
	
		//stampa tutti i dati condivisi da carmela 
		try {
			Iterator <Data> it = bacheca.getFriendIterator(amico3);
			System.out.println("Ecco i dati condivisi da Carmelas\n");
	        while (it.hasNext()) {
	        	Data temp = it.next();
	        	temp.Display();
				System.out.println("\n");
	        }
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci un amico\n");
		}
		catch (FriendNotExistException e) {
			System.out.println("L'amico inserito non è stato trovato\n");
		}
		
		//stampa tutti i dati condivisi di ciccio che non essendo fra gli amici inseriti non è presente in nessuna categoria:
		// solleva FriendNotExistException
		try {
			Iterator <Data> it = bacheca.getFriendIterator("ciccio");
			System.out.println("Ecco i dati condivisi da Ciccio\n");
	        while (it.hasNext()) {
	        	Data temp = it.next();
	        	temp.Display();
				System.out.println("\n");
	        }
		}
		catch (NullPointerException e) {
			System.out.println("Inserisci un amico\n");
		}
		catch (FriendNotExistException e) {
			System.out.println("L'amico inserito non è stato trovato\n");
		}
		
		
		
		
		
		
		
		

		

		

		
		
		
		
		
		
		
		
		
				
				
				
	}

}
