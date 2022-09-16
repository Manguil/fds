main : main.o calcul.o
	gcc build/main.o build/calcul.o -o build/main

main.o : main.c calcul.h
	gcc -Wall -c main.c -o build/main.o

calcul.o : calcul.c calcul.h
	gcc -Wall -c calcul.c -o build/calcul.o

.PHONY: clean

clean:
	rm -f build/*.o build/main