# **ALGO GYAKORLÓ FELADAT**

**Bevezetés**  
Ebben a feladatban egy metódust kell létrehoznod, ami egy tömböt dolgoz fel.  
A `main` metódusban próbálhatod ki a kódodat, illetve használd az előre megírt teszteseteket az algoritmusod kipróbálására! A kiadott teszteseteken ne módosíts!

**Feladatleírás**  
Írj egy metódust a `hu.nive.ujratervezes.decoder.Decoder` osztályban a következő specifikácó alapján:  
a metódus neve: `decode`  
a metódus bemeneti paramétere: `code`, egy egész számokat tartalmazó tömb int[]  
visszatérési értéke: A dekódolt szöveg String

A decode metódus olvasható szöveget készít a számokból a következő szabályok alapján:  
1. az első szám (ha van) az első betű ASCII kódjának a négyzetgyöke  
2. minden további szám azt adja meg, hogy az adott betű ASCII kódja milyen messze van az előző betű Ascii kódjától

**Kivételkezelés:**  
ha a metódust úgy hívjuk meg, hogy a `code` paraméter egy üres tömb, akkor adjon vissza egy új, üres String-et  
ha a metódust úgy hívjuk meg, hogy a `code` paraméter értéke null, akkor dobjon `IllegalArgumentException`-t

Példák

| Code | Eredmény |
|-----|-----|
| [10] | d |
| [10, 0, 0] | ddd |
| [10,1,7,-7,15,-15] | delete |
| [ ] | |
