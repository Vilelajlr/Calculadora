package br.com.calculadora.model.dominio;

public class Somar {

    private double resultado;

    public Somar(){
        this.resultado = 0;
    }

    public double getResultado() {
        return resultado;
    }

    public void adicionar(double valor){
        this.resultado += valor;
    }

    public void reset(){
        this.resultado = 0;
    }


    
}
