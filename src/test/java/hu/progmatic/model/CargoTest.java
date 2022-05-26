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
}