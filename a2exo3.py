LISTE = [0, 3, 17, 4, 8, 0, 6, -4, -8, 7, 11, 0, 14, 0, -19]

def separe(L) -> list:
    """Sépare les négatifs à gauche, les neutres au milieu et les positifs à droites

    Args:
        L (list): Liste d'entiers

    Returns:
        list: Liste avec les entiers séparés
    """
    LSEP = []
    L_nega = []
    L_posi = []
    L_zero = []
    for i in range(len(L)):
        if L[i] < 0:
            L_nega.insert(0, L[i])
        elif L[i] == 0:
            L_zero.insert(int(i/2), L[i])
        else:
            L_posi.append(L[i])
    LSEP.extend(L_nega)
    LSEP.extend(L_zero)
    LSEP.extend(L_posi)
    return LSEP

def test():
    print(separe(LISTE))

test()