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
public class RegistroDaAula {
    private Date data;
    private int hora;
    private String objetivo;
    private String tipo;
    

    public RegistroDaAula(Date data, int hora, String objetivo, String tipo) {
        this.data = data;
        this.hora = hora;
        this.objetivo = objetivo;
        this.tipo = tipo;
        
    }
    
    
    
    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}