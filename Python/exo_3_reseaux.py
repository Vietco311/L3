
from typing import Tuple
import numpy as np

l = np.uintc(51)

print(bin(True)[2:] * 8)

def encoder_donnes(n1:int,n2:int,n3:int,b1:bool,b2:bool) -> str:
    string = ""
    tab = [n1, n2, n3, b1, b2]
    for e in tab:
        if len(string) <= 32:
            if isinstance(e, int):
                binaire = "0" * 9
                binaire = binaire.replace("0"*len(bin(e)[2:]), bin(e)[2:])
            else:
                binaire = bin(e)[2:]
            string += binaire
    return string


def extraire_entier(n: np.uintc, debut, fin, taille = 32):
    masque = (1 << (fin-debut+1)) - 1
    decalage = taille - (fin-debut+1) - debut
    extraction = (n & (masque << decalage)) >> decalage

    return extraction

def encoder_donnees2(a: np.uintc, b: np.uintc, c: np.uintc, bln1: bool, bln2: bool) -> np.uintc:
    return np.uintc((a << 23) + (b << 14) + (c << 5) + (bln1 << 4) + (bln2 << 3))

def decoder(n: np.uintc) -> Tuple:
    a = extraire_entier(n, 0, 8)

    b = extraire_entier(n, 9, 17)

    c = extraire_entier(n, 18, 26)

    bln1 = (bool)

print(encoder_donnees2(410,380,92,False,True), len(encoder_donnes(410,380,92,False,True)))