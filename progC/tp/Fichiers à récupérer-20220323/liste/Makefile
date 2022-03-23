testListe : testListe.o liste.o
	gcc -o testListe liste.o testListe.o

liste.o : liste.c liste.h
	gcc -Wall -c liste.c

testListe.o : testListe.c liste.h
	gcc -Wall -c testListe.c

clean :
	rm *.o testListe
