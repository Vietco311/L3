# Echo client program
import socket

HOST = 'localhost'          # The remote host
PORT = 50007              # The same port as used by the server
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    intro = s.recv(1024).decode()
    print('Received', repr(intro))
    essai = s.recv(1024).decode()
    essai = int(essai)
    i = 0
    while i < essai:
        guess = input("Mon guess: ")
        s.sendall(guess.encode())
        data = s.recv(1024).decode()
        print('Received', repr(data))
        i+=1
