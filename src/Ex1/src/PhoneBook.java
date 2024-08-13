package Ex1.src;

import javax.swing.*;
import java.awt.*;

public class PhoneBook extends JFrame {
    JPanel background;
    JTable table;
    JScrollPane bar;
    Object[][] data = {
            {"20080001","Antonio","11 98888-0001","antonio@gmail.com"},
            {"31324235","Leonardo","11 98540-2623","leonardo@gmail.com"},
            {"94235869","Pedro","11 65263-2413","pedro@gmail.com"},
            {"94950412","Jorge","55 12322-8675","jorge@hotmail.com"},
            {"94375828","Pascal","11 27758-1324","pascal@gmail.com"}
    };
    String [] column = {"RA","Nome","Telefone","Email"};

    public PhoneBook(){
        super("Contatos");
    }
    public void makeWindow(){
        background = new JPanel();
        background.setLayout(new GridLayout(1, 1));
        table = new JTable(data,column);
        bar = new JScrollPane(table);
        background.add(bar);
        getContentPane().add(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,125);
        setVisible(true);
    }
}
