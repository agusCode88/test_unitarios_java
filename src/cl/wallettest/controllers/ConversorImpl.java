package cl.wallettest.controllers;

import cl.wallettest.controllers.interfaces.ConversorMoneda;

import java.util.Scanner;

public class ConversorImpl implements ConversorMoneda {

    private Scanner scanner;

    public ConversorImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public double obtenerValorMoneda() {
        System.out.println("Ingrese el valor de la moneda");
        double valorMoneda = scanner.nextDouble();

        return valorMoneda;
    }

    @Override
    public String obtenerSimboloMoneda() {
        System.out.println("Ingrese el símbolo de la moneda");
        return scanner.nextLine();
    }

    @Override
    public String transformarSaldoaMoneda(double saldoCuenta) {
        double valorMoneda = obtenerValorMoneda();
        String simboloMoneda = obtenerSimboloMoneda();
        double saldoTransformado = saldoCuenta / valorMoneda;

        return "Saldo en " + simboloMoneda +  " es: " + saldoTransformado;
    }
}
