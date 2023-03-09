CC=gcc
CFLAGS=-Wall -pedantic -g

all: ColinExo2

fonction_pile.o: fonction_pile.h fonction_pile.c 
	$(CC) -c fonction_pile.c -o fonction_pile.o

ColinExo2: ColinExo2.c fonction_pile.o
	$(CC) $(CFLAGS) -o ColinExo2 ColinExo2.c fonction_pile.o

clean:
	del *.o ColinExo2