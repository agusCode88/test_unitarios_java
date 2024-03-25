package cl.wallettest.controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 */
class CuentaBancariaTest {

    CuentaBancaria cuentaBaancariaTest;

    @BeforeEach
    public void configuration(){
        cuentaBaancariaTest = new CuentaBancaria();
    }

    @Test
    void verificarEdadUsuarioMayor() {
        boolean ismayorEdad = cuentaBaancariaTest.verificarEdadUsuario(35);
        assertEquals(true, ismayorEdad);
    }

    @Test
    void verificarUsuarioEdadMenor(){
        boolean isMayoredad = cuentaBaancariaTest.verificarEdadUsuario(17);
        assertEquals( false , isMayoredad);
    }


    @Test
    void saludoMayorEdad() {
        cuentaBaancariaTest.saludoMayorEdad(20);
        boolean isMayorEdad = cuentaBaancariaTest.getEsMayorEdad();
        assertEquals(true,isMayorEdad);
    }
}