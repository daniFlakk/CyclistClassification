package presenter;

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

/**
 * @author Santiago Ortega
 *@Date 10/03/2021
 */
public class Presenter implements ActionListener {

    JfMainWindow jfMainWindow;
    Cyclist cyclist;
    Chart chart;
    HandlerLanguage handlerLanguage;
    ManagerFiles managerFiles;

    private ManagerFiles mngFile;

    public Presenter() {
        jfMainWindow = new JfMainWindow(this);
        cyclist = new Cyclist();
        chart = new Chart();
        loadConfiguration();

        for (int i = 0; i < chart.getSize(); i++) {
            jfMainWindow.addElementTable(chart.getRunner(i).objectVector());
        }
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
                break;
            case C_WRITEFILE:
                managerFiles.writeNewfile(writeFile(), chart.cyclistError);

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

    public String writeFile(){
        return jfMainWindow.saveChooser();
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
        Gender gender1;
        if ( stringG.equals("Femenino")) {
            gender1 = Gender.FEMENINO;
        }else{
            gender1 = Gender.MASCULINO;
        }
        return gender1;
    }

    public LocalDate arrayToLocalDate(String dates){
        String[] array = dates.split("/");
        return LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[0]), Integer.parseInt(array[1]));
    }

    public static void main(String[] args) {
        new Presenter();
    }
}

