package models;
/**
 * @author Santiago Ortega
 *@Date 10/11/2020
 */
public enum Gender {
    MASCULINO("Masculino"), FEMENINO("Femenino");

    private String gender;

    /**
     * Constructor de la clase gender
     * @param gender
     */
    Gender(String gender) {
        this.gender = gender;
    }
}