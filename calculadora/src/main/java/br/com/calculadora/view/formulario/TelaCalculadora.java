package br.com.calculadora.view.formulario;

import javax.swing.*;

public class TelaCalculadora extends JFrame {

    private JButton botaoSomar;
    private JButton botaoSubtrair;
    private JButton botaoMultiplicar;
    private JButton botaoDividir;
    private JButton botaoLimpar;
    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JTextField campoResultado;


    public TelaCalculadora(){
        setTitle("Calculadora");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

       

        setVisible(true);
    }




    public static void main(String[] args) {
        new TelaCalculadora();
    }
    
}
