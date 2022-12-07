import datetime
from struct import *
from datetime import *

import socket

def encode_message(mess: str) -> bytes:
        size = len(mess) + len(str(datetime.now().timestamp()))
        encode = pack(f'>If{len(mess)}s', size, datetime.now().timestamp(), mess.encode())
        print(size)
        return encode

def decode_message(encode_mess: bytes) -> str:
        mess = (datetime.datetime.fromtimestamp(unpack(f'>If{len(encode_mess)-8}s ',encode_mess)))
        return mess

HOST = 'localhost'          # The remote host
PORT = 50007              # The same port as used by the server
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:

    s.connect((HOST, PORT))
    s.sendall(encode_message(input("Vous: ")))

print(encode_message('lalala'))
print(decode_message(encode_message('lalala')))

