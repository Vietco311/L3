from typing import Tuple
from xmlrpc.client import boolean
import numpy as np

l = np.uintc(51)

print(bin(True)[2:] * 8)

def encoder_donnes(n1:int,n2:int,n3:int,b1:bool,b2:bool) -> str:
    string = ""
    tab = [n1, n2, n3, b1, b2]
    for e in tab:
        if len(string) <= 32:
            binaire = bin(e)[2:]
            if e is bool:
                binaire *= 8
            string += binaire
    return string

#def decoder_entier(encoder_donnes: function) -> Tuple:
    

print(encoder_donnes(410,380,92,False,True), len(encoder_donnes(410,380,92,False,True)))