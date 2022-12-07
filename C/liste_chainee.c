#include "liste_chainee.h"

int main(int argc, char const *argv[])
{
    srand(time(NULL));
    Maillon_int * premier = NULL;
    premier = init();
    insert_head_elem(&premier);
    printf("%d",premier->val);
    return 0;
}

Maillon_int * init(){
    Maillon_int * m;
    m = malloc(sizeof(Maillon_int));
    m->val = rand()%100;
    m->suiv = NULL;
    return m;
}

void insert_head_elem(Maillon_int ** pt_premier){
    Maillon_int * head_maillon = NULL;
    head_maillon = init();
    head_maillon->suiv = *pt_premier;
    *pt_premier = head_maillon;
}

void print_list(Maillon_int * pt_premier){
    Maillon_int * head = pt_premier->suiv;
    while(pt_premier->suiv == NULL){

    }
}

void insert_new(Maillon_int ** premier){
    Maillon_int * new_maillon = NULL;
    new_maillon = init();
    while(premier->suiv == NULL){
        "";
    }

}
