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
    void whenNotFood_thenGrossValuePlusTenPercent() {
        Cargo cargo = new Cargo("2250.01.01", "Hold", "Ganymedes", "Nyersanyagok", 1000);

        assertEquals(1100, cargo.getGrossValue());
        cargo.setValue(1004);
        assertEquals(1104, cargo.getGrossValue());
        cargo.setValue(1005);
        assertEquals(1106, cargo.getGrossValue());
    }

    @Test
    void whenFood_thenGrossValueUnchanged() {
        Cargo cargo = new Cargo("2250.01.01", "Hold", "Ganymedes", "Élelmiszer", 1000);

        assertEquals(1000, cargo.getGrossValue());
        cargo.setValue(1004);
        assertEquals(1004, cargo.getGrossValue());
        cargo.setValue(1005);
        assertEquals(1005, cargo.getGrossValue());
    }

    @Test
    void whenNotFood_thenTaxTenPercent() {
        Cargo cargo = new Cargo("2250.01.01", "Hold", "Ganymedes", "Nyersanyagok", 1000);

        assertEquals(100, cargo.getTax());
        cargo.setValue(1004);
        assertEquals(100, cargo.getTax());
        cargo.setValue(1005);
        assertEquals(101, cargo.getTax());
    }

    @Test
    void whenFood_thenTaxZeroPercent() {
        Cargo cargo = new Cargo("2250.01.01", "Hold", "Ganymedes", "Élelmiszer", 1000);

        assertEquals(0, cargo.getTax());
        cargo.setValue(1004);
        assertEquals(0, cargo.getTax());
        cargo.setValue(1005);
        assertEquals(0, cargo.getTax());
    }
}