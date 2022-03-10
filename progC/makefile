.PHONY: clean

clean:
	rm *.o

tp_c : tp_c.o parfait.o temps.o
	gcc tp_c.o parfait.o temps.o -o tp_c -lm
	clean

tp_c.o : tp_c.c parfait.h temps.h
	gcc -Wall -c tp_c.c

#pour compiler avec le module parfait

parfait.o : parfait.c parfait.h
	gcc -Wall -c parfait.c

#pour compiler avec le module temps

temps.o : temps.c temps.h
	gcc -Wall -c temps.c