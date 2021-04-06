package models;

import java.time.LocalTime;
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
		if ((cyclist.getActualAge() >= 15 && cyclist.getActualAge() <= 40) && (cyclist.getName().charAt(0) == cyclist.getName().toUpperCase().charAt(0) && cyclist.getLastname().charAt(0) == cyclist.getLastname().toUpperCase().charAt(0) ) ){
			cyclists.add(cyclist);
			cyclist.setDorsal(count + 1);
			count = count + 1;
			Collections.sort(cyclists);
		}else {
			cyclistNotValid(cyclist);
		}

	}

	public void cyclistNotValid(Cyclist cyclist){
		String auxc = " ";
		auxc = auxc + cyclist.objectstring();
//		System.out.println(cyclist.objectstring());
		cyclistError += (cyclist.objectstring() + "\n");
//		return auxc;
	}
//	public void order(ArrayList a){
//		Collections.sort(a);
//	}
//	/**
//	 * Metodo que muestra la lista de corredores
//	 * @return lista de corredores
//	 */
//	public ArrayList<Object[]> printlist() {
//		ArrayList<Object[]> list = new ArrayList<>();
//		for (int i = 0; i < cyclists.size(); i++) {
//			list.add(cyclists.get(i).objectVector());
//		}
//		return list;
//	}


	public String getCyclistError() {
		return cyclistError;
	}

	/**
	 * Metodo que muestra el mejor tiempo de mujeres
	 * @return mejor ciclista mujer
	 */
	public String printBestWoman() {
//		ArrayList<Object[]> averageList = new ArrayList<>();
		String aux = "";
		for (int i = 0; i < cyclists.size(); i++) {
			if (cyclists.get(i).getGender() == Gender.FEMALE){
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
			int count = 0;
			LocalTime average = LocalTime.of(0, 0,0);
			LocalTime averagFinal = LocalTime.of(0, 0,0);
			for (int i = 0; i < cyclists.size(); i++) {
				if (cyclists.get(i).getGender() == Gender.MALE) {
					count = count +1;
					average = average.plusSeconds(cyclists.get(i).toSeconds());
				}
			}
			averagFinal = averagFinal.plusSeconds((average.getHour()*3600 + average.getMinute()*60 + average.getSecond())/count);
			return averagFinal;
	}
	
	/**
	 * Metodo que calcula el prmedio de las mujeres
	 * @return Promedio de mujeres
	 */
	public LocalTime AverageFemale() {
		int count = 0;
		LocalTime average = LocalTime.of(0, 0,0);
		LocalTime averagFinal = LocalTime.of(0, 0,0);
		for (int i = 0; i < cyclists.size(); i++) {
			if (cyclists.get(i).getGender() == Gender.FEMALE) {
				count = count +1;
				average = average.plusSeconds(cyclists.get(i).toSeconds());
			}
		}
		averagFinal = averagFinal.plusSeconds((average.getHour()*3600 + average.getMinute()*60 + average.getSecond())/count);
		return averagFinal;
	}

	public Cyclist getRunner(int i){
		return cyclists.get(i);
	}

	public int getSize(){
		return cyclists.size();
	}
}
