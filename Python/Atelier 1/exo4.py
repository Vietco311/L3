from datetime import *
from time import strptime

def est_bissectile(year):
    if (year%100 == 0 and year%400 == 0 and year%4 == 0):
        return True
    
    elif (year%100 != 0 and year%400 != 0):
        return True
    else:
        return False

def date_est_valide(jour:int, mois:int, année:int):
    if jour < 9:
        if datetime.strptime(f"{année}-{mois}-0{jour}", "%Y-%m-%d") < datetime.now():
            print("Bon")
        else:
            print("pas bon")
    elif mois < 9:
        if datetime.strptime(f"{année}-0{mois}-{jour}", "%Y-%m-%d") < datetime.now():
            print("Bon")
        else:
            print("pas bon")
    elif mois < 9 and jour < 9:
        if datetime.strptime(f"{année}-0{mois}-0{jour}", "%Y-%m-%d") < datetime.now():
            print("Bon")
        else:
            print("pas bon")    
    else:
        if datetime.strptime(f"{année}-{mois}-{jour}", "%Y-%m-%d") < datetime.now():
            print("Bon")
        else:
            print("pas bon")

def saisie_date_naissance():
    date_naissance = input("Rentrez votre dâte de naissance(Ex: jj/mm/aaaa):")
    
    return datetime.strptime(date_naissance, "%d/%m/%Y")

def Age(date_naissance):
    today = date.today()
    age = today.year - date_naissance.year - ((today.month, today.day) < (date_naissance.month, date_naissance.day))
    print(age, "ans")
    return age

def est_majeur(age):
    majeur = age >= 18
    return age, majeur
       
def test_acces():
    [age, majeur] = est_majeur(Age(saisie_date_naissance()))
    if majeur:
        print(f"Bonjour, vous avez {age} ans, Accès autorisé")
    else:
        print(f"Bonjour, vous avez {age} ans, Accès interdit")


def bissectileTest():
    print(est_bissectile(6))
    print(est_bissectile(1900))
    print(est_bissectile(2000))

bissectileTest()
date_est_valide(30,3,2002)
test_acces()