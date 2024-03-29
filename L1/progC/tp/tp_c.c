#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#include "tp3.h"
#include "tp4.h"
#include "liste.h"

void tp1_1()
{
	int a, b, som, prod;
	printf("rentre 2 valeurs:\n");
	scanf("%d %d", &a, &b);
	som = a + b;
	prod = a * b;
	printf("%d+%d = %d et %d*%d = %d\n", a, b, som, a, b, prod);
}

void tp1_2()
{
	int a, b, temp;
	printf("rentre 2 valeurs:\n");
	scanf("%d %d", &a, &b);
	printf("a=%d à l'adresse %p et b=%d à l'adresse %p\n", a, &a, b, &b);
	temp = a;
	a = b;
	b = temp;
	printf("a=%d à l'adresse %p et b=%d à l'adresse %p\n", a, &a, b, &b);
}

void tp2_2()
{
	int n1, n2, n3;
	printf("Rentre 3 entiers : (sep par des espaces)\n");
	scanf("%d%d%d", &n1, &n2, &n3);
	int max, min;
	if (n1 > n2)
	{
		max = n1;
		min = n2;
	}
	else
	{
		max = n2;
		min = n1;
	}
	if (n3 > max)
		max = n3;
	else if (n3 < min)
	{
		min = n3;
	}
	printf("le min est %d et le max est %d", min, max);
}

void tp2_3()
{
	int x, n;
	printf("valeur x et n : (sep par des espaces) (n >=0)\n");
	scanf("%d%d", &x, &n);
	while (n < 0)
	{
		printf("n est inférieur à 0 !!\n");
		scanf("%d", &n);
	}
	int res = 1;
	for (int i = 0; i < n; i++)
		res *= x;
	printf("%d exposant %d = %d\n", x, n, res);
}

void tp2_4()
{
	int n;
	double res = 0;
	printf("valeur n : \n");
	scanf("%d", &n);
	for (int i = 1; i < n; i++)
		res += 1. / i;
	printf("la somme est %lf\n", res);
	res = 0;
	for (int i = n; i > 0; i--)
		res += 1. / i;
	printf("la somme est %lf\n", res);
}

void tp2_5()
{
	int n, nb_n;
	nb_n = 0;
	do
	{
		printf("entre un entier relatif : \n");
		scanf("%d", &n);
		nb_n += 1;
		n += n;
	} while (n >= 0);
	printf("il y a %d entier naturel \n", nb_n);
	float nb_n_float = nb_n;
	printf("la moyenne est %f", n / nb_n_float);
}

void tp2_6()
{
	int n, div;
	printf("entre un entier : \n");
	scanf("%d", &n);
	_Bool prem = 0;
	for (int i = 2; i < n - 1; i++)
	{
		if (n % i == 0)
		{
			prem = 1;
			div = i;
			break;
		}
	}
	if (!prem)
		printf("%d est un nombre premier", n);
	else
		printf("%d n'est pas un nombre premier car %d divise %d", n, div, n);
}

void tp3_1()
{
	int nbNote = 0;
	float moyNote = 0;
	printf("Combien de note as-tu :\n");
	scanf("%d", &nbNote);
	if (nbNote <= 0)
		return;
	moyNote = moyenne(nbNote);
	printf("tu as %f de moyenne", moyNote);
}

void tp3_2()
{
	int n = 0;
	printf("nb :\n");
	scanf("%d", &n);
	printf("cent %d, diz %d, uni %d\n", centaine(n), dizaine(n), unite(n));
	while (n < 0 || n > 999)
	{
		printf("nb non valide, nb :\n");
		scanf("%d", &n);
	}
	printf("%d\n", testeProp(n));
}

void tp3_3()
{
	time_t s;
	struct tm *current_time;
	s = time(NULL);
	current_time = localtime(&s);
	int anneeCourante = current_time->tm_year + 1900;
	int jour = 0;
	int annee = 0;
	int mois = 0;
	printf("rentre une date :\n");
	scanf("%d/%d/%d", &jour, &mois, &annee);
	if (dateValide(jour, mois, annee))
		compteJours(anneeCourante, jour, mois, annee);
}

int tp4_1()
{
	int val = 0;
	while (1)
	{
		printf("choisi entre :\n- 0 : quitte le programme\n- 1 : saisit un entier et dit s'il est parfait\n- 2 : saisit deux entiers a et b et affiche le nombre d'entiers parfait de l'intervalle [a,b] \n- 3 : saisit un entier n et affiche le nième nombre parfait\n");
		scanf("%d", &val);
		int n = 0;
		int a = 0;
		int b = 0;
		switch (val)
		{
		case 0:
			return 0;
		case 1:
			printf("n : ");
			scanf("%d", &n);
			printf("%d est parfait : %d\n", n, testParfait(n));
			break;
		case 2:
			printf("a b : (sep par des espaces)");
			scanf("%d %d", &a, &b);
			printf("il y a %d nb parfait\n", nbParfait(a, b));
			break;
		case 3:
			printf("n : ");
			scanf("%d", &n);
			printf("le %d ième nb parfait est %d\n", n, niemeParfait(n));
			break;
		}
	}
	return 0;
}

void tp4_2()
{
	int choix = 1;
	printf("choisi [1-5] :\n");
	scanf("\t%d", &choix);
	switch (choix)
	{
	case 2:
	{
		tps t = {0, 0, 0};
		printf("rentre un temps (format: hh:mm:ss.dcm)\n");
		scanf("%2d:%2d,%6f", &t.h, &t.m, &t.s);
		verifTemps(&t);
		float s = 0;
		s = tempsEnSeconde(&t);
		printf("%2.3f seconde(s)", s);
		break;
	}
	case 3:
	{
		float s = 0;
		printf("rentre un nb de secondes(ss.dcm)\n");
		scanf("%f", &s);
		tps t = {0, 0, 0};
		secondeEnTemps(s, &t);
		afficherTemps(&t);
		break;
	}
	case 4:
	{
		tps t1 = {0, 0, 0};
		tps t2 = {0, 0, 0};
		printf("rentre deux temps (format: hh:mm:ss.dcm|hh:mm:ss.dcm)\n");
		scanf("%2d:%2d:%6f|%2d:%2d:%6f", &t1.h, &t1.m, &t1.s, &t2.h, &t2.m, &t2.s);
		verifTemps(&t1);
		verifTemps(&t2);
		float sDuree = 0;
		sDuree = duree(&t1, &t2);
		printf("il y a %2.3f s de difference", sDuree);
		break;
	}
	case 5:
	{
		int choix = 0;
		tps tempsDepart = {0, 0, 0}, tempsMax = {0, 0, 0}, tempsMin = {0, 0, 0}, duree = {0, 0, 0};
		float coeff = 1;
		printf("quelle est l'heure de depart (format: hh:mm:ss.dcm)\n");
		scanf("\t%2d:%2d:%6f", &tempsDepart.h, &tempsDepart.m, &tempsDepart.s);
		printf("quelle est la duree : \n");
		scanf("\t%2d:%2d:%6f", &duree.h, &duree.m, &duree.s);
		printf("quelle est le coeff : \n");
		scanf("%f", &coeff);
		printf("quelle version veux-tu : \n");
		scanf("%d", &choix);
		switch (choix)
		{
		case 2:
		{

			break;
		}
		case 3:
		{

			break;
		}
		default:
		{
			heureArriveeV1(&tempsDepart, &duree, coeff, &tempsMax, &tempsMin);
			break;
		}
		}
		afficherTemps(&tempsMin);
		afficherTemps(&tempsMax);
		break;
	}
	default:
	{
		tps t = {0, 0, 0};
		printf("rentre un temps (format: hh:mm:ss.dcm)\n");
		scanf("%2d:%2d:%6f", &t.h, &t.m, &t.s);
		verifTemps(&t);
		afficherTemps(&t);
		break;
	}
	}
}

int tp7_1()
{
	liste l[2];
	l[0] = insereTete(133, insereTete(15, insereTete(4, insereTete(34, insereTete(23, NULL)))));
	l[1] = NULL;

	char choix = '0';
	int i = 2, pos = '0', elem = 0;
	do
	{
		printf("\n*************************************************\n");
		printf("l[0] contient %d elements : ", longueur(l[0]));
		afficher(l[0]);
		printf("\n");
		printf("l1 contient %d elements : ", longueur(l[1]));
		afficher(l[1]);
		printf("\n");
		printf("Menu\n");
		printf("(A)fficher n-ieme element\n");
		printf("(M)odifier n-ieme element de liste\n");
		printf("(I)nserer element a une position\n");
		printf("(S)upprimer n-ieme element\n");
		printf("(V)ider liste\n");
		printf("(P)ermuter 2 elements de la liste\n");
		printf("(C)oncatener liste a l'autre liste\n");
		printf("(D)upliquer liste dans l'autre liste\n");
		printf("Inserer(B)is element a une position\n");
		printf("(E)xtraire pairs de liste dans l'autre\n");
		printf("(Q)uitter\n");
		printf("Votre Choix (Lettre suivie de 0 ou 1) => ");
		int nb = scanf("%c%d", &choix, &i);
		while ((nb != 2 && (nb != 1 || choix != 'Q')) || (choix != 'A' && choix != 'M' && choix != 'I' && choix != 'S' && choix != 'V' && choix != 'P' && choix != 'C' && choix != 'D' && choix != 'B' && choix != 'E' && choix != 'Q') || (i != 0 && i != 1 && choix != 'Q'))
		{
			// printf("Mauvais choix => ");
			nb = scanf("%c%d", &choix, &i);
		}
		switch (choix)
		{
		case 'A':
			printf("Nieme element : quelle position ? ");
			scanf("%d", &pos);
			printf("==> Le %d-ieme element de l%d est %d\n\n", pos, i, nieme(pos, l[i]));
			break;
		case 'M':
			printf("==> Fonction non implantee \n\n");
			break;
		case 'I':
			printf("Inserer element : quel element ? ");
			scanf("%d", &elem);
			printf("Quelle position ? ");
			scanf("%d", &pos);
			l[i] = inserer(elem, pos, l[i]);
			printf("\n");
			break;
		case 'S':
			printf("==> Fonction non implantee \n\n");
			break;
		case 'V':
			while (l[i] != NULL)
				l[i] = supprimerTete(l[i]);
			printf("liste supprimée \n\n");
			break;
		case 'P':
			printf("==> Fonction non implantee \n\n");
			break;
		case 'C':
			printf("==> Fonction non implantee \n\n");
			break;
		case 'D':
			printf("==> Fonction non implantee \n\n");
			break;
		case 'B':
			printf("==> Fonction non implantee \n\n");
			break;
		case 'E':
			printf("==> Fonction non implantee \n\n");
			break;
		case 'Q':
			printf("==> Au revoir !\n\n");
		default:;
		}
	} while (choix != 'Q');
	return 0;
}

void traiterNotes(FILE fichier)
{
}

void tp8_2(int argc, char **argv)
{
	int num;
	char prenom[51], nom[51], chaine[10];
	float note;
	FILE *fd = fopen(argv[1], "r");
	int nbChamps;
	if (argc != 2)
	{
		printf("mauvais nombre d'argument");
		exit(EXIT_FAILURE);
	}
	else if (fd == NULL)
	{
		printf("Probleme de lecture");
		exit(EXIT_FAILURE);
	}
	else
	{
		do
		{
			nbChamps = fscanf(fd, "%i %s %s %f", &num, prenom, nom, &note);
			switch (nbChamps)
			{
			case 4:
			{
				printf("%i %s %s %f\n", &num, prenom, nom, &note);
				break;
			}
			case 3:
			{
				fscanf(fd, "%s", &chaine);
				printf("il y a %s", chaine);
				break;
			}
			};
		} while (nbChamps != EOF);
	}
}

int main(int argc, char **argv)
{
	float nb;
	int num;
	printf("1.1:tp1 tp1, 2.1:tp2 tp1 ...\n");
	scanf("%f", &nb);
	num = nb * 10;
	switch (num)
	{
	default:
	{
		printf("il n'y a pas d'exercice !!");
		break;
	}
	case 11:
	{
		tp1_1();
		break;
	}
	case 12:
	{
		tp1_2();
		break;
	}
	case 22:
	{
		tp2_2();
		break;
	}
	case 23:
	{
		tp2_3();
		break;
	}
	case 24:
	{
		tp2_4();
		break;
	}
	case 25:
	{
		tp2_5();
		break;
	}
	case 26:
	{
		tp2_6();
		break;
	}
	case 31:
	{
		tp3_1();
		break;
	}
	case 32:
	{
		tp3_2();
		break;
	}
	case 33:
	{
		tp3_3();
		break;
	}
	case 41:
	{
		tp4_1();
		break;
	}
	case 42:
	{
		tp4_2();
		break;
	}
	case 71:
	{
		tp7_1();
		break;
	}
	case 82:
	{
		tp8_2(argc, argv);
		break;
	}
	}
	return 0;
}