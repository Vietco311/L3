/*
Je pense que le meilleur moyen de créer le type abstrait Pile est une liste chainée
car il s'agit selon moi du meilleur moyen de représenter quelque chose qui s'empile
et se dépile en tête.
*/
#include "fonction_pile.h"

int main(int argc, char const *argv[])
{

    int tab[5] = {1,2,3,4,5};
    pile* premier = NULL;
    reverse_list(tab, &premier);    
    return 0;
}
