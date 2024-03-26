package cl.wallettest.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 *
 */
class CuentaBancariaTest {

    public static CuentaBancaria cuentaBaancariaTest;
    int edadMayor = 0;
    int edadMenor = 0;
    double saldoInicial=0;

    double saldoInicialMinimo=0;

    @BeforeAll
    public static void configuration(){
        cuentaBaancariaTest = new CuentaBancaria();
        //Aca se conecta a una Base de datos
    }
    @BeforeEach
    void setupTest(){
         this.edadMayor = 35;
         this.edadMenor = 0;
         this.saldoInicial = 150000;
         this.saldoInicialMinimo = 95000;
    }
    @Test
    void verificarEdadUsuarioMayor() {
        boolean ismayorEdad = cuentaBaancariaTest.verificarEdadUsuario(this.edadMayor);
        System.out.println("CAI ACA1 " + this.edadMayor);
        assertEquals(true, ismayorEdad);
    }

    @Test
    void verificarUsuarioEdadMenor(){
        boolean isMayoredad = cuentaBaancariaTest.verificarEdadUsuario(this.edadMenor);
        assertEquals( false , isMayoredad);
    }

    @Test
    void saludoMayorEdad() {
        cuentaBaancariaTest.saludoMayorEdad(20);
        boolean isMayorEdad = cuentaBaancariaTest.getEsMayorEdad();
        assertEquals(true,isMayorEdad);
    }

    @Test
    void abrirCuentaCorrienteConSaldo(){

        //double saldoCuenta = cuentaBaancariaTest.getSaldoCuenta();
        double saldoCuenta = cuentaBaancariaTest.depositarPrimeraVez(this.saldoInicial);
        assertEquals( cuentaBaancariaTest.getSaldoCuenta(), saldoCuenta );
        System.out.println(cuentaBaancariaTest.getSaldoCuenta());
    }

    @Test
    void abrirCunetaCorrienteConSaldoPequenio(){

        double saldoCuenta = cuentaBaancariaTest.depositarPrimeraVez(this.saldoInicialMinimo);
        assertEquals( cuentaBaancariaTest.getSaldoCuenta(), saldoCuenta );
        System.out.println(cuentaBaancariaTest.getSaldoCuenta());
    }

    @Test
    void depositarEnLaCuentaCorriente() {

        double valorAdepositar = 12000;
        cuentaBaancariaTest.setSaldoCuenta(1000);
        double saldoCuenta = cuentaBaancariaTest.getSaldoCuenta();
        double saldoEsperado = saldoCuenta + valorAdepositar;
        assertEquals( saldoEsperado , cuentaBaancariaTest.hacerDeposito(valorAdepositar));
        System.out.println("Saldo Cuenta " + cuentaBaancariaTest.getSaldoCuenta());
    }

    @Test
    void retirarDelaCuentaCorriente(){
        double valorAretirar = 20000;
        cuentaBaancariaTest.setSaldoCuenta(20000);
        double saldoCuenta = cuentaBaancariaTest.getSaldoCuenta();
        double saldoEsperado = saldoCuenta - valorAretirar;
        assertEquals(saldoEsperado , cuentaBaancariaTest.hacerRetiro(valorAretirar));
        System.out.println("El saldo es de :" + cuentaBaancariaTest.getSaldoCuenta());

    }
    @AfterEach
    void limpieza(){
        System.out.println("Se ejecuta el AfterEach");
        this.edadMenor = 0;
        this.edadMayor = 0;
    }
    @AfterAll
    public static void limpiezaConfigracion(){
        cuentaBaancariaTest = null;
        // Aca se libera la base de datos, se desconecta
    }
}