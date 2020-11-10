package com.company;
import java.util.*;

public class CategoryData <E>{
/*
@OVERVIEW : Tipo che definisce una categoria per dati  della bacheca, ci da quindi informazioni sul nome e sui dati
            assocciati ad essa. 
@TYPICAL ELEMENTS: coppia <Nome, {insieme dei dati}>

@Abstract Function
AF (c) : 
    <c.NameCat, {c.CatData.get(i) | 0 <= i < c.CatData.size()}}>

@Rep Invariant
RI(c) : c.NameCat!= null && c.CatData!= null && 
        (forall i,j | 0<= i < j < c.CatData.size() = > !(c.CatData.get(i).equals(c.CatData.get(j)))) &&          //non ci possono essere 2 dati uguali
        (forall i | 0<= i < c.CatData.size() => c.CatData.get(i) != null)                                        //tutti i dati devono essere != null 
*/


    private String NameCat; //Nome della categoria
    private Vector<E> CatData; //Dati associati alla categoria

    public CategoryData (String NameCat){ //non c'è bisogno di passare nulla perchè la stringa è già presente nel metodo createCategory
        this.NameCat=NameCat; //Imposto il nome della categoria
        this.CatData = new Vector<E>(); //inizializzo il vettore dei dati vuoto
    }


    public String getNameCat() {
        return NameCat;
    }


    public Vector<E> getCatData() {
        return CatData;
    }


    
    public void setNameCat(String nameCat) {
    /*
    @MODIFIES: la 1a componente di this
    @EFFECTS : modifica this.NameCat con nameCat
    */
        NameCat = nameCat;
    }


 
    
}