
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.util.Date;

/**
 *
 * @author Sr.Adulis
 */
public class Compromisso {
    
    private Aluno aluno;
    private int cod;
    private Date data;
    private String objetivo;
    private String tipo;
    private static int quantidade;
    
    
    public enum Status {
        agendado, confirmado, efetuado, cancelado
    };
    Status status;

    public Compromisso(Aluno aluno,Date data, String objetivo, String tipo) {
        
        this.aluno=aluno;
        this.data = data;
        this.objetivo = objetivo;
        this.tipo = tipo;
        this.status = Status.agendado;
        
        this.cod=Compromisso.quantidade;
        Compromisso.quantidade++;
    }
    
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void efetuaCompromisso() {
        setStatus(Status.efetuado);

    }

    public static int getQuantidade() {
        return quantidade;
    }

    public static void setQuantidade(int quantidade) {
        Compromisso.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

   
    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}
