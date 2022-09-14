from exo2 import mot_Nlettres
from exo3 import dictionnaire, build_dict
from collections import OrderedDict


def mot_correspond(mot, motif) -> bool:
    """Check if a word match its motif's jokers

    Args:
        mot (str): A word
        motif (str): A motif with random jokers

    Returns:
        bool
    """

    index = 0
    valide = True
    while valide == True and index < len(mot):
        if mot[index] == motif[index]:
            valide = True
        elif motif[index] == '.':
            valide = True
        else:
            valide = False
        index += 1
    return valide

def present(lettre, mot) -> int:
    """Check if a letter is present in a word

    Args:
        lettre (str): a letter
        mot (str): a word

    Returns:
        int: Index of the letter, -1 if not present
    """
    for i in range(len(mot)):
        if lettre == mot[i]:
            return i
    return -1

def mot_possible(mot, lettres) -> bool:
    """Check if a random choice of letters can make a word

    Args:
        mot (str): a word
        lettres (str): random letters

    Returns:
        bool
    """
    copy = ''
    valide = True
    for i in range(len(mot)):
        copy += '.'
    while valide and copy != mot:
        for e in lettres:
            if e in mot:
                index = present(e, mot)
                copy = copy[:index] + e + copy[index+1:]
            else:
                valide = False
    return copy == mot

def mot_optimaux(dico: list, lettres: str) -> list:
    """Return a list of optimal words(maximum lenght for the given letters)

    Args:
        dico (list): List of word
        lettres (str): Random choice of letters

    Returns:
        list: The chosen words in a list
    """
    dico_copy = dico.copy()
    max = len(lettres)
    lst = mot_Nlettres(dico_copy, max)
    lst_copy = lst.copy()
    for mot in lst:
        if mot_possible(mot, lettres) == False:
            lst_copy.remove(mot)
    if lst_copy == []:
        mot_optimaux(dico, lettres)
    else:
        possibilites = OrderedDict(sorted(build_dict(lst_copy)))
        print(possibilites)
        return possibilites

mot_optimaux(dictionnaire("littre.txt"), "lheaovc")
#print(mot_correspond('cheval', "ch..al"))            
                
        
            
