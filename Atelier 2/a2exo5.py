LOBJETS = [0,2,2,3,5,4,5,0]

def RemoveIthOcc(lst, occ, N):
    newList = []
    count = 0
    for i in lst:
        if(i == occ):
            count = count + 1
            if(count != N):
                newList.append(i)
        else:
            newList.append(i)
             
    lst = newList
     
    if count == 0:
        print("Item not found")
    else:
        print("Updated list is: ", lst)   
     
    return newList

def config_vitrine(nbEmplacements: int, LObjets:list) -> tuple:
    """Renvoie une liste comportant 2 listes(vitrines) de nombres uniques dans elle même

    Args:
        nbEmplacements (int): Nombre d'emplacements maximum par vitrine
        LObjets (list): La liste d'objet à mettre dans les vitrines

    Returns:
        tuple: Les deux vitrines, dans une liste plus grande.
    """
    vitrine_1 = []
    vitrine_2 = []
    couple_vitr = []
    objet_unique = []
    vitrine_1_full = False
    vitrine_2_full = False

    #On parcourt LObjets afin de compter le nombre d'objet unique

    for e in LObjets:
        if e not in objet_unique:
            objet_unique.append(e)

    #Ensuite on regarde si tous les objets peuvent être mis en vitrine en moins une fois        
    if nbEmplacements > len(objet_unique)//2:
        sorted_LObjets = sorted(LObjets)
        copy = LObjets.copy()

        #On répète le processus suivant tant que les vitrines ne sont pas pleines
        while vitrine_1_full != True and vitrine_2_full != True:
            for a in sorted_LObjets:  

                #On supprime les triples occurrences pour chaque élément
                copy = RemoveIthOcc(copy, a, 3)

                #On vide la copie quand on entre un élément dans une vitrine à condition qu'il ne soit pas en double et que la vitrine ait encore de l'espace      
                if a not in vitrine_1 and vitrine_1_full != True:
                    vitrine_1.append(a)
                    copy.remove(a)
                else:
                    vitrine_2.append(a)
                    copy.remove(a)


                #On regarde à chaque élément rentré si une vitrine est pleine
                if len(vitrine_1) == nbEmplacements:
                    vitrine_1_full = True
                if len(vitrine_2) == nbEmplacements:
                    vitrine_2_full = True

                #Ou si la copie est vide, alors on assume que les 2 vitrines sont remplies    
                if copy == []:
                    vitrine_1_full = True
                    vitrine_2_full = True

                #Enfin on regarde si l'élément actuel est plus petit que le plus petit élément de la vitrine 1 ou l'inverse
                # Comme la liste parcouru est rangé par ordre croissant, les conditions coincides
                # On vérifie avant que la copie ne possède qu'un seul élément et qu'il s'agit d'un élément qui n'a pas pu être placé de manière conventionelle    
                if copy == [a]:
                    if min(vitrine_1) > a:
                        vitrine_2.remove(a)
                        vitrine_2.append(min(vitrine_1))
                        vitrine_1.remove(min(vitrine_1))
                        vitrine_1.append(a)
                    elif max(vitrine_1) < a:
                        vitrine_2.remove(a)
                        vitrine_2.append(max(vitrine_1))
                        vitrine_1.remove(max(vitrine_1))
                        vitrine_1.append(a)

                        
    #On ne retourne rien si les emplacements sont insuffisant pour contenir tous les objets aux moins une fois
    else:       
        print('Emplacement insuffisant')
    couple_vitr = (vitrine_1, vitrine_2)
    return couple_vitr
    
def test_5():
    print(config_vitrine(4, LOBJETS))

test_5()