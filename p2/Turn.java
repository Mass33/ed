package crewmanagement;

/**
 * En esta clase guardamos toda la información sobre los turnos de los
 * empleados de la empresa.
 * @version 1.0
 * @author Miguel Ángel Sebastiá Soler DAM 1B
 */
public class Turn {
    String dia      = null;
    int horaInicio  = 0;
    int horaFinal   = 0;
    
 
    // Constructor por defecto.
    public Turn(){   
    }
    
    /**
     * Constructor sobredimensionado con la variable aDay.
     * @param aDay 
     */
    public Turn(String aDay){
        setDay(aDay);
        horaInicio = 0;
        horaFinal = 0;
    }
    
    /**
     * Constructor sobedimensionado con las 3 variables posibles.
     * @param aDay
     * @param aInitHour
     * @param aFinishHour 
     */
    public Turn(String aDay, int aInitHour, int aFinishHour){
        setDay(aDay);
        setInitHour(aInitHour);
        setFinishHour(aFinishHour);
    }
    
    /**
     * Método para guardar el día de la semana y pasarlo a mayúscyulas,
     * o null si no tiene.
     * @param aDay 
     */
    public void setDay(String aDay){
        dia = (aDay==null)?null:aDay.toUpperCase();
    }
    
    /**
     * @return el día de la semana.
     */
    public String getDay(){
        return dia;
    }
    
    /**
     * Método para guardar la hora de inicio del turno si su valor 
     * es entre 0 y 23.
     * @param aInitHour 
     */
    public void setInitHour (int aInitHour){
        if ((aInitHour>=0)&&(aInitHour<24))
            horaInicio = aInitHour;
    }

    /**
     * @return la hora de inicio del turno.
     */
    public int getInitHour(){
        return horaInicio;
    }
    
    /**
     * Método para guardar la hora de finalización del turno si su valor 
     * es entre 0 y 23.
     * @param aFinishHour 
     */
    public void setFinishHour(int aFinishHour){
        if ((aFinishHour>=0)&&(aFinishHour<24))
            horaFinal = aFinishHour;
    }
    
    /**
     * @return la hora de finalización del turno.
     */
    public int getFinishHour(){
        return horaFinal;
    }
}
