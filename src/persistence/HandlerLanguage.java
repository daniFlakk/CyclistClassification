package persistence;

import java.io.IOException;
import java.util.Properties;

import utils.Utilities;
/**
 * @author Santiago Ortega
 *@Date 10/03/2021
 */
public class HandlerLanguage {
    public String fileName;
    public static String language = "undefined";
    public static Properties languageProperties;

    /**
     * Constructor de la clase HandlerLenguage
     * @param fileName
     */
    public HandlerLanguage(String fileName){
        this.fileName = fileName;
    }

    /**
     * Metodo que carga qel lenguaje
     * @throws IOException
     */
    public void loadLanguage() throws IOException{
        Properties handlerproperties = Utilities.generateProperties(fileName);
        language = handlerproperties.getProperty("Language");

        languageProperties = Utilities.generateProperties(language);
    }

    /**
     * Metodo que guarda el lenguaje
     * @throws IOException
     */
    public void saveLanguage() throws IOException{
        Properties handlerproperties = Utilities.generateProperties(fileName);
        handlerproperties.setProperty("Language", language);
        Utilities.saveProperties( handlerproperties, fileName);
    }
}