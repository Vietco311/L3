ZONE_LIVRAISON = ['France', 'Monaco', 'Andorre', 'Armee']
COMPLEMENT_AERIEN1 = ['Guyane', 'Guadeloupe', 'Martinique', 'La Réunion', 'St Pierre et Miquelon', 'St Barthélémy', 'St-Martin et Mayotte']
COMPLEMENT_AERIEN2 = ['Nouvelle-Calédonie', 'Polynésie française', 'Wallis-et-Futuna', 'T.A.A.F']

#Dictionnaire de tarif en fonction du poids et du complément aérien pour les Outre-Mers.
LETTRE = {
    "verte":{
        20: 1.16,
        100: 2.32,
        250: 4.00,
        500: 6.00,
        1000: 7.50,
        3000: 10.00
    },

    "prioritaire":{
        20: 1.43,
        100: 2.83,
        250: 5.26,
        500: 7.89,
        3000: 11.44,
        
    },

    "eco-pli":{        
        20: 1.14,
        100: 2.28,
        250: 3.92,
        
    },
    "Outre-mer":{
        "OM1":{
            "verte/prio": 0.05,
            "eco-pli": 0.02
        },
        "OM2":{
            "verte/prio": 0.11,
            "eco-pli": 0.05
        }

    }
}


def tarif_net_colis(type_lettre:str, poids_colis:int):
    """Calcul le tarif net d'un colis

    Args:
        type_lettre (str): Quelle va être utilisée pour le calcul
        poids_colis (int): Le poids du colis pour le calcul

    Returns:
        float: Le tarif net
    """

    LISTE_TARIFS = list(LETTRE[type_lettre].values())
    LISTE_POIDS = list(LETTRE[type_lettre].keys())
    print(list(LETTRE[type_lettre].keys()), list(LETTRE[type_lettre].values()))
    i = 0
    if type_lettre == "verte":
        while poids_colis > LISTE_POIDS[i]:
            print(i)
            i += 1
    if type_lettre == "prioritaire":
        while poids_colis > LISTE_POIDS[i]:
            print(i)
            i += 1
    if type_lettre == "eco-pli":
        while poids_colis > LISTE_POIDS[i]:
            print(i)
            i += 1
    tarif = LISTE_TARIFS[i]
    print(tarif)
    return tarif


def complément_outre_mer(choix_livraison:str, poids_colis:int, type_lettre:str):
    """Ajoute au tarif total un complément aérien si la livraison est en Outre-mer

    Args:
        type_lettre (str): Quelle va être utilisée pour le calcul
        poids_colis (int): Le poids du colis pour le calcul
        tarif (float): tarif net sans complément
        choix_livraison (string): Lieu de livraison en Outre-mer

    Returns:
        float: Le tarif avec complément
    """

    complément = 0
    LISTE_TARIFS_OM1 = list(LETTRE["Outre-mer"]['OM1'].values())
    LISTE_TARIFS_OM2 = list(LETTRE["Outre-mer"]['OM1'].values())
    if choix_livraison in ZONE_LIVRAISON:
        return complément
    elif choix_livraison in COMPLEMENT_AERIEN1:        
        for i in range(100, poids_colis):
            if type_lettre == "verte" or type_lettre == "prioritaire":
                complément += LISTE_TARIFS_OM1[0]
            else:
                complément += LISTE_TARIFS_OM1[1]
            i += 1
    elif choix_livraison in COMPLEMENT_AERIEN2:        
        for i in range(100, poids_colis):
            if type_lettre == "verte" or type_lettre == "prioritaire":
                complément += LISTE_TARIFS_OM2[0]
            else:
                complément += LISTE_TARIFS_OM2[1]
            i += 1
    return complément

def calcul_tarif():

    """Calcul le tarif d'un colis en fonction de la destination, son poids et du type de la lettre
    """
    tarif = 0
    type_lettre = input("Quelle lettre voulez vous utiliser?")
    poids_colis = int(input("Poids du colis?"))
    tarif = tarif_net_colis(type_lettre, poids_colis)
    print(tarif, " tarif net")
    choix_livraison = input("Où voulez vous livrer?")
    tarif = tarif + complément_outre_mer(choix_livraison, poids_colis, type_lettre)
    print(tarif, " tarif supp")
    sticker_suivi = input("Un sticker de suivi? O/N" )
    if sticker_suivi == "O":
        tarif += 0.50             
    print(tarif)

  
calcul_tarif()

