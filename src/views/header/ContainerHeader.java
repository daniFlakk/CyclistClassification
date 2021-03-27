package views.header;

import persistence.HandlerLanguage;
import presenter.Command;
import presenter.Presenter;
import views.ConstantsUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContainerHeader extends JPanel {

    JButton jButtonAverage;
    JTextField textField;
    JTextArea textArea;
    JPanel jPanelt;

    public ContainerHeader(Presenter presenter) {
        setLayout(new BorderLayout());
        setVisible(true);
        initiComponents(presenter);

    }

    public void initiComponents(Presenter presenter){
        jPanelt = new JPanel();

        jPanelt.setBackground(Color.decode("#215B6F"));

        JButton jButtonAdd = new JButton();
        jButtonAdd.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_NEW_CYCLIST)).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
        jButtonAdd.setActionCommand(Command.C_ADD_CYCLIST.toString());
        jButtonAdd.addActionListener(presenter);
        jButtonAdd.setBorderPainted(false);
        jPanelt.add(jButtonAdd);

        JButton jButtonEraser = new JButton();
        jButtonEraser.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_REMOVE)).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
        jButtonEraser.setActionCommand(Command.C_ELIMINATE.toString());
        jButtonEraser.addActionListener(presenter);
        jButtonEraser.setBorderPainted(false);
        jPanelt.add(jButtonEraser);

        JButton jButtonrefresh = new JButton();
        jButtonrefresh.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_REFRESH)).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
        jButtonrefresh.setActionCommand(Command.C_REFRESH.toString());
        jButtonrefresh.addActionListener(presenter);
        jPanelt.add(jButtonrefresh);

        JButton jButtonbestw = new JButton();
        jButtonbestw.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_BEST_WOMAN)).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
        jButtonbestw.setActionCommand(Command.C_BEST_WOMAN.toString());
        jButtonbestw.addActionListener(presenter);
        jPanelt.add(jButtonbestw);

        jButtonAverage = new JButton();
        jButtonAverage.setText("Promedio por generos");
        jButtonAverage.setActionCommand(Command.C_AERAGE.toString());
        jButtonAverage.addActionListener(presenter);
        jPanelt.add(jButtonAverage);

        JButton jButtonenglish = new JButton();
        jButtonenglish.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_USA)).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
//        jButtonenglish.setText("Ingles");
        jButtonenglish.setActionCommand(Command.C_ENGLISH.toString());
        jButtonenglish.addActionListener(presenter);
        jPanelt.add(jButtonenglish);

        JButton jButtonEspanish = new JButton();
        jButtonEspanish.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ConstantsUI.PATH_SPAIN)).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
//        jButtonEspanish.setText("Español");
        jButtonEspanish.setActionCommand(Command.C_ESPANISH.toString());
        jButtonEspanish.addActionListener(presenter);
        jPanelt.add(jButtonEspanish);

//        JButton jButtonFile = new JButton();
//        jButtonFile.setText("Archivo");
//        jButtonFile.setActionCommand(Command.C_FILE.toString());
//        jButtonFile.addActionListener(presenter);
//        jPanelt.add(jButtonFile);

        JButton jButtonchooser = new JButton();
        jButtonchooser.setText("...");
        jButtonchooser.setActionCommand(Command.C_FILECHOOSER.toString());
        jButtonchooser.addActionListener(presenter);
        jPanelt.add(jButtonchooser);

        textField = new JTextField();
        textField.setToolTipText("Inserta la ruta del fichero de audio");
        textField.setBounds(52, 26, 209, 20);
        jPanelt.add(textField);
        textField.setColumns(10);
//        jPanelt.add(textField);

//        textArea = new JTextArea();
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
//        textArea.setBounds(52, 76, 360, 156);
//        jPanelt.add(textArea);




        this.add(jPanelt);

    }

    public void changeLanguage(){
        jButtonAverage.setText(HandlerLanguage.languageProperties.getProperty("Average_button"));
    }

    public String fileChoosertest(){
        JFileChooser fc=new JFileChooser();
        int seleccion=fc.showOpenDialog(this);
        String aux;
        aux = " ";

        if(seleccion==JFileChooser.APPROVE_OPTION){
            File fichero=fc.getSelectedFile();
            aux = fichero.getAbsolutePath();
        }
        return aux;
    }

}
