import numpy as np

objets = np.loadtxt('sac_a_dos.txt', dtype=int)
print(objets)
W=15
n = len(objets)
C = [0] * W
Cnext = [0] * W
for i in range(n):
    for w in range(W):
        if w >= objets[i][2]:
            Cnext[w] = max(C[w], C[w-objets[i][2]] + objets[i][1])
        else:
            Cnext[w] = C[w]
    C = Cnext.copy()

