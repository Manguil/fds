import java.util.ArrayList;

public class FileAttente <A>
{
    private String nomFile;
    private static int nbEntreesTotal = 0;
    private ArrayList<A> contenu;

    public FileAttente(){contenu=new ArrayList<A>();}

    public ArrayList<A> getContenu(){return contenu;}

    public void entre(A p){contenu.add(p); nbEntreesTotal++;}

    public A sort()
    {
        A p=null;
        if (!contenu.isEmpty())
        {p=contenu.get(0);
        contenu.remove(0);}
        return p;
    }

    public int nbElements(){return contenu.size();}

    public boolean estVide(){return contenu.isEmpty();}

    public String toString(){return ""+descriptionContenu();}
    
    private String descriptionContenu()
    {
        String resultat = "";
        for (A p:this.contenu)
        resultat += p + " ";
        return resultat;
    }

    public static int nbEntreesTotal(){return nbEntreesTotal;}

    public static <A> boolean memesObjetsStatique(FileAttente<A> a, FileAttente<A> b){return a.equals(b);}

    public boolean memesObjets(FileAttente<A> a){return contenu.containsAll(a.getContenu()) && a.getContenu().containsAll(contenu);}

    public <B> boolean memesTailles(FileAttente<B> a)
    {
        return nbElements() == a.nbElements();
    }

}