from math import sqrt

def distance(A, B):
    return sqrt((A[0]-B[0])**2 + (A[1]-B[1])**2)

def aretes(P):
    n = len(P)
    arete = []*n
    for A in range(n):
        for B in range(A+1, n):
            print("P[A] - P[B]",P[A],P[B])
            arete[A] = (A , B , distance(P[A] , P[B]))
    return arete

A , B , C = (121 ,77) , (48 ,70) , (12 ,72)
print ( distance (A , B ) , distance (A ,C ) , distance (B , C ))

P = [(6 ,20) ,(67 ,18) ,(96 ,4) ,(32 ,45)]
print( aretes ( P ))
