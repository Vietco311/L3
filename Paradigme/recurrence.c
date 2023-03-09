#include <stdio.h>
#include <math.h>

int algoC(int n, int m){
    int ite = 0;
    int i = 1;
    int j = 1;
    while(j <= n){
        if(i <= m){
            i = i + 1;
            ite = ite + 1;
        }
        else {
            j = j + 1;
            ite = ite + 1;
        }
    }
    return ite;
}

int algoD(int n, int m){
    int ite = 0;
    int i = 1;
    int j = 1;
    while(j <= n){
        if(i < m){
            i = i + 1;
            ite = ite + 1;
        }
        else {
            j = j + 1;
            i = 1;
            ite = ite + 1;
        }
    }
    return ite;
}

int mystereF(int n){
    if (n == 0){
        return 2;
    }else{
        return mystereF(n-1) * mystereF(n-1);
    }
}

int mystereG(int n){
    int R = 2;
    for (int i = 1; i <= n; i++){
        R *= R;
    }
    return R;
}

int main(int argc, char const *argv[])
{
    int n = 11;
    int m = 12;
    int ite = algoC(n, m);
    printf("nombre d'iteration pour algoC = %d\n", ite);
    ite = algoD(n, m);
    printf("nombre d'iteration pour algoD = %d\n", ite);
    ite = mystereF(4);
    printf("nombre d'iteration pour mystereF = %d\n", ite);
    ite = mystereG(4);
    printf("nombre d'iteration pour mystereG = %d", ite);
    return 0;
}

