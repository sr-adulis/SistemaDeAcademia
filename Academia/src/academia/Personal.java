/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    public static void main(String[] args) throws IOException {

        File arquivo = new File("E:\\SistemaDeAcademia\\Academia\\src\\academia\\personais.txt");
        File[] arquivos = arquivo.listFiles();
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Nome Personais:");
        bw.newLine();
        bw.close();
        fw.close();

        //Ler o Arquivo
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String linha = br.readLine();
            System.out.println(linha);
            br.close();
            fr.close();

        }
    }
}
