def parcoursProfondeur(L, n, racine):
    aTraiter = []
    x = 0
    t = 0
    sommet = 0
    dejaVu = [False]*n
    debut = [0]*n
    fin = [0]*n
    pere = [0]*n
    dejaVu[racine] = True
    debut[racine] = 1
    pere[racine] = None
    aTraiter.append(racine)
    t = 2
    while aTraiter != []:
        sommet = aTraiter[-1]
        if L[sommet] == []:
            aTraiter.pop()
            fin[sommet] = t
            t += 1
        else :
            x = L[sommet].pop()
            if not dejaVu[x] :
                dejaVu[x] = True
                aTraiter.append(x)
                debut[x] = t
                t += 1
                pere[x] = sommet
    return pere,debut,fin
#[[1,2],[4,3,5,2,0],[1,0],[4,1,5],[1,3],[3,1,6],[5]]

print(parcoursProfondeur([[1,2],[4,3,5,2,0],[1,0],[4,1,5],[1,3],[3,1,6],[5]], 7, 6))