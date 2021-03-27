package views;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Santiago Ortega
 *@Date 10/11/2020
 */
public class View {

    private Scanner scanner;
    public static final String WELCOME_MESSAGE = "Bienvenido a la tabla de clasificacion de La Clasica de Ramiriqui";
    public static final String MENU = "1) Agregar Corredor\n2) Mostrar corredores\n3) Mostrar promedio de hombres y mujeres\n4) Mostrar mejor tiempo mujeres";
    public static final String NAME = "Nombre ";
    public static final String LAST_NAME = "Apellido ";
    public static final String DATE_OF_BIRTH = "Fecha de nacimiento AAAA-MM-DD ";
    public static final String GENDER = "Hombre o Mujer";
    public static final String TEAM = "Equipo";
    public static final String TIME_TRAVEL = "Tiempo total";
    public static final String FORMAT = "%1$-20s %2$-5s %3$-25s %4$-25s %5$-8s %6$-5s %7$-10s";
    public static final String HEADER_NAME ="Nombre";
    public static final String HEADER_LAST_NAME ="Apellido";
    public static final String HEADER_DATE ="Fecha de nacimiento";
    public static final String HEADER_GENDER ="Genero";
    public static final String HEADER_TEAM ="Equipo";
    public static final String HEADER_TIME ="Tiempo total";
    public static final String HEADER_AGE ="Edad";
    public static final String HEADER_DORSAL ="DorsalL";
    private Object[] header = {HEADER_TIME,HEADER_DORSAL,LAST_NAME,HEADER_NAME,HEADER_GENDER,HEADER_AGE,TEAM};

    

    /**
     * Metodo constructor
     */
    public View() {
        scanner = new Scanner(System.in);
    }

    /**
     * Metodo que muestra el saludo de bienvenida
     */
    public void printWelcome(){
        System.out.println(WELCOME_MESSAGE);
    }

    /**
     * Metodo que muestra el menu
     * @return opcion elegida
     */
    public int menu() {
        System.out.println(MENU);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Metodo pide el nombre del ciclista a agregar
     * @return nombre del ciclista
     */
    public String name(){
        System.out.println(NAME);
        return scanner.nextLine();
    }

    /**
     * Metodo que pide el apellido del ciclista
     * @return Apellido del ciclista
     */
    public String lastName(){
        System.out.println(LAST_NAME);
        return scanner.nextLine();
    }

    /**
     * Metodo que pide la fecha de nacimiento del ciclista
     * @return Fecha de nacimiento
     */
    public String dateOfBirth(){
        System.out.println(DATE_OF_BIRTH);
        return scanner.nextLine();
    }
    
    /**
     * Metodo que pide el tiempo total de ciclista
     * @return Tiempo total del ciclista
     */
    public String timeTravel(){
        System.out.println(TIME_TRAVEL);
        return scanner.nextLine();
    }

    /**
     * Metodo que pide el genero del ciclista
     * @return genero del ciclista
     */
    public String gender(){
        System.out.println(GENDER);
        return scanner.nextLine();
    }

    /**
     * Metodo que pide el equipo del ciclista
     * @return Equipo del ciclista
     */
    public String team(){
        System.out.println(TEAM);
        return scanner.nextLine();
    }
    /**
     * Metodo que muestra el mensaje de bienvenida
     * @param message mensaje de bienvenida
     */
    public void printMessage(String message){
        System.out.println(message);
    }
    
    /**
     * Metodo que muestra los promedios de hombre y mujer
     * @param avg: promedio hombres
     * @param avgm: Promedio mujeres
     */
    public void printAverage(LocalTime avg, LocalTime avgm) {
		System.out.println("promedio hombres: " + avg);
		System.out.println("Promedio mujeres: " + avgm);
	}

    /**
     * Metodo que muestra la tabla de todos los ciclistas
     * @param aux: lista de objetos ciclistas
     */
    public void showChart(ArrayList<Object[]> aux){
        System.out.println(String.format(FORMAT,header));
        for (Object[] o: aux) {
            System.out.println(String.format(FORMAT,o));
        }
    }
    
    /**
     * Metodo que muestra el mejor tiempo de mujeres
     * @param aux: objeto ejor mujer
     */
    public void showBestWoman(ArrayList<Object[]> aux){
    	System.out.println(String.format(FORMAT,header));
    	for (Object[] o: aux) {
    		System.out.println(String.format(FORMAT,o));
    	}
    }
}