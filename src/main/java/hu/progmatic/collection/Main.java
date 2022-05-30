package hu.progmatic.collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // utazás: sorrend fontos, lehet ismétlődés
        List<String> route = new ArrayList<>();
        route.add("Budapest");
        route.add("Párizs");
        route.add("Budapest");
        route.add("Berlin");
        route.add("Budapest");

        for (int i = 0; i < route.size(); i++) {
            System.out.println(route.get(i));
        }

        for (String city : route) {
            System.out.println(city);
        }

        // meglátogatott városok: nem lehet ismétlődés, nem számít a sorrend
        // a Set és a List képes egy kollekcióból (Collection) létrehozni magát
        // Set<String> visitedCities = new TreeSet<>(route);
        Set<String> visitedCities = new TreeSet<>();
        visitedCities.add("Budapest");
        visitedCities.add("Párizs");
        visitedCities.add("Budapest"); // ez már nem kerül bele a Set-be
        visitedCities.add("Berlin");
        visitedCities.add("Budapest"); // ez már nem kerül bele a Set-be

        // TreeSet esetében ábécé szerint rendezett sorrendben
        // HashSet véletlenszerű sorrendben,
        // de minden elem pontosan egyszer kerül kiírásra
        for (String city : visitedCities) {
            System.out.println(city);
        }

        // TreeSet-ben olyan elemek lehetnek,
        // akik implementálják a Comparable interfészt
        // String -> abc szerint növekvő
        // Integer -> növekvő
        // ha az alapértelmezett rendezés nem megfelelő,
        // akkor külső komparátor segítségével lehet rendezni

        // függvényszerű kapcsolat (pl. látogatások száma)
        // Budapest -> 3
        // Berlin -> 1
        // Párizs -> 1
        Map<String, Integer> visitNumberByCities = new TreeMap<>();

        for (String city : route) {
            // első alkalommal null helyett 0-t adjon
            // semmit nem lehet kicsomagolni
            // Integer = doboz + érték, null -> üres doboz
            // int = érték, ez nem lehet üres (doboz nélkül nem tudjuk jelezni)
            // null érték esetében nem működik az unboxing ("kicsomagolás")
            // ami az int-hez való hozzárendeléshez vagy összeadáshoz kellene
            int oldVisitNumber = visitNumberByCities.getOrDefault(city, 0);
            // null + 1 nem jó, viszont 0 + 1 az elvárt értéket adja vissza
            visitNumberByCities.put(city, oldVisitNumber + 1);
        }

        // meglátogatott városok kiírása (kucslok szerinti bejárás)
        // kiválthatja a kulcs-érték párok szerinti bejárás
        // int visitNumber = visitNumberByCities.get(city);
        for (String city : visitNumberByCities.keySet()) {
            // int visitNumber = visitNumberByCities.get(city);
            System.out.println(city);
        }

        // értékek szerint bejárás
        // Pl. maximum hányszor voltunk egy városban?
        for (int visitNumber : visitNumberByCities.values()) {
            System.out.println(visitNumber);
        }

        // kulcs-érték párok szerinti bejárás
        // egyszerre "pörgeti" a várost és a hozzá tartozó értéket
        for (Map.Entry<String, Integer> visitBumberByCity : visitNumberByCities.entrySet()) {
            // key -> város
            // value -> látogatások száma
            System.out.println(visitBumberByCity.getKey() + ": " + visitBumberByCity.getValue());
        }
    }
}
