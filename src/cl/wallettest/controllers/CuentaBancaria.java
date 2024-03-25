package cl.wallettest.controllers;

public class CuentaBancaria {

    private boolean esMayorEdad;
    private double saldoCuenta;

    private CuentaBancariaImpl cuentaBancariaImpl;

    public CuentaBancaria() {
        this.saldoCuenta = 0;
        this.cuentaBancariaImpl = new CuentaBancariaImpl();

    }

    public boolean getEsMayorEdad() {
        return esMayorEdad;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
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

    public void depositarSaldoInicial(double saldoDepositado) {

        if( this.saldoCuenta == 0){
            this.saldoCuenta = this.saldoCuenta + saldoDepositado;
            System.out.println("Cuenta corriente creada");
            System.out.println("Saldo incial: " + this.saldoCuenta);
        }else{
            throw new IllegalStateException("La cuenta corriente ya fue creada y tiene saldo");
        }
    }

    public double despositoAlaCuenta(double valorDeposito) {

        this.saldoCuenta
                = ( valorDeposito > 0 )
                ? this.saldoCuenta + valorDeposito
                : this.saldoCuenta;

        return this.saldoCuenta;
    }

    public double retirarEnLaCuenta(double valorAretirar) {

        this.saldoCuenta
                = ( this.saldoCuenta  > 0 && valorAretirar <= this.saldoCuenta  )
                ? this.saldoCuenta - valorAretirar
                : this.saldoCuenta;

        return this.saldoCuenta;
    }

    public String transformarSaldoEnDolares(){

        double valorCuentaEnDolares = cuentaBancariaImpl.transformarMoneda(this.saldoCuenta);
        String signoDolar = cuentaBancariaImpl.obtenerSimboloMoneda();
        String mostraSaldoEnDolares = valorCuentaEnDolares + signoDolar;

        return mostraSaldoEnDolares;

    }
}
