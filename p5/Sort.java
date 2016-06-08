package p5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * En esta clase vamos a trabajar con diferentes algoritmos de ordenacion
 * y de busqueda y vamos a medir su tiempo de ejecución.
 * @author Miguel Ángel Sebastiá Soler DAM 1B
 * @version 1.0
 */
public class Sort {
    DecimalFormat df = new DecimalFormat("00.000000");
    DecimalFormat df2 = new DecimalFormat("000000000");
    List<Double> tiempos = new ArrayList<>();
    List<Integer> lista = new ArrayList<>();
    List<String> lineas = new ArrayList<>();
    String linea;
    String comprobacion;
    String rutaFichero = "C:/Users/Miki/Desktop/resultados.txt";
    File fichero = new File(rutaFichero);
    BufferedWriter bw;
    double tiempoInicio;
    double tiempoRequerido;
    double tiempoMedio = 0;
    double mejorTiempo;
    double peorTiempo;
    final int pruebas = 10;
    int intercambios = 0;
    int accesos = 0;
    int comparaciones = 0;
    boolean correcto;
    boolean existe;
    boolean encontrado;
    
    /**
     * Este método rellena una lista de enteros vacia
     * con una serie de enteros del 1 al 1000.
     * @return la lista rellena de 1000 enteros.
     */
    public List<Integer> rellenarListaOrdenada(){
        List<Integer> listaRellena = new ArrayList<>();
        
        for (int i = 1; i <= 1000; i++)
            listaRellena.add(i);
        return listaRellena;  
    }
    
    /**
     * Este método rellena una lista de enteros vacia
     * con una serie de enteros del 1000 al 1.
     * @return la lista rellena de 1000 enteros.
     */
    public List<Integer> rellenarListaOrdenadaInversa(){
        List<Integer> listaRellena = new ArrayList<>();
        
        for (int i = 1000; i >= 1; i--)
            listaRellena.add(i);
        return listaRellena;  
    }
    
    /**
     * Este método rellena una lista de enteros vacia
     * con un mismo entero repetido 1000 veces.
     * @return la lista rellena de 1000 enteros.
     */
    public List<Integer> rellenarListaIguales(){
        List<Integer> listaRellena = new ArrayList<>();
        
        for (int i = 1; i <= 1000; i++)
            listaRellena.add(7);
        return listaRellena;  
    }
    
    /**
     * Este método rellena una lista de enteros vacia
     * con una serie de 1000 enteros aleatorios.
     * @return la lista rellena de 1000 enteros.
     */
    public List<Integer> rellenarListaOrdenadaAleatoria(){
        List<Integer> listaRellena = new ArrayList<>();
        
        for (int i = 1; i <= 1000; i++){
            int numAleatorio = (int)Math.floor(Math.random()*(0-1000)+1000);
            listaRellena.add(numAleatorio);
        }    
        return listaRellena;  
    }
    
    /**
     * Este método contiene todas las mediciones que vamos a realizar.
     * @throws java.io.IOException
     */
    public void RunTimes() throws IOException{
        linea = "                            TEST                            " 
        + "              TIEMPO MEDIO     " + "MEJOR TIEMPO     " 
        + "PEOR TIEMPO         SWAPS      COMPARACIONES"
        + "     EXISTE   CORRECTO";
        System.out.println(linea);
        lineas.add(linea);
        
        lista = rellenarListaOrdenadaAleatoria();
        bubbleSort(lista);
        linea = "Ordenar los datos de una lista aleatoria "
        + "con el método burbuja:           " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenada();
        bubbleSort(lista);
        linea = "Ordenar los datos de una lista ya ordenada "
        + "con el método burbuja:         " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenadaInversa();
        bubbleSort(lista);
        linea = "Ordenar los datos de una lista ordenada inversa "
        + "con el método burbuja:    " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaIguales();
        bubbleSort(lista);
        linea = "Ordenar los datos de una lista de todos iguales "
        + "con el método burbuja:    " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        linea = " ";
        lineas.add(linea);
        System.out.println(linea);
        System.out.println();
        
        lista = rellenarListaOrdenadaAleatoria();
        selectionSort(lista);
        linea = "Ordenar los datos de una lista aleatoria "
        + "con el método selection:         " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenada();
        selectionSort(lista);
        linea = "Ordenar los datos de una lista ya ordenada "
        + "con el método selection:       " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenadaInversa();
        selectionSort(lista);
        linea = "Ordenar los datos de una lista ordenada inversa "
        + "con el método selection:  " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaIguales();
        selectionSort(lista);
        linea = "Ordenar los datos de una lista de todos iguales "
        + "con el método selection:  " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        linea = " ";
        System.out.println(linea);
        lineas.add(linea);
        System.out.println();
        
        lista = rellenarListaOrdenadaAleatoria();
        insertionSort(lista);
        linea = "Ordenar los datos de una lista aleatoria "
        + "con el método insertion:         " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        "; 
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenada();
        insertionSort(lista);
        linea = "Ordenar los datos de una lista ya ordenada "
        + "con el método insertion:       " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea); 
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenadaInversa();
        insertionSort(lista);
        linea = "Ordenar los datos de una lista ordenada inversa "
        + "con el método insertion:  " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaIguales();
        insertionSort(lista);
        linea = "Ordenar los datos de una lista de todos iguales "
        + "con el método insertion:  " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        linea = " ";
        System.out.println(linea);
        lineas.add(linea);
        System.out.println();
        
        lista = rellenarListaOrdenadaAleatoria();
        quickSort(lista);
        linea = "Ordenar los datos de una lista aleatoria "
        + "con el método quick:             " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenada();
        quickSort(lista);
        linea = "Ordenar los datos de una lista ya ordenada "
        + "con el método quick:           " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea); 
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenadaInversa();
        quickSort(lista);
        linea = "Ordenar los datos de una lista ordenada inversa "
        + "con el método quick:      " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaIguales();
        quickSort(lista);
        linea = "Ordenar los datos de una lista de todos iguales "
        + "con el método quick:      " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        linea = " ";
        System.out.println(linea);
        lineas.add(linea); 
        System.out.println();
        
        lista = rellenarListaOrdenadaAleatoria();
        mergeSort(lista);
        linea = "Ordenar los datos de una lista aleatoria "
        + "con el método merge:             " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenada();
        mergeSort(lista);
        linea = "Ordenar los datos de una lista ya ordenada "
        + "con el método merge:           " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios)
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea); 
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenadaInversa();
        mergeSort(lista);
        linea = "Ordenar los datos de una lista ordenada inversa "
        + "con el método merge:      " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaIguales();
        mergeSort(lista);
        linea = "Ordenar los datos de una lista de todos iguales "
        + "con el método merge:      " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms.     " + df2.format(intercambios) 
        + "      " + df2.format(comparaciones) + "        ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        linea = " ";
        System.out.println(linea);
        lineas.add(linea); 
        System.out.println();
        
        lista = rellenarListaOrdenada();
        searchElementoBinaria(lista);
        linea = "Buscar un dato en una lista ya ordenada mediante "
        + "busqueda binaria.        " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms."
        + "                                     ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        linea = " ";
        System.out.println(linea);
        lineas.add(linea);
        System.out.println();
        
        lista = rellenarListaOrdenadaAleatoria();
        searchElementoBucle(lista);
        linea = "Buscar un dato en una lista aleatoria mediante bucle."  
        + "                     " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms."
        + "                                     ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenada();
        searchElementoBucle(lista);
        linea = "Buscar un dato en una lista ya ordenada mediante bucle."  
        + "                   " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms."
        + "                                     ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaOrdenadaInversa();
        searchElementoBucle(lista);
        linea = "Buscar un dato en una lista ordenada inversa mediante bucle."  
        + "              " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms."
        + "                                     ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        System.out.println();
        
        lista = rellenarListaIguales();
        searchElementoBucle(lista);
        linea = "Buscar un dato en una lista de todos iguales mediante bucle."  
        + "              " + df.format(tiempoMedio/tiempos.size()) 
        + " ms.    " + df.format(mejorTiempo) + " ms.    " 
        + df.format(peorTiempo) + " ms."
        + "                                     ";
        System.out.print(linea);
        comprobacion = imprimirResultados();
        linea += comprobacion;
        lineas.add(linea);
        reiniciarVariables();
        linea = " ";
        System.out.println(linea);
        lineas.add(linea);
        System.out.println();
        escribirFichero();
    }
    
    public void RunTetsts(){
        /* Los tets los paso en cada método de ordenación, asegurandome
	*  de no interferir en la medición de tiempos, para aprovechar
	*  los propios métodos de ordenación para realizar los tets y
	*  ahorrar código. */
    }
    
    /**
     * Este método comprueba que la ordenación se realizó correctamente.
     * Obtenemos la lista ya ordenada como parametro y la volvemos a
     * ordenar con la función Collections.sort() que sabemos que
     * funciona correctamente. Luego comparamos la lista previamente
     * ordenada con la que acabamos de ordenar. Si son listas 
     * identicas, entonces la ordenación fue correcta.
     * @param list con la lista ya ordenada por el método 
     * de ordenación a probar.
     */
    public void comprobarOrdenacion(List list){
        List<Integer> ordenada = new ArrayList<>(list);
        int n = ordenada.size();
        correcto = true;
        existe = false;
        if(ordenada != null)
            existe = true;
        Collections.sort(ordenada);
        for (int i = 0; i < n; i++) {
            if (!Objects.equals(ordenada.get(i), list.get(i))){
                correcto = false;
            }
        }
    }
    
    /**
     * Este método comprueba que la busqueda se realizó correctamente.
     * @param list con la lista original donde se realizó la busqueda.
     * @param x con el entero que se buscó en la lista.
     * @param buscado con el resultado en booleano de la busqueda.
     */
    public void comprobarBusqueda(List<Integer> list, int x, boolean buscado){
        encontrado = false;
        correcto = false;
        existe = false;
        if(list != null)
            existe = true;
        if(list.contains(x))
            encontrado = true;
        if (encontrado == buscado)
            correcto = true;
    }
    
    /**
     * Este método automatiza el visualizar los resultados
     * obtenidos de los tets de integridad y ordenación.
     * @return con el String que contiene el resultado.
     */
    public String imprimirResultados(){
        String exis;
        String cor;
        String comp;
        
        if(existe){
            exis = " Si       ";
            System.out.print(exis);
        }
        else{
            exis = " No       ";
            System.out.print(exis);
        }    
        if(correcto){
            cor = " Si       ";
            System.out.print(cor);
        } 
        else{
            cor = " Si       ";
            System.out.print(cor);
        }
        comp = (exis + cor);
        return comp;
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
     * Este método automatiza el reiniciar algunas variables.
     */
    private void reiniciarVariables(){
        lista.clear();
        tiempos.clear();
        tiempoMedio = 0;
        intercambios = 0;
        comparaciones = 0;
    }
    
    /**
     * Este método ordena una lista de enteros con el método burbuja.
     * @param lista con la lista a ordenar.
     */
    private void bubbleSort(List lista){
        int aux;
        int cantidad = lista.size();
        List<Integer> list = new ArrayList<>(lista);
        
        for (int x = 0; x < pruebas; x++){ 
            list = new ArrayList<>(lista);
            tiempoInicio = System.nanoTime();
            for (int i = 0; i < cantidad-1; i++){
                for (int j = i+1; j < cantidad; j++){
                    comparaciones++;
                    if(list.get(i) > list.get(j)){
                        aux = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, aux);
                        intercambios++;
                    }
                }
            }
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
        }  
        calcularTiempos(tiempos);
        comprobarOrdenacion(list);
    }

    /**
     * Este método ordena una lista de enteros con el método selection.
     * @param lista con la lista a ordenar.
     */
    private void selectionSort(List lista){
        int aux;
        int cantidad = lista.size();
        List<Integer> list = new ArrayList<>(lista);
        
        for (int x = 0; x < pruebas; x++){ 
            list = new ArrayList<>(lista);
            tiempoInicio = System.nanoTime();
            for (int i = 0; i < cantidad-1; i++){
                int menor = i;
                for (int j = i+1; j < cantidad; j++){
                    comparaciones++;
                    if(list.get(j) < list.get(menor))
                        menor = j;
                    if (menor != i){
                        aux = list.get(i);
                        list.set(i, list.get(menor));
                        list.set(menor, aux);
                        intercambios++;
                    }
                }
            }
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
        }  
        calcularTiempos(tiempos);
        comprobarOrdenacion(list);
    }   
    
    /**
     * Este método ordena una lista de enteros con el método insertion.
     * @param lista con la lista a ordenar.
     */
    public void insertionSort(List lista){
        int cantidad = lista.size();
        List<Integer> list = new ArrayList<>(lista);
        
        for (int x = 0; x < pruebas; x++){ 
            list = new ArrayList<>(lista);
            tiempoInicio = System.nanoTime();
            for (int i = 1; i < cantidad; i++){
                int valueToSort = list.get(i);
                int j = i;
                comparaciones++;
                while (j > 0 && list.get(j - 1) > valueToSort) {
                    list.set(j, list.get(j - 1));
                    j--;
                    intercambios++;
                }    
                list.set(j, valueToSort);
            }    
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
        }  
        calcularTiempos(tiempos);
        comprobarOrdenacion(list);
    }  
    
    /**
     * Este método toma la medición del tiempo requerido en ordenar
     * una lista de enteros con el método quick.
     * @param lista con la lista a ordenar.
     */
    public void quickSort(List lista){
        List<Integer> list = new ArrayList<>(lista);
        for (int x = 0; x < pruebas; x++){
            list = new ArrayList<>(lista);
            tiempoInicio = System.nanoTime();
            quickSort2(list, 0, list.size()-1);
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
        }  
        calcularTiempos(tiempos); 
        comprobarOrdenacion(list);
    }
    
    /**
     * Este método ordena una lista de enteros con el método quick.
     * @param list con la lista a ordenar.
     * @param low con el menor indice.
     * @param high con el mayor indice.
     */
    public void quickSort2(List<Integer> list, int low, int high){
            int aux;
            int middle = low + (high - low) / 2;
            int pivot = list.get(middle);
            int i = low, j = high;

            while (i <= j){
                while (list.get(i) < pivot){
                    i++;
                    comparaciones++;
                }    
                while (list.get(j) > pivot){
                    j--;
                    comparaciones++;
                }    
                if (i <= j){
                    aux = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, aux);
                    intercambios++;
                    i++;
                    j--;
                }
            }
            if (low < j){
                quickSort2(list, low, j);
            }    
            if (high > i){
                quickSort2(list, i, high);
            }    
    }
    
    /**
     * Este método toma la medición del tiempo requerido en ordenar
     * una lista de enteros con el método merge.
     * @param lista con la lista a ordenar.
     */
    private void mergeSort(List lista){
        List<Integer> list = new ArrayList<>(lista);
        for (int x = 0; x < pruebas; x++){
            list = new ArrayList<>(lista);
            tiempoInicio = System.nanoTime();
            mergeSort2(list);
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
        }  
        calcularTiempos(tiempos); 
        comprobarOrdenacion(list);
    }

    /**
     * Este método ordena una lista de enteros con el método merge.
     * @param list con la lista a ordenar.
     */
    public void mergeSort2(List list) {
        if (list.size() > 1) {
            List<Integer> izq = mitadIzq(list);
            List<Integer> der = mitadDer(list);
            
            mergeSort2(izq);
            mergeSort2(der);
            
            merge(list, izq, der);
        }    
    }
    
    /**
     * Este método recibe la mitad izquierda de una lista
     * y la divide en 2.
     * @param list con la mitad izqiuerda de una lista.
     * @return con la mitad izquierda de la lista recibida.
     */
    public List<Integer> mitadIzq(List list) {
        int mitad = list.size() / 2;
        List<Integer> izq;
        izq = new ArrayList<>();
        for (int i = 0; i < mitad; i++) {
            izq.add(i, (Integer) list.get(i));
        }
        return izq;
    }
    
    /**
     * Este método recibe la mitad derecha de una lista
     * y la divide en 2.
     * @param list con la mitad derecha de una lista.
     * @return con la mitad derecha de la lista recibida.
     */
    public List<Integer> mitadDer(List list) {
        int mitad = list.size() / 2;
        int mitad2 = list.size() - mitad;
        List<Integer> right;
        right = new ArrayList<>();
        for (int i = 0; i < mitad2; i++) {
            right.add(i,(Integer) list.get(i + mitad));
        }
        return right;
    }
    /**
     * Este método realiza la ordenación de la lista original, 
     * utilizando para ello las listas divididas previamente.
     * @param ordenada con la lista ordenada.
     * @param izq con los elementos de la parte izquierda de la lista.
     * @param der con los elementos de la parte derecha de la lista.
     */
    public void merge(List ordenada, List izq, List der) {
        int i1 = 0;
        int i2 = 0;
        
        for (int i = 0; i < ordenada.size(); i++) {
            if (i2 >= der.size() || (i1 < izq.size() && 
                  (Integer) izq.get(i1) <= (Integer) der.get(i2))) {
                ordenada.set(i, izq.get(i1));
                i1++;
                comparaciones++;
            } else {
                ordenada.set(i, der.get(i2));
                i2++;
                comparaciones++;
            }
        }
    }
    
    /**
     * Este método mide el tiempo necesario en buscar un elemento 
     * de una lista mediante busqueda binaria.
     * @param list con la lista para realizar las pruebas.
     */
    private void searchElementoBinaria(List list){
        Collections.sort(list);
        encontrado = false;
        int num = 47;
        int cantidad = list.size();
        int centro;
        int inferior = 0;
        int superior = cantidad-1;
        
        for (int i = 1; i <= pruebas; i++){    
            tiempoInicio = System.nanoTime();
            while(inferior <= superior){
                centro = (superior + inferior)/2;
                if (num == (int) list.get(centro)){
                    encontrado = true;            
                    break;
                }    
                else{
                    if (num < (int) list.get(centro)){
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
        comprobarBusqueda(list, 47, encontrado);
    }
    
    /**
     * Este método mide el tiempo necesario en buscar un elemento 
     * de una lista mediante bucle.
     * @param list con la lista para realizar las pruebas. 
     */
    private void searchElementoBucle(List list){
        encontrado = false;
        for (int i = 1; i <= pruebas; i++){
            int num = 47;
            tiempoInicio = System.nanoTime();
            for (int j = 0; j < list.size(); j++){
                if(num == (int) list.get(j)){
                    encontrado = true;
                    break;
                }    
            }   
            tiempoRequerido = System.nanoTime() - tiempoInicio;
            tiempos.add(tiempoRequerido/1000000);
        }
        calcularTiempos(tiempos);
        comprobarBusqueda(list, 47, encontrado);
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
            bw = new BufferedWriter(new FileWriter(fichero, true));
            bw.newLine();
            bw.newLine();
            for (String cadena : lineas){
                bw.write(cadena);
                bw.newLine();
            }
        }
        else{
            System.out.print("Error, el fichero de resultados.txt no existe.");
        }
        bw.close();
    }
}
