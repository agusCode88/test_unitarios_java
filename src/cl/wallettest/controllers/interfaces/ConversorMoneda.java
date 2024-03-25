package cl.wallettest.controllers.interfaces;

public interface ConversorMoneda {
    double obTenerValorMoneda();

    double transformarMoneda(double valorSaldoCuenta);

    String obtenerSimboloMoneda();
}
