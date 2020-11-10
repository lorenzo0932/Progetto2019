package com.company;
import java.util.*;

public class MyDataBoardV2 <E extends Data> implements DataBoard<E>{
	/*
	OVERVIEW: Tipo modificabile che rappresenta una bacheca di un utente formata da n dati di tipo <E extend Data> divisi per 
			    categorie con n categorie, ciascuno dei quali accessible da un insieme di n amici. L'utente può aggiungere, clonare, 
			    rimuovere, condividere, gestire dati. Inoltre può creare o rimuovere categorie e associazioni fra queste e gli amici. 



		TYPICAL ELEMENTS:  tripla <passw, {Insieme di categorie per dati}, {insieme di categorie per amici}>
					dove :
					-ogni categoria per amici è composta da una coppia <NomeCategoriaF, {insieme degli amici}>
		            -ogni categoria per dato è composto da una coppia <NomeCategoriaD, {insieme dei dati}>
		            	-dove ogni dato di {insieme dei dati} è una coppia <Likes, {amici che hanno messo like}
		            	
		            nello specifico:
		            <passw,
		            {<NomeCategoriaF_i , {insieme di categorie per dati_k | 0<= k  < m} | 0<= i < z>,
		            {<NomeCategoriaD_j , {<Like_s, {amici che hanno messo like_p | 0 <= p < n}	| 0 <= s < g> | 0<= j < z>> |
		            	con i==j => NomeCategoriaF_i == NomeCategoriaD_j
							

	@Abstraction Function

	AF (c) :
	<passw, 
	
	{<c.hashDataCategory.get(NomeCategoriaD_i),												//nome categoria per dati
		{<c.hashDataCategory.get(NomeCategoriaD_i).get(j).getLikes(),						//likes dato
			{c.hashDataCategory.get(NomeCategoriaD_i).get(j).getFriend().get(g)				//amici che hanno messo likes
				|0 <= g < c.hashDataCaregory.get(NomeCategoriaD_i).get(j).getFriend().size()}>//g< dimensione {amici che hanno messo like}
			| 0 <= j < c.hashDataCategory.get(NomeCategoriaD_i).size()}>					//dimensione {insieme dei dati}
		| 0 <= i < hashDataCategory.size()}													//i < dimensione hashDatacategory
		
	{<c.hashFriendsCategory.get(NomeCategoriaF_z),											//nome categoria per amici
		{c.hashFriendsCategory.get(NomeCategoriaF_z).get(h)									//{insieme degli amici}
			| 0 <= h < hashFriendsCategory.get(NomeCategoriaF_z).size()}>					//h < dimensione {insieme degli amici}
		| 0 <= z < hashFriendsCategory.size()}												// z < dimensione hashFriendsCategory
		
		con i ==z && c.hashFriendsCategory.size() == c.hashDataCategory.size() 

		

	Rep Invariant 

		RI (c) = 
			c.passw != null && c.hashDataCategory != null && c.hashFriendsCategory 1= null &&
			c.hashDataCategory.keySet() != null &&  c.hashFriendsCateogory .keySet() != null &&
			c.hashDataCategory.values() != null &&  c.hashFriendsCateogory .values() != null &&
			(forall i | 																					
				0<=i<c.hashDataCategory.size() ==> 																//ogni elemento di hashDataCategory != null
					c.hashDataCategory.get(CategoryNameD_i) != null) %%											//l'hashSet in chiave CategoryNameD deve essere != null
			}


			(forall i | 																					
				0<=i<c.hashFriendsCateogory.size() ==> 															//ogni elemento di hashFriendsCateogory != null
					c.hashFriendsCateogory.get(CategoryNameF_i) != null) &&										//l'hashSet in chiave CategoryNameF deve essere != null
				
					
			(forall i,j |																						//categorie per dati e categorie per amici hanno nome uguale se sono nella stessa posizione						
				0<= i <c.hashFriendsCateogory.size() && 
				0<= j <c.hashDataCategory.size() &&
				i == j ==>
					c. hashFriendsCateogory. keySet().get(i) equals(c.hashDataCategory.keySet().get(j))) &&
			
			
			(forall i, j , k |																					//due dati della stessa CategoryNameD_i non sono uguali se in posizioni diverse	
				0 <= i < hashDataCategory.size() &&																
				0 <= j < k < hashDataCategory.get(CategoryNameD_i).size()  =>
					!(hashDataCategory.get(CategoryNameD_i).get(j) equals
						(hashDataCategory.get(CategoryNameD_i).get(k)))) &&
			
			(forall i, j , k |																					//due amici della stessa CategoryNameF_i non sono uguali se in posizioni diverse	
				0 <= i < hashFriendsCateogory.size() &&																
				0 <= j < k < hashFriendsCateogory.get(CategoryNameF_i).size()  =>
					!(hashFriendsCateogory.get(CategoryNameD_i).get(j) equals
						(hashFriendsCateogory.get(CategoryNameF_i).get(k)))) &&
									
			
			(forall i,j,k,z |
				0<= k < z < hashDataCategory.size () && 0<= i< j < hashFriendsCateogory.size() => 				//k,z,i,j indicano categorie diverse
																												
					!(c.hashFriendsCateogory.keySet().get(k).equals												//non esistono 2 categorie con lo stesso nome 
						(c.hashFriendsCateogory.keySet().get(z))) &&
					!(c.hashDataCategory.keySet().get(i) equals												
						(c.hashDataCategory.keySet().get(j))))
					


			(forall i,j,k,z |
				0<= i < j <c.hashDataCategory.size() &&														//i e j indicano due categorie diverse
				0<= k < c.hashDataCategory.get(CategoryNameD_i).size ()&&									//indica un dato della categoria i
				0<= k < c.hashDataCategory.get (CategoryNameD_j).size() =>									//indica un dato della categoria j
						!(c.hashDataCategory.get(CategoryNameD_i).get(k) equals								//due dati di due categorie diverse non posso essere uguali
								((c.hashDataCategory.get(CategoryNameD_j).get(z))))) &&

						 
	*/

	private String passw;
	private HashMap<String, HashSet<E>> hashDataCategory;
	private HashMap<String, HashSet<String>> hashFriendsCategory;
	
	//costruttore
	public MyDataBoardV2 (String passw)throws NullPointerException{
		if(passw == null) throw new NullPointerException();
		this.passw=passw;
		hashDataCategory = new HashMap<String, HashSet<E>>();
		hashFriendsCategory = new HashMap<String, HashSet<String>>();
	}
	
	//Verifica la validità della password immessa
	private boolean verifyPass(String password) {
		/*
		@EFFECT : ritorna true se la password è corretta, false altrimenti
		*/
	    return this.passw.equals(password);
	    }
	
	//trova il dato considerato
	private E findDato(E dato) {
	//EFFECT: restituisce una copia del dato dato	
		E datoTemp= null;
		Iterator<String> it  = hashDataCategory.keySet().iterator();
		
		while (it.hasNext()) {
			String current = it.next();
			Iterator<E> data = hashDataCategory.get(current).iterator();
			
			while(data.hasNext()) {
				E temp = data.next();
				if (temp.equals(dato)) {
					datoTemp = temp;
					return datoTemp;
				}	
			}
		}
	return datoTemp;		
	}
	
	//trova la categoria del dato dato
	private String findCategory (E dato) {
	//EFFECT: restituisce una stringa corrispondente al nome della categoria
		String Category = null;
		Iterator<String> it  = hashDataCategory.keySet().iterator();
		
		while (it.hasNext()) {
			String current = it.next();
			Iterator<E> data = hashDataCategory.get(current).iterator();
			
			while(data.hasNext()) {
				E temp = data.next();
				if (temp.equals(dato)) {
					Category = current;
					return Category;
				}
			}
		}
		
	return Category;
	}

    // Crea una categoria di dati se vengono rispettati i controlli di identità
	public void createCategory(String Category, String passw)
			throws WrongPasswordException, NullPointerException, CategoryExistenceException {
		
		if (Category == null || passw == null ) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		if (!hashDataCategory.containsKey(Category)){
			hashDataCategory.put (Category, new HashSet<E>());
			hashFriendsCategory.put(Category, new HashSet<String>());			
		}
		else throw new CategoryExistenceException();
		
	}

    // Rimuove una categoria di dati se vengono rispettati i controlli d'identità
	public void removeCategory(String Category, String passw)
			throws WrongPasswordException, NullPointerException, CategoryNotExistException {
		
		if (Category == null || passw == null ) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		
		if (hashDataCategory.containsKey(Category) || hashFriendsCategory.containsKey(Category)){
			hashDataCategory.remove(Category);
			hashFriendsCategory.remove(Category);	
		}
		else throw new CategoryNotExistException();
		
	}

    // Aggiunge un amico ad una categoria di dati se vengono rispettati i controlli d'identità
	public void addFriend(String Category, String passw, String friend)
			throws WrongPasswordException, NullPointerException, CategoryNotExistException, FriendExistException {
		
		if (Category == null || passw == null || friend == null ) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		
		if (!hashDataCategory.containsKey(Category)) throw new CategoryNotExistException();
		if	(!hashFriendsCategory.get(Category).add(friend)) throw new FriendExistException();	
	}

    // rimuove un amico ad una categoria di dati se vengono rispettati i controlli d'identità
	public void removeFriend(String Category, String passw, String friend)
			throws WrongPasswordException, NullPointerException, FriendNotExistException, CategoryNotExistException {
		if (Category == null || passw == null || friend == null ) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		
		if (!hashDataCategory.containsKey(Category)) throw new CategoryNotExistException();
		if	(!hashFriendsCategory.get(Category).remove(friend)) throw new FriendNotExistException();	
	}

    // Inserisce un dato in bacheca se vengono rispettati i controlli di identità
	public boolean put(String passw, E dato, String categoria)
			throws WrongPasswordException, NullPointerException, DataExistException, CategoryNotExistException {
		
		if (categoria == null || passw == null || dato == null ) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		
		if (!hashDataCategory.containsKey(categoria)) throw new CategoryNotExistException();
		E nuovoDato = findDato(dato);
		if (nuovoDato != null) throw new DataExistException();
		else
			return hashDataCategory.get(categoria).add(dato);
		
	}

    // Ottiene una copia del del dato in bacheca se vengono rispettati i controlli di identità
	public E get(String passw, E dato)
			throws WrongPasswordException, NullPointerException, DataNotFoundException {
		
		if (passw == null || dato == null ) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		
		E nuovoDato=findDato(dato);
		if (nuovoDato==null) throw new DataNotFoundException();
		@SuppressWarnings("unchecked")
		E copiaFinale = (E) nuovoDato.copy();
		return copiaFinale;
		
	}

    // Rimuove il dato dalla bacheca se vengono rispettati i controlli di identità
	public E remove(String passw, E dato)
			throws WrongPasswordException, NullPointerException, DataNotFoundException {
			
		if (passw == null || dato == null ) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		
		String Category = findCategory (dato);
		if(Category == null) throw new DataNotFoundException();
		E Dato = findDato(dato);
		if(hashDataCategory.get(Category).remove(Dato))
			return Dato;
		
		return null;
	}

    // Crea una lista dei dati in bacheca su una determinata categoria se vengono rispettati i controlli di identità
	public List<E> getDataCategory(String passw, String Category)
			throws WrongPasswordException, NullPointerException, CategoryNotExistException {
		
		if (passw == null || Category == null ) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		
		if (hashDataCategory.containsKey(Category)) {
			List <E> lista = new Vector<E>();
			lista.addAll(hashDataCategory.get(Category));
			return lista;
		}
	else throw new CategoryNotExistException();
}

	// restituisce un iteratore (senza remove) che genera tutti i dati in
    // bacheca ordinati rispetto al numero di like
    //	se vengono rispettati i controlli d'identità
	public Iterator<E> getIterator(String passw) throws WrongPasswordException, NullPointerException, UnsupportedOperationException {
		
		if (passw == null) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
	
		List <E> listOfData = new Vector<E>();
		Iterator<String> it  = hashDataCategory.keySet().iterator();
		
		while (it.hasNext()) {
			String current = it.next();
			listOfData.addAll(hashDataCategory.get(current));
		}
			
		listOfData.sort(new Comparator<E> () {
			@Override
			public int compare (E object1, E object2) {
				return (-object1.getLikes() + object2.getLikes());}
			});

		return Collections.unmodifiableCollection(listOfData).iterator();

	}

    // Aggiunge un like a un dato se vengono rispettati i controlli d'identità
	public void insertLike(String friend, E dato)
			throws NullPointerException, FriendNotExistException, DataNotFoundException, TooMuchLikeException {
		
		if(dato==null || friend==null) throw new NullPointerException();
		String CategoryData =  findCategory(dato);
		if (CategoryData == null) throw new DataNotFoundException();
		if (!hashFriendsCategory.get(CategoryData).contains(friend)) throw new FriendNotExistException();
		
		E data = findDato(dato); 
		if(data.addLikes(friend, data) == false) 
			throw new TooMuchLikeException();
	
	}

	// Restituisce un iteratore (senza remove) che genera tutti i dati in bacheca condivisi.
	public Iterator<E> getFriendIterator(String friend) throws NullPointerException, UnsupportedOperationException, FriendNotExistException {

		if (friend == null ) throw new NullPointerException ();
		List <E> datiCondivisi = new Vector<E>();
		Iterator<String> it  = hashDataCategory.keySet().iterator();
		boolean trovato=false;
		while (it.hasNext()){
				
				String current = it.next();

				if(hashFriendsCategory.get(current).contains(friend)) {
						datiCondivisi.addAll(hashDataCategory.get(current));
						trovato=true;
				}
		}
		
		if (!trovato) throw new FriendNotExistException();
		

		return Collections.unmodifiableCollection(datiCondivisi).iterator();
	}
}

