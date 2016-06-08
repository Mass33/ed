package crewmanagement;

/**
 * En esta clase guardamos todos los datos de los empleados de la empresa.
 * @version 1.0
 * @author Miguel Ángel Sebastiá Soler  DAM 1B
 */
public class Employee { 
    
    Turn turnos[]        = new Turn[7];
    String nombre        = null;
    String apellidos     = null;
    String dni           = null;
    int cantidadDeTurnos = 0;
    
    // Constructor por defecto.
    public Employee(){
    }
    
    /**
     * Constructor sobredimensionado con las variables aName y aSurename.
     * @param aName
     * @param aSurname 
     */
    public Employee(String aName, String aSurname){
        nombre    = aName;
        apellidos = aSurname;
    }
    
    /**
     * Constructor sobredimensionado con todas las variables.
     * @param aDNI
     * @param aName
     * @param aSurname 
     */
    public Employee(String aDNI, String aName, String aSurname){
        nombre    = aName;
        apellidos = aSurname;
        setDNI(aDNI);
    }
    
    /**
     * Método para guardar el nombre del empleado.
     * @param aName 
     */
    public void setName(String aName){
        nombre = aName;
    }
    
    /**
     * @return el nombre del empleado.
     */
    public String getName(){
        return nombre;
    }
    
    /**
     * Método para guardar los apellidos del empleado.
     * @param aSurname 
     */
    public void setSurname(String aSurname){
        apellidos = aSurname;
    }
    
    /**
     * @return los apellidos del empleado.
     */
    public String getSurname(){
        return apellidos;
    }
    
    /**
     * Método para obtener el nombre completo del empleado en el formato
     * deseado.
     * @param nameInUppercase
     * @param surnameInUpperCase
     * @return el nombre completo del empleado.
     */
    public String getFullName(boolean nameInUppercase, boolean surnameInUpperCase){
        String n, s, nombreCompleto, separador = ", ";
        
        n = (nombre == null) ? "" : nombre;
        if (nameInUppercase)
            n = n.toUpperCase();
        s = (apellidos == null) ? "" : apellidos;
        if (surnameInUpperCase)
            s = s.toUpperCase();
        if(n == "" || s == "")
            separador = "";
        nombreCompleto = (n + separador + s);
        return nombreCompleto;
    }
    
    /**
     * Método que comprueba que el DNI introducido por el usuario es válido.
     * Para ello comprobamos primero que el dni tiene la longitud adecuada 
     * de 9 caracteres. Si la longitud es la correcta, se pasa a comprobar
     * si los 8 primeros caracteres corresponden a dígitos y en ese caso los
     * guardamos en un String. Si los 8 primeros caracteres son dígitos, 
     * pasamos a comprobar que el último caracter del dni corresponde a una 
     * letra. Por último comprobamos que la letra del DNI es la que corresponde
     * con el número introducido.
     * @param aDNI
     * @return si el dni es valido o no
     */
    public boolean comprobarDNI(String aDNI){
        char[] letraDni = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 
            'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        }; 
        String num = "";
        int ind = 0;
        
        if (aDNI == null)
            return false;
        if (aDNI.length()!=9)
            return false;
        for (int i=0; i <=7; i++){
            if (!Character.isDigit(aDNI.charAt(i)))
                return false;
            num += aDNI.charAt(i);
        } 
        if (!Character.isLetter(aDNI.charAt(8)))
            return false; 
        ind = Integer.parseInt(num);
        ind %= 23;
        if ((Character.toUpperCase(aDNI.charAt(8))) != letraDni[ind])
             return false;  
        return true;
    }
        
    /**
     * Metodo que guarda el dni del empleado si se comprueba su
     * validez mediante el método indicado.
     * @param aDNI 
     */
    public void setDNI(String aDNI){
        boolean dniValido;
        
        dniValido = comprobarDNI(aDNI);
        if (dniValido)
            dni = aDNI;
    }
    
    /**
     * @return el dni del empleado.
     */
    public String getDNI(){
        return dni;
    }
    
    /**
     * Método para localizar la posición de un turno en el array según
     * el día.
     * @param aDay
     * @return la posición del turno en el array o -1 si no se encontró.
     */
    public int findTurnPos(String aDay){
        for (int i=0; i<cantidadDeTurnos; i++)
            if (turnos[i].dia.equals(aDay))
               return i; 
        return -1;
    }
    
    /**
     * Método para añadir un turno al empleado.
     * @param turno
     */
    public void addTurn(Turn turno){
        if (cantidadDeTurnos<=6)
            if (turno != null){
                turnos[cantidadDeTurnos] = turno;
                cantidadDeTurnos++;
            }    
    }  
    
    /**
     * Método para eliminar un turno de un determinado día al empleado.
     * @param aDay 
     */
    public void removeTurn(String aDay){
        String buscarDia;
        int posicion;
        
        if(aDay!=null){
            buscarDia = aDay.toUpperCase();
            posicion = findTurnPos(buscarDia);
            if (posicion>=0&&posicion<7){
                for (int i=posicion; i<cantidadDeTurnos-1; i++)
                    turnos[i] = turnos[i+1];
                cantidadDeTurnos--;
            }     
        }   
    }
    
    /**
     * @return devuelve el número de turnos asignados al empleado. 
     */
    public int getTurnCount(){
        return cantidadDeTurnos;
    }
    
    /**
     * Método que devuelve el turno de una posición indicada por el usuario.
     * @param pos
     * @return el turno de la posición indicada o null de lo contrario.
     */
    public Turn getTurnAt(int pos){
        if (pos>=0 && pos<cantidadDeTurnos)
            return turnos[pos];
        return null;
    }
    
    /**
     * @return devuelve los turnos asignados al empleado. 
     */
    public Turn[] getTurns(){
        Turn temp[] = new Turn[cantidadDeTurnos];
        
        for (int i = 0; i < cantidadDeTurnos; i++)
            temp[i] = turnos[i];
        return temp; 
    }
}
