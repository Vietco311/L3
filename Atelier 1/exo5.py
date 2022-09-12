from math import *


def discriminant(a,b,c):
    """Calcule le discriminant d'un polynome ax²+bx+c=0

    Args:
        a (float): ax²
        b (float): bx
        c (float): constante

    Returns:
        float: Le discriminant, delta, permettant de trouver les solutions de l'équation
    """
    delta = b**2 - 4 * a * c
    return delta

#Calcul la racine unique d'un polynome
def racine_unique(a,b,delta):
    """Calcule la racine unique d'un polynôme ax²+bx+c=0 si delta est égal à 0

    Args:
        a (float): ax²
        b (float): bx

    Returns:
        float: La racine unique d'un polynôme ax²+bx+c=0
    """
    if delta != 0:
        return -b / 2 * a

#Calcul les racines doubles d'un polynome
def racine_double(a,b,delta,num):
    """Calcule les deux racines d'un polynôme ax²+bx+c=0 si delta est supérieur à 0

    Args:
        a (float): ax²
        b (float): bx
        delta (float): Le discriminant, delta, permettant de trouver les solutions de l'équation
        num (int): 1 ou 2, donne une des deux racines d'un polynôme ax²+bx+c=0

    Returns:
        float: solution d'un polynôme, x1 ou x2 en fonction de num.
    """
    if num == 1 and a != 0:
        return (-b + sqrt(delta)) / 2 * a
    elif num == 2 and a != 0:
        return (-b - sqrt(delta)) / 2 * a
    else:
        print("Retry!")
        racine_double()

def str_equation(a,b,c):
    """Retourne l'équation, en enlevant les parties non nécessaires

    Args:
        a (float): ax²
        b (float): bx
        c (float): constante

    Returns:
        string: L'équation sous forme ax²+bx+c=0
    """
    text = ""
    if a == 1:
        text = "x²"
    else:
        text = f"{a}x²"
    if b == 1:
        text = text + f"+x"
    elif b < 0:
        text = text + f"{b}"
    elif b == 0:
        text = text
    else: 
        text = text + f"+{b}x"
    if c < 0:
        text = text + f"{c}"
    elif c == 0:
        text = text
    else:
        text = text + f"+{c}"

    return text + "=0"

def solution_equation(a,b,c,delta):
    """Retourne l'équation avec ses racines, s'il y a.

    Args:
        a (float): ax²
        b (float): bx
        c (float): constante
        delta (float): Le discriminant, delta, permettant de trouver les solutions de l'équation

    Returns:
        string: Une chaine de caractère présentant les racines solutions de l'équation.
    """
    if 4*a*c > b**2:
        return f"Solution de l'équation {str_equation(a,b,c)}: \n Pas de racine réelle"
    elif 4*a*c == b**2:
        return f"Solution de l'équation {str_equation(a,b,c)} \n Racine unique : \n x={-b / 2 * a}"
    elif 4*a*c < b**2:
        return f"Solution de l'équation {str_equation(a,b,c)} \n Deux racines: \n x1={(-b + sqrt(delta)) / 2 * a} \n x2={(-b - sqrt(delta)) / 2 * a} "

#paramètre formel
def equation(a,b,c,delta):
    """Affiche en console l'équation avec ses racines, s'il y a.

    Args:
        a (float): ax²
        b (float): bx
        c (float): constante
        delta (float): Le discriminant, delta, permettant de trouver les solutions de l'équation
    """
    if 4*a*c > b**2:
        print(f"Solution de l'équation {str_equation(a,b,c)}: \n Pas de racine réelle")
    elif 4*a*c == b**2:
        print(f"Solution de l'équation {str_equation(a,b,c)}: \n x={-b / 2 * a}")
    elif 4*a*c < b**2:
        print(f"Solution de l'équation {str_equation(a,b,c)}: \n Deux racines: \n x1={(-b + sqrt(delta)) / 2 * a} \n x2={(-b - sqrt(delta)) / 2 * a} ")

def Main():
    equation(0,6,5,4) #paramètre effectif
    equation(0,3,7,65)
    equation(2,4,2,0)




Main()
