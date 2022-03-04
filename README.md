# Több csillagos Csillagrendszer
Ebben a feladatban egy csillagrendszert kell modelezned.

Minden osztályodat a s `hu.nive.ujratervezes.starsystem` packagben kell létrehozni.

A `Main` osztály `main` metódusában próbálhatod ki a kódodat, illetve használd
az előre megírt teszteseteket az algoritmusod kipróbálására!

## Feladatleírás
Implementáld az alábbi leírás szerinti programot:

### hu.nive.ujratervezes.starsystem.StarSystemObject
tulajdonságai:
- `String id` ami az űrbeli objektum neve. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy `String getId()` getter.

### hu.nive.ujratervezes.starsystem.PlanetCategory
Egy enum ami a `BIG` és a `SMALL` értékeket veheti fel.

### hu.nive.ujratervezes.starsystem.StarCategory
Egy enum ami a `DWARF`, `GIANT`, `SUPER_GIANT` értékeket veheti fel.

### hu.nive.ujratervezes.starsystem.Planet
Az összes `Planet` egyben `StarSystemObject` is.
Ezen felül tulajdonsága:
- `PlanetCategory planetCategory` a bolygó tipusa. 
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `PlanetCategory getPlanetCategory()` getter.
    

### hu.nive.ujratervezes.starsystem.Star
Az összes `Star`  egyben `StarSystemObject` is.
Ezen felül tulajdonsága:
- `StarCategory starCategory`  a csillag tipusa. 
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `StarCategory getStarCategory()` getter.
    - Tartozik hozzá egy `void setStarCategory(StarCategory starCategory)` setter.

### hu.nive.ujratervezes.starsystem.StarSystem
Tulajdonsága:
- `List<Planet> planets` a bolygók listája. 
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `List<Planet> getPlanets()` getter.
- `List<Star> stars` a csillagok listája. 
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `List<Star> getStars()` getter.

Metodusai:
- `List<Planet> filterPlanetCategory(PlanetCategory planetCategory)` vissza adja azokat a bolygókat, amiknek tipusa a paraméterben kapott tipus.
- `boolean hasMultipleStar()` vissza adja, hogy több csillagból áll e a rendszer.
- `void removeByPlanetCategory(PlanetCategory planetCategory)` eltávolítja a bolygók közül azokat melyeknek tipusa a paraméterben kapott tipus.
- `int countByStarCategory(StarCategory starCategory)` vissza adja, hogy az adott típusú csillagból hány darab van.
