% les faits :

% les 3 maisons :
maison(chateau).
maison(studio).
maison(pavillon).

% les 3 animaux :
animal(chat).
animal(poisson).
animal(cheval).

%--------------------------------------------------------
% les r�gles :

% le pr�dicat relation constitue la relation entre une personne, son animal et sa maison :
relation(max,M,chat):-maison(M).
relation(luc,studio,A):-animal(A),A\==cheval.
relation(eric,M,A):-maison(M),M\==pavillon,animal(A).

% le pr�dicat different est vraie seulement si ses 3 param�tres sont diff�rents :
different(X,X,_):-!,fail.
different(X,_,X):-!,fail.
different(_,X,X):-!,fail.
different(_,_,_).

% le pr�dicat "resoudre" indique les 4 inconnues � retrouver :
resoudre(MM,ME,AE,AL):-

relation(max,MM,chat),
relation(eric,ME,AE),
different(MM,ME,studio),
relation(luc,studio,AL),
different(AE,AL,chat).
