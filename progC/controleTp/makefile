main : main.o calcul.o
	gcc build/main.o build/calcul.o -o main

main.o : main.c calcul.h
	gcc -Wall -c main.c /build

calcul.o : calcul.c calcul.h
	gcc -Wall -c calcul.c /build

.PHONY: clean

clean:
	rm -f buil/*.o