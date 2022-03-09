#tps: temps.o temps.c
#pour compiler avec le module temps

tp_c : tp_c.o temps.o
	gcc tp_c.o temps.o -o tp_c

tp_c.o : tp_c.c temps.h
	gcc -Wall -c tp_c.c

temps.o : temps.c temps.h
	gcc -Wall -c temps.c

#-----------------------------------#
#pour compiler avec le module temps

tp_c : tp_c.o temps.o
	gcc tp_c.o temps.o -o tp_c

tp_c.o : tp_c.c temps.h
	gcc -Wall -c tp_c.c

temps.o : temps.c temps.h
	gcc -Wall -c temps.c

.PHONY: clean

clean:
	rm -f *~ *.o tp_c temps
