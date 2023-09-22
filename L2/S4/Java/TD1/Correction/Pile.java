package assertionsExceptionsSolution;

import java.util.ArrayList;

public class Pile implements IPile{
		// structure de stockage interne des elements
		private ArrayList<Object> elements;
		
		// Mise en oeuvre des operations
		public Pile(){initialiser();}
		
		public Object depiler() throws PileVideException{
			int nbElementAvant = this.taille();
			if (this.estVide())
				throw new PileVideException("en depilant");
			Object sommet = elements.get(elements.size()-1);
			elements.remove(sommet);
			assert this.taille()==nbElementAvant-1; // Q2
			return sommet;
		}
			
		
		/*
		 * Q1. C'est l'appel à sommet() qui obligeait
		 * à déclarer throws PileVideException
		 * une solution est de regarder directement le sommet
		 * de la pile en accédant au tableau
		 */
		
		public void empiler(Object t) throws PilePleineException {
			// PilePleineException est ajoute a cause de la question suivante
			int nbElementAvant = this.taille();
			elements.add(t);
			Object sommet = elements.get(elements.size()-1);
			assert sommet==t : "dernier empile ="+sommet;
			assert this.taille()==nbElementAvant+1; // Q2
		}
		
		public boolean estVide() {return elements.isEmpty();}
		
		public void initialiser() {
			elements = new ArrayList<>(); 
			assert this.estVide(); //Q2
		}
		
		public Object sommet() throws PileVideException{
		if (this.estVide())
			throw new PileVideException("en depilant");
		return elements.get(elements.size()-1);
		}
		
		public int taille(){return elements.size();}
		
		public String toString(){return "Pile = "+ elements;}

}
