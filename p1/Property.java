
package propertyshop;

/**
 * Clase que almacena los datos de los inmuebles de una inmobiliaria. 
 * Para ello utiliza una serie de métodos que recogen los datos introducidos 
 * por el usuario, y los guarda en sus variables correspondientes.
 * @version 1.0
 * @author Miguel Ángel Sebastiá Soler DAM 1B
 */
public class Property {
    String nombre, direccion, propietario, dirPropietario;
    double construidos, utiles;
    int precio;
    
    /**
     * Método para guardar el nombre, o null si no tiene, y pasarlo a minúsculas.
     * @param name 
     */
    public void setName (String name) {
        nombre = (name==null)?null:name.toLowerCase();
    }
    
    /**
     * @return el nombre del inmueble
     */
    public String getName() {
        return nombre;
    }
    
    /**
     * Método para guardar la dirección, o null si no tiene, y pasarla a mayúsculas.
     * @param address 
     */
    public void setAddress (String address) {
        direccion = (address==null)?null:address.toUpperCase();
    }
    
    /**
     * @return la dirección del inmueble.
     */
    public String getAddress() {
        return direccion;
    }
    
    /**
     * Método para guardar los metros construidos si son más de 0.
     * @param constructed 
     */
    public void setConstructedSurface (double constructed) {
        if (constructed>0) {
        construidos = constructed;
        }
    }
    
    /**
     * @return los metros construidos del inmueble.
     */
    public double getConstructedSurface() {
        return construidos;
    }
    
    /**
     * Método para guardar los metros útiles si son más de 0.
     * @param available 
     */
    public void setAvailableSurface (double available) {
        if (available>0) {
            utiles = available;
        }
    }
    
    /**
     * @return los metros útiles del inmueble
     */
    public double getAvailableSurface() {
        return utiles;
    }
    
    /**
     * Método para guardar el nombre del propietario, o null si no tiene.
     * @param owner 
     */
    public void setOwner (String owner) {
        propietario = (owner==null)?null:owner;
    }
    
    /**
     * @return el nombre del propietario del inmueble.
     */
    public String getOwner() {
        return propietario;
    }
    
    /**
     * Método para guardar la dirección del propietario, o null si no tiene.
     * @param ownerAdd 
     */
    public void setOwnerAddress (String ownerAdd) {
        dirPropietario = (ownerAdd==null)?null:ownerAdd;
    }
    
    /**
     * @return la dirección del propietario del inmueble.
     */
    public String getOwnerAddress() {
        return dirPropietario;
    }
    
    /**
     * Método para guardar el precio del inmueble con valor mínimo de 0.
     * A diferencia de los metros, en el enunciado no especifica que el
     * precio no pueda ser 0.
     * @param price 
     */
    public void setPrice (int price) {
        if (price>=0){
          precio = price;  
        }
    }
    
    /**
     * @return el precio del inmueble.
     */
    public int getPrice() {
        return precio;
    }
}
