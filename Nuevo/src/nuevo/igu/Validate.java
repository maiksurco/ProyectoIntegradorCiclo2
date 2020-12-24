package nuevo.igu;

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
