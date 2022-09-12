LISTE = [3, 17, 4, 6, 6]

def position1(L, e):
    """Indique l'index de e dans la liste L

    Args:
        L (list): liste d'élément
        e (int): nombre rentré

    Returns:
        int: Index de e
    """
    for i in range(len(L)):
        if e == L[i]:
            return i
    
def position2(L, e):
    """Indique l'index de e dans la liste L

    Args:
        L (list): liste d'élément
        e (int): nombre rentré

    Returns:
        int: Index de e
    """
    i = 0
    while i < len(L):
        if e == L[i]:
            return i
        i += 1

def nb_occurences(L, e) :
    """Compte le nombre de e dans la liste L

    Args:
        L (list): liste d'élément
        e (int): nombre rentré

    Returns:
        int: Index de e
    """
    occurence = 0
    for i in range(len(L)):
        if L[i] == e:
            occurence += 1
    return occurence

#Personnellement celle là car plus compact
def est_triee(L):
    """Vérifie si L est triee ou non

    Args:
        L (list): liste d'élément

    Returns:
        bool
    """
    triee = True
    for i in range(len(L)):
        if i != 0 and L[i] < L[i-1]:
            triee = False
    print(triee)
    return triee

def est_triee2(L):
    """Vérifie si L est triee ou non

    Args:
        L (list): liste d'élément

    Returns:
        bool
    """
    triee = True
    i = 0
    while triee and i < len(L):
        if i != 0 and L[i] < L[i-1]:
            triee = False
        i += 1
    return triee

def position_tri(L, e) -> int:
    """Indique l'index de e dans la liste L en cherchant par dichotomie

    Args:
        L (list): liste d'élément
        e (int): nombre rentré

    Returns:
        int: Index de e
    """
    debut_liste = 0
    fin_liste = len(L) - 1
    while debut_liste <= fin_liste:
        milieu = (debut_liste + fin_liste) // 2
        if L[milieu] == e:
            return milieu
        elif L[milieu] < e:
            debut_liste = milieu + 1
        else:
            fin_liste = milieu - 1
    return None
    
def a_repetition(L) -> bool:
    """Vérifie si un élément dans la liste l se répète

    Args:
        L (list): liste d'élément

    Returns:
        bool
    """
    i = 0
    t = []
    while i < len(L):
        if L[i] not in t:
            t.append(L[i])
            if i == len(L) - 1:
                return False
        else:
            return True
        i += 1
        

def test():
    print(position1(LISTE, 4))
    print(position2(LISTE, 4))
    print(nb_occurences(LISTE, 4))
    print(est_triee(sorted(LISTE)))
    print(est_triee(LISTE))
    print(position_tri(sorted(LISTE), 8))
    print(a_repetition(LISTE))



test()