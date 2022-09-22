import random
from time import *
import matplotlib.pyplot as plt
import numpy as np

LIST_NUMBER = [170, 45, 75, 90, 2, 24, 802, 66]
LIST = [1, 2, 7, 9, 6, 10, 13, 14, 'cuillère', 'fourchette', 'couteau']
LIST_OCC = [i for i in range(0, 50000, 5000)]


def gen_list_random_int(int_binf:int, int_bsup:int) -> list:
    """generate a list of random number

    Args:
        int_binf (int): minimum value
        int_bsup (int): maximum value

    Returns:
        list: The said list
    """
    int_nbr = random.randint(int_binf, int_bsup)
    return int_nbr

def mix_list(list_to_mix:list) -> list:
    """Mix a list

    Args:
        list_to_mix (list): A list

    Returns:
        list: Mixed list
    """
    list_mixed = []
    copy = list_to_mix.copy()
    while list_to_mix != []:
        j = random.randint(0, len(list_to_mix)-1)
        list_mixed.append(list_to_mix[j])
        list_to_mix.remove(copy[j])
    return list_mixed


def choose_element_list(list:list):
    """Return a random element of a list

    Args:
        list_in_which_to_choose (list): The list
    """
    print(list)
    j = random.randint(0, len(LIST)-1)
    element = list[j]
    return element

def extract_elements_list(list:list, int_to_extract:int) -> list:
    """Take a random element of a list to put it into another

    Args:
        list (list): A list
        int_to_extract (int): The number of element to extract

    Returns:
        list: The outputed list
    """
    list = list_in_which_to_choose.copy()
    list_chosen = []
    for i in range(int_to_extract):
        element = choose_element_list(list)
        list_chosen.append(element)
        list.remove(element)
    return list_chosen

def sort_list(list:list) -> tuple:
    """Sort a list

    Args:
        list (list): List of random numbers

    Returns:
        tuple: sorted and initial list
    """
    copy = list.copy()
    sorted = []
    for i in range(len(list)):
        sorted.append(min(copy))
        copy.remove(min(copy))
    return sorted, list

def stupid_list(list:list) -> tuple:
    """Sort a list but stupidly(shuffle until sorted)

    Args:
        list (list): List of random numbers

    Returns:
        tuple: stupid and initial list
    """
    copy = list.copy()
    sorted_stup = []
    while sorted_stup != sorted(list):
        sorted_stup = extract_elements_list(copy, len(copy))
    return sorted_stup, list

def insert_list(list:list) -> tuple:
    """Sort a list by insertion

    Args:
        list (list): List of random numbers

    Returns:
        tuple: insert and initial list
    """
    copy = list.copy()
    for i in range(len(list)):
        x = list[i]
        j = i
        while j > 0 and copy[j-1] > x:
            copy[j] = copy[j-1]
            j = j-1
        copy[j] = x
    return copy, list

def select_list(list: list) -> tuple:
    """Sort by selection

    Args:
        list (list): List of random numbers

    Returns:
        tuple: selected and initial list
    """
    copy = list.copy()
    for i in range(0, len(list)):
        mini = i
        for j in range(i+1, len(list)):
            if copy[j] < copy[mini]:
                mini = j
        if mini != i:
            copy[mini], copy[i] = copy[i], copy[mini]

    return copy, list

def bubble_list(list: list) -> tuple:
    """Sort by according to bubble

    Args:
        list (list): List of random numbers

    Returns:
        tuple: bubbled and initial list
    """
    copy = list.copy()
    for i in range(len(list), 1, -1):
        tableau_trie = True
        for j in range(0, i-1):
            if copy[j+1] < copy[j]:
                copy[j+1], copy[j] = copy[j], copy[j+1]
                tableau_trie = False
        if tableau_trie:
            return copy, list

def fusion_list(list:list) -> tuple:
    """Merged two list

    Args:
        list (list): List of random numbers

    Returns:
        tuple: merged list
    """
    copy = list.copy()
    if len(list) <= 1:
        return list
    else:
        listA = copy[:len(list)//2]
        listB = copy[len(list)//2:]
        fusionne = fusion(fusion_list(listA), fusion_list(listB))
        return fusionne

def fusion(listA:list, listB:list)-> list:
    """Come with fusion_list, do the sorting by selecting from each list the smaller element

    Args:
        listA (list)
        listB (list)

    Returns:
        list: merged list
    """
    indexA = 0
    indexB = 0
    fusion = []
    while indexA < len(listA) and indexB < len(listB):
        if listA[indexA] < listB[indexB]:
            fusion.append(listA[indexA])
            indexA += 1
        else:
            fusion.append(listB[indexB])
            indexB += 1
    while indexA < len(listA):
        fusion.append(listA[indexA])
        indexA += 1
    while indexB < len(listB):
        fusion.append(listB[indexB])
        indexB += 1
    return fusion



def radix_order(list:list, order:int):
    """Sort a list by order range(unit, ten, hundred)

    Args:
        list (list): list to sort
        order (int): 1, 10, 100...etc

    Returns:
        _type_: list sorted with the current order
    """
    n = len(list)
    output = [0] * n
    count = [0] * 10
    #Divise par 10^x(0,1,2 etc) chaque élément de la liste
    for i in range(0, n):
        index = list[i] // order
        count[index % 10] += 1
    print(count, "toto")

    #Fait correspondre chaque élément de count à la position
    #des éléments dans la liste de sortie
    for i in range(1, 10):
        count[i] += count[i - 1]
    print(count, "titi")

    #Place les éléments de la liste à leur position configuré dans count
    i = n - 1
    while i >= 0:
        index = list[i] // order
        output[count[index % 10] - 1] = list[i]
        count[index % 10] -= 1
        i -= 1
    i = 0
    for i in range(0, len(list)):
        list[i] = output[i]
    print(output)
    return output

def radix_list(list:list) -> tuple:
    """Return the comparison of the list sorted and the initial list

    Args:
        list (list): list to mix 

    Returns:
        tuple: radix sorted and initial list
    """
    base = list.copy()
    max1 = max(list)
    order = 1
    while max1 / order >= 1:     
        base = radix_order(base, order)
        order *= 10
    return base, list
    


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

list_occ_ran = mix_list(LIST_OCC)

def perf_sort(sort_func:callable, taille:list, avg:int) -> list:
    start = perf_counter()
    for i in range(avg):
        sort_func(list_occ_ran)
    end = perf_counter()
    func_avg = (end - start)/avg
    return func_avg

def stock_valeur(perf_func:float, list:list) -> list:
    list_echant = []
    for j in range(0, 50000, 5000):
        print("JE SUIS LA", j)
        echant = perf_func
        list_echant.append(echant)
    print(list_echant)
    return list_echant
    

def sorted_bis(list:list) -> tuple:
    copy = list.copy()
    sorted(copy)
    return copy, list

def test():
    print(gen_list_random_int(1, 12))
    print(mix_list(LIST))
    print(choose_element_list(LIST))
    print(extract_elements_list(LIST, 5))
    print(sort_list(LIST_NUMBER))
    print(stupid_list(LIST_NUMBER), "STUPID")
    print(insert_list(LIST_NUMBER))
    print(select_list(LIST_NUMBER))
    print(bubble_list(LIST_NUMBER), "BUBBLE")
    print(fusion_list(LIST_NUMBER), "FUUUUUUUUUUUU...SION!!!")
    print(radix_list(LIST_NUMBER), "BASED")
    #print(perf(mix_list, shuffle, [i for i in range(10000)], 100))

test()

list_occ_ran = mix_list(LIST_OCC)

fig, ax = plt.subplots()
#Dessin des courbes, le premier paramètre
#correspond aux point d'abscisse le
#deuxième correspond aux points d'ordonnées
#le troisième paramètre, optionnel permet de
#choisir éventuellement la couleur et le marqueur
ax.plot(stock_valeur(perf_sort(sorted_bis, LIST_OCC, 100),100),LIST_OCC,'bo-',label='sorted')
ax.plot(stock_valeur(perf_sort(insert_list, LIST_OCC, 100),100),LIST_OCC, 'r*-', label='Machine')
ax.plot(stock_valeur(perf_sort(select_list, LIST_OCC, 100),100),LIST_OCC, 'r*-', label='Machine')
ax.plot(stock_valeur(perf_sort(bubble_list, LIST_OCC, 100),100),LIST_OCC, 'r*-', label='Machine')
ax.plot(stock_valeur(perf_sort(fusion_list, LIST_OCC, 100),100),LIST_OCC, 'r*-', label='Machine')
ax.plot(stock_valeur(perf_sort(radix_list, LIST_OCC, 100),100),LIST_OCC, 'r*-', label='Machine')
ax.set(xlabel='vitesse du programme', ylabel="Nombre d'élement", title='Comparaison de vitesse')
ax.legend(loc='upper center', shadow=True, fontsize='x-large')
#fig.savefig("test.png")
plt.show()