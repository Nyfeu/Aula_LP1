package authentication.app;

import authentication.db.DB;
import authentication.view.AuthenticationView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(DB::closeConnection));
        SwingUtilities.invokeLater(() -> new AuthenticationView().setVisible(true));

    }
}