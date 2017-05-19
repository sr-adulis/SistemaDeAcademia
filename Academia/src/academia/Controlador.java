/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.util.Scanner;

/**
 *
 * @author Pedro Henrique
 */
public class Controlador {

       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controlador.menuPrincipal();
      
    }


    public static void menuPrincipal() {
        Scanner in = new Scanner(System.in);
        String menuP;
        System.out.println("Projeto agendamento de academia Windows academic");
        System.out.println("\n MENU PRINCIPAL"
                + "\n 1- Lista de Personal treiners "
                + "\n 2- Adicionbar novo personal"
                + "\n 3- Selecionar Personal"/*Mostra Todos + opções:selecionar(remover/alterar/adicionar/adicionarCompromisso*/
                + "\n 4- Buscar Personais disponiveis por data"/*Mostra somente os disponiveis + opções : selecionar(adicionar compromisso)*/
                + "");
        System.out.println("Enter com a o"
                + "pção desejada");
        menuP = in.nextLine();
        switch (menuP) {

            case ("1"):
                System.out.println(printListaPersonal());
                
                break;
            case ("2"):
                addPersonal();
                
                break;
            case ("3"):
                Controlador.selPersonal();
                break;
        }
        in.nextLine();
        if (!menuP.equals("0")) {
            menuPrincipal();
        }
    }

    public static void addPersonal() {
        if (Academia.getQuantidadePersonal() <= 5) {

            System.out.println("Opção adicionar personal selecionada");
            Scanner in = new Scanner(System.in);

            System.out.println("digite o nome do pesonal");
            String nome = in.nextLine();

            System.out.println("digite o numero do crt");
            int crt = in.nextInt();

            Personal personal = new Personal(nome, crt);
            Academia.setPersonal(personal);

            Academia.setQuantidadePersonal(Academia.getQuantidadePersonal() + 1);
            System.out.println("Personal:" + nome + " ADICIONADO COM SUSSESSO");

        } else {
            System.out.println("Não ha espaço para adição de personal"
                    + "\n SUGESTÃO: DELÇÃO");
        }
    }

    public static String printListaPersonal() {
        if (Academia.getQuantidadePersonal() > 0) {
            int i = 0;
            String resultado = "\n Nº do personal: " + i + "\t \tnome: " + Academia.personal.get(i).getNome() + "\n";
            i++;
            if (Academia.getQuantidadePersonal() > i) {
                return resultado + printListaPersonal(i);
            }
            return resultado;
        }
        return "Não há Personal treiner algum cadastrado, cadastre um personal na opção 1";
    }

    public static String printListaPersonal(int i) {

        String resultado = "Nº do personal: " + i + "nome: " + Academia.personal.get(i).getNome() + "\n";
        i++;
        if (Academia.getQuantidadePersonal() > i) {
            return resultado + printListaPersonal(i);
        }
        return resultado;
    }

    public static void selPersonal() {
        Scanner in = new Scanner(System.in);
        System.out.println("Opção selecionar personal");
        int sel = 6;
        while (!((sel >= 0) && (sel <= 5))) {
            
            System.out.println("\n Digite o indice correspondente do personal");
            sel = in.nextInt();
        }
        if(Academia.personal.get(sel)!=null){
        System.out.println(Academia.personal.get(sel));
        
        }
        else{
        System.out.print(sel+"não é uma opção valida");
        }
    

}
}
