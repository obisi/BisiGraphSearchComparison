# Viikko 2:

GUI aloitettu. JFrame vaihdettu Javax. Alustava toimiva versio GUI:sta saatu aikaan, myöskin opeteltu tekemään testit luokkien
metodeille. GUI on kamalan näköinen, mutta ajaa asiansa nyt väliaikaisesti. BFS ja DFS ilmeisesti toimivat, tosin reitti
näyttää piirrettynä välillä oudolta. En vielä keksinyt, mistä se voisi johtua. Koodin dokumentointi puuttuu vielä, kun aika
tuntui loppuvan kesken. Piirtäminen ei myöskään mene nätisti kuten ajattelin. Tietenkin se tapahtuu niin nopeasti, ettei
kerkeä erottaa mitä milloinkin tapahtuu. Tämä ei tullut mieleen, kun hahmottelin sovelluksen toimintaa. Järkevämpi tyyli voisi
olla laskea haku ensin pelkälle verkolle, tallentaa aika ja vaiheet, sitten piirtää animationtimerilla animaatio josta saisi
jopa jotain selvää. Katsellaan, miten aika riittää.

Ongelmia on tuli ainakin GUI:n kanssa ja testien kanssa. Hakua ei voi suorittaa kahdesti samalla ajokerralla, vaikka nodet
nollaisi reset-metodilla. En tajua mistä voisi johtua. Testeissä en saanut (vanhoja) DFS ja BFS enää toimimaan. Nullpointer
exception, en kerennyt etsiä missä voisi olla vika. Toisaalta, ne toimivat oikein aiemmin, joten suurta vikaa itse algoritmissa
ei ole. Eikä vanhoja todennäköisesti enää käytetä muutenkaan, mutta testauksen kannalta olisivat olleet helpommat. Myöskin
iso osa metodeja jää testaamatta, kun en tiennyt miten testata GUI:n osia. Myöskin logiikan pilkkominen hankaloitui, kun
yhdistin GUI-elementtejä Graph- ja Node- luokkiin.

Testauksen alkeet opin ainakin tällä viikolla, kun sitä en ollut aiemmin tehnyt. GUI:n kanssa aina oppii jotain uutta, kuten nyt
että piirtäminen on niin nopeaa (tietenkin), ettei ihmissilmä ehdi huomata pikselien vaihtumista. Olisi pitänyt tajuta jo aiemmin.

Ensi viikolla voisi olla aika lisätä Astar ja lisäksi parannella testejä, dokumentoida koodia, sekä selventää ohjelman rakennetta.

Käytetty aika: n. 7h. Dokumentaatio n.0,5h, testaukset 2h, 4-5h muuhun koodaukseen.
