#include <stdlib.h>
#include <stdio.h>
#include <time.h>


typedef struct maillon_int
{
    int val;
    struct maillon_int* suiv;
}Maillon_int;

Maillon_int* init();



