package views.header;

import persistence.HandlerLanguage;
import presenter.Command;
import presenter.Presenter;
import views.ConstantsUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContainerHeader extends JToolBar {

    JButton jButtonAverage;
    JPanel jPanelt;

    /**
     * Metodo constructor de la clase ContainerHeader
     * @param presenter
     */
    public ContainerHeader(Presenter presenter) {
        setLayout(new BorderLayout());
        this.setFloatable(false);
        setVisible(true);
        initiComponents(presenter);

    }

    /**
     * Metodo que inicia los componentes de panel header
     * @param presenter
     */
    public void initiComponents(Presenter presenter){
        jPanelt = new JPanel();

        jPanelt.setBackground(Color.decode("#215B6F"));

        JButton jButtonAdd = new JButton();
        jButtonAdd.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_NEW_CYCLIST)).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        jButtonAdd.setActionCommand(Command.C_ADD_CYCLIST_DIALOG.toString());
        jButtonAdd.addActionListener(presenter);
        jButtonAdd.setBorderPainted(false);
        jButtonAdd.setBackground(Color.decode("#215B6F"));
        jPanelt.add(jButtonAdd);

        JButton jButtonEraser = new JButton();
        jButtonEraser.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_REMOVE)).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        jButtonEraser.setActionCommand(Command.C_ELIMINATE.toString());
        jButtonEraser.addActionListener(presenter);
        jButtonEraser.setBorderPainted(false);
        jButtonEraser.setBackground(Color.decode("#215B6F"));
        jPanelt.add(jButtonEraser);

        JButton jButtonrefresh = new JButton();
        jButtonrefresh.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_REFRESH)).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        jButtonrefresh.setActionCommand(Command.C_REFRESH.toString());
        jButtonrefresh.addActionListener(presenter);
        jButtonrefresh.setBorderPainted(false);
        jButtonrefresh.setBackground(Color.decode("#215B6F"));
        jPanelt.add(jButtonrefresh);

        JButton jButtonbestw = new JButton();
        jButtonbestw.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_BEST_WOMAN)).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        jButtonbestw.setActionCommand(Command.C_BEST_WOMAN.toString());
        jButtonbestw.addActionListener(presenter);
        jButtonbestw.setBorderPainted(false);
        jButtonbestw.setBackground(Color.decode("#215B6F"));
        jPanelt.add(jButtonbestw);

        jButtonAverage = new JButton();
        jButtonAverage.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_AVERAGE)).getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
//        jButtonAverage.setText("Promedio por generos");
        jButtonAverage.setActionCommand(Command.C_AERAGE.toString());
        jButtonAverage.setBorderPainted(false);
        jButtonAverage.setBackground(Color.decode("#215B6F"));
        jButtonAverage.addActionListener(presenter);
        jPanelt.add(jButtonAverage);

        JButton jButtonenglish = new JButton();
        jButtonenglish.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_USA)).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        jButtonenglish.setBorderPainted(false);
        jButtonenglish.setBackground(Color.decode("#215B6F"));
        jButtonenglish.setActionCommand(Command.C_ENGLISH.toString());
        jButtonenglish.addActionListener(presenter);
        jPanelt.add(jButtonenglish);

        JButton jButtonEspanish = new JButton();
        jButtonEspanish.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_SPAIN)).getImage().getScaledInstance(55,40,Image.SCALE_SMOOTH)));
        jButtonEspanish.setBorderPainted(false);
        jButtonEspanish.setBackground(Color.decode("#215B6F"));
        jButtonEspanish.setActionCommand(Command.C_ESPANISH.toString());
        jButtonEspanish.addActionListener(presenter);
        jPanelt.add(jButtonEspanish);

        JButton jButtonchooser = new JButton();
        jButtonchooser.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_ADD_FILE)).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        jButtonchooser.setBorderPainted(false);
        jButtonchooser.setBackground(Color.decode("#215B6F"));
        jButtonchooser.setActionCommand(Command.C_FILECHOOSER.toString());
        jButtonchooser.addActionListener(presenter);
        jPanelt.add(jButtonchooser);

        JButton jbuttonwriter = new JButton();
//        jbuttonwriter.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_ADD_FILE)).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        jbuttonwriter.setText("Sacar archivo");
        jbuttonwriter.setBorderPainted(false);
        jbuttonwriter.setBackground(Color.decode("#215B6F"));
        jbuttonwriter.setActionCommand(Command.C_WRITEFILE.toString());
        jbuttonwriter.addActionListener(presenter);
        jPanelt.add(jbuttonwriter);

        this.add(jPanelt);

    }

//    /**
//     * Metodo Para cambiar el idioma de un boton
//     */
//    public void changeLanguage(){
//        jButtonAverage.setText(HandlerLanguage.languageProperties.getProperty("Average_button"));
//    }

    /**
     * Metodo que permite seleccionar un fichero para lectura
     * @return Ruta absoluta
     */
    public String filechooser(){
        JFileChooser fc=new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.bike", "bike");
        fc.setFileFilter(filter);
        int seleccion=fc.showOpenDialog(this);
        String aux;
        aux = " ";

        if(seleccion==JFileChooser.APPROVE_OPTION){
            File fichero=fc.getSelectedFile();
            aux = fichero.getAbsolutePath();
        }
        return aux;
    }

    /**
     * Metodo que permite seleccionar un fichero para escritura
     *
     */
    public String saveChooser(){
        JFileChooser fcs=new JFileChooser();
        String aux = "";

        int seleccion=fcs.showSaveDialog(this);

        if(seleccion==JFileChooser.APPROVE_OPTION){
            //Seleccionamos el fichero
            File fichero=fcs.getSelectedFile();
            aux = fichero.getAbsolutePath();
//            try(FileWriter fw=new FileWriter(fichero)){
//
////                Escribimos el texto en el fichero
//                fw.write("textArea.getText()");
//
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }

        }
        return aux;
    }

}
