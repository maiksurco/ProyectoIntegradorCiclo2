/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevo.igu;

/**
 *
 * @author Asullom
 */
public class Validate {
    
    //definiendo variables de sesión
    
    public static boolean isPin = false;
    public static int userId = 0;
    

    public boolean comprobar() {
        if (isPin) {

            return true;

        } else {

            return false;
        }
    }
}
