/* Selon moi la meilleure structure de donnée pour représenter cet exercice
est un arbre de struct(tel un dictionnaire) qui permettrait stocké de stocké
toutes les informations nécessaires correspondant à un train.
*/
#include "train.h"


int main(int argc, char const *argv[])
{
    
    Horaire * h1 = init_horaire(8, 0, 8, 59);
    Train * t1 = init_train(h1, 237, "Lille", "Paris");
    Horaire * h2 = init_horaire(7, 0, 10, 0);
    Train * t2 = init_train(h2, 709, "Lille", "Lyon");
    Horaire * h3 = init_horaire(15, 19, 18, 34);
    Train * t3 = init_train(h3, 110, "Lille", "Calais");
    Horaire * h4 = init_horaire(12, 0, 18, 0);
    Train * t4 = init_train(h4, 900, "Paris", "Marseille");
    Horaire * h5 = init_horaire(10, 7, 15, 1);
    Train * t5 = init_train(h5, 450, "Lyon", "Marseille");
    Horaire * h6 = init_horaire(11, 50, 17, 0);
    Train * t6 = init_train(h6, 450, "Lyon", "Marseille");
    villeDepart(lstTrain, "Lille"); 
    triHoraire();   
    trajetMoinsLong("Lille", "Marseille");
    
    
    
    return 0;
}
