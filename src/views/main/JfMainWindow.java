package views.main;

//import view.body.JPBody;
//import view.constant.ConstantUI;

import models.Cyclist;
import presenter.Presenter;
import views.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class JfMainWindow extends JFrame {

    JPMainPanel jpMainPanel;
    AddCyclistJDialog addCyclistJDialog;



    public JfMainWindow(Presenter presenter) throws HeadlessException {
//        setMinimumSize(new Dimension(900,400));
        setExtendedState( MAXIMIZED_BOTH );
        this.setIconImage(new ImageIcon(getClass().getResource(ConstantsUI.PATH_ICON)).getImage());
        setTitle("Registro");
        setLocationRelativeTo( null );
        //setIconImage(new ImageIcon(getClass().getResource(ConstantUI.LOGO_MAIN)).getImage());
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        starComponent(presenter);
        setVisible(true);
    }

    public void starComponent(Presenter presenter) {
        jpMainPanel = new JPMainPanel(presenter);
        JScrollPane jScorllPane = new JScrollPane(jpMainPanel);

        addCyclistJDialog = new AddCyclistJDialog(presenter);
        this.add(jScorllPane);
        this.add(jpMainPanel);

        //Retorno
        JLabel previus = new JLabel();
        previus.setBounds(10,650,20,20);

    }

    public Cyclist makecyclist() {
        return addCyclistJDialog.createRunner();
    }

    public void ShowDiag(){
        addCyclistJDialog.setVisible(true);
    }

    public void addElementTable(Object[] objectVector) {
        jpMainPanel.addElementTable(objectVector);
    }

    public void removeTable(){
        jpMainPanel.removeTable();
    }

    public void changeInfo(String info){
        jpMainPanel.changeInfo(info);
    }

    public void changeLanguage(){
        jpMainPanel.changeLanguage();
    }

    public void  rest(){
        jpMainPanel.rest();
    }

    public String fileChoosertest(){
        return jpMainPanel.fileChoosertest();
    }

    public String saveChooser(){
        return jpMainPanel.saveChooser();
    }

//    public void changeMessage(String message){
//        jpMainPanel.changeMessage(message);
//    }
}
