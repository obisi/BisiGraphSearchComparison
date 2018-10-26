# Totetutus

## Logiikka

Ohjelma kysyy käyttäjältä piirrettävän kartan koon. Kartalle piirretään esteitä ja lähtö- ja maalipisteet. Haku suoritetaan DFS,
BFS tai A* -algoritmilla. Testauksessa käyttäjältä jälleen kysytään kartan koko, sekä testien määrä. Ohjelma arpoo karttalle seiniä,
ja hylkää, mikäli karttaa ei voi läpäistä. Hakualgoritmit tehdään kartoille annetun määrän kertoja, jonka jälkeen niiden kestojen
keskiarvot tulostetaan konsoliin.

### Reitinhaut:
BFS, DFS ja Astar toimivat samalla pohjalla, eli tietorakenteesta otetaan solmu, lisätään sen naapurit tietorakenteeseen. Läpikäynti loppuu, kun jokin naapureista on maali tai tietorakenne on tyhjä. Tyhjä tietorakenne tarkoittaa, ettei löydy
polkua aloituksen ja maalin väliltä. Tietorakenteena DFS käyttää pinoa, BFS jonoa ja Astar minimikekoa.

### Tietorakenteet:
* Pino on taulukko, jonka viimeisin käytetty indeksi pidetään muuttujassa i. Kun lisätään uusi, kasvatetaan i:tä ja sijoitetaan alkio indeksiin i. Kun poistetaan, otetaan indeksistä i, ja vähennetään indeksiä yhdellä. Jos pino täyttyy, luodaan uusi taulukko, joka on kaksi kertaa suurempi, ja kopioidaan vanhat alkiot sinne. Mikäli poistaessa käytetty osuus on yksi neljäsosa taulukon koosta ja taulukon koko on yli kahdeksan, puolitetaan taulukon koko.

* Jono on taulukko, jossa pidetään tietoa sekä alkuindeksistä i sekä koosta s. Kun lisätään uusi, lisätään se indeksiin s, ja kasvatetaan s yhdellä. Kun poistetaan, otetaan alkio indeksistä i, ja kasvatetaan i yhdellä. Jos i = s, tiedetään että jono on tyhjä. Mikäli taulukon koko on yli kahdeksan, ja i = s, puolitetaan taulukko. Mikäli lisättäessä s kasvaa taulukon kokoiseksi, luodaan uusi taulukko, joka on kaksi kertaa isompi kuin alkuperäinen, ja kopioidaan alkiot siihen.

* Minimikeko on taulukko, jossa pienin alkio on aina ensimmäisessä indeksissä. Kun taulukkoon lisätään uusi alkio, se laitetaan taulukon ensimmäiseen tyhjään kohtaan, ja tehdään heapify metodi, joka korjaa minimikeon. Tämä tarkoittaa, että pienin arvo nousee ensimmäiseksi. Kun keosta poistetaan arvo, lisätään keon viimeisestä indeksistä arvo päällimmäiseksi. Tehdään taas heapify, jotta keon rakenne pysyy ehjänä.

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

Kuvaajan merkitsemät tulokset ovat 20 satunnaisen kartan keskiarvot. Jokainen testi tehtiin kaksi kertaa, joten reitinhauille on kaksi eri käyrää.

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

