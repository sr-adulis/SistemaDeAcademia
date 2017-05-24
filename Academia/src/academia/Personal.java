/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;


import java.util.Date;

import java.util.Scanner;

public class Personal {

    private String nome;
    private int CPF;
    private int crt;

    private boolean ver = false;
    private int quantidadeCompromisso;
    Compromisso[] compromisso = new Compromisso[5];

    public Personal(String nome, int crt) {
        this.nome = nome;
        this.crt = crt;
        this.ver = true;
        this.cod = Academia.getQuantidadePersonal();

    }

    public int getQuantidadeCompromisso() {
        return quantidadeCompromisso;
    }

    public void setQuantidadeCompromisso(int quantidadeCompromisso) {
        this.quantidadeCompromisso = quantidadeCompromisso;
    }

    public boolean isVer() {
        return ver;
    }

    public void setVer(boolean ver) {
        this.ver = ver;
    }
    private int cod;

    @Override
    public String toString() {

        if (this != null) {
            String resultado = "Ficha do Personal{ \n \t" + "nome=" + this.nome + ", CPF=" + this.CPF + ", crt=" + this.crt + ", cod=" + this.cod + '}';
            if (this.getQuantidadeCompromisso() != 0) {
                this.printCompromisso();
            }
            return resultado;
        }
        return null;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getCrt() {
        return crt;
    }

    public void setCrt(int crt) {
        this.crt = crt;
    }

    public void addCompromisso() {
        if (this.getQuantidadeCompromisso() <= 5) {

            System.out.println("Opção adicionar personal selecionada");
            Scanner in = new Scanner(System.in);
            
            System.out.println("digite a data ");
            int data = in.nextInt();
            if (this.Disponibilidade(data)) {
                System.out.println("digite o nome do aluno");
                String nome = in.nextLine();

                

                Personal personal = new Personal(nome, crt);
                Academia.setPersonal(personal);

                Academia.setQuantidadePersonal(Academia.getQuantidadePersonal() + 1);
                System.out.println("Personal:" + nome + " ADICIONADO COM SUSSESSO");
            }
        } else {
            System.out.println("Não ha espaço para adição de personal"
                    + "\n SUGESTÃO: DELÇÃO");
        }
    }

    public Compromisso getCompromisso(int indice) {
        return compromisso[indice];
    }

    public void setCompromisso(Compromisso compromisso) {
        this.compromisso[this.getQuantidadeCompromisso()] = compromisso;
    }

    public boolean MarcarCompromisso(String aluno, Date data, String objetivo, String tipo, int codPersonal) {
        Compromisso compromisso = new Compromisso(aluno, data, objetivo, tipo, this.getQuantidadeCompromisso());
        this.setCompromisso(compromisso);
        return true;
    }

    public String selecionarCompromisso(int i) {
        String resultado = "Nº compromisso: " + i + "Tipo: " + this.compromisso[i].getTipo() + "objetivo"
                + this.compromisso[i].getObjetivo() + "\n \tNome do aluno:" + this.compromisso[i].getAluno()
                + "Data:" + this.compromisso[i].getData() + " Status:" + this.compromisso[i].getStatus() + "\t \t";
        return resultado;
    }

    public String printCompromisso() {
        int i = 0;
        String resultado = "Nº compromisso: " + i + "Tipo: " + this.compromisso[i].getTipo() + "objetivo"
                + this.compromisso[i].getObjetivo() + "\n \t Nome do aluno:" + this.compromisso[i].getAluno()
                + "Data:" + this.compromisso[i].getData() + " Status:" + this.compromisso[i].getStatus() + "\t \t";
        i++;
        if (this.getQuantidadeCompromisso() > i) {
            return resultado + printCompromisso(i);
        }
        return resultado;
    }

    public String printCompromisso(int i) {
        String resultado = "Nº compromisso: " + i + "Tipo: " + this.compromisso[i].getTipo() + "objetivo"
                + this.compromisso[i].getObjetivo() + "\n \tNome do aluno:" + this.compromisso[i].getAluno()
                + "Data:" + this.compromisso[i].getData() + " Status:" + this.compromisso[i].getStatus() + "\t \t";
        i++;
        if (this.getQuantidadeCompromisso() > i) {
            return resultado + printCompromisso(i);
        }
        return resultado;
    }

    public boolean Disponibilidade(Date data) {
        int i = 0;

        while (this.getQuantidadeCompromisso() - 1 <= i) {

            if ((this.compromisso[i].getData() == data) && (this.compromisso[i].status == Compromisso.Status.agendado
                    || this.compromisso[i].status == Compromisso.Status.confirmado)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean[] Disponibilidadess(Date data, Personal[] personal) {

        int j = 0;
        boolean ver[] = new boolean[Academia.getQuantidadePersonal()];
        while (Academia.getQuantidadePersonal() >= j) {
            int i = 0;
            ver[j] = true;

            while (personal[j].getQuantidadeCompromisso() >= i) {
                if ((personal[j].compromisso[i].getData() == data) && (personal[j].compromisso[i].status == Compromisso.Status.agendado
                        || personal[j].compromisso[i].status == Compromisso.Status.confirmado)) {
                    ver[j] = false;
                }
                i++;
            }

            j++;
        }
        return ver;
    }

    private boolean Disponibilidade(int data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
