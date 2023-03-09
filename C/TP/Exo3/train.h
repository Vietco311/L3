#ifndef __train_h__
#define __train_h__
 

#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define foreach(item, array) \
    for(int keep = 1, \
            count = 0,\
            size = sizeof (array) / sizeof *(array); \
        keep && count != size; \
        keep = !keep, count++) \
      for(item = (array) + count; keep; keep = !keep)

typedef struct horaire{
    char * depart;
    char * arrive;  
}Horaire;

typedef struct train{
    char villeArrive[12];
    char villeDepart[12];
    Horaire * temps;
    int distance;
}Train;

int numTrain;

Train * lstTrain[8];

char * lstHoraireDepart[1];

char * lstHoraireArrive[10];

Train * init_train(Horaire * tabHoraire, int nDistance, char * nDepart, char * nArrive);

Horaire * init_horaire(int nHeureDepart, int nMinuteDepart, int nHeureArrive, int nMinuteArrive);

void villeDepart(Train ** p_train, char * depart);

int calculVitesse(char * arrive, char * depart, int longueur);

Train * vitessePlusEleve(Train ** p_train);

void triHoraire();

void parcourirTrain(Train ** trains);

char * trajetMoinsLong(char * depart, char * arrive);

int toSecond(char * heure);

#endif
