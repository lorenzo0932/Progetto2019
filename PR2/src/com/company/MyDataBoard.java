package com.company;
import java.util.*;


public class MyDataBoard <E extends Data> implements DataBoard <E> {
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

{<c.dataCategory.get(i).getNameCat(),													//nome categoria per dati
	{<c.dataCategory.get(i).getCatData.get(j).getLikes(),								//likes dato
		{c.dataCategory.get(i).getCatData().get(j).getFriends().get(g)					//amici che hanno messo likes
			|0 <= g < c.dataCategory.get(i).getCatData().get(j).getFriends().size()}	//g < dimensione {amici che hanno messo like}
		| 0 <= j < c.dataCategory.get(i).getCatData().size()>}							//j < dimensione {insieme dei dati}
	| 0<= i <c.dataCategory.size()>},													//i < dimensione vettore dataCategory
		 										
{<c.friendCategory.get(z).getNameCat(),													//nome categoria per amici
	{c.friendCategory.get(z).getCatFriends().get(h)										//insieme degli amici
		| 0 <= h < friendCategory.get(z).size()}										//h < dimensione {insieme di amici}
	| 0 <= z <c.friendCategory.size()>}													//z < dimensione vettore degli friendCategory

	con i == z && c.friendCategory.size() == c.dataCategory.size();
	

Rep Invariant 

	RI (c) = c.passw != null && c.dataCategory != null && c.friendCategory != null
		(forall i | 																					
			0<=i<c.dataCategory.size() ==> 																//ogni elemento di dataCategory != null
				c.dataCategory.get(i) != null) &&

		(forall i | 																					
			0<=i<c.friendCategory.size() ==> 															//ogni elemento di friendCategory != null
				c.friendCategory.get(i) != null) &&
			
				
		(forall i,j |																					//categorie per dati e categorie per amici hanno nome uguale se sono nella stessa posizione						
			0<= i <c.friendCategory.size() && 
			0<= j <c.dataCategory.size() &&
			i == j ==>
				c.friendCategory.get(i).getNameCat().equals(c.dataCategory.get(j).getNameCat()))&&
				

		
		(forall i,j,k,z |
			0<= k < z < dataCategory.size () && 0<= i< j < friendCategory.size() &&
			 	i == k && j == z ==>																	//k e z indicano categorie diverse
				!(c.friendCategory.get(k).getNameCat() equals											//non esistono 2 categorie con lo stesso nome 
					(c.friendCategory.get(z).getNameCat())) &&
				!(c.dataCategory.get(k).getNameCat() equals												
					(c.dataCategory.get(z).getNameCat()))
				


		(forall i,j,k,z |
			0<= i < j <c.dataCategory.size() &&														//i e j indicano due categorie diverse
			0<= k < c.dataCategory.get(i).getCatData().size() &&									//indica un dato della categoria i
			0<= k < c.dataCategory.get (j).getCatData().size() =>									//indica un dato della categoria j
					!(c.dataCategory.get(i).getCatData().get(k).equals								//due dati di due categorie diverse non posso essere uguali
							(c.dataCategory.get(j).getCatData().get(z))) &&

					 
*/

	private String password; //passw utente considerato
	private Vector<CategoryData<E>> dataCategory;
	private Vector<CategoryFriends<E>> friendCategory;
	
	//costruttore
	public MyDataBoard(String password) throws NullPointerException {
		/*
		@REQUIRE: password != null
		@THROWS :  Se password  == null solleva NullPointerException
		@MODIFIES: this
		@EFFECTS : inizializza this con password 
		*/

	if (password == null) throw new NullPointerException();
    this.password = password;
    dataCategory = new Vector<CategoryData<E>>();
    friendCategory = new Vector <CategoryFriends<E>> ();
    }

	//Verifica la validità della password immessa
	private boolean verifyPass(String password) {
	/*
	@EFFECT : ritorna true se la password è corretta, false altrimenti
	*/
    return this.password.equals(password);
    }

	//verifica l'esistenza della categoria
	private int verifyCategory (String Categoria){
	
	//@EFFECTS:  ritorna la posizione della categoria con nome Categoria
	
        int current = -1;
        int i=0;
        while (i<dataCategory.size() && current == -1){
            if (dataCategory.get(i).getNameCat().equals(Categoria)){
                current=i;
            }
            else i++;
        }

        return current;
	}

	//Verifica se l'amico è presente nella categoria considerata
  	private int verifyFriends (int position, String Amico) {

		//EFFECTS: ritorna la posizione dell'amico Amico nella categoria in posizione position

		int current=-1;
		int i=0;
		while (i<friendCategory.get(position).getCatFriends().size() && current==-1){
			if(friendCategory.get(position).getCatFriends().get(i).equals(Amico))
				current=i;
			else i++;
		}
		return current;
	}
  	
  	//Verifica l'esistenza di un dato
	private int verifyData (E dato){
	//EFFECTS: ritorna la posizione del dato dato 

		int trovato=-1;
		int i=0;
		while (i<dataCategory.size() && trovato == -1){
			int j=0;
			while(j<dataCategory.get(i).getCatData().size() && trovato == -1){
				if(dataCategory.get(i).getCatData().get(j).equals(dato))
					trovato = j;
				else j++;
			}
			i++;
		}

		return trovato;
	}

	//trova il dato considerato
	private E findData (E dato){
	//EFFECT: restituisce una copia del dato dato
		E nuovoDato = null;
		boolean trovato = false;
		int i=0;
		while (i<dataCategory.size() && trovato == false){
			int j=0;
			while(j<dataCategory.get(i).getCatData().size() && trovato == false)
				if(dataCategory.get(i).getCatData().get(j).equals(dato)){
					trovato = true;
					nuovoDato = dataCategory.get(i).getCatData().get(j);
				}
				else j++;

			if (trovato == false) i++;
		}
		return nuovoDato;
	}
	
	//cerca la posizione della categoria
	private int findCategory (int pos, E dato){
	//EFFECTS: ritorna la posizione della categoria contenete il dato dato in posizione pos

		int current= -1;
		int i=0;
		while (i<dataCategory.size() && current == -1){
			if(pos<dataCategory.get(i).getCatData().size())
				if(dataCategory.get(i).getCatData().get(pos).equals (dato))
					current = i;
			i++;
		}
		return current;
	}

    // Crea una categoria di dati se vengono rispettati i controlli di identità
	public void createCategory(String Category, String passw) throws WrongPasswordException, NullPointerException, CategoryExistenceException {
        if (Category == null || passw == null) throw new NullPointerException();	
		if (!verifyPass(passw)) throw new WrongPasswordException();					//verifica se la password è corretta
	//verifica che gli argomenti del metodo siano != null
        if  (verifyCategory(Category)==-1){											//
            dataCategory.addElement(new CategoryData<E> (Category)); 				//crea il nuovo oggetto Category e lo aggiunge al vettore Categorie
            friendCategory.addElement(new CategoryFriends<E> (Category)); 
        }
        else throw new CategoryExistenceException();								//La categoria esiste già
        
    }

    // Rimuove una categoria di dati se vengono rispettati i controlli d'identità
	public void removeCategory(String Category, String password)  throws WrongPasswordException, NullPointerException, CategoryNotExistException {
        if (Category == null || password == null) throw new NullPointerException();		
        if (!verifyPass(password)) throw new WrongPasswordException();

        int position= verifyCategory (Category);
        if  (position!=-1){
        	dataCategory.removeElementAt(position);							//rimove la categoria se esiste
        	friendCategory.removeElementAt(position);	
        }
        else throw new CategoryNotExistException();						//la Categoria non esiste
	
	}
	
    // Aggiunge un amico ad una categoria di dati se vengono rispettati i controlli d'identità
	public void addFriend(String Category, String passw, String friend) throws WrongPasswordException, NullPointerException, CategoryNotExistException, FriendExistException {
		if(Category==null || password==null || friend==null) throw new NullPointerException();
		if (!verifyPass(password)) throw new WrongPasswordException();
		

		int CategoryPosition = verifyCategory (Category);
		if (CategoryPosition!=-1) { 									
		int FriendPosition = verifyFriends(CategoryPosition, friend);
		if(FriendPosition==-1)											//Se l'amico considerato non è stato ancora associato a Category (l'amico può accedere a più categorie)
		friendCategory.get(CategoryPosition).getCatFriends().addElement(friend);//Aggiungi una nuova stringa al vettore degli amici
			else throw new FriendExistException(); 						//Amico già associato alla categoria
		}
		else throw new CategoryNotExistException(); 					//La categoria non esiste
		
	}
	
    // rimuove un amico ad una categoria di dati se vengono rispettati i controlli d'identità
	public void removeFriend(String Category, String passw, String friend) throws WrongPasswordException, NullPointerException,FriendNotExistException,CategoryNotExistException  {
		
		if(Category==null || passw==null || friend==null) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		
		int CategoryPosition = verifyCategory (Category);
		if (CategoryPosition!=-1) { 									//Se la categoria esiste entro nel corpo dell'if
			int FriendPosition = verifyFriends(CategoryPosition, friend);
			if(FriendPosition != -1) 									//Se l'amico considerato è associato alla categoria category
				friendCategory.get(CategoryPosition).getCatFriends().removeElementAt(FriendPosition); //Rimove l'associato di Amico con Categoria Category
			else throw new FriendNotExistException(); 					//Amico non associato alla categoria
		}
		else throw new CategoryNotExistException(); 					//La categoria non esiste
		
	}
		
	
    // Inserisce un dato in bacheca se vengono rispettati i controlli di identità
	public boolean put(String passw, E dato, String categoria) throws WrongPasswordException, NullPointerException, DataExistException,CategoryNotExistException {
		
		if(categoria==null || passw==null || dato==null) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		int CategoryPosition = verifyCategory (categoria);
		if (CategoryPosition!=-1){
			CategoryData <E> c = dataCategory.get(CategoryPosition);
			if(verifyData(dato) != -1)
				throw new DataExistException();							//esiste già un dato uguale a quello che si vuole immettere
			else
				return c.getCatData().add(dato);						//aggiunge un dato ad una categoria
		}
		else throw new CategoryNotExistException();
	}

    // Ottiene una copia del del dato in bacheca se vengono rispettati i controlli di identità
	public E get(String passw, E dato) throws WrongPasswordException, NullPointerException, DataNotFoundException {
		
		if(passw==null || dato==null) throw new NullPointerException();			
		if (!verifyPass(passw)) throw new WrongPasswordException();
		E trovato = findData(dato);
		if (trovato == null) throw new DataNotFoundException ();
		@SuppressWarnings("unchecked")
		E copiaFinale = (E) trovato.copy();
		return copiaFinale;
	}

    // Rimuove il dato dalla bacheca se vengono rispettati i controlli di identità
	public E remove(String passw, E dato) throws WrongPasswordException, NullPointerException, DataNotFoundException {
		
		if(passw==null || dato==null) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		int DataPosition = verifyData(dato);
		if (DataPosition == -1) throw new DataNotFoundException ();
		int CategoryPosition = findCategory (DataPosition, dato);

		return dataCategory.get(CategoryPosition).getCatData().remove(DataPosition);

	}

    // Crea una lista dei dati in bacheca su una determinata categoria se vengono rispettati i controlli di identità
	public List<E> getDataCategory(String passw, String categoria) throws WrongPasswordException, NullPointerException, CategoryNotExistException {
		
		if(passw==null || categoria==null) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
		int pos = verifyCategory(categoria);
		if (pos != -1)  {
			List<E> list = new Vector <E>();
			list.addAll(dataCategory.get(pos).getCatData());
			return list;
		}
		else throw new CategoryNotExistException();
	}
	
	// restituisce un iteratore (senza remove) che genera tutti i dati in
    // bacheca ordinati rispetto al numero di like
    //	se vengono rispettati i controlli d'identità
	public Iterator<E> getIterator(String passw) throws WrongPasswordException, NullPointerException, UnsupportedOperationException{
		if (passw == null) throw new NullPointerException();
		if (!verifyPass(passw)) throw new WrongPasswordException();
	
		List <E> listOfData = new Vector<E>();
		Iterator <CategoryData<E>> it = dataCategory.iterator(); 

		while (it.hasNext()){
			CategoryData<E> current = it.next();
			listOfData.addAll(current.getCatData());
		}
		listOfData.sort(new Comparator<E> () {
			@Override
			public int compare (E object1, E object2) {
				return (-object1.getLikes() + object2.getLikes());}
			});

		return Collections.unmodifiableCollection(listOfData).iterator();

		}

    // Aggiunge un like a un dato se vengono rispettati i controlli d'identità
	public void insertLike(String friend, E dato) throws NullPointerException, FriendNotExistException, DataNotFoundException, TooMuchLikeException  {
		
		if(dato==null || friend==null) throw new NullPointerException();
		int DataPosition = verifyData(dato); 								//trova la posizione del dato
		if (DataPosition == -1) throw new DataNotFoundException();			//il dato non esiste
		int CategoryPosition = findCategory(DataPosition, dato); 			//trova la categoria corrispondente al dato
		int	FriendPosition =  verifyFriends(CategoryPosition, friend); 		//cerca l'amico nella categoria dove si trova il dato
		if (FriendPosition == -1) throw new FriendNotExistException(); 		// l'amico non è nella categoria dove si trova il dato

		E data = dataCategory.get(CategoryPosition).getCatData().get(DataPosition); //creo un "puntatore" al dato 
		if(!data.addLikes(friend, data)) 									//gestisco l'aggiunta del like direttamente dalla classe "Data"
			throw new TooMuchLikeException(); 								//l'amico ha già messo "mi piace" al dato
	}
	
	// Restituisce un iteratore (senza remove) che genera tutti i dati in bacheca condivisi.
	public Iterator<E> getFriendIterator(String friend) throws NullPointerException, UnsupportedOperationException {

		if (friend == null ) throw new NullPointerException ();
		List <E> datiCondivisi = new Vector<E>();
		Iterator<CategoryFriends<E>> it = friendCategory.iterator();
		int count=-1;
		while (it.hasNext()){
				++count;
				CategoryFriends <E> current = it.next();

				if(current.getCatFriends().contains(friend))
						datiCondivisi.addAll(dataCategory.get(count).getCatData());	
		}

		return Collections.unmodifiableCollection(datiCondivisi).iterator();
	}
}