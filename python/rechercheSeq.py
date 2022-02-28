def rechercheSeq(n,t):
    place = 0
    for i in range(len(t)):
        if t[i] == n:
            place = i+1
    return place
        
nb = int(input("nb : "))
tab = input("tableau : ")
tab = list(map(int,tab.split(" ")))

print(rechercheSeq(nb,tab))