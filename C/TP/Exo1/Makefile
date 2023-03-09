CC=gcc
CFLAGS=-Wall -pedantic -g

all: ColinExo1

liste_int.o: liste_int.h liste_int.c 
	$(CC) -c liste_int.c -o liste_int.o

ColinExo1: ColinExo1.c liste_int.o
	$(CC) $(CFLAGS) -o ColinExo1 ColinExo1.c liste_int.o

clean:
	del *.o ColinExo1