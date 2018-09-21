# Viikko 3:

Tällä viikolla tein BFS:n ja DFS:n tietorakenteet valmiiksi, eli stack ja queue -luokat. Tein alustavan A*-algoritmin,
jota en vielä päässyt testaamaan. Testaamista varten olisi täytynyt luoda uusi comparator omille luokilleni, joten päätinkin
aloittaa suoraan oman tietorakenteen rakentamisen turhan välivaiheen poisjättämiseksi. Minimikeko, jota A* tulee käyttämään, on
aloitettu, mutta pahasti kesken. Path-luokkien vertailu ilmeisesti ontuu, jonka takia minimikeko ei oikein suostu siirtelemään
olioita omille paikolleen keossa.

Minimikeon yllättävien ongelmien takia muun toiminnallisuuden lisääminen jäi hieman vähäiseksi, mutta tietorakenteet DFS ja BFS
ovat sentään valmiit. Astar pitäisi myös toimia, kunhan minimikeon saa toimimaan.

Ongelmia tällä viikolla tuotti minimikeko, sekä Pathien vertailu. Sovelluksen logiikka jää valitettavasti myöhemmille viikoille
uudelleen rakennettavaksi, jos kerkeää. Tarkoituksena olisi piirtää vielä läpikäynti animationtimerilla. Lopullisen sovelluksen
logiikka olisi siis ehkä ensin antaa käyttäjän valita lähtö, maali ja seinät, laskea reitit ja ajat hakualgoritmeilla ja lopuksi
piirtää eri reitit animationtimerilla, jotta näkee kuinka reitinhaku toimi.

Tuntejä käytetty tällä viikolla yhteensä noin 10, josta koko aika meni ohjelmointiin.
