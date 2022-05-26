package hu.progmatic;

import hu.progmatic.model.Cargo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CargoFilterTest {
    private List<Cargo> cargos;

    @BeforeEach
    public void initTest() {
        cargos = new ArrayList<>();
        cargos.add(new Cargo("2250.01.01;Hold;Ganymedes;Nyersanyagok;353"));
        cargos.add(new Cargo("2250.01.02;Mars;Föld;Műszaki cikkek;543"));
        cargos.add(new Cargo("2250.01.03;Föld;Ganymedes;Energiahordozók;504"));
        cargos.add(new Cargo("2250.01.03;Ganymedes;Hold;Élelmiszer;432"));
        cargos.add(new Cargo("2250.01.04;Hold;Ganymedes;Nyersanyagok;91"));
    }

    @Test
    public void whenNoConditions_thenFilterOk() {
        CargoFilter filter = new CargoFilter();
        filter.filter(cargos);

        assertEquals(5, cargos.size());
    }

    @Test
    public void whenTypeSpecified_thenFilterOk() {
        CargoFilter filter = new CargoFilter();
        filter.setType("Nyersanyagok");
        filter.filter(cargos);

        assertEquals(2, cargos.size());
    }

    @Test
    public void whenDateSpecified_thenFilterOk() {
        CargoFilter filter = new CargoFilter("2250.01.02", "2250.01.03");
        filter.filter(cargos);

        assertEquals(3, cargos.size());
    }
}