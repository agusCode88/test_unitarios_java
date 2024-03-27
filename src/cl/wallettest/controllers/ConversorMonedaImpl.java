package cl.wallettest.controllers;

import cl.wallettest.controllers.interfaces.ConversorMoneda;

import java.util.Scanner;

public class ConversorMonedaImpl implements ConversorMoneda {

    Scanner scanner;

    public ConversorMonedaImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public double obtenerValorMoneda() {
        System.out.println("Ingrese el valor de la moneda:");
        double valorMoneda = scanner.nextDouble();
        return valorMoneda;
    }

    @Override
    public String obtenerSimboloMoneda() {
        System.out.println("Ingrese el símbolo de la moneda:");
        String simBoloMoneda = scanner.nextLine();
        return simBoloMoneda;
    }

    @Override
    public String transformarSaldoAMoneda(double saldoCuenta) {
        double valorMoneda = obtenerValorMoneda();
        String simboloMoneda = obtenerSimboloMoneda();
        double saldoTransformado = saldoCuenta/valorMoneda;

        return "El saldo en " + simboloMoneda + "es: " + saldoTransformado;
    }
}
