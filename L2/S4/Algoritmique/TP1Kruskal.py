from math import sqrt
from random import random
from dessins import dessinPoints, dessinGraphe, dessinArbre


def Distance(A, B):
    return sqrt((A[0] - B[0]) ** 2 + (A[1] - B[1]) ** 2)


def Aretes(P):
    n = len(P)
    arete = [0] * ((n * (n - 1)) // 2)
    i = 0
    for A in range(n):
        for B in range(A + 1, n):
            arete[i] = (A, B, Distance(P[A], P[B]))
            i += 1
    return arete


def pointsAleatoires(n, xmax, ymax):
    return [(random() * xmax, random() * ymax) for i in range(n)]


def listesAdjacence(n, A):
    listeAdjacence = {}
    for i in range((n * (n - 1)) // 2):
        if i < len(A):
            if A[i][0] in listeAdjacence:
                listeAdjacence[A[i][0]].append(A[i][1])
            else:
                listeAdjacence[A[i][0]] = [A[i][1]]
            if A[i][1] in listeAdjacence:
                listeAdjacence[A[i][1]].append(A[i][0])
            else:
                listeAdjacence[A[i][1]] = [A[i][0]]
    return listeAdjacence


def arbreCouvrant(P):
    aretes = Aretes(P)
    aretes.sort(key=lambda x: x[2])
    t = []
    comp = {}
    for i in range(len(P)):
        comp[i] = i
    for i in range(len(aretes)):
        if comp[aretes[i][0]] != comp[aretes[i][1]]:
            t.append(aretes[i][0:2])
            for j in range(len(P)):
                if comp[j] == comp[aretes[i][0]]:
                    comp[j] = comp[aretes[i][1]]
    return t


"""
A , B , C = (121 ,77) , (48 ,70) , (12 ,72)
print ( Distance (A , B ) , Distance (A ,C ) , Distance (B , C ))

P = [(6 ,20) ,(67 ,18) ,(96 ,4) ,(32 ,45)]
print( aretes ( P ))

print ( pointsAleatoires (3 , 10 , 20))
"""
A = [(1 ,5) ,(5 ,6) ,(4 ,4)]
arbreA = arbreCouvrant(A)

dessinGraphe(A, listesAdjacence(len(A) , Aretes(A) ))

dessinArbre(A,listesAdjacence(len(A), arbreA),listesAdjacence(len(A), Aretes(A)))
