package assertionsExceptionsSolution;

public interface IPileBornee extends IPile {
    int getTailleMax();
    void setTailleMax(int taille) 
    		throws TaillePileException;
    int tailleMaxParDefaut=10;// vaut pour toutes les piles
}

/*
*
******
*Types
| PileBornee
| Pile (super-type de PileBornee)
******
Operations
| les operations de la pile
| getTailleMax() :int
| setTailleMax(int taille)
******
Preconditions
| precondition(p.depiler()) et precondition(p.sommet()) : p.estVide()
| precondition(p.empiler(Object element)) : p.taille() < p.getTailleMax()
| precondition(p.setTailleMax(int taille)) : taille >0 et p.taille() <= taille
******
Axiomes
| Avec p.taille() < getTailleMax(), juste apres l'instruction p:empiler(t), on a p.sommet() = t
| Avec p.taille() >= getTailleMax(), et p.sommet() = x, juste apres l'instruction p.empiler(t), on a p.sommet() = x
| Juste apres p.initialiser(), on a p.estVide() = true
| Juste apres p.empiler(t), on a p.estVide() = faux
| Avec p.taille() < getTailleMax(), juste apres p.empiler(t), on a p.depiler() = t
| Avec p.taille()>= getTailleMax(), et p.sommet() = x, juste apres l'instruction p.empiler(t), on a p.depiler() = x
| Juste apres p.setTailleMax(i), avec i>0, et p.taille() < i on a p.getTailleMax() = i
| Juste apres p.setTailleMax(i) avec p.getTailleMax() = n et (p.taille() >=i ou avec i<=0), on a p.getTailleMax() = n
*
*/
