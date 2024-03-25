package cl.wallettest.controllers;

public class CuentaBancaria {

    private boolean esMayorEdad;

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

}
