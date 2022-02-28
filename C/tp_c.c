#include <stdio.h>
#include <math.h>
#include <time.h>
#include "parfait.h"



void exo1(){
    int a,b,som,prod;
    printf("rentre 2 valeurs:\n");
    scanf("%d %d",&a,&b);
    som=a+b;
    prod=a*b;
    printf("%d+%d = %d et %d*%d = %d\n",a,b,som,a,b,prod);
}



void exo2(){
    int a,b,temp;
    printf("rentre 2 valeurs:\n");
    scanf("%d %d",&a,&b);
    printf("a=%d à l'adresse %p et b=%d à l'adresse %p\n",a,&a,b,&b);
    temp=a;
    a=b;
    b=temp;
    printf("a=%d à l'adresse %p et b=%d à l'adresse %p\n",a,&a,b,&b);
}



void exo2_2(){
    int n1,n2,n3;
    printf("Rentre 3 entiers : (sep par des espaces)\n");
    scanf("%d%d%d",&n1,&n2,&n3);
    int max,min;
    if (n1 > n2){
        max = n1;
        min = n2;
    }
    else {
        max = n2;
        min = n1;
    }
    if (n3 > max)
    max = n3;
    else if (n3 < min){
        min = n3;
    }
    printf("le min est %d et le max est %d", min, max);
}



void exo2_3(){
    int x,n;
    printf("valeur x et n : (sep par des espaces) (n >=0)\n");
    scanf("%d%d",&x,&n);
    while (n<0){
        printf("n est inférieur à 0 !!\n");
        scanf("%d",&n);
    }
    int res = 1;
    for(int i = 0;i<n;i++)
        res*=x;
    printf("%d exposant %d = %d\n",x,n,res);
}



void exo2_4(){
    int n;
    double res = 0;
    printf("valeur n : \n");
    scanf("%d",&n);
    for(int i=1 ; i<n ; i++)
        res+=1./i;
    printf("la somme est %lf\n",res);
    res = 0;
    for(int i=n ; i>0 ; i--)
        res += 1./i;
    printf("la somme est %lf\n",res);
}



void exo2_5(){
    int n,nb_n;
    nb_n = 0;
    do {
        printf("entre un entier relatif : \n");
        scanf("%d",&n);
        nb_n += 1;
        n += n;
    }
    while (n>=0);
    printf("il y a %d entier naturel \n",nb_n);
    float nb_n_float = nb_n;
    printf("la moyenne est %f",n/nb_n_float);
}



void exo2_6(){
    int n,div;
    printf("entre un entier : \n");
    scanf("%d",&n);
    _Bool prem = 0;
    for(int i = 2; i<n-1;i++){
        if (n%i==0){
            prem = 1;
            div = i;
            break;
        }
    }
    if (!prem)
        printf("%d est un nombre premier",n);
    else printf("%d n'est pas un nombre premier car %d divise %d",n,div,n);    
}



float saisiNote(){
    float note = -1;
    printf("Rentre ta note : \n");
    scanf("%f",&note);
    if (note < 0 || note > 20) return -1;
    return note;
}

float moyenne(int n){
    float note = 0;
    float moy = 0;
    for(int i = 0; i<n; i++){
        note = saisiNote();
        while (note == -1) note = saisiNote();
        moy = moy + note;
    }
    moy = moy/n;
    return moy;
}

void exo3_1(){
    int nbNote = 0;
    float moyNote = 0;
    printf("Combien de note as-tu :\n");
    scanf("%d",&nbNote);
    if (nbNote <= 0) return;
    moyNote = moyenne(nbNote);
    printf("tu as %f de moyenne",moyNote);
}



int unite(int n){
    return n%10;
}

int dizaine(int n){
    return unite(n/10);
}

int centaine(int n){
    return unite(n/100);
}

_Bool testeProp(int n){
    if (pow(unite(n),3)+pow(dizaine(n),3)+pow(centaine(n),3)==n) return 1;
    return 0;
}

void exo3_2(){
    int n = 0;
    printf("nb :\n");
    scanf("%d",&n);
    printf("cent %d, diz %d, uni %d\n", centaine(n), dizaine(n), unite(n));
    while(n < 0 || n > 999) {
        printf("nb non valide, nb :\n");
        scanf("%d",&n);
    }
    printf("%d\n",testeProp(n));
}



_Bool bissextile(int n){
    if (n%400==0) return 1;
    else if (n%100==0) return 0;
    else if (n%4==0) return 1;
    else return 0;
}

_Bool dateValide(int jour, int mois, int annee){
    _Bool a = 0;
    if (annee > 1582){
        /*
        if (mois > 0 && mois <= 12){
            if (mois == 2 && bissextile(annee) && jour > 0 && jour <= 29)
                a = 1;
            else if (mois == 2 && !bissextile(annee) && jour > 0 && jour <= 28)
                a = 1;
            else if (mois <= 7 && mois%2 == 1 && jour > 1 && jour <= 31)
                a = 1;
            else if (mois > 7 && mois%2 == 0 && jour > 1 && jour <= 30)
                a = 1;
            else if (mois <= 7 && mois%2 == 0 && jour > 1 && jour <= 30)
                a = 1;
            else if (mois > 7 && mois%2 == 1 && jour > 1 && jour <= 31)
                a = 1;
            */
            switch (mois){
                case 1:
                    if (jour > 0 && jour <= 31) a = 1;
                    break;
                case 2:
                    if (bissextile(annee)){
                        if (jour > 0 && jour <= 29) a = 1;
                        break;
                    }
                    else {
                        if (jour > 0 && jour <= 28) a = 1;
                        break;
                    }
                case 3:
                    if (jour > 0 && jour <= 31) a = 1;
                    break;
                case 4:
                    if (jour > 0 && jour <= 30) a = 1;
                    break;
                case 5:
                    if (jour > 0 && jour <= 31) a = 1;
                    break;
                case 6:
                    if (jour > 0 && jour <= 30) a = 1;
                    break;
                case 7:
                    if (jour > 0 && jour <= 31) a = 1;
                    break;
                case 8:
                    if (jour > 0 && jour <= 31) a = 1;
                    break;
                case 9:
                    if (jour > 0 && jour <= 30) a = 1;
                    break;
                case 10:
                    if (jour > 0 && jour <= 31) a = 1;
                    break;
                case 11:
                    if (jour > 0 && jour <= 30) a = 1;
                    break;
                case 12:
                    if (jour > 0 && jour <= 31) a = 1;
        
        }
    }
    return a;
}

int nbJourMois(int mois, int annee){
    if (mois == 2 && bissextile(annee)) return 29;
    else if (mois == 2 && !bissextile(annee)) return 28;
    else if (mois <= 7 && mois%2 == 1) return 31;
    else if (mois <= 7 && mois%2 == 0) return 30;
    else if (mois > 7 && mois%2 == 0) return 31;
    else if (mois > 7 && mois%2 == 1) return 30;
    else return 0;
}

void compteJours(int anneeCourante, int jour, int mois, int annee){
    int nbJour = 0;
    int diffAnnee;
    if (anneeCourante <= annee){
        diffAnnee = annee - anneeCourante;
        for (int i = 0; i < diffAnnee; i++){
            if (bissextile(anneeCourante+i)) nbJour ++;
        }
        printf("%d\n",nbJour);
        nbJour += 365*diffAnnee;
        for (int i = mois-1; i>0; i--){
            nbJour += nbJourMois(mois-i,annee);
        }
        if (diffAnnee == 0) nbJour += (jour-(1*(mois-1)));
        else nbJour += (jour-1);
    printf("Il y a %d jours entre le 1/1/%d et le %d/%d/%d", nbJour,anneeCourante,jour,mois,annee);
    }
}

void exo3_3(){
    time_t s;
    struct tm* current_time;
    s = time(NULL);
    current_time = localtime(&s);
    int anneeCourante = current_time->tm_year+1900;
    printf("%d",bissextile(anneeCourante));
    int jour = 0;
    int annee = 0;
    int mois = 0;
    printf("rentre une date :\n");
    scanf("%d/%d/%d\n",&jour,&mois,&annee);
    if (dateValide(jour,mois,annee)) compteJours(anneeCourante,jour,mois,annee);
}


/*
int exo4_1(){
    int val = 0;
    while (1){
        printf("choisi entre :\n- 0 : quitte le programme\n- 1 : saisit un entier et dit s'il est parfait\n- 2 : saisit deux entiers a et b et affiche le nombre d'entiers parfait de l'intervalle [a,b] \n- 3 : saisit un entier n et affiche le nième nombre parfait\n");
        scanf("%d",&val);
        int n = 0;
        int a = 0;
        int b = 0;
        switch (val){
            case 0:
                return 0;
            case 1:
                printf("n : ");
                scanf("%d",&n);
                printf("%d est parfait : %d\n",n,testParfait(n));
                break;
            case 2:
                printf("a b : (sep par des espaces)");
                scanf("%d %d",&a,&b);
                printf("il y a %d nb parfait\n",nbParfait(a, b));
                break;
            case 3:
                printf("n : ");
                scanf("%d",&n);
                printf("le %d ième nb parfait est %d\n",n,niemeParfait(n));
                break;
        }
    }
    return 0;
}*/


#include "temps.h"

void exo4_2(){
    tps t1 = {1,1,53.175};
    tempToSeconde(&t1);
    printf("%d : %d : %f \n",t1.h,t1.m,t1.s);
}



int main(){
    float nb;
    int num;
    printf("1.1:td1 exo1, 2.1:td2 exo1 ...\n");
    scanf("%f",&nb);
    num = nb*10;
    switch (num){
        case 11:
            exo1();
            break;
        case 12:
            exo2();
            break;
        case 22:
            exo2_2();
            break;
        case 23:
            exo2_3();
            break;
        case 24:
            exo2_4();
            break;
        case 25:
            exo2_5();
            break;
        case 26:
            exo2_6();
            break;
        case 31:
            exo3_1();
            break;
        case 32:
            exo3_2();
            break;
        case 33:
            exo3_3();
            break;
            /*
        case 41:
            exo4_1();
            break;*/
        case 42:
            exo4_2();
            break;
    }
    return 0;
}