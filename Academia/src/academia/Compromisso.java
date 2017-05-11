
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

    private Date data;
    private int hora;
    private int duração;
    private String objetivo;
    private String tipo;
    private static int quantidade;
    private Aluno aluno;
    
    public enum Status {
        agendado, confirmado, efetuado, cancelado
    };
    Status status;

    public Compromisso(Date data, int hora, int duração, String objetivo, String tipo, boolean confirmado) {
        
        this.aluno=aluno;
        this.data = data;
        this.hora = hora;
        this.duração = duração;
        this.objetivo = objetivo;
        this.tipo = tipo;
        this.status = Status.agendado;

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

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}
