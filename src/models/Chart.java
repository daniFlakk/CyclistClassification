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
	private int count = 0;
	
	/**
	 * Metodo que agrega un ciclistas
	 * @param cyclist: ciclista que se desea agregar
	 */
	public void addCyclist(Cyclist cyclist) {
		cyclists.add(cyclist);
		cyclist.setDorsal(count + 1);
		count = count + 1;
		Collections.sort(cyclists);
	}


	public void order(ArrayList a){
		Collections.sort(a);
	}
	/**
	 * Metodo que muestra la lista de corredores
	 * @return lista de corredores
	 */
	public ArrayList<Object[]> printlist() {
		ArrayList<Object[]> list = new ArrayList<>();
		for (int i = 0; i < cyclists.size(); i++) {
			list.add(cyclists.get(i).objectVector());
		}
		return list;
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
