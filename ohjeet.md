# Käyttöohjeet:

Lataa ohjelma gitistä. Avaa projekti IDE:llä (esim Netbeans). Aja ohjelma. Tekstipohjainen käyttöliittymä kysyy ensin piirrettävän kartan koon. Sopivat arvot ovat 10-100 välillä. 

Kun olet valinnut kartan koon, uusi ikkuna aukeaa. Ikkunassa on kartta, sekä napit, joilla ohjelmaa käytetään. Painamalla nappia Set start, voit valita kartalta, mistä reitinhaku aloitetaan. Aloitusruutu on valkoinen. Napista set goal voit päättää, mihin reitinhaku päättyy. Lopetusruutu on punainen. Voit luoda seiniä, eli mustia ruutuja, painamalla set wall. Set empty -napilla voit nollata valitsemasi ruudun takaisin tyhjäksi, eli vaaleanharmaaksi.

Napista wallify ohjelma pyyhkii ensin kartan tyhjäksi, jonka jälkeen se arpoo noin yhden kolmasosan alueesta seinäksi. Tämän jälkeen voit itse valita maalin ja aloituspaikan. Clear all Pyyhkii koko kartan tyhjäksi.

Napit DFS, BFS ja Astar käynnistävät reitinhaun. Mikäli aloitusta ja maalia ei ole valittu, haku ei käynnisty. Haun kesto tulostuu konsoliin. Haun edetessä tummanharmaaksi muuttuneet ruudut ovat käytyjä ruutuja, sininen on löydetty reitti. DFS tekee syvyyssuuntaisen haun, BFS leveyssuuntaisen ja Astar käynnistää A*-haun.

Napilla test avautuu konsoliin tekstipohjainen liittymä reittihakujen testaukselle. Voit määrittää kartan koon, sekä testien määrän. Ohjelma arpoo satunnaisesti testien määrän läpäistäviä karttoja, ja suorittaa hakualgoritmit niissä. Suoritettujen hakujen jälkeen se laskee keskiarvojen jokaiselle hakualgoritmille, ja tulostaa tiedot konsoliin. Kirjoittamalla 'y', voit yrittää uudestaan. Mikäli annetuilla luvuilla ei löydy ratkaistavaa karttaa 30:llä yrityksellä, testi keskeytetään.
