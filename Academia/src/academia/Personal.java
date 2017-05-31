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

            System.out.println("Opção adicionar compromisso ao personal "+this.getNome());
            Scanner in = new Scanner(System.in);
            
            System.out.println("digite a data que deseja adicionar o compromisso");
            String data = in.nextLine();
            if (this.Disponibilidade(data)) {
                 System.out.println("informe o objetivo do seu treino ex: ganho de massa, perda de gordura, etc..)");
                String objetivo = in.nextLine();
                
                System.out.println("informe o tipo de treino desejado ex: airóbicos, musculação, etc...");
                String tipo = in.nextLine();
                
                System.out.println("digite o nome do aluno(PARA CANCELAR DE ENTER sem digitar)");
                String nome = in.nextLine();

                
                if (!nome.equals("")){
                this.MarcarCompromisso(nome, data, tipo, objetivo);

                this.setQuantidadeCompromisso(this.getQuantidadeCompromisso() + 1);
                System.out.println("compromisso com" + nome + " ADICIONADO COM SUSSESSO");
                
                }
                else{
                    System.out.println("AGENDAMENTO CALCELADO");
                }
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

    public boolean MarcarCompromisso(String aluno, String data, String objetivo, String tipo) {
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

    public boolean Disponibilidade(String data) {
       
        int i = 0;

        while (4>= i) {
            if(this.compromisso[i]!=null){
            if ((this.compromisso[i].getData().equals(data)) && (this.compromisso[i].status.equals(Compromisso.Status.agendado)
                    || this.compromisso[i].status.equals(Compromisso.Status.confirmado))) {
                return false;
            }
            }
            i++;
        }
        return true;
    }

    public static boolean[] Disponibilidadess(String data, Personal[] personal) {

        int j = 0;
        boolean ver[] = new boolean[Academia.getQuantidadePersonal()];
        while (Academia.getQuantidadePersonal() >= j) {
            int i = 0;
            ver[j] = true;

            while (personal[j].getQuantidadeCompromisso() >= i) {
                if ((personal[j].compromisso[i].getData().equals(data)) && (personal[j].compromisso[i].status == Compromisso.Status.agendado
                        || personal[j].compromisso[i].status == Compromisso.Status.confirmado)) {
                    ver[j] = false;
                }
                i++;
            }

            j++;
        }
        return ver;
    }

   
}
