package com.company;
import java.util.*;

public class Data {
/*
@OVERVIEW: Tipo che definisce un dato in bacheca. Permette la creazione, modifica, copia e stampa di un dato 
@TYPICAL ELEMENTS: coppia <Likes, {insieme di amici che hanno messo like}>

@Abstract Function:
@AF (c) : <c.Likes, {c.Friends.get(i) |0<= i < c.Friends.size()}>

@Rep Invariant
@RI (c) :
    c.Likes>=0 && c.Friends != null &&
    (forall i,j | 0<= i < j < c.Friends.size() => !(c.Friends.get(i)equals(c.Friends.get(j)))

*/


    //definisce il numero di like per il dato considerato
    protected int likes; 

    //Vettore di stringhe necessario per verificare se un utente ha messo più di un like ad un determinato dato 
    protected Vector <String> Friends; 
    
    //costruttore
    public Data (){
    //EFFECTS: inzializza this
        this.Friends = new Vector<String>();
        this.likes = 0;
    }

    
    public int getLikes (){
        return likes;
    }

   
    public Vector<String> getFriends(){
        return Friends;
    } 


    public void setLikes(int likes) {
    /*
    @MODIFIES : la 1a componente di this
    @EFFECTS : modifica il valore di this.likes con likes
    */
        this.likes = likes;
    }

    //Stampa Likes
    public String toString (){
    //EFFECTS: ritorna una stringa seguita da un intero che indica il numero di likes 
        return "\nPiace a " + this.likes;
    }

    //Copia un dato
    public Data copy (){
    //@EFFECTS: crea una copia di this
        Data dato = new Data();
        dato.likes = this.likes;
        dato.Friends = new Vector<String>(this.Friends);
        return dato;
    }

    //Aggiunge un like
    public boolean addLikes(String amico, Data dato) {
    /*
    @MODIFIES : la 2a componente di this
    @EFFECTS : modifica {insieme degli amici che hanno messo like} e ritorna true se l'aggiunta è andata a buon fine
    */

        if (dato.Friends.contains(amico))
            return false;
        else {
            dato.Friends.add(amico);
            dato.likes++;
        }
        return true;
    }
    
    //Stampa tutte le info sul dato   
    public void Display (){
    //@EFFECTS: stampa toString
        System.out.println(toString());
        
    }

}


