#include<stdio.h> // define the header file 
#include <stdlib.h>
//Commentaire 
int main(int argc, char const *argv[])   // define the main function  
{  
    int un_int = 5;
    int *pt_int = &un_int;
    *pt_int = 6;
    long taille = sizeof(&un_int);
    printf("le int est %ld\n", taille);
    char C = 'a';
    int A = 256;
    int B = 129;
    char *pt_char = &C;
    int *pt_inta = &A;
    int *pt_intb = &B;
    printf("Adresse de c =%p\n", &C);
    printf("Adresse de a =%p\n", &A);
    printf("Adresse de b =%p\n", &B);
    return 0;  
}  