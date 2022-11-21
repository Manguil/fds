package filesAttente;

public class FileAttenteAvecStatistiques  extends FileAttente implements
IFileAttenteAvecStatistiques  {

	private  int nbEntrees;
	private  int nbSorties;


	public void mettreEnFile(Personne p)
	{super.mettreEnFile(p); nbEntrees++;}

	public Personne defiler()
	{
		if (!estVide())
			nbSorties++;
		return super.defiler();
	}

	@Override
	public int nbEntrees() {
		return nbEntrees;
	}

	@Override
	public int nbSorties() {
		return nbSorties;
	}
}
