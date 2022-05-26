package hu.progmatic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {
    @Test
    public void whenDefaultConstructorUsed_thenValuesOk() {
        Cargo cargo = new Cargo();

        assertNull(cargo.getDate());
        assertNull(cargo.getSource());
        assertNull(cargo.getDestination());
        assertNull(cargo.getType());
        assertEquals(0, cargo.getValue());
    }

    @Test
    public void whenValuesConstructorUsed_thenValuesOk() {
        Cargo cargo = new Cargo("2250.01.01", "Hold", "Ganymedes", "Nyersanyagok", 353);

        assertEquals("2250.01.01", cargo.getDate());
        assertEquals("Hold", cargo.getSource());
        assertEquals("Ganymedes", cargo.getDestination());
        assertEquals("Nyersanyagok", cargo.getType());
        assertEquals(353, cargo.getValue());
    }

    @Test
    public void whenLineConstructorUsed_thenValuesOk() {
        Cargo cargo = new Cargo("2250.01.01;Hold;Ganymedes;Nyersanyagok;353");

        assertEquals("2250.01.01", cargo.getDate());
        assertEquals("Hold", cargo.getSource());
        assertEquals("Ganymedes", cargo.getDestination());
        assertEquals("Nyersanyagok", cargo.getType());
        assertEquals(353, cargo.getValue());
    }

    @Test
    void getGrossValue() {
        Cargo cargo = new Cargo("2250.01.01", "Hold", "Ganymedes", "Nyersanyagok", 1000);

        assertEquals(1100, cargo.getGrossValue());
        cargo.setValue(1004);
        assertEquals(1104, cargo.getGrossValue());
        cargo.setValue(1005);
        assertEquals(1106, cargo.getGrossValue());
    }

    @Test
    void getTax() {
        Cargo cargo = new Cargo("2250.01.01", "Hold", "Ganymedes", "Nyersanyagok", 1000);

        assertEquals(100, cargo.getTax());
        cargo.setValue(1004);
        assertEquals(100, cargo.getTax());
        cargo.setValue(1005);
        assertEquals(101, cargo.getTax());
    }
}