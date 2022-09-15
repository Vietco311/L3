from ast import operator


def ouvrante(car: str) -> bool:
    """Return True if car is a (, a [, or a {

    Args:
        car (str)

    Returns:
        bool
    """
    return car == '(' or car =='[' or car == '{'

def fermante(car: str) -> bool:
    """Return True if car is a ), a ], or a }

    Args:
        car (str)

    Returns:
        bool
    """
    return car == ')' or car ==']' or car == '}'

def renverse(car: str) -> str:
    """Return 

    Args:
        car (str): _description_

    Returns:
        str: _description_
    """
    match car:
        case ')':
            car = '('
        case ']':
            car = '['
        case '}':
            car = '{'
        case _:
            car = car
    return car


def operateur(car: str) -> bool:
    """Return True if car is operator

    Args:
        car (str)

    Returns:
        bool
    """
    return car == '+' or car == '-' or car == '*' or car == '/'

def nombre(car: str) -> bool:  
    """Return True if car is numeric

    Args:
        car (str)

    Returns:
        bool
    """  
    return car.isdigit()
def caractere_valide(car: str) -> bool:
    """Return True if car is a valid in a arithmetic expression

    Args:
        car (str)

    Returns:
        bool
    """
    return ouvrante(car) or fermante(car) or nombre(car) or operateur(car)

def verif_parenthese(expression: str) -> bool:
    """Check if an arithmetic expression is correct(syntax)

    Args:
        expression (str)

    Returns:
        bool
    """
    i = 0
    pile = []
    for e in expression:
        if caractere_valide(e):
            if ouvrante(e):
                pile.append(e)
            elif fermante(e) and (pile[-1] == ']' or pile[-1] == ')' or pile[-1] == '}'):
                pile.pop(-1)
            else:
                pile.append(e)
    valide = True
    while i < len(pile) and valide == True:
        if caractere_valide(pile[i]) == False:
            valide = False
        i += 1
    print(pile)
    return valide


def test():
    print(ouvrante('('))
    print(ouvrante('['))
    print(ouvrante('{'))
    print(ouvrante(')'))
    print(fermante(')'))
    print(fermante(']'))
    print(fermante('}'))
    print(fermante('('))
    print(renverse(')'))
    print(renverse(']'))
    print(renverse('}'))
    print(renverse('a'))
    print(operateur('+'))
    print(operateur('/'))
    print(operateur('-'))
    print(operateur('*'))
    print(operateur('a'))
    print(nombre('6'))
    print(caractere_valide('('))
    print(verif_parenthese('()3+1)*12'))

test()