package authentication.view;

import authentication.model.dao.DAOFactory;
import authentication.model.dao.interfaces.UsuarioDao;
import authentication.model.entities.Usuario;
import authentication.utils.Authenticator;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame {

    JPanel background;
    JTable table;
    JScrollPane bar;
    DefaultTableModel tableModel;
    String[] column = {"N1", "N2", "N3", "N4", "Faltas", "Modificado"};

    public MainView() {
        super("Registro Aluno");
    }

    public void makeWindow() {
        background = new JPanel();
        background.setLayout(new GridLayout(1, 1));

        ArrayList<Float> notas = Authenticator.getAuthenticatedUser().getNotas();
        String[] dataString = new String[6];

        for (int i = 0; i < notas.size(); i++) {
            dataString[i] = String.format("%.2f", notas.get(i));
        }

        Integer faltas = Authenticator.getAuthenticatedUser().getFaltas();
        if (faltas != null) {
            dataString[4] = faltas.toString();
        }

        dataString[5] = Authenticator.getAuthenticatedUser().getLastModified().toString();

        tableModel = new DefaultTableModel(new String[][]{dataString}, column);
        table = new JTable(tableModel);

        bar = new JScrollPane(table);
        background.add(bar);
        getContentPane().add(background);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 125);
        setVisible(true);

        tableModel.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                ArrayList<Float> notasAtualizadas = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    notasAtualizadas.add(Float.parseFloat(((String) tableModel.getValueAt(0, i)).replace(',', '.')));
                }

                Usuario usuario = Authenticator.getAuthenticatedUser();
                usuario.setNotas(notasAtualizadas);
                usuario.setFaltas(Integer.parseInt((String) tableModel.getValueAt(0, 4)));
                usuario.setLastModified();

                UsuarioDao usuarioDao = DAOFactory.createUsuarioDao();
                usuarioDao.update(usuario);

            }
        });
    }
}
