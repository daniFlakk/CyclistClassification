package views.body;

import persistence.HandlerLanguage;

import javax.swing.*;
import java.awt.*;


public class InfoPanel extends JPanel {

    JLabel jLabelInfo;
    JLabel jlabelTitle;

    public InfoPanel() {
        this.setPreferredSize(new Dimension(300,100));
        this.setBackground(Color.decode("#536878"));
        initComponents();
    }

    /**
     * Metodo que incia los componentes de la clase infoPanel
     */
    public void initComponents(){
        jlabelTitle = new JLabel("La informacion deseada es: ");
        jlabelTitle.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        jlabelTitle.setToolTipText("La informacion deseada es: ");
        jlabelTitle.setForeground(Color.white);

        jLabelInfo = new JLabel(" ");
        jLabelInfo.setPreferredSize(new Dimension(500,100));
        jLabelInfo.setForeground(Color.white);
        jLabelInfo.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));



        this.add(jlabelTitle);
        this.add(jLabelInfo);
    }

    public void changeInfo(String info){
        jLabelInfo.setText(info);
    }

    public void changeLenguaje(){
        jlabelTitle.setText(HandlerLanguage.languageProperties.getProperty("Info_Panel"));
    }
}
