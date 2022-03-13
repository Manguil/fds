import time
from math import *
from random import *

from pylab import legend,show,plot,array

NB=0

def pere(i):
  return (i-1)//2

def gauche(i):
  return 2*i+1

def droite(i):
  return 2*i+2

def verifierProprieteDeTas(t,n):
  for i in range(1,n):
    if t[pere(i)]<t[i]:
      return False
  return True

def entasser(t,n,i):
  global NB
  NB+=1
  g=gauche(i)
  d=droite(i)
  if g<n and t[g]>t[i]:
    mmax=g
  else:
    mmax=i
  if d<n and t[d]>t[mmax]:
    mmax=d
  if i!=mmax:
    t[i],t[mmax]=t[mmax],t[i]
    entasser(t,n,mmax)

def construireTas(t,n):
  for i in range(int(n/2)-1,-1,-1):
    entasser(t,n,i)

#l=[randrange(30) for i in range(10)]
#shuffle(l)
#construireTas(l,len(l))
#print(l)
#print("verifie la propriete de tas ?",verifierProprieteDeTas(l,len(l)))
#l1=[6, 28, 22, 24, 18, 0, 21, 22, 4, 17]
#entasser(l1,len(l1),0)
#print(l1)
#print("verifie la propriete de tas ?",verifierProprieteDeTas(l1,len(l1)))

def afficherCourbe(maListeDeValeurs,name):
    plot(array(range(len(maListeDeValeurs))),array(maListeDeValeurs),label=name)

def bancEssai():
  global NB
  data=[]
  for i in range(1,1001):
    NB=0
    liste=[randint(0,1000) for _ in range(i)]
    construireTas(liste,len(liste))
    data.append(NB)
  afficherCourbe(data,"construireTas : Nb itérations en fonction de la taille du tableau")  
  legend(loc='upper right')
  show()

#bancEssai()

def tempsMoyen(fonction,l,n,nbRepetitions=20):
  somme=0
  for k in range(nbRepetitions):
    shuffle(l)
    start=time.time()
    fonction(l,n)
    end=time.time()
    somme+=(end-start)
  return somme/nbRepetitions

def bancEssaiPrime():
  data=[]
  for i in range(1,1001):
    liste=[i for i in range(i)]
    temps=tempsMoyen(construireTas,liste,len(liste))
    data.append(temps)
  afficherCourbe(data,"construireTas : temps realise en fonction de la taille du tableau")  
  legend(loc='upper right')
  show()

#bancEssaiPrime()

def trierParTas(t,n):
  construireTas(t,n)
  for i in range(n-1,0,-1):
    t[0],t[i]=t[i],t[0]
    entasser(t,i,0)

#l=[i for i in range(1,1001)]
#shuffle(l)
#trierParTas(l,len(l))
#print(l)

def bancEssai2():
  global NB
  data=[]
  for i in range(1,1001):
    NB=0
    liste=[i for i in range(i)]
    shuffle(liste)
    trierParTas(liste,len(liste))
    data.append(NB)
  afficherCourbe(data,"trierParTas : Nb itérations en fonction de la taille du tableau")
  v=[i*log(i)/log(2) for i in range(1,1001)]
  afficherCourbe(v,'n log n')
  legend(loc='upper right')
  show()

#bancEssai2()

def bancEssai2Prime():
  data=[]
  for i in range(1,1001):
    liste=[k for k in range(i)]
    temps=tempsMoyen(trierParTas,liste,len(liste))
    data.append(temps)
  afficherCourbe(data,"trierParTas : temps en fonction de la taille du tableau")
  legend(loc='upper right')
  show()