package com.company;
import java.util.*;

public interface DataBoard <E extends Data> {
	
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
*/

    // Crea una categoria di dati se vengono rispettati i controlli di identità
    public void createCategory(String Category, String passw) throws WrongPasswordException,NullPointerException, CategoryExistenceException;
    /*
    @REQUIRE : Category di tipo stringa != null, passw di tipo stringa != null, passw == this.passw, la stringa Category 
              non è nella prima componente di {Insieme di categoria per dati}
    @THROWS : se Category == null o passw==null solleva NullPonterException
              se passw != this.passw solleva WrongPasswordException
              se Category è incluso nella prima componente di una categoria per dato con 1a componente la stringa Category solleva CategoryExistException;
    MODIFIES : {Insieme di categoria per dati} e {Insieme di categoria per amici}
    EFFECT : aggiunge Category in {Insieme di categoria per dati} e {Insieme di categoria per amici}
    */

    // Rimuove una categoria di dati se vengono rispettati i controlli d'identità
    public void removeCategory(String Category, String passw) throws WrongPasswordException, NullPointerException, CategoryNotExistException;
    /*
    @REQUIRE : Category oggetto di tipo stringa != null , passw oggetto di tipo stringa !=null, l'oggetto passw == this.passw,
                l'oggetto Category è incluso in {Insieme di categoria per dati}
    @THROWS : se Category == null o passw==null solleva NullPonterException
              se passw != this.passw solleva WrongPasswordException
              se Category non è incluso nella prima componente di una categoria per dato con 1a componente la stringa Category solleva CategoryNotExistException;
    @MODIFIES : {Insieme di categoria per amici} e {insieme dei dati}  
    @EFFECT : rimuove Category da {Insieme di categoria per amici} e {Insieme di categoria per dati}
    */

    // Aggiunge un amico ad una categoria di dati se vengono rispettati i controlli d'identità
    public void addFriend(String Category, String passw, String friend)throws WrongPasswordException, NullPointerException, CategoryNotExistException, FriendExistException;
    /*
    @REQUIRE : Category oggetto di tipo stringa != null , passw oggetto di tipo stringa !=null, l'oggetto friend != null, 
                l'oggetto passw == this.passw, l'oggetto Category è incluso in {Insieme di categoria per dati}
                l'oggetto friend non è incluso nella seconda componente di {Insieme di categoria per amici}
                
    @THROWS : se Category == null o passw==null o friend == null solleva NullPonterException
              se passw != this.passw solleva WrongPasswordException
              se Category non è incluso nella prima componente di una categoria per dato con 1a componente la stringa Category solleva CategoryNotExistException;
              se friend è incluso nella 2a componente di una categoria per amici con 1a componente la stringa Category solleva FriendExistException

    @MODIFIES : 2a componente di una categoria per amici

    @EFFECT : aggiunge friend alla 2a componente della categoria per amici con 1a componente la stringa Category
    */

    // rimuove un amico ad una categoria di dati se vengono rispettati i controlli d'identità
    public void removeFriend(String Category, String passw, String friend) throws WrongPasswordException, NullPointerException,FriendNotExistException,CategoryNotExistException;
    /*
    @REQUIRE : Category oggetto di tipo stringa != null , passw oggetto di tipo stringa !=null, l'oggetto friend != null, 
                l'oggetto passw == this.passw, l'oggetto Category è incluso in {Insieme di categoria per dati},
                l'oggetto friend è incluso nella 3a componente della categoria con prima componente la stringa Category,

    @THROWS : se Category == null o passw==null o friend == null solleva NullPonterException
              se passw != this.passw solleva WrongPasswordException
              se Category non è incluso nella prima componente di una categoria per dato con 1a componente la stringa Category solleva CategoryNotExistException;
          	  se friend è incluso nella 2a componente di una categoria per amici con 1a componente la stringa Category solleva FriendNotExistException

    @MODIFIES :2a componente di una categoria per amici
    @EFFECT : rimuove friend dalla 2a componente dellacategoria per amici con 1a componente la stringa Category
    */

    // Inserisce un dato in bacheca se vengono rispettati i controlli di identità
    public boolean put(String passw,  E dato, String categoria) throws WrongPasswordException, NullPointerException, DataExistException,CategoryNotExistException;
    /*
    @REQUIRE : Category oggetto di tipo stringa != null , passw oggetto di tipo stringa !=null, l'oggetto dato != null, 
                l'oggetto passw == this.passw, l'oggetto Category è incluso in {Insieme di categoria per dati}
                l'oggetto dato non è incluso nella 2a componente della categoria per dato con 1a componente la stringa categoria
    
    @THROWS : se Category == null o passw==null o dato == null solleva NullPonterException
              se passw != this.passw solleva WrongPasswordException
              se Category non è incluso nella prima componente di una categoria per dato con 1a componente la stringa Category solleva CategoryNotExistException;
              se dato è incluso nella 2a componente della categoria per dato con 1a componente la stringa categoria solleva DataExistException

    @MODIFIES : La 2a componente di una categoria per dato

    @EFFECT : Aggiunge l'oggetto E alla categoria per dato con la 1a componente la stringa categoria
    */

    // Ottiene una copia del del dato in bacheca se vengono rispettati i controlli di identità
    public E get(String passw,  E dato) throws WrongPasswordException, NullPointerException, DataNotFoundException;
    /*
    @REQUIRE : passw oggetto di tipo stringa !=null,  l'oggetto dato != null, 
                l'oggetto passw == this.passw, l'oggetto dato è incluso nella 2a componente di una categoria per dati

    @THROWS : se passw==null o dato == null solleva NullPonterException
              se passw != this.passw solleva WrongPasswordException
              se dato non è incluso nella 2a componente di una categoria per dato inclusa in {insieme delle categorie per dato} 
              	solleva DataNotFoundException

    @EFFECT : ritorna una copia del dato dato
    */

    // Rimuove il dato dalla bacheca se vengono rispettati i controlli di identità
    public E remove(String passw,  E dato)throws WrongPasswordException, NullPointerException, DataNotFoundException;
    /*
    @REQUIRE : passw oggetto di tipo stringa !=null,  l'oggetto dato != null, 
                l'oggetto passw == this.passw, l'oggetto dato è incluso nella 2a componente di una categoria per dato

    @THROWS : se passw==null o dato == null solleva NullPonterException
              se passw != this.passw solleva WrongPasswordException
              se dato non è incluso nella 2a componente di una categoria per dato inclusa in {insieme delle categorie per dato} 
              	solleva DataNotFoundException
              	
    @MODIFIES : La 2a componente di una categoria per dato inclusa in {insieme delle categorie per dato}

    @EFFECT : rimuove dalla 2a componente di una categoriaper dato inclusa in {insieme delle categorie per dato} il dato dato
    */

    // Crea una lista dei dati in bacheca su una determinata categoria se vengono rispettati i controlli di identità
    public List<E> getDataCategory(String passw, String Category) throws WrongPasswordException, NullPointerException, CategoryNotExistException;
    /*
    @REQUIRE : passw oggetto di tipo stringa !=null,  l'oggetto Category di tipo stringa != null
                l'oggetto passw == this.passw, l'oggetto Category è incluso in {insieme delle categorie per dati}

    @THROWS : se passw==null o Category == null solleva NullPonterException
              se passw != this.passw solleva WrongPasswordException
              se Category non è incluso nella prima componente di una categoria per dato con 1a componente la stringa Category solleva CategoryNotExistException;

    @EFFECT : restitusce una lista contenente tutti gli elementi della 2a componente della categoria per dato Category
    */

    // restituisce un iteratore (senza remove) che genera tutti i dati in
    // bacheca ordinati rispetto al numero di like
    //	se vengono rispettati i controlli d'identità
    public Iterator<E> getIterator(String passw) throws WrongPasswordException, NullPointerException, UnsupportedOperationException;
    /*
    @REQUIRE :  passw oggetto di tipo stringa != null
                l'oggetto passw == this.passw

    @THROWS : se passw == null solleva NullPointerException
              se passw != this.passw solleva WrongPasswordException

    @EFFECT : ritorna un iteratore (senza remove) che genera tutti i dati in bacheca ordinati rispetto al numero di like
    */

    // Aggiunge un like a un dato se vengono rispettati i controlli d'identità
    void insertLike(String friend,  E dato) throws NullPointerException, FriendNotExistException, DataNotFoundException, TooMuchLikeException;
    /*
    @REQUIRE : l'oggetto friend di tipo stringa != null, l'oggetto dato di tipo E !=null
               l'oggetto friend non deve essere incluso nella 2a componente del dato dato
               L'oggetto dato deve essere incluso nella 2a componente di una categoria 
               	per dati di {insieme di categorie per dati}
               l'oggetto friend deve essere incluso nella 2a componente di 
               una categoria per dati di {insieme di categorie per amici}
               Il NomeCategoria associato all {insieme dei dati} dove è inlcuso dato deve essere uguale
               al NomeCategoria associato all {insieme degli amici} dove è incluso friend. 
               

    @THROWS: se friend == null o dato == null solleva NullPointerException
             se dato non è incluso nella 2a componente di una categoria per dati  di {insieme di categorie per dati} 
             	solleva DataNotFoundException
             se friend non è incluso nella 2a componente della categoria per amici di {insieme delle categorie per amici}
             	dove la 1a componente è equivalente alla 1a componente della categoria per dati dove è incluso il dato dato
             		solleva FriendNotExistException
             se friend è incluso nella 2a componente del dato dato solleva TooMuchLikeException
    
    @MODIFIES : il dato dato

    @EFFECT : incrementa la prima componente del dato dato 
    		  aggiunge friend alla 2a componente del dato dato 
    */

    // Restituisce un iteratore (senza remove) che genera tutti i dati in bacheca condivisi.
    public Iterator<E> getFriendIterator(String friend) throws NullPointerException, UnsupportedOperationException , FriendNotExistException;
    /*
    @REQUIRE : l'oggetto friend di tipo stringa != null

    @THROWS : se friend == null solleva NullPointerException
    
    @EFFECT :  restituisce un iteratore (senza remove) che genera tutti i dati inclusi nelle categorie a cui è associato friend
    */
               
}