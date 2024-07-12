package br.com.calculadora.model.dominio;

public class Subtrair {

    private double resultado;

    public Subtrair(){
        this.resultado = 0;
    }

    public double getResultado() {
        return resultado;
    }

    public void subtrair(double valor){
        this.resultado -= valor;
    }

    public void reset(){
        this.resultado = 0;
    }
    
}
