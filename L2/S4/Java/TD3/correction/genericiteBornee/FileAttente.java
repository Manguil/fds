package correction.genericiteBornee;


import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class FileAttente<E extends Invitable>
	{
		private String nomFile;
		private static int nbElementsEntresTotal = 0;
		private ArrayList<E> contenu;
		
		public FileAttente(){contenu=new ArrayList<E>();}
		
		public void entre(E p) throws NonInviteException
		{
			if (p.estInvite())
				{contenu.add(p); nbElementsEntresTotal++;}
			else throw new NonInviteException("non invite");
		}
		
		public E sort()
			{
				E p=null;
				if (!contenu.isEmpty())
				{p=contenu.get(contenu.size()-1);      
	                   contenu.remove(contenu.size()-1);}
				return p;
			}
		
		public boolean estVide(){return contenu.isEmpty();}
		
		public String toString(){return ""+descriptionContenu();}
		
		private String descriptionContenu()
		{
			String resultat = "";
			for (E p:this.contenu)
				resultat += p + " ";
			return resultat;
		}
		
		public static int getNbPersonnesEntreesTotal() // 
		{
			return FileAttente.nbElementsEntresTotal;
		}
		
		public void deplacePremierVers(FileAttente<? super E> autreFile) throws NonInviteException
		{
			if (this.estVide())
				return;
			else
				autreFile.entre(this.sort());
		}
		
		public void accueillePremierDe(FileAttente<? extends E> autreFile) throws NonInviteException
		{
			if (autreFile.estVide())
				return;
			else
				this.entre(autreFile.sort());
		}
	
	public static void main(String[] args) {
		try {
			FileAttente<Personne> f3 = new FileAttente<>();
			f3.entre(new Personne("Jeanne","Larivière", true, 18));
			f3.entre(new Personne("Nancy","Petipon", true, 14));
			//f3.entre(new Personne("Virginie","Zachs", false));
			//f3.entre(new Personne("Rachel","Artigues", false));
			FileAttente<Adulte> f2 = new FileAttente<>();
			f2.entre(new Adulte("Mathurin","Despres",true, 25));
			//f2.entre(new Adulte("Hector","Malo",false));
			FileAttente<Enfant> f1 = new FileAttente<>();
			f1.entre(new Enfant("Mohamed","Bouate", true, 8));
			
			f1.deplacePremierVers(f3);
			f2.deplacePremierVers(f3);
			// impossible f3.deplacePremierVers(f1);
			
			// impossible f1.accueillePremierDe(f3);
			f3.accueillePremierDe(f2);
			f3.accueillePremierDe(f1);
			
			List<Personne> l3 = new LinkedList<>();
			l3.add(new Personne("Jeanne","Larivière", true, 10));
			l3.add(new Personne("Nancy","Petipon", true, 14));
			l3.add(new Personne("Virginie","Zachs", false, 25));
			l3.add(new Personne("Rachel","Artigues", false, 12));
			System.out.println(l3);
			System.out.println(Collections.max(l3).getNom());
			System.out.println(Collections.max(l3, new ComparePersonneAge()).getNom());	
			Collections.sort(l3);
			System.out.println(l3);
			Collections.sort(l3, new ComparePersonneAge());
			System.out.println(l3);
			
		} catch (NonInviteException e) {
			System.out.println(e.getMessage());
		}


	}

}
