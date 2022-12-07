#include <stdio.h>
#include <stdlib.h>

typedef struct coord{
    int x, y;
}Coord;

int modif(Coord* p){
    p->x ++;
    if (p->x>1000){
        p->x = 0;
    }

}

int main(int argc, char const *argv[])
{
    Coord p={10,20};
    printf("x=%d, y=%d\n", p.x, p.y);
    modif(&p);
    printf("x=%d, y=%d\n", p.x, p.y);
    return 0;
}



