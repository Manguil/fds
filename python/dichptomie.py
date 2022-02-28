from pylab import *
from random import *

def affichCourbe(nb):
    plot(range(array(len(nb))),array(nb))
    show()

def dico(n,tableau):
    '''
    t trié
    '''
    if len(tableau) == 1:
        return 1
    m = len(tableau)//2
    if tableau[m] == n:
        return m + 1
    elif tableau[m] > n:
        return dico(n,tableau[:m])
    else:
        return m + dico(n,tableau[m:])

nb = int(input("nb : "))
tab = input("tableau : ")
tab = list(map(int,tab.split(" ")))

print(dico(nb,tab))

def bancEssai():
  data=[]
  for i in range(1,1001):
    liste=[randint(0,1000) for _ in range(i)]
    liste.sort() # dans le cas de la recherche dichotomique
    nb=dico(randint(0,1002),liste)
    data.append(nb)
  affichCourbe(data)

bancEssai()