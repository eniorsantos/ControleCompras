import br.alura.modelo.CartaoCredito;
import br.alura.modelo.Compra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------------Controle de Compras----------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.print("- Digite o limite disponível: ");
        double limite = sc.nextDouble();
        CartaoCredito cartaoCredito = new CartaoCredito(limite)  ;
        System.out.print("- Deseja iniciar as compras? (S)im ou (N)ão: ");
        String caracter = sc.next().toUpperCase();

        if (caracter.equals("S")){
            List<Compra> listaCompras = new ArrayList<>();

            boolean controle = true;

            while(controle) {
                System.out.println("\t\tEscolha sua opção: ");
                System.out.println("\t1 para adicionar compra:");
                System.out.println("\t2 para listar compras:");
                System.out.println("\t3 para finalizer.");
                System.out.print("--> ");

                String opcao = sc.next();
                if (isStringInt(opcao)) {
                    switch (Integer.parseInt(opcao)) {
                        case 1:
                            System.out.print("Digite o produto: ");
                            String produto = sc.next();
                            sc.nextLine() ;
                            System.out.print("Digite o valor: ");
                            double valor = sc.nextDouble();
                            if (valor < cartaoCredito.getSaldo()) {
                                Compra compra = new Compra(produto, valor);
                                listaCompras.add(compra);
                                cartaoCredito.controleCredito(valor);
                                System.out.println("\t\t\t\t\tCompra Realizada!");
                            } else {
                                System.out.println("\n");
                                System.out.println("Limite insuficiente.");
                                Collections.sort(listaCompras); 
                                for (Compra c : listaCompras) {
                                    System.out.println(c.toString());
                                }
                                System.out.println("--------------------------------------------------------------");
                            }
                            break;
                        case 2:
                            Collections.sort(listaCompras);
                            for (Compra c : listaCompras) {
                                System.out.println(c.toString());
                            }
                            System.out.println("--------------------------------------------------------------");
                            break;
                        case 3:
                            controle = false;
                            break;
                        default:
                            System.out.println("Escolha uma ooção valida!\n");
                            ;


                    }

                } else{
                    System.out.println("Digite uma opção valida!\n");
                    
                }

            }
            System.out.println("\t\t\t\t\tControle Finalizado.");

        }else{

            System.out.printf("- Limite disponivel R$ %.2f.\n ", cartaoCredito.getSaldo());


        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");



    }
      public static boolean isStringInt(String s)
             {
                 try {
                     Integer.parseInt(s);
                     return true;
                 } catch (NumberFormatException ex) {
                     return false;
                 }
             }
}