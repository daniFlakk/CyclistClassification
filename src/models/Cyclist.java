package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * @author Santiago Ortega
 *@Date 10/11/2020
 */
public class Cyclist implements Comparable<Cyclist> {
	private String name;
	private String secondName;
	private String lastname;
	private Gender gender;
	private LocalDate age;
	private LocalTime fullTime;
	private int dorsal;
	private int actualAge;
	private Team team;
	
	/**
	 * Metodo constructor
	 * @param name :Nombre ciclista
	 * @param lastname: Apellido ciclista
	 * @param gender: Genero del ciclista
	 * @param age: Fecha de nacimiento del ciclista
	 * @param fullTime: Tiempo total del ciclista
	 * @param team: Equipo del ciclista
	 */
	public Cyclist(String name,String secondName, String lastname, Gender gender, LocalDate age, LocalTime fullTime, Team team) {
		this.name = name;
		this.secondName = secondName;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.fullTime = fullTime;
		this.team = team;
		setActualAge();
	}

	/**
	 * Metodo constructor sin parametros
	 */
	public Cyclist() {

	}

	/**
	 * Metodo que convierte horas minutos y segunodos a solo segundos
	 * @return cantidad de segundos
	 */
	public int toSeconds() {
		return(fullTime.getHour()*3600 + fullTime.getMinute()*60 + fullTime.getSecond());
	}

	/**
	 * Metodo que devuelve el nombre del ciclista
	 * @return nombre ciclista
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que devuelve el apellido del ciclista
	 * @return nombre ciclista
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Metodo que devuelve el genero del ciclista
	 * @return genero ciclista
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Metodo que devuelve la fecha de nacimiento del ciclista
	 * @return fecha de nacimiento ciclista
	 */
	public LocalDate getAge() {
		return age;
	}
	
	/**
	 * Metodo que da una edad al ciclista
	 */
	public void setActualAge() {
		this.actualAge = Period.between(age, LocalDate.now()).getYears();
	}

	/**
	 * Metodo que devuelve el tiempo del ciclista
	 * @return tiempo ciclista
	 */
	public LocalTime getFullTime() {
		return fullTime;
	}

	/**
	 * Metodo que da un numero de dorsal al ciclista
	 * @param dorsal: Numero de dorsa
	 */
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	/**
	 * Metodo que devuelve la edad actual del ciclista
	 * @return edad ciclista
	 */
	public int getActualAge() {
		return actualAge;
	}

	/**
	 *Metodo que sirve para comparar los tiempos de los ciclistas
	 */
	@Override
    public int compareTo(Cyclist o) {
        return fullTime.compareTo(o.fullTime);
    }

	/**
	 * Metodo que devuelve el equipo del ciclista
	 * @return equipo ciclista
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Metodo que convierte de objeto a vector
	 * @return un vector
	 */
	public Object[] objectVector() {
		return new Object[] {dorsal,name,secondName,lastname,age,gender,team,fullTime,getActualAge()};
	}

	/**
	 * Metodo getter para secondName
	 * @return el segundo nombre del ciclista
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * Metodo que convierto un objeto cyclist a String
	 * @return un string con los datos del ciclista
	 */
	public String objectstring(){
		String auxs = getName() + " " + getSecondName() + " " + getLastname() + " " + getAge() + " " + getGender() + " " + getTeam() + " " + getFullTime();
		return auxs;
	}

}
