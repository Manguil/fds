#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define tailleTampon 10

int main(int argc, char **argv)
{
	if (argc != 3)
	{
		printf("commmande format: %s -[8|c8] chemin\n", argv[0]);
		return 1;
	}

	FILE *f = fopen(argv[2], "r");
	if (f == NULL)
	{
		printf("erreur d'ouverture de %s\n", argv[2]);
		return 2;
	}

	int nb = 0;
	int nbALire = 0;

	if (argv[1][1] == 'c')
	{
		nbALire = atoi(argv[1] + 2); // pour sauter -c
		char *tampon = malloc(sizeof(char) * nbALire);
		if (fread(tampon, sizeof(char), nbALire, f) != nbALire)
		{
			printf("erreur de lecture (surement fin de fichier)\n");
			return 3;
		}
		printf("%s\n", tampon);
		nb++;
	}

	else
	{
		nbALire = atoi(argv[1] + 1); // pour sauter - (sizeof(char) pour le 1)
		char **tableauLignes = malloc(sizeof(char *) * nbALire);
		char *ligne = malloc(sizeof(char) * tailleTampon);

		for (int j = 0; j < nbALire; j++)
		{
			tableauLignes[j] = malloc(sizeof(char) * tailleTampon);
		}

		int i = 0;
		while (nb < nbALire)
		{
			ligne = fgets(tableauLignes[nb] + (i * (tailleTampon - 1)), sizeof(char) * (tailleTampon), f);

			if (ligne[strlen(ligne) - 1] != '\n')
			{
				printf("La taille ligne n'est pas assez grande\n");
				printf("ligne if: %s\n", ligne);
				tableauLignes[nb] = realloc(tableauLignes[nb], sizeof(char) * tailleTampon * (i + 1) +1);
				i++;
			}

			else
			{
				printf("ligne else: %s\n", ligne);
				printf("ligne suivante\n");
				tableauLignes[nb][strlen(ligne) - 2 + (tailleTampon - 1) * i] = '\0';
				nb++;
				i = 0;
			}
		}

		for (int j = 0; j < nb; j++)
		{
			printf("T[%i] = %s\n", j, tableauLignes[j]);
			for (int a = 0; tableauLignes[j][a] != '\0'; a++)
			{
				printf("T[%i][%i] = %c\n", j, a, tableauLignes[j][a]);
			}
			free(tableauLignes[j]);
		}

		free(tableauLignes);
	}

	fclose(f);
}