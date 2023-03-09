CC=gcc
CFLAGS=-Wall -pedantic -g

all: ColinExo3

train.o: train.h train.c 
	$(CC) -c train.c -o train.o

ColinExo3: ColinExo3.c train.o
	$(CC) $(CFLAGS) -o ColinExo3 ColinExo3.c train.o

clean:
	del *.o ColinExo3