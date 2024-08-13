package authentication.view;

import authentication.utils.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame {

    JPanel background;
    JTable table;
    JScrollPane bar;
    String[][] data = new String[1][5];
    String [] column = {"N1","N2","N3","N4", "Faltas"};

    public MainView(){
        super("Registro Aluno");
    }
    public void makeWindow(){
        background = new JPanel();
        background.setLayout(new GridLayout(1, 1));

        ArrayList<Float> notas = Authenticator.getAuthenticatedUser().getNotas();
        String[] data_string = new String[notas.size() + 1];
        for (int i = 0; i < notas.size(); i++) data_string[i] = String.format("%.2f", notas.get(i));
        data_string[4] = Authenticator.getAuthenticatedUser().getFaltas().toString();
        data[0] = data_string;

        table = new JTable(data,column);
        bar = new JScrollPane(table);
        background.add(bar);
        getContentPane().add(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,125);
        setVisible(true);
    }

}
