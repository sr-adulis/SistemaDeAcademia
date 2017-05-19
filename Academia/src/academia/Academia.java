/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Sr.Adulis <Sr.Adulis@192.168.1.32>
 */
package academia;

/**
 *
 * @author 31626351
 */
import java.util.ArrayList;

public class Academia {

 
    static ArrayList<Personal> personal = new ArrayList<Personal>();
    static int quantidadePersonal;
    
    public static Personal[] getPersonal() {
        Personal[] arr = new Personal[personal.size()];
        return personal.toArray(arr);
    }

    public static void setPersonal(Personal personal) {
        Academia.personal.add(personal);
    }
    public static void delPersonal(int i){
        Academia.personal.remove(i);
        
    }

    public static void setQuantidadePersonal(int quantidadePersonal) {
        Academia.quantidadePersonal = quantidadePersonal;
    }

    public static int getQuantidadePersonal() {
        return quantidadePersonal;
    }
    
    
}
