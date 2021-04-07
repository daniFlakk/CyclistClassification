package models;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Santiago Ortega
 *@Date 10/11/2020
 */
public class Chart {
	private ArrayList<Cyclist> cyclists= new ArrayList<>();
	public String cyclistError = "";
	private int count = 0;
	
	/**
	 * Metodo que agrega un ciclistas
	 * @param cyclist: ciclista que se desea agregar
	 */
	public void addCyclist(Cyclist cyclist) {
		if ((cyclist.getActualAge() >= 15 && cyclist.getActualAge() <= 40) && (cyclist.getName().charAt(0) == cyclist.getName().toUpperCase().charAt(0) && cyclist.getLastname().charAt(0) == cyclist.getLastname().toUpperCase().charAt(0)) && (cyclist.getSecondName().charAt(0) == cyclist.getSecondName().toUpperCase().charAt(0)) ){
			cyclists.add(cyclist);
			cyclist.setDorsal(count + 1);
			count = count + 1;
			Collections.sort(cyclists);
		}else {
			cyclistNotValid(cyclist);
		}

	}

	/**
	 * Metodo que pasa el string de corredores no aptos al documento
	 * @param cyclist informacion del ciclista
	 */
	public void cyclistNotValid(Cyclist cyclist){
		cyclistError += (cyclist.objectstring() + "\n");
	}

	/**
	 * Metodo que muestra el mejor tiempo de mujeres
	 * @return mejor ciclista mujer
	 */
	public String printBestWoman() {
//		ArrayList<Object[]> averageList = new ArrayList<>();
		String aux = "";
		for (int i = 0; i < cyclists.size(); i++) {
			if (cyclists.get(i).getGender() == Gender.FEMENINO){
//				averageList.add(cyclists.get(i).objectVector());
				aux = cyclists.get(i).getName() + " " + cyclists.get(i).getLastname() + " " + cyclists.get(i).getFullTime();
                break;
            }
		}
		return aux;
	}
	
	/**
	 * Metodo que calcula el prmedio de los hombres
	 * @return promedio de hombres
	 */
	public LocalTime AverageMale() {
		LocalTime start = LocalTime.of(0, 0, 0);
		int count = 0;
		long seconds = 0;
		long average = 0;
		for (int i = 0; i < cyclists.size(); i++) {
			if (cyclists.get(i).getGender() == Gender.MASCULINO) {
				count++;
				seconds += start.until(cyclists.get(i).getFullTime(), ChronoUnit.SECONDS);
			}
		}
		average = seconds / count;
		return LocalTime.ofSecondOfDay(average);
	}
	
	/**
	 * Metodo que calcula el prmedio de las mujeres
	 * @return Promedio de mujeres
	 */
	public LocalTime AverageFemale() {
		LocalTime start = LocalTime.of(0, 0, 0);
		int count = 0;
		long seconds = 0;
		long average = 0;
		for (int i = 0; i < cyclists.size(); i++) {
			if (cyclists.get(i).getGender() == Gender.FEMENINO) {
				count++;
				seconds += start.until(cyclists.get(i).getFullTime(), ChronoUnit.SECONDS);
			}
		}
		average = seconds / count;
		return LocalTime.ofSecondOfDay(average);
	}

	/**
	 * Metodo que devuelve el ciclista para agregarlo a la tabla
	 * @param i lugar del ciclista en el arreglo
	 * @return el ciclista
	 */
	public Cyclist getRunner(int i){
		return cyclists.get(i);
	}

	/**
	 * Metodo que devuelve el tamaño del array de ciclistas
	 * @return tamaño del arreglo de ciclistas
	 */
	public int getSize(){
		return cyclists.size();
	}

}
