package com.controle;

import com.entidade.Calculadora;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controle da calculadora.
 *
 * @author osmar
 */
@RestController
public class CalculadoraControle {

    @RequestMapping("/getResultado")    
    public String getResultado(double valorA, double valorB, String operacao) {
        
        //Instancia e passa os valores para a calculadora
        Calculadora calculadora = new Calculadora(valorA, valorB);
        
        double resultado = 0;
        if (operacao.equals("adicao")) {
            resultado = calculadora.getSoma();
            System.out.println("A = " + valorA + " + B = " + valorB + " Resultado: " + resultado);
        } else {
            if (operacao.equals("subtracao")) {
                resultado = calculadora.getDiferenca();
                System.out.println("A = " + valorA + " - B = " + valorB + " Resultado: " + resultado);

            } else {
                if (operacao.equals("multiplicacao")) {
                    resultado = calculadora.getProduto();
                    System.out.println("A = " + valorA + " * B = " + valorB + " Resultado: " + resultado);
                } else {
                    if (operacao.equals("divisao")) {
                        resultado = calculadora.getQuociente();
                        System.out.println("A = " + valorA + " / B = " + valorB + " Resultado: " + resultado);
                    }
                }
            }
        }
        //Formata a saída do método getResultado
        String paginaResultado = "<html>"
                + "<head>"
                + "<title>Calculadora</title>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />"
                + "</head>"
                + "<body>"
                + "<h1>Resultado Calculadora</h1>"
                + "Resultado: " + resultado
                + "</body>" + "</html>";

        return paginaResultado;
    }
}
