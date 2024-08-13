package authentication.controller;

import authentication.utils.Authenticator;
import authentication.view.AuthenticationView;
import authentication.view.Validator;
import authentication.view.ViewUtils;

import javax.swing.*;

public class AuthenticationController {

    private AuthenticationView view;

    public AuthenticationController(AuthenticationView view) {

        this.view = view;

        view.getSubmitButton().addActionListener(e -> {

            if (view.isLogin()) {
                login();
            } else {
                register();
            }

        });

    }

    private void login() {

        String email = view.getEmail();
        String senha = view.getPassword();

        if (view.getEmail().isEmpty() || view.getPassword().isEmpty()) return;

        boolean authenticated = Authenticator.login(email, senha, view);
        verifyAuthentication(authenticated);

    }

    private void register() {

        String nome = view.getNome();
        String email = view.getEmail();
        String senha = view.getPassword();

        System.out.println(view.getEmail());
        System.out.println(view.getNome());
        System.out.println(view.getPassword());

        if (view.getEmail().isEmpty() ||
                view.getPassword().isEmpty() ||
                view.getNome().isEmpty()) return;

        if (!Validator.isValidEmail(view.getEmail())) {
            JOptionPane.showMessageDialog(view,"Formato de email inválido!");
            return;
        }

        boolean authenticated = Authenticator.registrar(nome, email, senha);
        verifyAuthentication(authenticated);

    }

    private void verifyAuthentication(boolean authenticated) {
        if (authenticated) {
            System.out.println("Usuário Autenticado!");
            ViewUtils.closeView(view);
            // new MainView().setVisible(true);
            JOptionPane.showMessageDialog(view,"Logado com sucesso!");
        } else {
            System.out.println("Falha na autenticação...");
        }
    }

}