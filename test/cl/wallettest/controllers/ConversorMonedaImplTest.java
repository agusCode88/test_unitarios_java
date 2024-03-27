package cl.wallettest.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Scanner;
import cl.wallettest.controllers.interfaces.ConversorMoneda;
import org.junit.jupiter.api.Test;

class ConversorMonedaImplTest {

    @Test
    void transformarSaldoAMoneda() {

        Scanner scannerMock = mock(Scanner.class);
        when( scannerMock.nextDouble() ).thenReturn ( 1000.0 );
        when( scannerMock.nextLine() ).thenReturn( "$" );

        ConversorMoneda conversor = new ConversorMonedaImpl( scannerMock );
        double valorEsperadoMoneda = 500.0;
        String valorDevueltoConversor = conversor.transformarSaldoAMoneda(500000.0);
        String valorEsperadoFinal = "El saldo en " + "$" + "es: " + valorEsperadoMoneda;

        verify(scannerMock).nextDouble();
        verify(scannerMock).nextLine();

        assertEquals(valorDevueltoConversor,valorEsperadoFinal);

    }
}