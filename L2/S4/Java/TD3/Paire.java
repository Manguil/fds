public class Paire<A,B>
{
    private A fst;
    private B snd;
    public Paire(A f,B s){fst = f ; snd =  s;}
    public A getFst(){return fst;}
    public B getSnd(){return snd;}
    public void setFst(A a){fst = a;}
    public void setSnd(B b){ snd = b;}
    public String toString(){return getFst() +" - "+ getSnd();}
}