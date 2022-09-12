LOBJETS = [1,2,2,3,4,5,5,6,7,8,8,9,10,10,11]

def config_vitrine(nbEmplacements: int, LObjets:list) -> list:
    """Renvoie une liste comportant 2 listes(vitrines) de nombres uniques dans elle même

    Args:
        nbEmplacements (int): Nombre d'emplacements maximum par vitrine
        LObjets (list): La liste d'objet à mettre dans les vitrines

    Returns:
        list: Les deux vitrines, dans une liste plus grande.
    """
    vitrine_1 = []
    vitrine_2 = []
    couple_vitr = []
    objet_unique = []
    for e in LObjets:
        if e not in objet_unique:
            objet_unique.append(e)
    if nbEmplacements > len(objet_unique)//2:
        for a in LObjets:        
            if a not in vitrine_1 and len(vitrine_1)+1 <= nbEmplacements:
                vitrine_1.append(a)
            elif a not in vitrine_2 and len(vitrine_2)+1 <= nbEmplacements:
                vitrine_2.append(a)
    else:
        return None
    couple_vitr.append(vitrine_1)
    couple_vitr.append(vitrine_2)
    return couple_vitr
    
def test_5():
    print(config_vitrine(6, LOBJETS))

test_5()