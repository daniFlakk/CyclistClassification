package views.main;

import presenter.Presenter;
import javax.swing.*;
import views.body.ContainerBody;

//import controller.Controller;
import views.header.ContainerHeader;

import java.awt.*;
//import presenters.PresenterApp;
//import views.header.JPContainerHeader;

public class JPMainPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ContainerBody jContainerBody;
    ContainerHeader jContainerHeader;

    public JPMainPanel(Presenter presenter) {
        setLayout(new BorderLayout());
        jContainerBody = new ContainerBody();
        jContainerHeader =  new ContainerHeader(presenter);
        initComponents(presenter);
    }

    private void initComponents( Presenter presenter) {
//        JPanel jPanelt = new JPanel();
//
//        jPanelt.setBackground(Color.decode("#E84A5F"));
////        jPanelt.setSize(100,100);
//
//        JButton jButtonAdd = new JButton();
//        jButtonAdd.setText("AGREGAR");
//        jButtonAdd.setActionCommand(Command.C_ADD_CYCLIST.toString());
//        jButtonAdd.addActionListener(presenter);
//        jPanelt.add(jButtonAdd);
//
//        JButton jButtonEraser = new JButton();
//        jButtonEraser.setText("ELIMINAR");
//        jButtonEraser.setActionCommand(Command.C_ELIMINATE.toString());
//        jButtonEraser.addActionListener(presenter);
//        jPanelt.add(jButtonEraser);
//
//        JButton jButtonrefresh = new JButton();
//        jButtonrefresh.setText("Refrescar");
//        jButtonrefresh.setActionCommand(Command.C_REFRESH.toString());
//        jButtonrefresh.addActionListener(presenter);
//        jPanelt.add(jButtonrefresh);
//
////        JTextField jPanelaux = new JTextField();
////        jPanelaux.setBackground(Color.decode("#FF847C"));
////        jPanelaux.setSize(150,1000);
//
//        JButton jButtonbestw = new JButton();
//        jButtonbestw.setText("mejor mujer");
//        jButtonbestw.setActionCommand(Command.C_BEST_WOMAN.toString());
//        jButtonbestw.addActionListener(presenter);
//        jPanelt.add(jButtonbestw);

        jContainerBody = new ContainerBody();
        jContainerHeader = new ContainerHeader(presenter);
        this.add(jContainerHeader,BorderLayout.NORTH);
        this.add(jContainerBody,BorderLayout.CENTER);
    }

    public void addElementTable(Object[] infoHead){
        jContainerBody.addElementTable(infoHead);
    }

    public void rest(){
        jContainerBody.rest();
    }

    public void changeInfo(String info){
        jContainerBody.changeInfo(info);
    }

    public void removeTable(){
        jContainerBody.removeTable();
    }

    public void changeLanguage(){
        jContainerBody.changeLanguage();
        jContainerHeader.changeLanguage();
    }

    public String fileChoosertest(){
        return jContainerHeader.filechooser();
    }

}