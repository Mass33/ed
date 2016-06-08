package aplicacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase corresponde a los clientes que están formados
 * por 1 o más personas y que pueden tener máscotas
 * a su cuidado.
 */
public class Familia {
    private String codigo;
    public String apellido;
    private int cuentaBancaria;
    public String direccion;
    public int telefono;
    public List<Animal> mascota = new ArrayList<Animal>();
    public List<Persona> persona = new ArrayList<Persona>();
    
    /**
     * Este método devuelve el valor de la cuentaBancaria
     * del cliente.
     * @return la cuenta bancaria del cliente
     */
    int getCuentaBancaria(){
    }
    
    /**
     * Este método da valor a la cuenta bancaria del cliente.
     * @param newCuenta con el valor de la cuenta bancaria.
     */
    void setCuentaBancaria(int newCuenta){  
    }
}
