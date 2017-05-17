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

    static Personal[] personal = new Personal[5];

    public static Personal[] getPersonal() {
        return personal;
    }

    public static void setPersonal(Personal personal) {
        Controlador.personal[Personal.getQuantidade()] = personal;
    }
    

    public static void menuPrincipal() {
        Scanner in = new Scanner(System.in);
        String menuP;
        System.out.println("Projeto agendamento de academia Windows academic");
        System.out.println("\n MENU PRINCIPAL"/*Mostra Todos + opções:selecionar(remover/alterar/adicionar/adicionarCompromisso)*/
                + "\n 1- Lista de Personal treiners "
                + "\n 2- Adicionbar novo personal"
                + "\n 3- Selecionar Personal"
                + "\n 2- Buscar Personais disponiveis por data"/*Mostra somente os disponiveis + opções : selecionar(adicionar compromisso)*/
                + "");
        System.out.println("Enter com a opção desejada");
        menuP = in.nextLine();
        switch (menuP) {
            
            case ("1"):
                System.out.println(printListaPersonal());
            case("2"): 
                addPersonal();
            case("3"):
                
        }
        if( !menuP.equals("0")){
        menuPrincipal();
        }
    }

    public static void addPersonal() {
        if (Personal.getQuantidade()<=5){
            
        System.out.println("Opção adicionar personal selecionada");
        Scanner in = new Scanner(System.in);
        
        System.out.println("digite o nome do pesonal");
        String nome = in.nextLine();
        
        System.out.println("digite o numero do crt");
        int crt = in.nextInt();
        
        Personal personal= new Personal(nome,crt);
        Controlador.setPersonal(personal);
        
        Personal.setQuantidade(Personal.getQuantidade()+1);
            System.out.println("Personal:"+nome+" ADICIONADO COM SUSSESSO");
            
        }
        else{
            System.out.println("Não ha espaço para adição de personal"
                    + "\n SUGESTÃO: DELÇÃO");
        }
    }

    public static String printListaPersonal() {
        if (Personal.getQuantidade() > 0) {
            int i = 0;
            String resultado = "\n\n\n Nº do personal: " + i + "nome: " + personal[i].getNome() + "\n";
            i++;
            if (Personal.getQuantidade() > i) {
                return resultado + printListaPersonal(i);
            }
            return resultado;
        }
        return "Não há Personal treiner algum cadastrado, cadastre um personal na opção 1";
    }

    public static String printListaPersonal(int i) {

        String resultado = "Nº do personal: " + i + "nome: " + personal[i].getNome();
        i++;
        if (Personal.getQuantidade() > i) {
            return resultado + printListaPersonal(i);
        }
        return resultado;
    }
}
