#include "liste_int.h"


/* Permet de créer un nouveau maillon avec une valeur
entre un 0 et 20. Ce maillon n'est pas encore placé
dans la liste chainée, il pointe donc sur NULL.
On crée un pointeur dynamique avec malloc afin d'allouer la mémoire dynamiquement
pour le maillon.
@output: maillon_int*, le maillon créé sous la forme d'un pointeur.
@postcondition: le maillon contient une valeur entre 0 et 20 et ne pointe sur aucun autre
*/
maillon_int* init_elt()
{
    maillon_int* p_nv_elt = malloc(sizeof(maillon_int));
    p_nv_elt->val = rand() % 21;
    p_nv_elt->p_suiv = NULL;
    return p_nv_elt;
}


/* Remplace le maillon de tête de la liste chainée
à partir d'un nouveau pointeur sur maillon.
@input: maillon_int * p_tete, pointeur qui viendra en tête de la liste
        maillon_int * p_nv_elt, nouveau pointeur qui ne possède aucun maillon pointé.
@output: maillon_int * p_tete, le pointeur de tête, nécessaire au passage par valeur
@précondition: p_nv_elt ne possède aucun maillon sur lequel il pointe

*/
maillon_int* ajout_tete_v1(maillon_int* p_tete, maillon_int* p_nv_elt)
{
    p_nv_elt->p_suiv = p_tete;
    p_tete = p_nv_elt;
    return p_tete;
}


/* Similaire à la fonction ajout_tete_v1, à la différence où celle ci
prend en paramètre un pointeur sur pointeur de maillon pour le pointeur
de tête, permettant d'éviter de retourner le pointeur de tête
@input: maillon_int ** p_p_tete, pointeur sur le pointeur de tête
        maillon_int * p_nv_elt, nouveau pointeur qui ne possède aucun maillon pointé.
@output: void
@précondition: p_nv_elt ne possède aucun maillon sur lequel il pointe
               Ne pas oublier qu'il faut pointé un autre pointeur dans le premier paramètre
*/
void ajout_tete_v2(maillon_int** p_p_tete, maillon_int* p_nv_elt)
{
    p_nv_elt->p_suiv = *p_p_tete;
    *p_p_tete = p_nv_elt;
}

/* Permet de parcourir la liste chainée de maillon en s'arrêtant
au premier NULL. La fonction affiche la valeur pointé par les
maillons puis passe au maillon suivant. On commence par le poitneur de tête
passer en paramètre  afin d'accéder aux maillons.
@input: maillon_int * p_tete, le pointeur de tête
@output: void
*/

void parcourir(maillon_int* p_tete)
{
    if (p_tete == NULL)
        printf("liste vide");
    else
        while (p_tete != NULL) {
            printf("%d--", p_tete->val);
            p_tete = p_tete->p_suiv;
        }
    putchar('\n');
}

/* Insère un maillon dans la liste chainée avec un passage par valeur,
en rentrant dans la liste avec le pointeur sur tête. Si le pointeur de
tête n'existe pas, il crée à la manière de ajout_tete_v1.
@input: maillon_int * p_tete, le poitneur de tête
        maillon_int * p_nv_elt, le nouveau pointeur que l'on veut insérer
@output: maillon_int * p_tete, le poitneur de tête nécessaire au passage par valeur
@précondition: p_nv_elt ne possède aucun maillon sur lequel il pointe.
@postcondition: le nouveau maillon est placé dans la liste au bon endroit.
*/

maillon_int* inserer1(maillon_int* p_tete, maillon_int* p_nv_elt)
{
    maillon_int* n, * prec;
    
    if (p_tete == NULL || p_nv_elt->val <= p_tete->val) {  
        p_nv_elt->p_suiv = p_tete;
        p_tete = p_nv_elt;
    }
    else {  
        n = prec = p_tete;
        while (n != NULL && p_nv_elt->val > n->val) {
            prec = n;
            n = n->p_suiv;
        }
        p_nv_elt->p_suiv = n;
        prec->p_suiv = p_nv_elt;
    }
    return p_tete;
}

/* Insère un maillon dans la liste chainée avec un passage par référence
en rentrant avec un pointeur sur pointeur de maillon.
Si le pointeur de tête n'existe pas, il crée à la manière de ajout_tete_v2.
@input: maillon_int ** prem, pointeur sur pointeur du premier maillon.
        maillon_int * e, le nouveau pointeur que l'on veut insérer
@précondition: e ne possède aucun maillon sur lequel il pointe.
@postcondition: le nouveau maillon est placé dans la liste au bon endroit
*/

void inserer2(maillon_int** prem, maillon_int* e)
{
    maillon_int* n, * prec;
    if (*prem == NULL || e->val <= (*prem)->val){ 
        e->p_suiv = *prem;
        *prem = e;
    }
    else {  
        n = prec = *prem;
        while (n != NULL && e->val > n->val) {
            prec = n;
            n = n->p_suiv;
        }
        e->p_suiv = n;
        prec->p_suiv = e;
    }
}

/* Libère la mémoire du premier pointeur de la liste chaîné en passant le pointeur
sur pointeur de la tête de la liste et place la tête sur le pointeur suivant.
@input: maillon_int ** prem, pointeur sur pointeur de tête de la liste chainée.
@output: void
@postcondition: Le premier pointeur de la liste chainée est libéré.
*/
void supprimer_debut(maillon_int** prem)
{
    maillon_int* n;
    if (*prem != NULL) {
        n = *prem;
        *prem = (*prem)->p_suiv;
        free(n);
    }
}

/* Libère avec passage par valeur les pointeurs qui pointe une valeur égale
à celle passé en paramètre. La liste chainé se décale vers la gauche s'il
n'y a pas de maillon précédent, sinon se décale vers la droite à partir de celui ci
@input: maillon_int * prem, le pointeur de tête de la liste chainée.
         int val, une valeur à comparer
@output: maillon_int * prem, le pointneur de tête, nécessaire au passage par valeur
@precondition: La valeur est entre 0 et 20
                prem fait déjà partie de la liste chainée
@postcondition: Les pointeurs que l'ont désires libérer le sont.
*/
maillon_int* critere_supp_un1(maillon_int* prem, int val)
{
    maillon_int* e = prem, * prec = NULL, * n;

    //Tant que le pointeur passer en paramètre n'est pas NULL
    while (e != NULL) {
        //Initialise le pointeur n à NULL
        n = NULL;
        //Si la valeur pointeur par le pointeur passer en pramètre est égale à celle passer en paramètre
        if (e->val == val) {
            //n prend les attributs de e
            n = e;
            //Si prec est NULL alors le pointeur en paramètre prem devient pointé par e
            if (prec == NULL)
                prem = e->p_suiv;
            //Sinon le prec pointe sur le maillon suivant e
            else
                prec->p_suiv = e->p_suiv;
        }
        //Sinon prec égale e
        else
            prec = e;
        //le pointeur e avance de 1.
        e = e->p_suiv;
        //Si n n'est pas NULL, alors on libère sa mémoire
        if (n != NULL)
            free(n);
    }
    return prem;

}

/* Libère avec passage par référence les pointeurs qui pointe une valeur égale
à celle passé en paramètre. La liste chainé se décale vers la gauche s'il
n'y a pas de maillon précédent, sinon se décale vers la droite à partir de celui ci
@input: maillon_int ** prem, le pointeur sur pointeur de tête de la liste chainée.
         int val, une valeur à comparer
@output: void
@precondition: La valeur est entre 0 et 20
                prem fait déjà partie de la liste chainée
@postcondition: Les pointeurs que l'ont désires libérer le sont.
*/
void critere_supp_un2(maillon_int** prem, int val)
{
    maillon_int* e = *prem, * prec = NULL, * n;

    while (e != NULL) {
        n = NULL;
        if (e->val == val) {
            n = e;
            if (prec == NULL)
                *prem = e->p_suiv;
            else
                prec->p_suiv = e->p_suiv;
        }
        else
            prec = e;
        e = e->p_suiv;
        if (n != NULL)
            free(n);
    }
}

/* Supprime tous les éléments de la liste en y accédant par référence
par la tête avec un pointeur sur pointeur.
@input: maillon_int ** prem, le pointeur sur pointeur de tête
@postcondition: la liste est entièrement détruite

*/
void detruire_liste(maillon_int** prem)
{
    maillon_int* n;
    while (*prem != NULL) {
        n = *prem;
        *prem = (*prem)->p_suiv;
        free(n);
    }
}


/* Supprime tous les éléments de la liste en appelant supprimer_debut
dans une boucle qui s'assure que chaque nouvelle tête ne soit pas NULL.
@input: maillon_int ** prem, le pointeur sur pointeur de tête
@postcondition: la liste est entièrement détruite
*/
void detruire_liste2(maillon_int** prem)
{
    while (*prem != NULL)
        supprimer_debut(prem);
    
}

/* Permet la sérialisation format binaire dans le fichier
"saveliste.bin" de la liste d'entier (maillon_int) dont
le pointeur sur le premier élément est passé en paramètre
@input : maillon_int * prem, pointeur sur l'élément de tête de la liste à sérialiser
@output : void
@precondition : le répertoire courant et le processus père permettent l'écriture 
                le pointeur prem, est soit NULL (aucune action) soit pointe sur
                le premier élément d'une liste d'entiers
@postcondition : le fichier saveliste.bin contient les éléments de la liste 
                dont le premier élément est pointé par prem. 
                Nota : il n'y a pas de libération de la mémoire occupée par la 
                liste. Il faut donc la détruire avant d'éventuellement la recharger.
*/
void sauver_liste(maillon_int* prem)
{
    //ouvrir un fichier binaire en écriture : suffixe b
    FILE* f=fopen("saveliste.bin", "wb");
    printf("Ouvertude du fichier %p\n",f);
    // si liste non vide
    if (prem != NULL) {
        if (f==NULL)
            fprintf(stderr,"erreur création fichier :%i\n",errno);
        else // parcourir la liste jusque fin
            while (prem != NULL) {
                // écrire chaque maillon en binaire
                if (1 !=fwrite(prem, sizeof(maillon_int), 1, f))
                    fprintf(stderr,"Erreur d'écriture du maillon %p\n",prem);
                else 
                // passer au maillon suivant
                prem = prem->p_suiv;
            }
            fclose(f);	// fermer le fichier
    }
    else
        fprintf(stderr,"pas de sauvegarde pour une liste vide\n");
}

/* Génère une liste depuis un fichier avec une tête de liste chainée
et retourne la tête.
@output: maillon * prem, la tête de la liste chainée
@postcondition: la liste est créée avec un premier élément.
*/
maillon_int* load_liste()
{
    FILE* f;
    maillon_int* prem = NULL, * p, e;
    if ((f= fopen("saveliste.bin", "rb")) != NULL) {
        prem = malloc(sizeof(maillon_int));
        fread(prem, sizeof(maillon_int), 1, f);
        p = prem;
        while (fread(&e, sizeof(maillon_int), 1, f)) {
            p->p_suiv = malloc(sizeof(maillon_int));
            p = p->p_suiv;
            *p = e;
            p->p_suiv = NULL;
        }
        fclose(f);
    }
    else
        printf("erreur ou fichier inexistant");
    return prem;
}