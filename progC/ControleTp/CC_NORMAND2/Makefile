all : ex1 ex2 ex3

ex1 : ex1.o carte.o
	gcc -o ex1 ex1.o carte.o

ex2 : ex2.o carte.o
	gcc -o ex2 ex2.o carte.o

ex3 : ex3.o carte.o pioche.o
	gcc -o ex3 ex3.o carte.o pioche.o

ex1.o : ex1.c carte.h
	gcc -Wall -c ex1.c

ex2.o : ex2.c carte.h
	gcc -Wall -c ex2.c

ex3.o : ex3.c carte.h pioche.h
	gcc -Wall -c ex3.c

carte.o : carte.c carte.h
	gcc -Wall -c carte.c

pioche.o : pioche.c pioche.h carte.h
	gcc -Wall -c pioche.c
	
clean : 
	rm *.o ex1 ex2 ex3
