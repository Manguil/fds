main : main.o calcul.o
	gcc main.o calcul.o -o main
	clean

main.o : main.c calcul.h
	gcc -Wall -c main.c

calcul.o : calcul.c calcul.h
	gcc -Wall -c calcul.c

.PHONY: clean

clean:
	rm -f *.o