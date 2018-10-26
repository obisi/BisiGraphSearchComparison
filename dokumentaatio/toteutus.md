# Totetutus

## Logiikka

Ohjelma kysyy käyttäjältä piirrettävän kartan koon. Kartalle piirretään esteitä ja lähtö- ja maalipisteet. Haku suoritetaan DFS,
BFS tai A* -algoritmilla. Testauksessa käyttäjältä jälleen kysytään kartan koko, sekä testien määrä. Ohjelma arpoo karttalle seiniä,
ja hylkää, mikäli karttaa ei voi läpäistä. Hakualgoritmit tehdään kartoille annetun määrän kertoja, jonka jälkeen niiden kestojen
keskiarvot tulostetaan konsoliin.

## Saavutetut aika- ja tilavaativuudet.

Karttoja luodaan kaksi, sekä GUI:n piirtämä, että hakuun käytettävä. Tilavaativuus on täten O(n^2) molemmille kartoille, eli 
yhteensä O(n^2). Aikavaativuus on sama, O(n^2). Haun alkaessa kartta tyhjennetään käydyistä pisteistä, sekä luodaan uudelleen
naapurilistat solmuille. Tyhjennys vie O(n^2), sillä jokainen solmu pitää tutkia erikseen. Tämän jälkeen jokaisen solmun naapurit
tarkistetaan. Tämäkin vie O(n^2). 

Testivaiheessa tilavaativuus on sama, hieman korkeampi, sillä karttoja luodaan 4 kappaletta. Ensin testikartta, joka kopioidaan
jokaiselle hakualgoritmille. Saadaan 4*O(n^2). Tämän olisi voinut toteuttaa tehokkaammin tyhjentämällä kartta jokaisen haun jälkeen.


### Reitinhaut:
* DFS ja BFS: Pahimmassa tapauksessa jokainen solmu ja kaari pitää tutkia, jolloin aikavaativuus on O(V + E), 
jossa V on solmut ja E kaaret. Kummankaan tietorakenteessa ei voi olla kuin korkeintaan solmujen määrä kerrallaan, joten tilavaativuus
on O(V).
* Astar: Aikavaativuus on O(b^d), jossa b on naapurien määrä solmuilla ja d lyhimmän reitin pituus. Tietorakenteessa voi olla
korkeintaan kaikki solmut kerrallaan, joten tilavaativuus on O(V).

### Tietorakenteet:
* Pino, jono: Push ja Pop: Yleensä O(1), sillä sijainti keossa tiedossa. Kuitenkin jos kokoa pitää muuttaa, joudutaan tekemään
n-kappaletta operaatioita. Tällöin aikavaativuus on O(n). Tilavaativuus molemmissa O(n), alkioiden määrä.

* Keko: Pop ja Push Pahimmillaan O(log n), sillä pinon uusi pienin arvo joudutaan etsimään pinosta. Tilavaativuus on O(n)


## Suorituskykyvertailu:

![Graph search plot](https://github.com/obisi/BisiGraphSearchComparison/blob/master/dokumentaatio/Plots/Graph_Search_Plot.png)

Kuten kuvaajasta näkee, selvästikin A* on nopeampi kuin BFS tai DFS. Tämä ei ole yllättävää, sillä aikavaativuuskin on huomattavasti parempi. Solmulla on kuitenkin keskimäärin kolme tutkittavaa naapuria. DFS on kuitenkin selkeästi nopeampi kuin BFS isoilla kartoilla,
vaikka pahimman tapauksen aikavaativuus on sama. Jollain kerroilla DFS saattaa olla jopa Astaria nopeampi, riippuen seinien sijoittelusta.

## Puutteet & Parannukset:

Reitinhakua olisi mielenkiintoisempi seurata graafisesti, jos haku toimisi hieman hidastettuna. Alunperin tarkoituksena olikin luoda
animationtimerilla animaatio reitin etenemisestä, jotta näkee paremmin solmujen valinnat. Tämä osoittautui liian aikaavieväksi,
joten tein tekstipohjaisen testauksen. Tällä menetelmällä tosin voi tarkemmin seurata itse reitinhaun vaatimaa aikaa, kun grafiikan
piirtämiseen ei kulu aikaa.


# Lähteet:

http://bigocheatsheet.com
https://en.wikipedia.org/
Tietorakenteet & Algoritmit kurssimateriaali (Kevät 2018)

