package br.com.calculadora.view.formulario;

import javax.swing.*;

import br.com.calculadora.model.dominio.Somar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraLayout extends JFrame {

    private JTextField displayPrincipal;
    private JTextField displayOperacao;
    private boolean operadorPressionado = false;
    private String operacaoAtual = "";
    private double valorAtual = 0.0;

    public CalculadoraLayout() {
        // Configuração da janela principal
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação do painel principal com layout BorderLayout
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Campo de texto para exibir a operação atual
        displayOperacao = new JTextField();
        displayOperacao.setHorizontalAlignment(JTextField.RIGHT);
        displayOperacao.setEditable(false);
        displayOperacao.setFont(new Font("Arial", Font.PLAIN, 18));
        displayOperacao.setPreferredSize(new Dimension(300, 30));
        painelPrincipal.add(displayOperacao, BorderLayout.NORTH);

        // Campo de texto para exibir os números e resultados
        displayPrincipal = new JTextField("0");
        displayPrincipal.setHorizontalAlignment(JTextField.RIGHT);
        displayPrincipal.setEditable(false);
        displayPrincipal.setFont(new Font("Arial", Font.PLAIN, 24));
        displayPrincipal.setPreferredSize(new Dimension(300, 50));
        painelPrincipal.add(displayPrincipal, BorderLayout.CENTER);

        // Painel para os botões com layout GridLayout
        JPanel painelBotoes = new JPanel(new GridLayout(5, 4, 10, 10));

        // Array de rótulos para os botões
        String[] rotulos = {
            "%", "CE", "C", "<-",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Criação e adição dos botões ao painel
        for (String rotulo : rotulos) {
            JButton botao = new JButton(rotulo);
            botao.setFont(new Font("Arial", Font.PLAIN, 18));
            botao.addActionListener(new BotaoActionListener());
            painelBotoes.add(botao);
        }

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Adiciona o painel principal ao frame
        add(painelPrincipal);

        // Torna o frame visível
        setVisible(true);
    }

    // Classe interna para tratar eventos dos botões
    private class BotaoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();

            if ("0123456789".contains(comando)) {
                if (displayPrincipal.getText().equals("0") || operadorPressionado) {
                    displayPrincipal.setText(comando);
                    operadorPressionado = false;
                } else {
                    displayPrincipal.setText(displayPrincipal.getText() + comando);
                }
            } else if (comando.equals("C")) {
                displayPrincipal.setText("0");
                displayOperacao.setText("");
                operacaoAtual = "";
            } else if (comando.equals("<-")) {
                String textoAtual = displayPrincipal.getText();
                if (textoAtual.length() > 1) {
                    displayPrincipal.setText(textoAtual.substring(0, textoAtual.length() - 1));
                } else {
                    displayPrincipal.setText("0");
                }
            } else if (comando.equals("CE")) {
                displayPrincipal.setText("0");
            } else if (comando.equals(".")) {
                if (!displayPrincipal.getText().contains(".")) {
                    displayPrincipal.setText(displayPrincipal.getText() + ".");
                }
            } else if (comando.equals("%")) {
                // Placeholder para a funcionalidade do botão %
            } else if (comando.equals("+")) {
                valorAtual = Double.parseDouble(displayPrincipal.getText());
                    

                operacaoAtual = displayPrincipal.getText() + " " + comando;
                displayOperacao.setText(operacaoAtual);
                operadorPressionado = true;
            } else if (comando.equals("=")) {
                // Placeholder para o cálculo

                Somar somar = new Somar();
                somar.adicionar(valorAtual);
                double resultado = somar.getResultado();

                displayPrincipal.setText(String.valueOf(resultado));

                displayOperacao.setText(operacaoAtual + " " + displayPrincipal.getText() + " =");

                operadorPressionado = false;
            }
        }
    }

    public static void main(String[] args) {
        // Criação da instância da calculadora
        new CalculadoraLayout();
    }
}
