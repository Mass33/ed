package aplicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta clase corresponde a las mascotas que estan a
 * cargo de los clientes.
 */
public class Animal {
    private String codigo;
    public String alias;
    public String especie;
    public String raza;
    public String colorPelo;
    public Date fechaNacimiento;
    public double pesoMedio;
    public double pesoActual;
    public double[] pesoUltimas10Visitas = new double[10];
    public List<Historial> historial = new ArrayList<Historial>();
    public Calendario vacunas;
    
    /**
     * Este método añade el peso actual al array de pesos
     * de las 10 últimas visitas de la mascota. Borrando 
     * el primer peso del array en el proceso si es 
     * necesario.
     * @param peso con el peso actual de la mascota.
     */
    private void addPesoUltimaVisita(double peso){
    }
    
    /**
     * Este método llama al constructor por defecto de
     * la clase Historial.
     */
    private void addHistorial(){    
    }
    
    /**
     * Este método llama al constructor por defecto de
     * la clase Calendario.
     */
    private void addCalendario(){
    }
    
    /**
     * Este metodo calcula el peso medio de la mascota
     * calculandolo en base a los 10 últimos pesos registrados.
     * @param pesos con el array de pesos de las 10 últimas
     * visitas.
     * @return el peso medio de la mascota
     */
    private double calcularPesoMedio(double[] pesos){
    }
}
