package cl.wallettest.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 */
class CuentaBancariaTest {

    CuentaBancaria cuentaBaancariaTest;
    CuentaBancariaImpl cuentaImpl;

    double valorInicial = 100000;
    double valorDeposito= 150000;
    double valorAretirar = 50000;

    @BeforeEach
    public void configuration(){
        cuentaBaancariaTest = new CuentaBancaria();
        cuentaBaancariaTest.setSaldoCuenta(100000);
        cuentaImpl = new CuentaBancariaImpl();
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
    @Test
    public void testDepositoInicialCeroCuenta(){
        assertEquals(0,cuentaBaancariaTest.getSaldoCuenta());
    }
    @Test
    public void testDepositoInicialCuenta(){
        String textoSalida = "Saldo incial: ";
        String textoSalidaEsperado = textoSalida + valorInicial;
        cuentaBaancariaTest.depositarSaldoInicial( valorInicial );
        String textoSalidaConsaldo = textoSalida + cuentaBaancariaTest.getSaldoCuenta();
        assertEquals(textoSalidaEsperado,textoSalidaConsaldo);
    }

    @Test
    public void depositoAlaCuenta(){
        double valorSaldoCuenta = cuentaBaancariaTest.getSaldoCuenta();
        double valorDespuesDeposito = valorDeposito + valorSaldoCuenta;
        cuentaBaancariaTest.despositoAlaCuenta(valorDeposito);
        assertEquals(valorDespuesDeposito , cuentaBaancariaTest.getSaldoCuenta());
    }

    @Test
    public void retiroALaCuenta(){
        double valorSaldoCuenta = cuentaBaancariaTest.getSaldoCuenta();
        double valorDespuesRetiro = valorSaldoCuenta - valorAretirar;
        cuentaBaancariaTest.retirarEnLaCuenta(valorAretirar);
        assertEquals( valorDespuesRetiro , cuentaBaancariaTest.getSaldoCuenta());
    }

    @Test
    public void transformarSaldoEnDolares(){
        double valorSaldoCuenta = cuentaBaancariaTest.getSaldoCuenta();
        double valorSaldoEnDolares = cuentaImpl.transformarMoneda(valorSaldoCuenta);
        String simboloMoneda= cuentaImpl.obtenerSimboloMoneda();
        double valorEsperadoDolar = valorSaldoEnDolares / cuentaImpl.obTenerValorMoneda();
        String valorSalidaConversor =  valorEsperadoDolar + simboloMoneda;
        assertEquals(valorEsperadoDolar + simboloMoneda, valorSalidaConversor);

    }
    
}