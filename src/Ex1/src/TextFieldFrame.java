package Ex1.src;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.util.*;

public class TextFieldFrame extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField;

    public TextFieldFrame(){
        super("JTextField e JPasswordField");
        setLayout(new FlowLayout());
        textField1 = new JTextField(10);
        add(textField1);
        textField2 = new JTextField("Entre com o texto aqui");
        add(textField2);
        textField3 = new JTextField("Campo Texto nao editavel", 21);
        textField3.setEditable(false);
        add(textField3);
        passwordField = new JPasswordField("Texto oculto");
        add(passwordField);

        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);

    }
    private class TextFieldHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String string = "";
            if(e.getSource() == textField1)
                string = String.format("textField1: %s",e.getActionCommand());
            else if(e.getSource() == textField2)
                string = String.format("textField2: %s",e.getActionCommand());
            else if(e.getSource() == textField3)
                string = String.format("textField3: %s",e.getActionCommand());
            else if (e.getSource() == passwordField)
                string = String.format("passwordField: %s", new String(passwordField.getPassword()));
            JOptionPane.showMessageDialog(null,string);
        }
    }
}
