#include "fonction_pile.h"


/* Permet de créer une nouvelle pile ayant une valeur comprise entre 0 et 100*/
pile * init_pile()
{
    pile* p_nv_elt = malloc(sizeof(pile));
    p_nv_elt->val = rand() % 101;
    p_nv_elt->p_suiv = NULL;
    return p_nv_elt;
}

/*Vérifie si la liste est vide
@input: pile * p_sommet, sommet de la pile la liste est vide si NULL 
*/
void test_vide(pile* p_sommet)
{
    if (p_sommet == NULL)
        printf("liste vide");
}

/* Ajoute un élément en haut de la pile
@input: pile ** p_p_sommet, pointeur sur pointeur de l'élément de tête de la pile
        pile * p_nv_elt, nouveau pointeur qui viendra au sommet de la pile.
*/
void empile(pile** p_p_sommet, pile* p_nv_elt)
{
    p_nv_elt->p_suiv = *p_p_sommet;
    *p_p_sommet = p_nv_elt;
}

/* enlève le premier élément de la pile
@input: pile * p_p_sommet, pointeur sur pointeur du sommet de la pile, pour y accéder
*/
void depile(pile** p_p_sommet)
{
    pile* n;
    if (*p_p_sommet != NULL) {
        n = *p_p_sommet;
        *p_p_sommet = (*p_p_sommet)->p_suiv;
        free(n);
    }
}

/*Récupère la valeur du hatu de la pile
@input: pile * p_sommet, pointeur sur le sommet de la pile
*/
int get_sommet(pile* p_sommet)
{
    return p_sommet->val;
}


/*Récupère la valeur du haut de la pile passez en paramètre, puis la dépile
@input: pile ** p_p_sommet, pointeur sur le pointeur du le sommet de la pile
*/
int get_sommet_depile(pile** p_p_sommet)
{
    int retour = (*p_sommet)->val;
    depile(p_sommet);
    return retour;
}

/*Renverse la pile passer en paramètre puis l'affiche
@input: pile ** p_p_sommet, pointeur sur le pointeur du sommet de la pile
        int * tab, tableau d'entier, permettant d'échanger les valeurs avec la pile
*/
void reverse_list(int * tab, pile ** p_p_sommet){
    for (int i = 0; i <= sizeof(tab)/sizeof(tab[0]); i++)
    {
        pile* nouveau = malloc(sizeof(pile));
        nouveau->val = tab[i];
        nouveau->p_suiv = NULL;
        empile(p_p_sommet, nouveau);
    }
    parcourir(*p_p_sommet);
    while(*p_p_sommet != NULL){   
        tab[sizeof(tab)] = get_sommet_depile(p_p_sommet);
        printf("%d",tab[sizeof(tab)]);
    }
    parcourir(*p_p_sommet);    
}

/*Parcours les éléments de la pile
@input: pile * p_sommet, pointeur sur la valeur du sommet de la pile
*/
void parcourir(pile* p_sommet)
{
    if (p_sommet == NULL)
        printf("liste vide");
    else
        while (p_sommet != NULL) {
            printf("%d--", p_sommet->val);
            p_sommet = p_sommet->p_suiv;
        }
    putchar('\n');
}
