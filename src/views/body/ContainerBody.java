package views.body;

import jdk.internal.org.objectweb.asm.Handle;
import persistence.HandlerLanguage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ContainerBody extends JPanel {

    private DefaultTableModel tableStandar;
    private JTable tableItems;
    private JScrollPane jScrollPane;
    private InfoPanel infoPanel;

    public ContainerBody() {
//        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);
        infoPanel = new InfoPanel();
        initComponents();
    }

    private void initComponents(){
        String[] heads = {"Dorsal","Nombre","Segundo nombre","Apellido","Fecha De Nacimiento","Género","Equipo","Tiempo De Vuelta","Edad"};
        tableStandar = new DefaultTableModel();
        tableStandar.setColumnIdentifiers(heads);

        tableItems = new JTable();
        tableItems.setModel(tableStandar);
        tableItems.getTableHeader().setReorderingAllowed(false);
        tableItems.getTableHeader().setBackground(Color.decode("#5FBDD6"));
        tableItems.getTableHeader().setForeground(Color.WHITE);
        tableItems.setBackground(Color.decode("#96c8a2"));
        tableItems.setFillsViewportHeight(true);
        tableItems.setRowHeight(25);


        jScrollPane = new JScrollPane(tableItems);
        jScrollPane.setAlignmentX(LEFT_ALIGNMENT);



        this.add(jScrollPane,BorderLayout.CENTER);
        this.add(infoPanel,BorderLayout.SOUTH);
    }

    public void addElementTable(Object[] infoHeads){
//        setVisible(false);
        tableStandar.addRow(infoHeads);


    }

    public void removeTable(){
        tableStandar.setNumRows(0);
    }

    public void rest() {
        int row = tableItems.getSelectedRow();
        tableStandar.removeRow(row);
    }

    public void changeInfo(String info){
        infoPanel.changeInfo(info);
    }

    public void changeLanguage(){
        tableStandar.setColumnIdentifiers(new String[]{
                HandlerLanguage.languageProperties.getProperty("Cyclist_Dorsal"),
                HandlerLanguage.languageProperties.getProperty("Cyclist_Name"),
                HandlerLanguage.languageProperties.getProperty("Cyclist_Second"),
                HandlerLanguage.languageProperties.getProperty("Cyclist_Lastname"),
                HandlerLanguage.languageProperties.getProperty("Cyclist_Born"),
                HandlerLanguage.languageProperties.getProperty("Cyclist_Gender"),
                HandlerLanguage.languageProperties.getProperty("Cyclist_Team"),
                HandlerLanguage.languageProperties.getProperty("Cyclist_FullTime"),
                HandlerLanguage.languageProperties.getProperty("Cyclist_Age")});
        infoPanel.changeLenguaje();
    }


    }
//}
