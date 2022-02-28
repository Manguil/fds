from pylab import *
from math import floor
from random import randint

nb_it = 0
liste_nbit = []
tas = [12, 8, 5, 6, 1, 4, 3, 2, 0]
li = [4,5,9,2,7]

def fils_gauche(i):
        return 2*i+1

def fils_droit(i):
        return 2*i+2

def pere(i):
    if i==0:
        return 0
    else :
        return floor((i-1)/2)

def est_tas(li):
    if li==[]:
        return False
    elif len(li)==1:
        return True
    else :
        for i in range(len(li)-1):
            if fils_gauche(i) < len(li):
                if li[i]<li[fils_gauche(i)]:
                    return False
            if fils_droit(i) < len(li):
                if li[i]<li[fils_droit(i)]:
                    return False
    return True

def entasser(tas,n,i):
    g = fils_gauche(i)
    d = fils_droit(i)
    if g<n and tas[g]>tas[i]:
        max = g
    else :
        max = i
    if d<n and tas[d]>tas[max]:
        max = d
    if i != max:
        tmp = tas[i]
        tas[i] = tas[max]
        tas[max] = tmp
        entasser(tas,n,max)
    n += 1
    return tas

def construire_tas(li,n):
    global nb_it
    global liste_nbit
    for i in range(floor(n/2)-1,-1,-1):
        entasser(li,n,i)
        liste_nbit.append(nb_it)
        nb_it=0
    return li

def li_random(nb):
    li = []
    for i in range(nb):
        li.append(randint(0,10))
    return li,len(li)


def triParTas(li,n):
    li = construire_tas(li, n)
    for i in range(n-1,-1,-1):
        temp = li[i]
        li[i] = li[0]
        li[0] = temp
        entasser(li, i, 0)
    return li


def afficherCourbe(name):
    global liste_nbit
    for i in range(5):
        li,taille = li_random(i)
        construire_tas(li, taille)
    plot(array(range(len(liste_nbit))),array(liste_nbit),label=name)
    legend(loc='upper right')
    show()

if __name__ == "__main__":
    #afficherCourbe("nb iteration")
    print(triParTas(li, len(li)))