package p5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * En esta clase vamos a trabajar con listas para hacer unas pruebas
 * de rendimiento y medir el tiempo de ejecución mediante una serie
 * de métodos.
 * @author Miguel Ángel Sebastiá Soler DAM 1B
 * @version 1.0
 */
public class Lists {
    DecimalFormat df = new DecimalFormat("0.000000");
    List<Double> tiempos = new ArrayList<>();
    List<String> lineas = new ArrayList<>();
    String linea;
    String rutaFichero = "C:/Users/Miki/Desktop/resultados.txt";
    File fichero = new File(rutaFichero);
    BufferedWriter bw;
    double tiempoInicio;
    double tiempoRequerido;
    double tiempoMedio = 0;
    double mejorTiempo;
    double peorTiempo;
    int num, ultimo, primer, mitad;
    final int pruebas = 1000;
    
    /**
     * Este método rellena una lista de enteros vacia
     * con una serie de enteros del 1 al tamaño deseado.
     * @param list con la lista a rellenar.
     * @param cantidad con el tamaño deseado para la lista.
     * @return la lista rellena de números enteros.
     */
    public List<Integer> rellenarLista(List list, int cantidad){
        for (int i = 1; i <= cantidad; i++)
            list.add(i);
        return list;  
    }
    
    /**
     * Este método contiene todas las mediciones que vamos 
     * a realizar.
     * @throws java.io.IOException
     */
    public void RunTimes() throws IOException{
        List<Integer> listaPrueba = new ArrayList<>();
        listaPrueba = rellenarLista(listaPrueba, 1000);
        List<Integer> lista = new ArrayList<>(listaPrueba);
        List<Integer> listaLink = new LinkedList<>(listaPrueba);

        linea = "                            TEST                            " 
        + "        TIEMPO MEDIO     " + "MEJOR TIEMPO    " + "PEOR TIEMPO";
        lineas.add(linea);
        System.out.println(linea);
        
        addElemento(lista);
        linea = "Insercción de un dato al final de la lista tipo"
        + " Array.               " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        addElemento(listaLink);
        linea = "Insercción de un dato al final de la lista tipo"
        + " Linked.              " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
        
        addElementoInicio(lista);
        linea = "Insercción de un dato al principio de la lista tipo"
        + " Array.           " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        addElementoInicio(listaLink);
        linea = "Insercción de un dato al principio de la lista tipo"
        + " Linked.          " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0; 
        lineaBlanca();
 
        addElementoMitad(lista);     
        linea = "Insercción de un dato a mitad de la lista tipo"
        + " Array.                " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        addElementoMitad(listaLink);  
        linea = "Insercción de un dato a mitad de la lista tipo"
        + " Linked.               " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0; 
        lineaBlanca();
        
        removeElementoFinal(lista);    
        linea = "Eliminar un dato al final de la lista tipo"
        + " Array.                    " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        removeElementoFinal(listaLink);  
        linea = "Eliminar un dato al final de la lista tipo"
        + " Linked.                   " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
        
        removeElementoInicio(lista);   
        linea = "Eliminar un dato al principio de la lista tipo"
        + " Array.                " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        removeElementoInicio(listaLink);
        linea = "Eliminar un dato al principio de la lista tipo"
        + " Linked.               " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
        
        removeElementoMitad(lista);   
        linea = "Eliminar un dato a mitad de la lista tipo"
        + " Array.                     " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        removeElementoMitad(listaLink);
        linea = "Eliminar un dato a mitad de la lista tipo"
        + " Linked.                    " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();

        removeValorFinal(lista); 
        linea = "Eliminar un dato al final de la lista tipo"
        + " Array por su valor.       " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        removeValorFinal(listaLink); 
        linea = "Eliminar un dato al final de la lista tipo"
        + " Linked por su valor.      " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
        
        removeValorInicio(lista);  
        linea = "Eliminar un dato al inicio de la lista tipo"
        + " Array por su valor.      " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        removeValorInicio(listaLink);
        linea = "Eliminar un dato al inicio de la lista tipo"
        + " Linked por su valor.     " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
        
        removeValorMitad(lista);  
        linea = "Eliminar un dato a mitad de la lista tipo"
        + " Array por su valor.        " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        removeValorMitad(listaLink);   
        linea = "Eliminar un dato a mitad de la lista tipo"
        + " Linked por su valor.       " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
         
        searchElementoFuncion(lista);
        linea = "Buscar un dato en la lista tipo Array mediante "
        + "funciones.            " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        searchElementoFuncion(listaLink);
        linea = "Buscar un dato en la lista tipo Linked mediante "
        + "funciones.           " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
        
        searchElementoBucle(lista);
        linea = "Buscar un dato en la lista tipo Array mediante bucle."  
        + "                " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        searchElementoBucle(listaLink);
        linea = "Buscar un dato en la lista tipo Linked mediante bucle."  
        + "               " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
        
        searchElementoBinaria(lista);
        linea = "Buscar un dato en la lista tipo Array mediante "
        + "busqueda binaria.     " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        searchElementoBinaria(listaLink); 
        linea = "Buscar un dato en la lista tipo Linked mediante "
        + "busqueda binaria.    " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) 
        + " ms.    " + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
        
        removeTodo(lista);
        linea = "Borrar todos los datos de la lista tipo Array. "
        + "                      " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        
        removeTodo(listaLink);
        linea = "Borrar todos los datos de la lista tipo Linked. "
        + "                     " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.";
        lineas.add(linea);
        System.out.println(linea);
        tiempos.clear();
        tiempoMedio = 0;
        lineaBlanca();
        escribirFichero();
    }
    
    /**
     * Este método permite trabajar con los tiempos recogidos
     * durantes las pruebas para poder averiguar el tiempo
     * medio, el mejor tiempo y el peor tiempo obtenidos.
     * @param tiempos con la lista de tiempos guardados.
     */
    private void calcularTiempos(List tiempos){
        mejorTiempo = (double) tiempos.get(0);
        peorTiempo = (double) tiempos.get(tiempos.size()-1);
        for (int i = 0; i < tiempos.size(); i++){
            tiempoMedio += (double) tiempos.get(i);
                if (mejorTiempo > (double) tiempos.get(i))
                    mejorTiempo = (double) tiempos.get(i);
                if (peorTiempo < (double) tiempos.get(i))
                    peorTiempo =  (double) tiempos.get(i);
        }  
    }
    
    /**
     * Este método mide el tiempo necesario en añadir un elemento 
     * al final de una lista.
     * @param list con la list para realizar pruebas
     */
    private void addElemento(List list){
        for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.add(1000+i);
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list.remove(list.size()-1);   
        } 
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en añadir un elemento 
     * al inicio de una lista. 
     * @param list con la lista para realizar las pruebas.
     */
    private void addElementoInicio(List list){
        for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.add(0, 1000+i);
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list.remove(0);
        }   
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en añadir un elemento 
     * a mitad de una lista.
     * @param list con la lista para realizar las pruebas.
     */
    private void addElementoMitad(List list){
        for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.add(list.size()/2, 1000+i);
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list.remove(list.size()/2);
        }    
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en borrar un elemento 
     * al final de una lista.
     * @param list con la lista para realizar las pruebas.
     */
    private void removeElementoFinal(List list){
       for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.remove(list.size()-1);
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list.add(1000);
        }
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en borrar un elemento 
     * al final de una lista.
     * @param list con la lista para realizar las pruebas.
     */
    private void removeElementoInicio(List list){
        for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.remove(0);
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list.add(0, 1000);
        }
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en borrar un elemento 
     * a mitad de una lista.
     * @param list con la lista para realizar las pruebas.
     */
    private void removeElementoMitad(List list){
        for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.remove(list.size()/2);
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list.add(list.size()/2, 501);
        }
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en borrar un elemento 
     * al final de una lista por su valor.
     * @param list con la lista para realizar las pruebas.
     */
    private void removeValorFinal(List list){
        ultimo = (int) list.get(list.size()-1);
        for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.remove(Integer.valueOf(ultimo));
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list.add(ultimo);
        }
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en borrar un elemento 
     * al inicio de una lista por su valor.
     * @param list con la lista para realizar las pruebas.
     */
    private void removeValorInicio(List list){
        primer = (int) list.get(0);
        for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.remove(Integer.valueOf(primer));
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list.add(0, primer);
        }
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en borrar un elemento 
     * a mitad de una lista por su valor.
     * @param list con la lista para realizar las pruebas.
     */
    private void removeValorMitad(List list){
        mitad = (int) list.get(list.size()/2);
        for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.remove(Integer.valueOf(mitad));
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list.add(list.size()/2, mitad);
        }   
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en buscar un elemento 
     * de una lista mediante funciones de lista.
     * @param list con la lista para realizar las pruebas.
     */
    private void searchElementoFuncion(List list){
        for (int i = 1; i <= pruebas; i++){
            num = 950+i;
            tiempoInicio = System.nanoTime();
            list.contains(num);
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
        }
        calcularTiempos(tiempos); 
    }
    
    /**
     * Este método mide el tiempo necesario en buscar un elemento 
     * de una lista mediante bucle.
     * @param list con la lista para realizar las pruebas. 
     */
    private void searchElementoBucle(List list){
        for (int i = 1; i <= pruebas; i++){
            num = 950+i;
            tiempoInicio = System.nanoTime();
            for (int j = 0; j < list.size(); j++){
                if(num == (int) list.get(j)){
                    break;
                }    
            }   
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
        }
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en buscar un elemento 
     * de una lista mediante busqueda binaria.
     * @param list con la lista para realizar las pruebas.
     */
    private void searchElementoBinaria(List list){
        Collections.sort(list);
        int numero = 47;
        int cantidad = list.size();
        int centro;
        int inferior = 0;
        int superior = cantidad-1;
        
        for (int i = 1; i <= pruebas; i++){    
            tiempoInicio = System.nanoTime();
            while(inferior <= superior){
                centro = (superior + inferior)/2;
                if (numero == (int) list.get(centro)){            
                    break;
                }    
                else{
                    if (numero < (int) list.get(centro)){
                        superior = centro-1;
                    }
                    else{
                        inferior = centro+1;
                    }
                }    
            }
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
        }
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método mide el tiempo necesario en borrar todos
     * los elementos de una lista.
     * @param list con la lista para realizar las pruebas.
     */
    private void removeTodo(List list){
        int cantidad = list.size();
        for (int i = 1; i <= pruebas; i++){
            tiempoInicio = System.nanoTime();
            list.clear();
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
            list = rellenarLista(list, cantidad);
        }
        calcularTiempos(tiempos);
    }
    
    /**
     * Este método imprime y prepara una linea en blanco
     * para ser guardada en el fichero txt.
     */
    public void lineaBlanca(){
        linea = " ";
        lineas.add(linea);
        System.out.println(linea);
    }
    
    /**
     * Este método escribe en un fichero txt los resultados
     * obtenidos en las mediciones.
     * @throws IOException 
     */
    private void escribirFichero() throws IOException{
        if (fichero.exists()){
            System.out.print("Error, el fichero de resultados.txt ya existe.");
        }
        else{
            bw = new BufferedWriter(new FileWriter(fichero));
            for (String cadena : lineas){
                bw.write(cadena);
                bw.newLine();
            }
        }
        bw.close();
    }
}


