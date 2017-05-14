/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

/**
 *
 * @author Pedro Henrique
 */
public class Controlador {

    static Personal[] personal = new Personal[5];

    public static void menuPrincipal() {
        Personal[] personal = new Personal[5];

        System.out.println("Projeto agendamento de academia Windows academic");
        System.out.println("\n MENU PRINCIPAL"
                + "\n - Lista de Personal treiners "
                
                + printListaPersonal()
                + "\n 2- buscar Personais disponiveis por data");

    }

    public static String printListaPersonal() {
        if (Personal.getQuantidade() > 0) {
            int i = 0;
            String resultado = "\n\n Nº do personal: " + i + "nome: " + personal[i].getNome() + "\n";
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
