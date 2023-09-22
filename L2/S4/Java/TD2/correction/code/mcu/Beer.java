package mcu;

public class Beer {

    public double beerEBC() 
    {return 2.939*Math.pow(MCU(), 0.6859);}	
    
    // la méthode suivante est mal rédigée
    // elle fait mention d'un test de type sur le type
    // de l'objet
    // le code qu'elle contient est celui de la responsabilité
    // de la classe SingleMaltBeer
    
    public double MCU() {
         if (this instanceof SingleMaltBeer){
              SingleMaltBeer smb = (SingleMaltBeer)this;
              return 4.23*smb.getMaltEBC()*
              smb.getMaltWeight()/smb.getBeerVolume();
         } else return 1;     
    }

}
