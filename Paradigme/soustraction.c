#include <stdio.h>
#include <stdlib.h>

int ouExclu(int x, int y){
    return x^y;
}

int complementa2(int x, int y){
    return ~x + 1;
}


int main(int argc, char const *argv[])
{
    int a = ouExclu(55, 50);
    int b = complementa2(17, 13);
    printf("%d | %d", a,b);
    return 0;
}


