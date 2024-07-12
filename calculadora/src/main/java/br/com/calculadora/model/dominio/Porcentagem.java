package br.com.calculadora.model.dominio;

public class Porcentagem {

    private double resultado;

    public Porcentagem(){
        this.resultado = 0;
    }

    public double getResultado() {
        return resultado;
    }

    public void calcularPorcentagem(double valor, double porcentagem){
        this.resultado = (valor * porcentagem) / 100;
    }

    public void reset(){
        this.resultado = 0;
    }
    
    
}
