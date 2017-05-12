/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.util.Date;

public class Personal extends Pessoa{
    private int crt;
    private int cod;
    private static int quantidade;
    Compromisso []compromisso;

    public Personal(int crt, int cod, Compromisso[] compromisso) {
        this.crt = crt;
        this.cod = cod;
        this.compromisso = compromisso;
    }    
    public int getCrt() {
        return crt;
    }

    public void setCrt(int crt) {
        this.crt = crt;
    }

    public Compromisso[] getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(Compromisso compromisso) {
        this.compromisso[Compromisso.getQuantidade()] = compromisso;
    }
    
    
    public  boolean MarcarCompromisso(Aluno aluno,Date data, String objetivo, String tipo,int codPersonal){
        Compromisso compromisso=new Compromisso(aluno,data,objetivo,tipo);
        this.setCompromisso(compromisso);
        return true;
    }


    public  boolean Disponibilidade(Date data){
       int i = 0;

        while (Compromisso.getQuantidade()-1<= i){

            if ((this.compromisso[i].getData() == data) && (this.compromisso[i].status== Compromisso.Status.agendado ||
                    this.compromisso[i].status==Compromisso.Status.confirmado )) {
                return false;  
            }
        i++;   
        }
        return true;
    }
    
       
    public static boolean[] Disponibilidadess(Date data,Personal[] personal){
  
        int j = 0;
        boolean ver[] = new boolean[Personal.quantidade];
        while (Personal.quantidade >= j) {
            int i = 0;
            ver[j]=true;
            while (Compromisso.getQuantidade() >= i) {
                if ((personal[j].compromisso[i].getData() == data) && (personal[j].compromisso[i].status == Compromisso.Status.agendado 
                        || personal[j].compromisso[i].status == Compromisso.Status.confirmado)) {
                    ver[j]=false;
                }
                i++;
            }
            
            j++;
        }
        return ver;
    }
}

