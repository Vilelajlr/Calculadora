package br.com.calculadora.model.dominio;

public class Dividir {

    private double resultado;

    public Dividir(){
        this.resultado = 0;
    }

    public double getResultado() {
        return resultado;
    }

    public void dividir(double valor){
        this.resultado /= valor;
    }

    public void reset(){
        this.resultado = 0;
    }
    
}
