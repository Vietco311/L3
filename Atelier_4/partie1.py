from random import *
from time import *
import matplotlib.pyplot as plt
import numpy as np

LIST = [1, 2, 7, 9, 6, 10, 13, 14, 'cuillère', 'fourchette', 'couteau']
LIST_OCC = [i for i in range(0, 100000, 5000)]

def gen_list_random_int(int_binf:int, int_bsup:int) -> list:
    """generate a list of random number

    Args:
        int_binf (int): minimum value
        int_bsup (int): maximum value

    Returns:
        list: The said list
    """
    int_nbr = randint(int_binf, int_bsup)
    return int_nbr

def mix_list(list_to_mix:list) -> list:
    """Mix a list

    Args:
        list_to_mix (list): A list

    Returns:
        list: Mixed list
    """
    list_mixed = []
    for i in range(len(list_to_mix)):
        i = randint(0, len(list_to_mix))
        list_mixed.append(i)
    return list_mixed
def choose_element_list(list_in_which_to_choose:list):
    """Return a random element of a list

    Args:
        list_in_which_to_choose (list): The list
    """
    element = choice(list_in_which_to_choose)
    return element

def extract_elements_list(list_in_which_to_choose:list, int_to_extract:int) -> list:
    """Take a number of element of a list to put it into another

    Args:
        list_in_which_to_choose (list): A list
        int_to_extract (int): The number of element to extract

    Returns:
        list: The outputed list
    """
    list = list_in_which_to_choose.copy()
    list_chosen = []
    for i in range(int_to_extract):
        element = choice(list)
        list_chosen.append(element)
        list.remove(element)
    return list_chosen

def sort_list(list:list) -> tuple:
    copy = list.copy()
    sorted = []
    for i in range(len(list)):
        sorted += min(copy)
        copy.remove(min(copy))
    return sorted, list


def perf(fait_main: callable, prog:callable, taille:list, avg:int) -> tuple:
    start = perf_counter()
    for i in range(avg):
        fait_main(taille)
    end = perf_counter()
    fait_main_avg = (end - start)/avg
    start = perf_counter()
    for i in range(avg):
        prog(taille)
    end = perf_counter()
    prog_avg = (end - start)/avg
    comparaison = (fait_main_avg, prog_avg)

    return comparaison


def stock_valeur(perf_func:callable, avg:int) -> dict:
    list_echant = {}
    for h in range(2):
        list_echant[h] = []
        for j in range(0, 100000, 5000):
            print("JE SUIS LA", j)
            echant = perf_func(mix_list, shuffle, [i for i in range(j)], avg)[h]
            list_echant[h].append(echant)
    print(list_echant)
    return list_echant
    
fig, ax = plt.subplots()
#Dessin des courbes, le premier paramètre
#correspond aux point d'abscisse le
#deuxième correspond aux points d'ordonnées
#le troisième paramètre, optionnel permet de
#choisir éventuellement la couleur et le marqueur
ax.plot(stock_valeur(perf,100)[0],LIST_OCC,'bo-',label='Fait main')
ax.plot(stock_valeur(perf,100)[1],LIST_OCC, 'r*-', label='Machine')
ax.set(xlabel='vitesse du programme', ylabel="Nombre d'élement", title='Comparaison de vitesse')
ax.legend(loc='upper center', shadow=True, fontsize='x-large')
#fig.savefig("test.png")
plt.show()



def test():
    print(gen_list_random_int(1, 12))
    print(mix_list(LIST))
    print(choose_element_list(LIST))
    print(extract_elements_list(LIST, 5))
    print(perf(mix_list, shuffle, [i for i in range(10000)], 100))

#test()