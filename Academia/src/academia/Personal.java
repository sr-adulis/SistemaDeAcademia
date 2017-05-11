/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.util.Date;

public class Personal extends Pessoa{
    private int crt;
    private static int quantiddade;
    Compromisso []compromisso;

    public int getCrt() {
        return crt;
    }

    public void setCrt(int crt) {
        this.crt = crt;
    }
    public  boolean Disponibilidade(Date data,Personal personal){
       int i = 0;
       boolean ver=true;
        while (Compromisso.getQuantidade()<= i){
            if ((this.compromisso[i].getData() == data) && (this.compromisso[i].status== Compromisso.Status.agendado ||
                    this.compromisso[i].status==Compromisso.Status.confirmado )) {
                return false;  
       }
        i++;   
   }
        return true;
    }
}

