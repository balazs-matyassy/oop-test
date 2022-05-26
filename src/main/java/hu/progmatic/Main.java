package hu.progmatic;

import hu.progmatic.model.Cargo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Hozzunk létre egy Cargo osztályt
        // 2. Legyen 3 konstruktor
        //      - default (TEST)
        //      - minden értéket beállító (TEST)
        //      - a csv fájl egy sorából minden értéket beállító (TEST)
        // 3. Legyenek getterek + setterek
        // 4. Legyen egy grossValue (10% adó kerekítve) és egy tax (10% adó kerekítve) számított getter.
        // 5. Az "Élelmiszer"-ek adója 0%.
        // 6. Hozzunk lére egy CargoFilter osztályt
        // A szűrés a következő paraméterek szerint működjön:
        //      - date (-tól), date (-ig)
        //      - source
        //      - destination
        //      - type
        //      - value (-tól), value (-ig)
        // Ha az egyik paraméter nincs megadva (null), akkor ne szűrjünk a paraméter szerint.
        // A CargoFilter rendelkezzen egy void filter(Collection<Cargo> cargos) metódussal.
        // Nem illeszkedő elemeket töröljük.
        try {
            List<Cargo> cargos = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("cargo.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    cargos.add(new Cargo(line));
                }
            }
        } catch (IOException e) {

        }
    }
}
