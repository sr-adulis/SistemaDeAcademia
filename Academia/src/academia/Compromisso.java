
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
   private RegistroDaAula aula;

    public Compromisso(Date data, int hora, RegistroDaAula aula) {
        this.data = data;
        this.hora = hora;
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

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
   private boolean confirmado;
}
