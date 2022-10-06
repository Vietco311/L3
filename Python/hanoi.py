from gettext import npgettext


import numpy as np
TA = [5,4,3,2,1]
TB = []
TC = []
N = len(TA)

def Hanoi(N , TA, TB, TC, NomA, NomB, NomC):
    if N==1:
        TB.append(TA[-1])
        del TA[-1]
        print(f'Deplace {TB[-1]} de {NomA} vers {NomB}')
    else:
        Hanoi(N-1, TA, TC, TB, NomA, NomC, NomB)
        Hanoi(1, TA, TB, TB, NomA, NomB, NomC)
        Hanoi(N-1, TC, TB, TA, NomC, NomB, NomA)

Hanoi(N, TA, TB, TC, 'TA', 'TB', 'TC')