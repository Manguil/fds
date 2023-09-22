tp_c : build/tp_c.o build/tp3.o build/tp4.o build/liste.o
	gcc build/tp_c.o build/tp3.o build/tp4.o build/liste.o -o tp_c -lm

build/tp_c.o : tp_c.c tp3.h tp4.h liste.h
	gcc -Wall -c tp_c.c -o build/tp_c.o

#pour compiler avec le module tp3
build/tp3.o : tp3.c tp3.h
	gcc -Wall -c tp3.c -o build/tp3.o

#pour compiler avec le module tp4
build/tp4.o : tp4.c tp4.h
	gcc -Wall -c tp4.c -o build/tp4.o

build/liste.o : liste.c liste.h
	gcc -Wall -c liste.c -o build/liste.o

.PHONY: clean

clean:
	rm -f build/*.o