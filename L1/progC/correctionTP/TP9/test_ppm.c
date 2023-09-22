// test_pgm.c : Lit une image en couleur (pgm binaire P6)
// 				Recopie cette image dans une seconde 
//				Ecrit cette seconde image dans un nouveau fichier 

#include <stdio.h>
#include "image.h"

int main(int argc, char* argv[])
{
  char cNomImgLue[250], cNomImgEcrite[250];
  int nH, nW, nTaille;
  
  if (argc != 3) 
     {
       printf("Usage: ImageIn.ppm ImageOut.ppm\n"); 
       exit (1) ;
     }
   
   sscanf (argv[1],"%s",cNomImgLue) ;
   sscanf (argv[2],"%s",cNomImgEcrite);

   OCTET *ImgIn, *ImgOut;
   
   lire_nb_lignes_colonnes_image_ppm(cNomImgLue, &nH, &nW);
   nTaille = nH * nW;
  
   int nTaille3 = nTaille * 3;
   allocation_tableau(ImgIn, OCTET, nTaille3);
   lire_image_ppm(cNomImgLue, ImgIn, nH * nW);
   allocation_tableau(ImgOut, OCTET, nTaille3);
	
   for (int i=0; i < nTaille3; i+=3)
     {
		ImgOut[i]=ImgIn[i]; // composante rouge
       	ImgOut[i+1]=ImgIn[i+1]; // composante verte
       	ImgOut[i+2]=ImgIn[i+2]; // composante bleue
     }

   ecrire_image_ppm(cNomImgEcrite, ImgOut,  nH, nW);
   free(ImgIn); free(ImgOut);
   return 1;
}
