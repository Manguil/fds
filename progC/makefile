#pour compiler avec le module parfait

tp_c : tp_c.o parfait.o temps.o
	gcc linux/tp_c.o linux/parfait.o linux/temps.o -o tp_c -lm

tp_c.o : tp_c.c parfait.h temps.h
	gcc -Wall -c tp_c.c linux/tp_c.o

parfait.o : parfait.c parfait.h
	gcc -Wall -c parfait.c linux/parfait.o

#-----------------------------------#
#pour compiler avec le module temps

temps.o : temps.c temps.h
	gcc -Wall -c temps.c linux/temps.o

.PHONY: clean

clean:
	rm -f *~ *.o tp_c temps
