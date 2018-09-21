# Projektin Tarkoitus

Ideana tehdä sovellus, joka vertailee DFS, BFS ja Astar -algoritmeja. Ideana olisi piirtää miten haku etenee algoritmeilla, ja
näyttää käytetty aika ja kertoa lyhimmän löydetyn reitin pituus.

## Tarvittavat tietorakenteet:

BFS:lle tehty First in, first out  logiikalla toimiva jono-tyyppinen tietorakenne metodeilla add, poll, isEmpty. DFS:lle tehty pino-tyyppinen tietorakenne last in, first out logiikalla samoilla metodeilla.
Astar tarvitsee priority queuen, jonka aion toteuttaa minimikeolla. Tämän toteutus on vielä kesken.

## Algoritmit:

Sovellus toteuttaa Leveyshaun (BFS), Syvyyshaun (DFS), ja A*-haun.

## Aikavaativuus:

Sovellus luo kaksi kappaletta n * m taulukoita, ensimmäinen GUIn paneeli, johon värit kytketään. Toinen on verkko, johon tallennetaan luodut solmut. Solmujen naapurit tallennetaan vieruslistoihin, jotta sovelluksen voi tarvittaessa implementoida helposti myös painotettuihin verkkoihin. Taulukot luodaan kahdella sisäkkäisellä forloopilla, joten aikavaativuus on O(n^2), missä n = max(n,m). Vieruslistojen kokoamiseen kuluu yks for loop, aikavaativuus O(n).

DFS ja BFS aikavaativuudet ovat O(V + E), missä V on solmujen määrä ja E kaarien määrä verkossa. Koska jokaiselle solmulle V on varattu neljän alkion pituinen pituinen lista, saadaan E määräksi 4 * V. Täten aikavaativuudeksi saadaan O(V + 4V) = O(5V) = O(V). Astar-algoritmin aikavaativuus on O(b^d), missä b on keskimääräinen haarautuminen per askel ja d lyhin polku verkossa.

Koska solmujen V määrä verkossa on n * m, jossa n on taulukon korkeus ja m leveys, saadaan:
O(n * m) + O(V) + O(V) + O(b^d) = O(V) + O(V) + O(b^d) = O(3 * V + b^d) = O(V + b^d)

## Tilavaativuus:

Sovellus vaatii tilaa kahdelle kaksiulotteiselle taulukolle, GUI:n tarvitsema sekä verkko, jota tutkitaan. Nämä molemmat vievät O(n * m) tilaa. 

DFS ja BFS vievät tilaa pahimmassa tapauksessa O(|V|), missä V on solmujen määrä verkossa. A* tilavaatimusta en ole vielä laskenut, olettaisin sen olevan sama O(|V|).

Näin saadaan:

n * m on jälleen solmujen määrä
O(n * m) + O(2|V|) + O(|V|) + O(|V|) = O(|V|) + O(|V|) + O(|V|) + O(|V|) = O(4*|V|) = O(|V|)
