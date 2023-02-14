package assertionsExceptionsSolution;

public class PileBornee extends Pile 
						implements IPileBornee {
	
	// chaque pile a sa propre taille max
	// qui est par défaut celle prévue dans
	// l'interface pour tout le monde
	
    private int tailleMax=IPileBornee.tailleMaxParDefaut; 
    
    public PileBornee() {}
    private boolean invariant() 
    	{return this.taille() <= tailleMax;}
	
    public void empiler(Object t) 
    		throws PilePleineException {
        if (this.taille() == tailleMax)
            throw new PilePleineException();
        super.empiler(t);
        assert invariant();
    }
	
	@Override
    public int getTailleMax() {return this.tailleMax;}

	@Override
    public void setTailleMax(int taille) 
    			throws TaillePileException {
        if (taille <=0)
            throw new TailleMaxNegativeException();
        if (taille() > taille) // il y a trop d'éléments stockés
        // par rapport à la nouvelle taille que l'on veut attribuer
            throw new TailleMaxInvalideException();
        this.tailleMax=taille;
        assert invariant();
    }
}