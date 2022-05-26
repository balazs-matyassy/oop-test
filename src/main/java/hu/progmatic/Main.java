package hu.progmatic;

import hu.progmatic.model.Cargo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        try {
            List<Cargo> cargos = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("cargo.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    cargos.add(new Cargo(line));
                }
            }

            System.out.println("Kérek egy szűrőt (az egyes feltételek vesszővel vannak elválasztva).");
            String filterValues = scanner.nextLine();
            CargoFilter filter = new CargoFilter(filterValues);
            filter.filter(cargos);

            System.out.println("A feltételeknek megfelelő szállítmányok:");
            for (Cargo cargo : cargos) {
                System.out.println(cargo);
            }
        } catch (IOException e) {

        }
    }
}
