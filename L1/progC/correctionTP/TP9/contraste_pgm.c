// contraste_pgm.c : Décale tous les niveaux de gris d'une image de la valeur alpha

#include <stdio.h>
#include "image.h"

int main(int argc, char* argv[])
{
  char cNomImgLue[250], cNomImgEcrite[250];
  int nH, nW, nTaille, alpha, valeur;
  
  if (argc != 4) 
     {
       printf("Usage: ImageIn.pgm ImageOut.pgm alpha\n"); 
       exit (1) ;
     }
   
   sscanf (argv[1],"%s",cNomImgLue) ;
   sscanf (argv[2],"%s",cNomImgEcrite);
   sscanf (argv[3],"%d",&alpha);


   OCTET *ImgIn, *ImgOut;
   
   lire_nb_lignes_colonnes_image_pgm(cNomImgLue, &nH, &nW);
   nTaille = nH * nW;
  
   allocation_tableau(ImgIn, OCTET, nTaille);
   lire_image_pgm(cNomImgLue, ImgIn, nH * nW);
   allocation_tableau(ImgOut, OCTET, nTaille);
	   
   for (int i=0; i < nH; i++)
		for (int j=0; j < nW; j++)
		{
			valeur = ImgIn[i*nW+j] + alpha;
			if (valeur < 0) valeur = 0;
			if (valeur > 255) valeur = 255;
			ImgOut[i*nW+j]=valeur; 
		}
		
   ecrire_image_pgm(cNomImgEcrite, ImgOut,  nH, nW);
   free(ImgIn); free(ImgOut);

   return 1;
}
