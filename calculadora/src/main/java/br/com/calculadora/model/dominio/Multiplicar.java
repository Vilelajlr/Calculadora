package br.com.calculadora.model.dominio;

public class Multiplicar {

    private double resultado;

    public Multiplicar(){
        this.resultado = 0;
    }

    public double getResultado() {
        return resultado;
    }

    public void multiplicar(double valor){
        this.resultado *= valor;
    }

    public void reset(){
        this.resultado = 0;
    }
    
    
}
