package hu.progmatic.constructor;

public class Person {
    private String name;
    private int birthYear;
    private int age;
    private String[] pets;
    private boolean hasCat;

    // 1. nincs visszatérési érték
    // 2. a metódus megegyezik az osztály nevével
    // 3. nem kötelező public láthatóságot kapnia (lehet pl. protected, package, private)
    //      ha pl. package a láthatóság, akkor csomagon kívül nem működik a new Person() hívás
    // new Person();
    public Person() {

    }

    // overloading (túlterhelés)
    // a ténylegesen meghívott konstruktort a szignatúra határozza meg
    // new Person("Pista");
    public Person(String name) {
        this.name = name;
    }

    // new Person("Pista", 1990);
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        // nem kötelező mindig mindegyik nem final mezőt beállítani
        this.age = 2022 - birthYear;
    }

    // new Person("Pista", 1990, 32);
    public Person(String name, int birthYear, int age) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = age;
    }

    public Person(String name, String[] pets) {
        this.name = name;
        this.pets = pets;

        for (String pet : pets) {
            if (pet.equals("macska")) {
                this.hasCat = true;
                break;
            }
        }
    }
}
