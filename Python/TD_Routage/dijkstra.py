import numpy as np
import math
import copy

djikstra=np.loadtxt("dijkstra.txt",dtype=float)

file=open("dijkstra.txt")
ligne=file.readline()
file.close()
nom=ligne.split()

P = []
chemin = [math.inf] * 6
chemin[0] = 0
pred = []

print(nom)


def poids(s1, s2):
    result = 0
    if nom[s1][s2] < 0:
        result = math.inf
    else:
        result = nom[s1][s2]
    return result


def trouveMin(q):
    min = math.inf
    sommet = -1
    for i in range(len(q[])):
        if chemin[i] < min:
            min = chemin[i]
            sommet = i
    return sommet

def majDistance(s1, s2):
    if chemin[s2] > chemin[s1] + poids(s1, s2):
        chemin[s2] = chemin[s1] + poids(s1, s2)
        pred[s2] = s1

def main(poids):
    while nom:
        s1 = trouveMin(nom)




