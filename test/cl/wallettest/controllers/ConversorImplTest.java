package cl.wallettest.controllers;

import cl.wallettest.controllers.interfaces.ConversorMoneda;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConversorImplTest {

    @Mock
    Scanner scannerMock;

    @BeforeEach
    public void setup(){
        this.scannerMock = new Scanner(System.in);
    }

    @Test
    void transformarSaldoaMoneda() {
        //Scanner scannerMock = mock(Scanner.class);
        // Cuando le envío el  argumento del mock ,espero un resultado
        when( scannerMock.nextDouble() ).thenReturn(960.0);
        when( scannerMock.nextLine() ).thenReturn("$");

        ConversorMoneda conversor = new ConversorImpl(scannerMock);
        double saldoCuenta = 500000.0;
        double resultadoEsperadoConversion = 520.8333333333334;
        String resultadoConversion = conversor.transformarSaldoaMoneda(saldoCuenta);
        String resultadoEsperado = "Saldo en $ es: " + resultadoEsperadoConversion;

        verify(scannerMock).nextDouble();
        verify(scannerMock).nextLine();

        assertEquals(resultadoEsperado,resultadoConversion);
    }
}