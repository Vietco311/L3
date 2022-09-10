import statistics


LISTE = [3, 17, 4, 8, 6]
LISTE_CROI = [1, 3, 6, 8]

#somme2 semble plus adapté

def somme1(L):
    somme = 0
    for i in range(len(L)):
        somme += L[i]
    print(somme)
    return somme


def somme2(L):
    somme = 0
    for e in L:
        somme += e
    print(somme)
    return somme

#crash si vide avec i <= lent(L)
def somme3(L):
    somme = 0
    i = 0
    while i < len(L):
        somme += L[i]
        i += 1 
    print(somme)
    return(somme)

def moyenne(L):
    i = 0
    moy = 0
    if len(L) > 0:
        while i < len(L):
            moy += L[i]
            i += 1
        moy /= len(L)
        return moy
    else:
        return 0

def nb_sup1(L, e):
    nombre = 0
    for i in range(len(L)):
        if L[i] > e:
            nombre += 1
    return nombre

def moy_sup(L, e):
    i = 0
    moy = 0
    i2 = 0
    if len(L) > 0:
        while i < len(L):
            if L[i] > e:
                moy += L[i]
                i2 += 1
            i += 1
        moy /= i2
        return moy
    else:
        return 0

def nb_sup2(L, e):
    nombre = 0
    for a in L:
        if a > e:
            nombre += 1
    return nombre

def val_max(L):
    max = 0
    for i in range(len(L)):
        if max < L[i]:
            max = L[i]
    return max

def ind_max(L):
    max = 0
    for i in range(len(L)):
        if max < L[i]:
            max = i
    return max



def test_exercice1 ():
    print("TEST SOMME")
    #test liste vide
    print("Test liste vide : ", somme2([]))
    print("Test liste vide : ", somme3([]))
    print("Test liste vide : ", somme1([]))
    #test somme 11111
    S=[1,10,100, 1000,10000]
    print("Test somme 11111 : ", somme2(S))
    print("Test somme 11111 : ", somme3(S))
    print("Test somme 11111 : ", somme1(S))
    print("TEST MOYENNE")
    #test liste vide
    print("Test liste vide : ", moyenne([]))
    #test liste de somme, produit, quotient
    print("Test liste de somme, produit, quotient: ", moyenne([3+4, 2*9, 9/3]))
    print("TEST NB_SUP")
    #test liste vide
    print("Test liste vide: ", nb_sup1([], 4))
    print("Test liste vide: ", nb_sup2([], 4))
    #test liste opération aléatoire
    print("Test liste remplie: ", nb_sup1([-6, 9, 5**2, 6*3/9], -4))
    print("Test liste remplie: ", nb_sup2([-6, 9, 5**2, 6*3/9], -4))
    print("TEST MOYENNE SUP")
    #test liste vide
    print("Test liste vide: ", moy_sup([], 4))
    #test liste opération aléatoire
    print("Test liste remplie: ", moy_sup([-6, 9, 5**2, 6*3/9], -4))
    print("TEST VALEUR MAX")
    #test liste vide
    print("Test liste vide: ", val_max([]))
    #test liste opération aléatoire
    print("Test liste remplie: ", val_max([-6, 9, 5**2, 6*3/9]))
    print("TEST INDEX MAX")
    #test liste vide
    print("Test liste vide: ", ind_max([]))
    #test liste opération aléatoire
    print("Test liste remplie: ", ind_max([-6, 9, 5**2, 6*3/9]))
    


#test_exercice1()