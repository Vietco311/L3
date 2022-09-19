from re import A


LST_MOT=["jouer","bonjour", "punir", "jour", "aurevoir", "revoir", "pouvoir", "cour", "abajour",
"finir", "aimer"]


def mot_Nlettres(lst_mot:list, n:int) -> list:
    """Check if a word contain the number of n letters in the list

    Args:
        lst_mot (list): list of words
        n (int): number of letters

    Returns:
        list: The list with the corresponding words.
    """
    lst = lst_mot.copy()
    for e in lst_mot:
        if len(e) > n:
            lst.remove(e)
    return lst

def commence_par(mot, prefixe):
    """Check if the start of a word is corresponding with prefixe

    Args:
        mot (str): the word
        prefixe (str): the prefixe

    Returns:
        bool
    """
    b = False
    i = 0
    for e in prefixe:
        if e == mot[i]:
            b = True
        else:
            b = False
        i += 1
    return b

def finit_par(mot:str, suffixe:str):
    """Check if the end of a word is corresponding with suffixe

    Args:
        mot (str): the word
        suffixe (str): the suffixe

    Returns:
        bool
    """
    b = False
    i = 1
    suffixe_inverse = suffixe[::-1]
    for e in suffixe_inverse:
        if e == mot[-i]:
            b = True
        else:
            b = False
        i += 1
    return b

def finissent_par(lst_mot, suffixe) -> list:
    """Check if the end of each word in the list correspond to the suffixe

    Args:
        lst_mot (list): words list
        suffixe (str): the suffixe

    Returns:
        list: List if only the wanted element
    """
    lst = []
    for mot in lst_mot:
        mot_coupé = mot[-len(suffixe):]
        print(mot_coupé)
        if suffixe == mot_coupé and mot not in lst:
            lst.append(mot)
    return lst

def commencent_par(lst_mot, prefixe) -> list:
    """Check if the start of each word in the list correspond to the prefixe

    Args:
        lst_mot (list): words list
        suffixe (str): the prefixe

    Returns:
        list: List if only the wanted element
    """
    lst = []
    for mot in lst_mot:
        mot_coupé = mot[:len(prefixe)]
        print(mot_coupé)
        if prefixe == mot_coupé and mot not in lst:
            lst.append(mot)
    return lst

def liste_mots(lst_mot, prefixe, suffixe, n) -> list:
    """Return a list of word corresponding with prefixe, suffixe and the number of letters n

    Args:
        lst_mot (list): words list
        prefixe (str)
        suffixe (str)
        n (int): Number of letter

    Returns:
        list: List if only the wanted element
    """
    is_valid = commencent_par(lst_mot, prefixe)
    is_valid = finissent_par(is_valid, suffixe)
    is_valid = mot_Nlettres(is_valid, n)

    return is_valid

def dictionnaire(fichier):
    lst = []
    f=open(fichier, encoding="utf-8")
    c=f.readline()
    while c !="":
        c=f.readline()
        lst.append(c.strip("\n"))
    return lst


def test():
    print(mot_Nlettres(LST_MOT, 5))
    print(mot_Nlettres([], 5))
    if commence_par("Batman", "Bat"):
        print("SUCCES")
    else:
        print("ECHEC")
    if finit_par("Batman", "man"):
        print("SUCCES")
    else:
        print("ECHEC")
    print(finissent_par(LST_MOT, "voir"))
    print(finissent_par([], "oir"))
    print(commencent_par(LST_MOT,"bon"))
    print(commencent_par([],"bon"))
    print(liste_mots(LST_MOT, "au", "oir", 8))
    print(dictionnaire("littre.txt"))

#test()