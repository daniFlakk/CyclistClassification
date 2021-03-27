//package controller;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import exception.CyclistAgeExeption;
//import exception.CyclistMayusExeption;
//import models.*;
//import views.*;
//import views.main.JfMainWindow;
//
//import static presenter.Command.C_AGREGAR;
//
///**
// * @author Santiago Ortega
// *@Date 10/11/2020
// */
//public class Controller {
//	private View views;
//	private Chart chart;
//	private int ageAux;
//	private String nameAux;
//	private String lastAux;
//	private JfMainWindow jfMainWindow;
//
//
//	/**
//	 * Metodo constructor
//	 */
//	public Controller() {
//		views = new View();
//		chart = new Chart();
////		jfMainWindow = new JfMainWindow();
//
//
//	}
//
//	/**
//	 * Metodo donde se encuentra el menu
//	 */
//	public void start() {
//		views.printWelcome();
//		switch (views.menu()) {
//		case 1:
////			jfMainWindow.starComponent();
//			createCyclist();
//			start();
//			break;
//		case 2:
//			views.showChart(chart.printlist());
//			start();
//			break;
//		case 3:
//			averageMen(chart.AverageMale(),chart.AverageFemale());
//			start();
//			break;
//		case 4:
//			views.showBestWoman(chart.printBestWoman());
//			start();
//			break;
//		}
//	}
//
//	/**
//	 * Metodo que verifica que la edad del corredor sea mayor o igual a 15 y menor o igual a 40
//	 * @return true si la edad es valida
//	 * @throws CyclistAgeExeption
//	 */
//	public boolean checkAge()throws CyclistAgeExeption{
//        if( ageAux >= 15 && ageAux <= 40 ){
//            return true;
//        }else {
//            throw new CyclistAgeExeption("Edad incorrecta");
//        }
//    }
//
//	/**
//	 * Metodo que muestra los promedios de hombres y mujeres
//	 * @param averg: tiempo de promedio hombres
//	 * @param avergm: Tiempo de promedio de mujeres
//	 */
//	public void averageMen(LocalTime averg, LocalTime avergm) {
//		views.printAverage(averg,avergm);
//	}
//
//	/**
//	 * Metodo para precrear ciclistas
//	 */
//	public void makeCyclist(){
//        chart.addCyclist(new Cyclist("Andrea", "Lopez", "Mujer", LocalDate.of(2001,12,02),LocalTime.of(1,10,30), Team.ASTANA));
//        chart.addCyclist(new Cyclist("Andres", "Nares", "Hombre", LocalDate.of(2000,2,22),LocalTime.of(2,1,10), Team.INEOS));
//        chart.addCyclist(new Cyclist("Lucho", "Herrera", "Hombre", LocalDate.of(1995,10,18),LocalTime.of(1,1,1), Team.EF));
//        chart.addCyclist(new Cyclist("Camila", "Ortega", "Mujer", LocalDate.of(1996,6,12),LocalTime.of(2,1,17), Team.MOVISTAR));
//        chart.addCyclist(new Cyclist("Dora", "Melendes", "Mujer", LocalDate.of(1999,8,22),LocalTime.of(1,20,11), Team.UAE));
//        chart.addCyclist(new Cyclist("Laura", "Benavides", "Mujer", LocalDate.of(2001,2,28),LocalTime.of(1,11,2), Team.ASTANA));
//        chart.addCyclist(new Cyclist("Camilo", "Joya", "Hombre", LocalDate.of(1989,8,4),LocalTime.of(1,13,1), Team.INEOS));
//        chart.addCyclist(new Cyclist("Shinji", "Ikari", "Hombre", LocalDate.of(2004,9,18),LocalTime.of(1,25,10), Team.EF));
//        chart.addCyclist(new Cyclist("Ricardo", "Montaner", "Hombre", LocalDate.of(1990,6,4),LocalTime.of(1,19,40), Team.MOVISTAR));
//        chart.addCyclist(new Cyclist("Angela", "Barreto", "Mujer", LocalDate.of(2002,7,15),LocalTime.of(1,30,36), Team.UAE));
//        chart.addCyclist(new Cyclist("Julissa", "Martines", "Mujer", LocalDate.of(2000,10,1),LocalTime.of(1,19,30), Team.ASTANA));
//        chart.addCyclist(new Cyclist("Nairo", "Quintana", "Hombre", LocalDate.of(1990,2,4),LocalTime.of(1,0,58), Team.INEOS));
//        chart.addCyclist(new Cyclist("Egan", "Bernal", "Hombre", LocalDate.of(1993,4,29),LocalTime.of(1,2,1), Team.EF));
//        chart.addCyclist(new Cyclist("Sarith", "Lopez", "Mujer", LocalDate.of(2001,11,7),LocalTime.of(1,5,1), Team.MOVISTAR));
//        chart.addCyclist(new Cyclist("Diego", "Puerto", "Hombre", LocalDate.of(1990,7,24),LocalTime.of(1,18,8), Team.UAE));
//	}
//
//    /**
//     * Metodo que verifica si la primera letra del nombre es mayuscula
//     * @return: Tru si la condicion se cumple
//     * @throws CyclistMayusExeption
//     */
//    public boolean checkMayus() throws CyclistMayusExeption{
//        if(nameAux.charAt(0) == nameAux.toUpperCase().charAt(0) && lastAux.charAt(0) == lastAux.toUpperCase().charAt(0) ){
//            return true;
//        }else {
//            throw new CyclistMayusExeption("Nombre bad");
//        }
//    }
//
//    /**
//     * Metodo que crea ciclistas
//     */
//    public void createCyclist(){
//        try {
//            Cyclist cyclist = new Cyclist(views.name(), views.lastName(), views.gender(), LocalDate.parse(views.dateOfBirth()), LocalTime.parse(views.timeTravel()), Team.valueOf(views.team()));
//            ageAux = cyclist.getActualAge();
//            nameAux = cyclist.getName();
//            lastAux = cyclist.getLastname();
//            if(checkAge() && checkMayus()){
//                chart.addCyclist(cyclist);
//            }
//        }catch (CyclistAgeExeption cyclistAgeExeption){
//            views.printMessage(cyclistAgeExeption.getMessage());
//        }catch (CyclistMayusExeption cyclistMayusExeption){
//            views.printMessage(cyclistMayusExeption.getMessage());
//        }
//    }
//
//	/**
//	 * Metodo principal
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		Controller ct = new Controller();
//		ct.makeCyclist();
//		ct.start();
//
//
//	}
//
////	@Override
////	public void actionPerformed(ActionEvent e) {
////		switch (command.valueOf( e.getActionCommand())){
////			case C_AGREGAR;
////				break;
////			default:
////				break;
////
////		}
////	}
//}