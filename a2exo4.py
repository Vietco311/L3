from a2exo1 import val_max


LISTE = [0, 3, 17, 4, 8, 1, 33, 22, 0]
LISTE2 = [0,1,2,3,4]


def histo(F) -> list:
    """Crée un histogrammede la liste F

    Args:
        F (list): Liste d'entiers

    Returns:
        list: L'histogramme
    """
    H = []
    for i in range(min(F), max(F)+1):
        H.append(0)
    for a in range(len(H)):
        for j in range(len(F)):
            if F[j] == a:
                H[a] += 1
    return H
    
def est_injective(F) -> bool:
    """Indique si f:F --> H est injective ou non

    Args:
        F (list): liste d'entiers

    Returns:
        bool
    """
    H = histo(F)
    for i in H:
        if i > 1:
            return False
    return True


def est_surjective(F) -> bool:
    """Indique si f:F --> H est surjective ou non

    Args:
        F (list): liste d'entiers

    Returns:
        bool
    """
    H = histo(F)
    for i in H:
        if i == 0:
            return False
    return True


def est_bijective(F) -> bool:
    """Indique si f:F --> H est bijective ou non

    Args:
        F (list): liste d'entiers

    Returns:
        bool
    """
    if est_injective(F) == True and est_surjective(F) == True:
        return True
    else:
        return False

def affiche_histo(F):
    """Affiche dans la console l'histogramme de la liste F

    Args:
        F (list): Liste d'entiers
    """
    H = histo(F)
    MAXOCC = val_max(H)
    for i in range(MAXOCC, -1, -1):
        for j in range(0, len(H), 1):
            if H[j] > i:
                print(" # |", end='')
            else:
                print("   |", end='')
        print("\n")
    plt.style.use('_mpl-gallery')

# make data
np.random.seed(1)
x = 4 + np.random.normal(0, 1.5, 200)

# plot:
fig, ax = plt.subplots()

ax.hist(x, bins=8, linewidth=0.5, edgecolor="white")

ax.set(xlim=(0, 8), xticks=np.arange(1, 8),
       ylim=(0, 56), yticks=np.linspace(0, 56, 9))

plt.show()

def test_exo4():
    print(histo(LISTE2))
    print(est_injective(LISTE2))
    print(est_surjective(LISTE2))
    print(est_bijective(LISTE2))

test_exo4()
affiche_histo(LISTE)