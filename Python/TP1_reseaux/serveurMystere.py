import random
import socket


mystere = random.randint(0, 100)

HOST = 'localhost'                 # Symbolic name meaning all available interfaces
PORT = 50007              # Arbitrary non-privileged port
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen(1)
    conn, addr = s.accept()
    with conn:
        trouve = False
        min = 0
        max = 100
        essai = 7
        conn.sendall(f"nombre d'essais: {essai}, intervalle: {min} à {max}".encode())
        while essai > 0 and trouve == False:
            conn.sendall(str(essai).encode())
            data = conn.recv(1024).decode()
            data = int(data)
            if not data: break
            if data == mystere:
                conn.sendall(f"BRAVO! Trouvé en {essai}. Le nombre était {mystere}".encode())
                trouve = True
            else:
                essai -= 1
                if essai == 0:
                    conn.sendall(f"FAUX! Il ne reste plus d'essai, c'était {mystere}".encode())
                elif data < mystere:
                    conn.sendall(f"FAUX! Plus haut! Il reste {essai}".encode())
                else:
                    conn.sendall(f"FAUX! Plus bas! Il reste {essai}".encode())