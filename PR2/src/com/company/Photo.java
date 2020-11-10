package com.company;
import java.util.*;

public class Photo extends Data {

    private String Description;
    private int Dimension;
    private String Location;
    private int Year, Month, Day;

    //costruttore foto
    public Photo (int Dimension, String Description, String Location, int Year, int Month, int Day){
        this.Dimension=Dimension;
        this.Description = Description;
        this.Location = Location;
        this.Year = Year;
        this.Month = Month;
        this.Day = Day;
    }

    @Override
    public boolean equals (Object o){
        if (o == this )
            return true;
        if (!(o instanceof Photo))
            return false;
        Photo immagine = (Photo) o;
        return 
            Description.equals (immagine.Description) 
            && Dimension == immagine.Dimension 
            && Location.equals(immagine.Location)
            && Day == immagine.Day
            && Month == immagine.Month
            && Year == immagine.Year;
     }

    public String getDataDescription (){
        return Description;
    }

    //Clona un dato di tipo foto
    public Data copy (){
        Photo foto = new Photo(this.Dimension, this.Description, this.Location,this.Year, this.Month, this.Day);
        foto.likes = this.likes;
        foto.Friends= new Vector<String>(this.Friends);
        return foto;
    }

    //Stampa le informazioni sulla foto senza like e amici che la possono vedere
    public String toString (){
        return "Tipo di dato: Foto\n" + "Descrizione: " 
        +  Description + "\nDimensione: "
        + Dimension 
        + "\nPubblicata il: " 
        + Day + "/" 
        + Month + "/" 
        + Year
        + "\nPresso: "
        +Location
        + super.toString();
    }

    //Stampa le informazioni sulla foto
    public void Display (){
        System.out.println (toString());
    }
}
