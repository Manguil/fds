testVector : testVector.o vector.o
	gcc -o testVector vector.o testvector.o

vector.o : vector.c vector.h
	gcc -Wall -c vector.c

testVector.o : testVector.c vector.h
	gcc -Wall -c testVector.c

clean :
	rm *.o testVector
