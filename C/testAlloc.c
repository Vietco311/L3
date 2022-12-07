#include <stdio.h>
#include <stdlib.h>



int swap_int(int *pt_1, int *pt_2){
       *pt_1 = *pt_1 + *pt_2;
       *pt_2 = *pt_1 - *pt_2;
       *pt_1 = *pt_1 - *pt_2;
}

int main(int argc, char const *argv[])
{   
    int a = 5;
    int b = 8;
    int * pt_1 = NULL;
    int * pt_2 = NULL;
    pt_1 = &a;
    pt_2 = &b;
    swap_int(pt_1, pt_2);
    printf("%d, %d", a,b);
    return 0;
}
