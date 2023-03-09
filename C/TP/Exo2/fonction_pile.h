#ifndef __fonction_pile_h__
#define __fonction_pile_h__
 

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <errno.h>

typedef struct pile {
    int val;
    struct pile* p_suiv;
}pile;

pile* init_pile();

void test_vide(pile * p_sommet);

void empile(pile** p_p_sommet, pile* p_nv_elt);

void depile(pile** p_p_sommet);

int get_sommet(pile* p_sommet);

int get_sommet_depile(pile** p_sommet);

void reverse_list(int * tab, pile ** premier);

void parcourir(pile* p_sommet);

#endif