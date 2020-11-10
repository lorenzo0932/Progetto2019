package com.company;
import java.util.*;

public class CategoryFriends <E>{
/*
@OVERVIEW : Tipo che definisce una categoria per amici della bacheca, ci da quindi informazioni sul nome e gli amici
            assocciati ad essa. 
@TYPICAL ELEMENTS: coppia <Nome, {insieme degli amici}>

@Abstract Function
AF (c) : 
    <c.NameCat, {c.CatFriends.get(j) | 0<= j < c.CatFriends.size()}>

@Rep Invariant
RI(c) : c.NameCat!= null  && c.CatFriends!= null &&
        (forall i,j | 0<= i < j < c.CatFriends.size() => !(c.CatFriends.get(i).equals (c.CatFriends.get(j))));&& //non ci possono essere 2 amici uguali
        (forall i | 0<= i < c.CatFriends.size() => c.CatFriends.get(i) != null) &&                               //tutti gli amici dell'insieme non devono essere null
*/


    private String NameCat; //Nome della categoria
    private Vector<String> CatFriends; // Amici associati alla categoria

    public CategoryFriends (String NameCat){ //non c'è bisogno di passare nulla perchè la stringa è già presente nel metodo createCategory
        this.NameCat=NameCat; //Imposto il nome della categoria
        this.CatFriends = new Vector<String> ();//inizializzo il vettore degli amici vuoto
    }


    public Vector<String> getCatFriends() {
        return CatFriends;
    }


    public String getNameCat() {
        return NameCat;
    }


    
    public void setNameCat(String nameCat) {
    /*
    @MODIFIES: la 1a componente di this
    @EFFECTS : modifica this.NameCat con nameCat
    */
        NameCat = nameCat;
    }


 
    
}