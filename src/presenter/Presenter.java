package presenter;

import exception.CyclistAgeExeption;
import exception.CyclistMayusExeption;
import models.Chart;
import models.Cyclist;
import models.Gender;
import models.Team;
import persistence.HandlerLanguage;
import persistence.ManagerFiles;
import views.main.AddCyclistJDialog;
import views.main.JfMainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;


public class Presenter implements ActionListener {

    JfMainWindow jfMainWindow;
    Cyclist cyclist;
    Chart chart;
    HandlerLanguage handlerLanguage;
    ManagerFiles managerFiles;
    private Gender gender;
    private int ageAux;
    private String nameAux;
    private String lastAux;

    private ManagerFiles mngFile;

    public Presenter() {
        jfMainWindow = new JfMainWindow(this);
        cyclist = new Cyclist();
        chart = new Chart();
        loadConfiguration();

        makeCyclist();
        for (int i = 0; i < chart.getSize(); i++) {
            jfMainWindow.addElementTable(chart.getRunner(i).objectVector());
        }
    }

    public void makeCyclist(){
        chart.addCyclist(new Cyclist("Andrea", "Carolina", "Lopez", Gender.FEMALE, LocalDate.of(2001,12,02), LocalTime.of(1,10,30), Team.ASTANA));
        chart.addCyclist(new Cyclist("Andres","Manuel", "Nares", Gender.MALE, LocalDate.of(2000,2,22),LocalTime.of(2,1,10), Team.INEOS));
        chart.addCyclist(new Cyclist("Lucho","", "Herrera", Gender.MALE, LocalDate.of(1995,10,18),LocalTime.of(1,1,1), Team.EF));
        chart.addCyclist(new Cyclist("Camila","", "Ortega", Gender.FEMALE, LocalDate.of(1996,6,12),LocalTime.of(2,1,17), Team.MOVISTAR));
        chart.addCyclist(new Cyclist("Dora","exploradora", "Melendes", Gender.FEMALE, LocalDate.of(1999,8,22),LocalTime.of(1,20,11), Team.UAE));
        chart.addCyclist(new Cyclist("Laura","", "Benavides", Gender.FEMALE, LocalDate.of(2001,2,28),LocalTime.of(1,11,2), Team.ASTANA));
        chart.addCyclist(new Cyclist("Camilo","", "Joya", Gender.MALE, LocalDate.of(1989,8,4),LocalTime.of(1,13,1), Team.INEOS));
        chart.addCyclist(new Cyclist("Shinji","", "Ikari", Gender.MALE, LocalDate.of(2004,9,18),LocalTime.of(1,25,10), Team.EF));
        chart.addCyclist(new Cyclist("Ricardo","", "Montaner", Gender.MALE, LocalDate.of(1990,6,4),LocalTime.of(1,19,40), Team.MOVISTAR));
        chart.addCyclist(new Cyclist("Angela","", "Barreto", Gender.FEMALE, LocalDate.of(2002,7,15),LocalTime.of(1,30,36), Team.UAE));
        chart.addCyclist(new Cyclist("Julissa","", "Martines", Gender.FEMALE, LocalDate.of(2000,10,1),LocalTime.of(1,19,30), Team.ASTANA));
        chart.addCyclist(new Cyclist("Nairo","", "Quintana", Gender.MALE, LocalDate.of(1990,2,4),LocalTime.of(1,0,58), Team.INEOS));
        chart.addCyclist(new Cyclist("Egan","", "Bernal", Gender.MALE, LocalDate.of(1993,4,29),LocalTime.of(1,2,1), Team.EF));
        chart.addCyclist(new Cyclist("Sarith","", "Lopez", Gender.FEMALE, LocalDate.of(2001,11,7),LocalTime.of(1,5,1), Team.MOVISTAR));
        chart.addCyclist(new Cyclist("Diego","", "Puerto", Gender.MALE, LocalDate.of(1990,7,24),LocalTime.of(1,18,8), Team.UAE));
	}


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf( e.getActionCommand())){
            case C_ADD_CYCLIST_DIALOG:
                jfMainWindow.ShowDiag();
                new AddCyclistJDialog(this);
                break;
            case C_NEW_CLYCLIST:
                Cyclist aux =  jfMainWindow.makecyclist();
                chart.addCyclist(aux);
                jfMainWindow.addElementTable(aux.objectVector());
                break;
            case C_ELIMINATE:
                jfMainWindow.rest();
                break;
            case C_REFRESH:
                refreshTable();
                break;
            case C_BEST_WOMAN:
                jfMainWindow.changeInfo("Mejor mujer: " + chart.printBestWoman());
                break;
            case C_AERAGE:
                jfMainWindow.changeInfo("<html>El promedio de tiempo de los masculino es: "+chart.AverageMale().toString()+"<br> El promedio de tiempo de las femenino es: "+chart.AverageFemale()+"</hmtl>");
                break;
            case C_ENGLISH:
                manageChangeLanguageUS();
                break;
            case C_ESPANISH:
                manageChangeLanguageES();
                break;
            case C_FILECHOOSER:
                addDoc();
                refreshTable();
            default:
                break;
            }
        }

    private void manageChangeLanguageUS(){
        try {
            changeToEnglish();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(jfMainWindow, e1.getMessage());
        }
        manageChangeLanguage();
    }

    /**
     * Metodo que verifica que la edad del corredor sea mayor o igual a 15 y menor o igual a 40
     * @return true si la edad es valida
     * @throws CyclistAgeExeption
     */
    public boolean checkAge()throws CyclistAgeExeption{
        if( ageAux >= 15 && ageAux <= 40 ){
            return true;
        }else {
            throw new CyclistAgeExeption("Edad incorrecta");
        }
    }

    /**
     * Metodo que verifica si la primera letra del nombre es mayuscula
     * @return: Tru si la condicion se cumple
     * @throws CyclistMayusExeption
     */
    public boolean checkMayus() throws CyclistMayusExeption{
        if(nameAux.charAt(0) == nameAux.toUpperCase().charAt(0) && lastAux.charAt(0) == lastAux.toUpperCase().charAt(0) ){
            return true;
        }else {
            throw new CyclistMayusExeption("Nombre bad");
        }
    }
    private void manageChangeLanguageES(){
        try {
            changeToSpanish();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(jfMainWindow, e1.getMessage());
        }
        manageChangeLanguage();
    }

    public void changeToEnglish() throws IOException {
        HandlerLanguage.language = "resources/languages/languageUS.properties";
        saveConfig();
        loadLanguage();
    }

    private void manageChangeLanguage(){
        jfMainWindow.changeLanguage();
    }

    public void loadConfiguration(){
        if(handlerLanguage == null){
            handlerLanguage = new HandlerLanguage("resources/config/config.init");
        }
        try{
            handlerLanguage.loadLanguage();
        }catch(IOException e){
//			JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void loadLanguage(){
        try {
            handlerLanguage.loadLanguage();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
        }
    }

    public void saveConfig(){
        try {
            new HandlerLanguage("resources/config/config.init").saveLanguage();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
        }
    }

    public void refreshTable(){
        jfMainWindow.removeTable();
        for (int j = 0; j < chart.getSize(); j++) {
            jfMainWindow.addElementTable(chart.getRunner(j).objectVector());
        }
    }

    public void addDoc(){
        try {
            String auxPath = jfMainWindow.fileChoosertest();
            managerFiles = new ManagerFiles(auxPath);
            startFile(mngFile);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void changeToSpanish() throws IOException{
        HandlerLanguage.language = "resources/languages/languageES.properties";
        saveConfig();
        loadLanguage();
    }

    private void startFile(ManagerFiles files) throws IOException {
        String cyclistFile;
        String[]   cyclistinfo;

        managerFiles.newFile('r');

        while ((cyclistFile = managerFiles.reader()) != null){
            cyclistinfo = cyclistFile.split("\\?+");
            LocalDate localDate = arrayToLocalDate(cyclistinfo[4]);
            if (cyclistinfo[6].equals("IAM CYCLING")){
                chart.addCyclist(new Cyclist(cyclistinfo[1],cyclistinfo[2],cyclistinfo[3], newGender(cyclistinfo[5]), localDate, LocalTime.parse(cyclistinfo[7]), Team.IAM_CYCLING));

            }else {
                chart.addCyclist(new Cyclist(cyclistinfo[1],cyclistinfo[2],cyclistinfo[3], newGender(cyclistinfo[5]), localDate, LocalTime.parse(cyclistinfo[7]), Team.valueOf(cyclistinfo[6])));
            }
        }
        managerFiles.close();
    }

    public Gender newGender(String stringG){
        if ( stringG == "Femenino") {
            return Gender.FEMALE;
        }else{
            return Gender.MALE;
        }
    }

    public LocalDate arrayToLocalDate(String dates){
        String[] array = dates.split("/");
        return LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[0]), Integer.parseInt(array[1]));
    }

    public static void main(String[] args) {
        new Presenter();
    }
}

