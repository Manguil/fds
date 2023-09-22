package mcu2;

/*
 * SingleMaltBeer peut être une classe soeur de MultiMaltBeer
 * ou comme ici une sous-classe et on va surveiller qu'on ne peut ajouter qu'un malt
 * 
 * Autre modélisation possible : bière spécialisée par bière avec malt (méthode MCU)
 * et bière avec mal spécialisée par SingleMaltBeer et MultiMaltBeer
 * cela permettrait de respecter la substitution comportementale
 * mais on factorise moins bien l'idée qu'il y a 1 ou plusieurs malts dans les 
 * bières avec malt (à discuter)
 * 
 */

public class SingleMaltBeer extends MultiMaltBeer {
	
	@Override
	public void addMalt(Malt m, double d) throws MaltAlreadyAddedException {
		if (nbMalts()==0)
			super.addMalt(m, d);
		else throw new MaltAlreadyAddedException("single malt : 1 seul malt");
	}

    public SingleMaltBeer(double beerVolume) {
         super(beerVolume);      
    }

}
