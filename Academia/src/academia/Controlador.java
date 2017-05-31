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

    public static void menuSelPersonal(int sel) {
        Scanner in = new Scanner(System.in);
        String menuP;
        System.out.println("Personal \"" + sel + "\" selecionado :" + Academia.personal.get(sel).getNome() + "\n Digite a opção desejada"
                + "\n \t 0- MENU INICIAL"
                + "\n \t 1- Mostrar informações do personal"
                + "\n \t 2- alterar dados do personal"
                + "\n \t 3- Mostrar compromissos"
                + "\n \t 4- Adicionar compromisso"
                + "\n \t 5- Selecionar compromisso");
        System.out.println("Entre com a opção desejada");
        menuP = in.nextLine();
        switch (menuP) {

            case ("1"):
                System.out.println(Academia.personal.get(sel));

                break;
            case ("2"):
                menuAlterarPersonal(sel);

                break;
            case ("3"):
                System.out.println(Academia.personal.get(sel).printCompromisso());
                break;
            case ("4"):
                Academia.personal.get(sel).addCompromisso();
             
                break;
        }
        in.nextLine();
        if (!menuP.equals("0")) {
            menuSelPersonal(sel);
        }

    }
    public static void menuAlterarPersonal(int sel) {
        Scanner in = new Scanner(System.in);
        String menuP;
        System.out.println("Opção alternar personal");

        System.out.println("Personal \"" + sel + "\" selecionado para alterações :" + Academia.personal.get(sel).getNome() + "\n Digite a opção desejada"
                + "\n \t 0- MENU SELECIONAR PERSONAL "
                + "\n \t 1- alterar nome:" + Academia.personal.get(sel).getNome()
                + "\n \t 2- alterar CPF:" + Academia.personal.get(sel).getCPF()
                + "\n \t 3- alterar CRT:" + Academia.personal.get(sel).getCrt()
                + "\n \t 4- EXCLUIR PERSONAL"
                + "\n \t 5- SAIR");
        System.out.println("Enter com a o"
                + "pção desejada");
        menuP = in.nextLine();
        switch (menuP) {
            case("0"):
                menuSelPersonal(sel);
                break;
            case ("1"):
                alterarAtributo(sel,"nome");

                break;
            case ("2"):
                alterarAtributo(sel,"cpf");

                break;
            case ("3"):
                alterarAtributo(sel,"crt");
                break;
            case ("4"):
                System.out.print("Para confirmar EXCLUSÂO(não tem retorno),digite o indice:"+sel+"ou de enter para CANCELAR \n");
                if(in.nextLine().equals(sel)){
                    Academia.delPersonal(sel);
                    System.out.print("EXCLUIDO COM SUSSESSO ");
                    System.out.print("redirecionado para MENU INICIAL");
                    menuPrincipal();
                }
                break;
            case ("5"):
                break;
            default:
                System.out.print("OPÇÂO INVALIDA");    
                
                
        }
        in.nextLine();
        
        if (!menuP.equals("0")) {
            System.out.print("OPÇÂO INVALIDA");
            menuAlterarPersonal(sel);
        }

    }
    public static void addPersonal() {
        //AdicionarPersonais tabela = new AdicionarPersonais();
        //tabela.setVisible(true);
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
            String resultado = "Opção print Personal treiners selecionada:"
                    + "\n \t Nº do personal: " + i + "\t \tnome: " + Academia.personal.get(i).getNome() + "\n";
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
        if (sel <= Academia.getQuantidadePersonal()) {
            Controlador.menuSelPersonal(sel);
        } else {
            System.out.print(" \"" + sel + "\" não é uma opção valida");

        }

    }

    public static void alterarAtributo(int sel, String atributo) {
        Scanner in = new Scanner(System.in);
        String input;
        String valor = "";
        switch (atributo) {

            case ("nome"):
                valor = Academia.personal.get(sel).getNome();

                break;
            case ("cpf"):
                valor = String.valueOf(Academia.personal.get(sel).getCPF());

                break;
            case ("crt"):
                valor = String.valueOf(Academia.personal.get(sel).getCrt());
                break;
        }

        System.out.println("Altarando atributo" + atributo + ":" + valor + " digite o novo" + atributo);
        input = in.nextLine();
        System.out.print("para confirmar as alterações, digite o" + atributo + " antigo:" + valor+"\n");
        if (in.nextLine().equals(valor)) {
            switch (atributo) {

                case ("nome"):
                    Academia.personal.get(sel).setNome(input);

                    break;
                case ("cpf"):
                    Academia.personal.get(sel).setCPF(Integer.parseInt(input));

                    break;
                case ("crt"):
                    Academia.personal.get(sel).setCrt(Integer.parseInt(input));
                    break;
            }
        }
    }
}
