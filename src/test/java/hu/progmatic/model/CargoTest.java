package hu.progmatic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {
    @Test
    public void whenCargoCreated_thenDefaultConstructorOk() {
        Cargo cargo = new Cargo();

        assertNull(cargo.getDate());
    }
}