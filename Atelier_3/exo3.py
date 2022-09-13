import random
import re
from exo2 import dictionnaire

def places_lettre(ch:str, mot:str)-> list:
    """Return a list with the places of letters in a word

    Args:
        ch (str): character
        mot (str): word

    Returns:
        list
    """
    lst = []
    for i in range(len(mot)):
        if mot[i] == ch:
            lst.append(i)
    return lst

def outputStr(mot:str, lpos:list)-> str:
    """Return a string corresponding to the word with missing letters

    Args:
        mot (str): word
        lpos (list): Indexes of letters to show

    Returns:
        str: String to show
    """
    i = 0
    output = ""
    mot.strip("\[a-z]")
    for j in range(len(mot)):
        if j not in lpos:
            output += '_'
            i += 1
        elif re.match("[$&+,:;=?@#|'<>._^*()%!]", mot[j]):
            output -= mot[j]
        elif mot[j] == ' ':
            output += ' '
        elif mot[j] == '-':
            output += '-'
        elif mot[j] == "'":
            output += "'"
        else:
            output += mot[j]
    return output

def pendu():
    C1 = "|______\n"
    C2 = "|/ \ \n"
    C3 = "| T \n"
    C4 = "| O \n"
    C5 = "|---] \n" 
    pendu_list = [C1, C2, C3, C4, C5]
    return pendu_list


def build_dict(lst: list) -> dict:
    """Build a dictionnary with keys corresponding to the number of letters in a word

    Args:
        lst (list): Words list

    Returns:
        dict
    """
    dictionnaire_mots = {}
    
    for e in lst:
        keys = len(e)
        if keys not in dictionnaire_mots:
            dictionnaire_mots[keys] = [e]
        else:
            dictionnaire_mots[keys].append(e)
    return dictionnaire_mots

def select_word(sorted_words:dict, word_len:int)->str:
    """Select a random word with the selected lenght

    Args:
        sorted_words (dict): Dictionnary where we pick a word
        word_len (int): The lenght selected

    Returns:
        str: The random word picked
    """
    mot_aléa = random.choice(sorted_words[word_len])
    return mot_aléa

def runGame():
    C = ""
    mot = ''
    coup = 5
    index_lettre = []
    erreur = 0
    lvl = input('Difficulté?')
    if lvl == 'easy':
        mot_aléa = select_word(build_dict(dictionnaire("capitales_pays.txt")), random.randint(4, 6))
    elif lvl == 'normal':
        mot_aléa = select_word(build_dict(dictionnaire("capitales_pays.txt")), random.randint(7, 8))
    else:
        mot_aléa = select_word(build_dict(dictionnaire("capitales_pays.txt")), random.randint(8, 12))
    mot = outputStr(mot_aléa, []).lower()
    while erreur < 5 and '_' in mot:
        print("coup restant:", coup - erreur)
        print(mot)
        lettre = input('Votre lettre?')
        if places_lettre(lettre, mot_aléa) == []:
            erreur += 1
            C += pendu()[-erreur]
        else:
            index_lettre += places_lettre(lettre, mot_aléa)
        print(C)
        mot = outputStr(mot_aléa, index_lettre)
    if erreur < 5:
        resultat = "Gagné!"
    else:
        resultat = "Perdu!"
    print(resultat)
    print("Le mot était:", mot_aléa)
    return resultat

        

def test():
    print(places_lettre('b', "babouin"))
    print(outputStr("babouin", places_lettre('b', "babouin")))

runGame()
test()