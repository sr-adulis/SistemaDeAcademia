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
    
    private int cod;
    private static int quantidade;
    Compromisso[] compromisso;

    public Personal(int crt, int cod, Compromisso[] compromisso) {
        this.crt = crt;
        this.cod = cod;
        this.compromisso = compromisso;

        this.cod = Personal.quantidade;
        Personal.quantidade++;
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

    public static int getQuantidade() {
        return quantidade;
    }

    public static void setQuantidade(int quantidade) {
        Personal.quantidade = quantidade;
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
        this.compromisso[Compromisso.getQuantidade()] = compromisso;
    }

    

    public boolean MarcarCompromisso(String aluno, Date data, String objetivo, String tipo, int codPersonal) {
        Compromisso compromisso = new Compromisso(aluno, data, objetivo, tipo);
        this.setCompromisso(compromisso);
        return true;
    }

    public boolean Disponibilidade(Date data) {
        int i = 0;

        while (Compromisso.getQuantidade() - 1 <= i) {

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
        boolean ver[] = new boolean[Personal.quantidade];
        while (Personal.quantidade >= j) {
            int i = 0;
            ver[j] = true;
            while (Compromisso.getQuantidade() >= i) {
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
     FileWriter fw = new FileWriter(arquivo,true);
     BufferedWriter bw = new BufferedWriter(fw);
     bw.write("Nome Personais:");
     bw.newLine();
     bw.close();
     fw.close();
     
     //Ler o Arquivo
     FileReader fr = new FileReader(arquivo);
     BufferedReader br = new BufferedReader(fr);
     while (br.ready()){
         String linha = br.readLine();
         System.out.println(linha);
         br.close();
         fr.close();
         
     }
     }
}
