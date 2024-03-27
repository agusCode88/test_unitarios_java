package cl.wallettest.controllers;

import cl.wallettest.controllers.interfaces.ConversorMoneda;

import java.util.Scanner;

public class CuentaBancaria  {

    private boolean esMayorEdad;
    private double saldoCuenta;


    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public boolean getEsMayorEdad() {
        return esMayorEdad;
    }

    public boolean verificarEdadUsuario(int edadUsuario){

          this.esMayorEdad
                  = ( edadUsuario >=18)
                  ? true
                  : false;

          return this.esMayorEdad;
      }
      public void saludoMayorEdad( int edadUsuario){
             this.esMayorEdad = verificarEdadUsuario(edadUsuario);
      }

    public double depositarPrimeraVez(double saldoInicial) {

        if(saldoInicial >= 100000){
            this.saldoCuenta = saldoInicial;
        } else {
            this.saldoCuenta = 0;
        }

        return this.saldoCuenta;
    }


    public double hacerDeposito(double valorAdepositar) {

        if( this.saldoCuenta > 0 && valorAdepositar > 0 ){
            this.saldoCuenta += valorAdepositar;
        }

        return this.saldoCuenta;
    }

    public double hacerRetiro(double valorAretirar) {

        if( (this.saldoCuenta - valorAretirar) >= 0){
            this.saldoCuenta -= valorAretirar;
        }

        return this.saldoCuenta;
    }

    public String convertirMoneda(Scanner scanner){

        ConversorMonedaImpl conversor = new ConversorMonedaImpl(scanner);
        return conversor.transformarSaldoAMoneda(this.saldoCuenta);
    }

}
