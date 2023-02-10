spair.c : build/spair.o build/pair.o build/impair.o
	gcc build/spair.o build/pair.o build/impair.o -o build/spair

build/spair.o : spair.c pair.h impair.h
	gcc -Wall -c spair.c -o build/spair.o

#pour compiler avec le module pair
build/pair.o : pair.c pair.h
	gcc -Wall -c pair.c -o build/pair.o

#pour compiler avec le module impair
build/impair.o : impair.c impair.h
	gcc -Wall -c impair.c -o build/impair.o

.PHONY: clean

clean:
	rm -f build/*.o