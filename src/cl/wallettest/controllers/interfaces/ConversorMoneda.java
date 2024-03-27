package cl.wallettest.controllers.interfaces;

public interface ConversorMoneda {
    double obtenerValorMoneda();
    String obtenerSimboloMoneda();
    String transformarSaldoAMoneda(double saldoCuenta);
}
