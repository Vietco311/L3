from random import *

LIST = [1, 2, 7, 9, 6, 10, 13, 14, 'cuillère', 'fourchette', 'couteau']

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
    shuffle(list_to_mix)
    return list_to_mix
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




def test():
    print(gen_list_random_int(1, 12))
    print(mix_list(LIST))
    print(choose_element_list(LIST))
    print(extract_elements_list(LIST, 5))

test()