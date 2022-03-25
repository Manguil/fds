tp_c : build/tp_c.o build/parfait.o build/temps.o build/liste.o
	gcc build/tp_c.o build/parfait.o build/temps.o build/liste.o -o tp_c -lm

build/tp_c.o : tp_c.c parfait.h temps.h liste.h
	gcc -Wall -c tp_c.c -o build/tp_c.o

#pour compiler avec le module parfait

build/parfait.o : parfait.c parfait.h
	gcc -Wall -c parfait.c -o build/parfait.o

#pour compiler avec le module temps

build/temps.o : temps.c temps.h
	gcc -Wall -c temps.c -o build/temps.o

build/liste.o : liste.c liste.h
	gcc -Wall -c liste.c -o build/liste.o

.PHONY: clean

clean:
	rm -f *.o