#include <stdbool.h>
#include <math.h>
#include <stdio.h>



int main(int argc, char const *argv[])
{
    int n = 7;
    int serie = 0;
    int somme1 = 0;
    int somme2 = 0;
    for (int k = 0; k <= n; k++){
        somme1 = 2 * k + 1; 
        somme2 = 2 * k;
        serie += somme1 - somme2;
    }
    printf("%d", serie);
    return 0;
}
