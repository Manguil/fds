fibomain4 : fibomain3.o fibo3.o
	gcc fibomain3.o fibo4.o -o fibomain3

fibomain4.o : fibomain3.c fibo3.h
	gcc -Wall -c fibomain3.c

fibo4.o : fibo3.c fibo3.h
	gcc -Wall -c fibo3.c

.PHONY: clean

clean:
	rm -f *.o