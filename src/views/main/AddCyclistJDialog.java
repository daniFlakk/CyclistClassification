package views.main;

import com.toedter.calendar.JDateChooser;
import models.*;
import presenter.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.ZoneId;

public class AddCyclistJDialog extends JDialog {

    private JTextField name;
    private JTextField secondName;
    private JTextField lastName;
    private JDateChooser dateOfBrith;
    private JComboBox<Team> team;
    private JComboBox<Gender> gender;
    private JTextField timeForTravel;
    private JPanel aux;


    public AddCyclistJDialog(Presenter presenter) {
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(400,500));
        initComponents(presenter);
        //  this.setVisible(true);
    }

    private void initComponents(Presenter presenter){

        aux = new JPanel();
        aux.setLayout(new GridLayout(5,7));

        name = new JTextField();
        name.setBorder(BorderFactory.createTitledBorder("Ingrese el priemr nombre del corredor:"));
        aux.add(name);

        secondName = new JTextField();
        secondName.setBorder(BorderFactory.createTitledBorder("Ingrese el priemr nombre del corredor:"));
        aux.add(secondName);

        lastName = new JTextField();
        lastName.setBorder(BorderFactory.createTitledBorder("Ingrese el apellido del corredor:"));
        aux.add(lastName);

        dateOfBrith = new JDateChooser();
        dateOfBrith.setBorder(BorderFactory.createTitledBorder("Ingrese fecha de nacimiento:"));
        aux.add(dateOfBrith);

        team = new JComboBox<>(Team.values());
        team.setBorder(BorderFactory.createTitledBorder("Elija el equipo donde corre:"));
        aux.add(team);

        gender = new JComboBox<>(Gender.values());
        gender.setBorder(BorderFactory.createTitledBorder("Elija el genero:"));
        aux.add(gender);

        timeForTravel = new JTextField();
        timeForTravel.setBorder(BorderFactory.createTitledBorder("Ingrese el tiempo del corredor HH:MM:SS"));
        aux.add(timeForTravel);

        JButton createCyclist = new JButton("Aceptar");
        createCyclist.setBackground(Color.ORANGE);
        createCyclist.setBorder(null);
        createCyclist.setActionCommand(Command.C_NEW_CLYCLIST.toString());
        createCyclist.addActionListener(presenter);
        aux.add(createCyclist);

        this.add(aux);

    }

    public Cyclist createRunner(){
        setVisible(false);
        return new Cyclist(name.getText(),secondName.getText(),lastName.getText(), (Gender)gender.getSelectedItem(), dateOfBrith.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalTime.parse(timeForTravel.getText()), (Team)team.getSelectedItem());
    }




}