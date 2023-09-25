exo13/spair.c : build/spair.o build/pair.o build/impair.o
	gcc build/spair.o build/pair.o build/impair.o -o build/spair

build/spair.o : exo13/spair.c exo13/pair.h exo13/impair.h
	gcc -Wall -c exo13/spair.c -o build/spair.o

#pour compiler avec le module pair
build/pair.o : exo13/pair.c exo13/pair.h
	gcc -Wall -c exo13/pair.c -o build/pair.o

#pour compiler avec le module impair
build/impair.o : exo13/impair.c exo13/impair.h
	gcc -Wall -c exo13/impair.c -o build/impair.o

.PHONY: clean

clean:
	rm -f build/*.o