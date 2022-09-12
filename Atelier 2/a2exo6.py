LISTE = [0, 3, 17, 4, 8, 0, 6, -4, -8, 7, 11, 0, 14, 0, -19]

def present(L, e) -> bool:
    if e in L:
        return True
    else:
        return False
    
def present1 (L, e) :
    for i in range (0, len(L), 1) :
        if (L[i] == e) :
            return(True)
    return (False) 

def present2 (L, e) :
    b=False
    for i in range (0, len(L), 1) :
        if (L[i] == e) :
            b=True
            return (b)
        else :
            b=False
    return (b)

def present3 (L, e) :
    b=True
    i=0
    while L[i] != e:
        return (i == e)
    

def present4 (L, e) :
    b=False
    i=0
    while (i<len(L)) :
        if (L[i] == e) :
            b=True
        i += 1
    return b

def test_present(present:callable):
    LISTE = [0, 3, 17, 4, 8, 0, 6, -4, -8, 7, 11, 0, 14, 0, -19]
    if present([], 4):
        print("ECHEC: test liste vide")
    else:
        print("SUCCES: test liste vide")
    if present(LISTE, 0):
        print("SUCCES: test liste debut")
    else:
        print("ECHEC: test liste debut")
    if present(LISTE, -4):
        print("SUCCES: test liste milieu")
    else:
        print("ECHEC: test liste milieu")
    if present(LISTE, -19):
        print("SUCCES: test liste fin")
    else:
        print("ECHEC: test liste fin")
    if present(LISTE, 10):
        print("ECHEC: test liste absent")
    else:
        print("SUCCES: test liste absent")
    print("#################################")

test_present(present)
test_present(present1)
test_present(present2)
test_present(present3)
test_present(present4)
