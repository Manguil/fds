package assertionsExceptionsSolution;

public interface IPile {
	void initialiser();	
	void empiler(Object t) throws PilePleineException ;
	Object depiler()throws PileVideException;;
	Object sommet() throws PileVideException;
	boolean estVide();
	int taille();
}
