#include "train.h"

/* Créer un nouveau train
@input: Horaire * tabHoraire, heure de départ et d'arrivé du train.
        int nDistance, distance en kilomètre du train.
        char * nDepart, ville de départ.
        char * nArrive, ville d'arrivé.
*/
Train *init_train(Horaire *tabHoraire, int nDistance, char *nDepart, char *nArrive)
{
    Train *nvTrain = malloc(sizeof(Train));
    nvTrain->distance = nDistance;
    memcpy(nvTrain->villeArrive, nArrive, 12);
    memcpy(nvTrain->villeDepart, nDepart, 12);
    nvTrain->temps = tabHoraire;
    lstTrain[numTrain] = nvTrain;
    numTrain += 1;
    return nvTrain;
}

/* Créer un nouvel horaire
@input: int nHeureDepart, heure de départ.
        int nHeureArrive, heure d'arrivé.
        int nMinuteDepart, minute de départ
        int nMinuteArrive, minute d'arrivé.
*/
Horaire *init_horaire(int nHeureDepart, int nMinuteDepart, int nHeureArrive, int nMinuteArrive)
{
    Horaire *nvHoraire = malloc(sizeof(Horaire));
    nvHoraire->depart = malloc(sizeof(char));
    nvHoraire->arrive = malloc(sizeof(char));
    if (nHeureArrive < 10 && nMinuteArrive < 10)
    {
        // sprintf() est faite pour enregistrer dans un buffer une chaine de caractères,
        // ici fait pour stocker les heures et minutes
        sprintf(nvHoraire->arrive, "0%d:0%d", nHeureArrive, nMinuteArrive);
    }
    else if (nHeureArrive < 10)
    {
        sprintf(nvHoraire->arrive, "0%d:%d", nHeureArrive, nMinuteArrive);
    }
    else if (nMinuteArrive < 10)
    {
        sprintf(nvHoraire->arrive, "%d:0%d", nHeureArrive, nMinuteArrive);
    }
    else
    {
        sprintf(nvHoraire->arrive, "%d:%d", nHeureArrive, nMinuteArrive);
    }
    if (nHeureDepart < 10 && nMinuteDepart < 10)
    {
        sprintf(nvHoraire->depart, "0%d:0%d", nHeureDepart, nMinuteDepart);
    }
    else if (nHeureDepart < 10)
    {
        sprintf(nvHoraire->depart, "0%d:%d", nHeureDepart, nMinuteDepart);
    }
    else if (nMinuteDepart < 10)
    {
        sprintf(nvHoraire->depart, "%d:0%d", nHeureDepart, nMinuteDepart);
    }
    else
    {
        sprintf(nvHoraire->depart, "%d:%d", nHeureDepart, nMinuteDepart);
    }
    lstHoraireDepart[numTrain] = nvHoraire->depart;
    lstHoraireArrive[numTrain] = nvHoraire->arrive;

    return nvHoraire;
}

/* Affiche les trains partant d'une ville
@input: Train ** trains, liste de trains.
        char * depart, ville dont on souhaite afficher les trains y partant.
*/
void villeDepart(Train **trains, char *depart)
{
    for (int i = 0; i < sizeof(trains); i++)
    {
        // strcmp permet de comparer deux chaines de caractères, true == 0 et false == 1
        if (strcmp(trains[i]->villeDepart, depart) == 0)
        {
            printf("%s, %s, %s, %s, %d Km\n", trains[i]->villeDepart, trains[i]->villeArrive,
                   trains[i]->temps->depart, trains[i]->temps->arrive, trains[i]->distance);
        }
    }
}

/* Affiche les trains partant d'une ville
@input: char * arrive, heure et minutes d'arrivé.
        char * depart, heure et minutes de départ.
        int longueur, la longueur du trajet.
*/
int calculVitesse(char *arrive, char *depart, int longueur)
{
    char delim[] = ":";
    // strtok() permet de scinder une chaine de caractères grâce à un delimiteur
    char *tDepartHeure = strtok(depart, delim);
    // atoi() permet de convertir une chaine de caractères en entier
    int tSecDep = atoi(tDepartHeure) * 3600;
    char *tDepartMinute = strtok(NULL, delim);
    // snprintf() permet de reconcaténer ici les heures et minutes en précisant un espace d'allocation
    snprintf(depart, 40, "%s:%s", tDepartHeure, tDepartMinute);
    tSecDep += atoi(tDepartMinute) * 60;
    char *tArriveHeure = strtok(arrive, delim);
    int tSecArr = atoi(tArriveHeure) * 3600;
    char *tArriveMinute = strtok(NULL, delim);
    snprintf(arrive, 40, "%s:%s", tArriveHeure, tArriveMinute);
    tSecArr += atoi(tArriveMinute) * 60;
    int secDiff = tSecArr - tSecDep;
    int vitesse = (int)longueur * 1000 / secDiff;
    return vitesse;
}

/* Compare la vitesse des trains donnés dans la liste
@input: Train ** trains, liste de train
*/
Train *vitessePlusEleve(Train **trains)
{
    size_t taille = sizeof(struct train);

    Train *tempTrain = NULL;
    int vitesseMax = 0;
    for (int i = 0; i < 6; i++)
    {
        if (trains[i] != NULL)
        {
            int vitesse = calculVitesse(trains[i]->temps->arrive, trains[i]->temps->depart, trains[i]->distance);
            if (vitesse > vitesseMax)
            {

                vitesseMax = vitesse;
                tempTrain = trains[i];
            }
        }
    }
    return tempTrain;
}

/* Tri les trains par horaire croissante
 */
void triHoraire()
{

    for (int j = 5; j >= 0; j--)
    {
        int compHoraire = toSecond(lstTrain[j]->temps->depart);
        for (int i = j - 1; i >= 0; i--)
        {
            int compHoraire1 = toSecond(lstTrain[i]->temps->depart);
            if (compHoraire < compHoraire1)
            {
                Train *temp = lstTrain[j];
                lstTrain[j] = lstTrain[i];
                lstTrain[i] = temp;
            }
        }
    }
    printf("Horaire de depart:\n");
    parcourirTrain(lstTrain);
}

/*Parcours la liste des trains, affichant leurs planning
@input: Train ** trains, liste de trains
*/
void parcourirTrain(Train **trains)
{
    if (trains == NULL)
        printf("liste vide");
    else
        for (int i = 0; i < 6; i++)
        {

            if (trains[i] != NULL)
            {
                printf("%s, %s, %s, %s, %d Km\n", trains[i]->villeDepart, trains[i]->villeArrive,
                       trains[i]->temps->depart, trains[i]->temps->arrive, trains[i]->distance);
            }
        }
    putchar('\n');
}

/* Affiche les trains à prendre pour effectuer le chemin le moins
long en termes de temps entre deux villes
@input: char * arrive, ville d'arrivé.
        char * depart, ville de départ.
*/
char *trajetMoinsLong(char *depart, char *arrive)
{
    char *result = NULL;
    Train *tempTrain = vitessePlusEleve(lstTrain);
    if (strcmp(tempTrain->villeDepart, depart) == 0 && strcmp(tempTrain->villeArrive, arrive) == 0)
    {
        printf("%s, %s, %s, %s, %d Km\n", tempTrain->villeDepart, tempTrain->villeArrive,
               tempTrain->temps->depart, tempTrain->temps->arrive, tempTrain->distance);
    }
    else
    {
        Train *lstTrainTrajetDepart[8] = {NULL};
        Train *lstTrainTrajetArrive[8] = {NULL};
        for (int i = 0; i < 6; i++)
        {
            if (strcmp(lstTrain[i]->villeDepart, depart) == 0)
            {
                lstTrainTrajetDepart[i] = lstTrain[i];
            }
            if (strcmp(lstTrain[i]->villeArrive, arrive) == 0)
            {
                lstTrainTrajetArrive[i] = lstTrain[i];
            }
        }
        int premierTempsMin = 0;
        int secondTempsMin = 0;
        Train *lstPlusRapide[2] = {NULL};
        for (int i = 0; i < 3; i++)
        {
            if (lstTrainTrajetDepart[i] != NULL)
            {
                int premierTemps = toSecond(lstTrainTrajetDepart[i]->temps->depart) - toSecond(lstTrainTrajetDepart[i]->temps->arrive);

                if (premierTemps < premierTempsMin)
                {
                    premierTempsMin = premierTemps;
                    lstPlusRapide[0] = lstTrainTrajetDepart[i];
                }
            }
        }
        for (int i = 0; i < 3; i++)
        {

            if (lstTrainTrajetArrive[i] != NULL)
            {
                int secondTemps = toSecond(lstTrainTrajetArrive[i]->temps->depart) - toSecond(lstTrainTrajetArrive[i]->temps->arrive);
                if (secondTemps < secondTempsMin &&  300 < toSecond(lstPlusRapide[0]) < 7200)
                {
                    secondTempsMin = secondTemps;
                    lstPlusRapide[1] = lstTrainTrajetArrive[i];
                }
            }
        }
        parcourirTrain(lstPlusRapide);
    }
}

/* Transforme une chaine de caratères représentant une horaire en entier(secondes)
@input: char * horaire, l'horaire en chaine de caractères
*/
int toSecond(char *horaire)
{
    char *delim = ":";
    char *tempsHeure = strtok(horaire, delim);
    int toSec = atoi(tempsHeure) * 3600;
    char *tempsMinute = strtok(NULL, delim);
    toSec += atoi(tempsMinute) * 60;
    snprintf(horaire, 40, "%s:%s", tempsHeure, tempsMinute);
    return toSec;
}