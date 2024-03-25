package cl.wallettest.controllers;

import cl.wallettest.controllers.interfaces.ConversorMoneda;

public class CuentaBancariaImpl implements ConversorMoneda {
    @Override
    public double obTenerValorMoneda() {
        return 1000;
    }

    @Override
    public double transformarMoneda(double valorSaldoCuenta) {
        return valorSaldoCuenta / obTenerValorMoneda();
    }

    @Override
    public String obtenerSimboloMoneda() {
        return "$";
    }
}
