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
	 * Metodo que da nombre a un ciclista
	 * @param name:nombre que recibe el ciclista
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que devuelve el apellido del ciclista
	 * @return nombre ciclista
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Metodo que da apellido al ciclista
	 * @param lastname: apellido del ciclista
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * Metodo que devuelve el genero del ciclista
	 * @return genero ciclista
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Metodo que da el genero a un ciclista
	 * @param gender: genero del ciclista
	 */
//	public void setGender(String gender) {
//		this.gender = gender;
//	}

	/**
	 * Metodo que devuelve la fecha de nacimiento del ciclista
	 * @return fecha de nacimiento ciclista
	 */
	public LocalDate getAge() {
		return age;
	}
	
	/**
	 * Metodo que da una fecha de nacimiento al ciclista
	 * @param age: fecha de nacimiento del ciclista
	 */
	public void setAge(LocalDate age) {
		this.age = age;
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
	 * Metodo que da un tiempo total de carrera al ciclista
	 * @param fullTime: Tiempo total del ciclista
	 */
	public void setFullTime(LocalTime fullTime) {
		this.fullTime = fullTime;
	}

	/**
	 * Metodo que devuelve el dorsal del ciclista
	 * @return dorsal ciclista
	 */
	public int getDorsal() {
		return dorsal;
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
	 * Metodo que da un equipo al ciclista
	 * @param team: equipo
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	/**
	 * Metodo que convierte de objeto a vector
	 * @return un vector
	 */
	public Object[] objectVector() {
		return new Object[] {dorsal,name,secondName,lastname,age,gender,team,fullTime,getActualAge()};
	}
	
	
}
