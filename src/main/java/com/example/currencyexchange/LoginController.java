package com.example.currencyexchange;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController
{
    private int incorrectLoginCount = 0;
    public PasswordField txtPassword;
    public TextField txtUser;
    public Button btnLogin;

    /**
     * Metoda sprawdza czy dane logowania są poprawne, jeśli sa to przechodzi do ekranu głównego, jeśli nie to wyświetla
     * komunikat, jeśli komunikat pokaże się 3 razy okienko logowania się wyłącza
     */
    public void btnLoginClicked(ActionEvent actionEvent) {
        String password = txtPassword.getText();
        String login = txtUser.getText();


        if (incorrectLoginCount >= 3) {
            ((Stage) txtPassword.getScene().getWindow()).close();
        } else if (password.equals("admin") && login.equals("admin")) {
            try {
                DataExchage.userName = login;

                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("widokProgram.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 1600);
                Stage stage = new Stage();
                stage.setTitle("Biblioteka");
                stage.setScene(scene);
                stage.show();
                ((Stage) txtPassword.getScene().getWindow()).close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            };
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Wpisz poprawne dane logowania");
            incorrectLoginCount++;
        }
    }
}