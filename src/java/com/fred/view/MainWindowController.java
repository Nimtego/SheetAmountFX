package com.fred.view;

import com.fred.exception.ErrorMessageException;
import com.fred.service.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import ru.reeson2003.persist_user.api.UserPersistException;

import java.util.Random;

/**
 * Created by nimtego_loc on 24.08.2017.
 */
public class MainWindowController {
    public Button singUp;
    public AnchorPane leftBar;
    public AnchorPane emptyRightPanel;
    public Button logIn;
    public PasswordField fieldPassword;
    public TextField fieldLogIn;
    public Label labelMain;
    public Button buttonCurrent;
    public Button buttonLighting;
    public Button buttonExit;
    public Button buttonSheetAmount;
    public AnchorPane mainAnchorPane;
    public AnchorPane sheetAmountBar;
    private MainWindow owner;
    private Color color = Color.SKYBLUE;
    private UserController userController;
    private String style;

    @FXML
    private void initialize() {
        //fieldLogIn.setStyle("-fx-text-inner-color: red;");
        this.userController = new UserController();
    }

    public void setWindowOwner(MainWindow owner) {
        this.owner = owner;
    }

    public void action(ActionEvent actionEvent) {
        if (buttonExit.isArmed()) {
            owner.getPrimaryStage().close();
        }
        if (singUp.isArmed()) {
            String logIn = fieldLogIn.getText();
            String password = fieldPassword.getText();
            try {
                if (userController.singUpUser(logIn, password)) {
                    labelMain.setText(userController.getCurrent().getLogin());
                }

            } catch (ErrorMessageException | UserPersistException e) {
                alert(e.getMessage());
            }
        }
        if (logIn.isArmed()) {
            String logIn = fieldLogIn.getText();
            String password = fieldPassword.getText();
            try {
                userController.logInUser(logIn, password);
                labelMain.setText(userController.getCurrent().getLogin());
            }
            catch (ErrorMessageException  | UserPersistException e) {
                alert(e.getMessage());
            }
        }
        if (buttonSheetAmount.isArmed()) {
            if (emptyRightPanel.isVisible()) {
                emptyRightPanel.setVisible(false);
                sheetAmountBar.setVisible(true);
            } else {
                emptyRightPanel.setVisible(true);
                sheetAmountBar.setVisible(false);
            }
        }
    }

    private void moveMenu(boolean up) {
        if (up) {
            buttonCurrent.setLayoutY(buttonCurrent.getLayoutY() - 100.0);
            buttonLighting.setLayoutY(buttonLighting.getLayoutY() - 100.0);
            buttonSheetAmount.setLayoutY(buttonSheetAmount.getLayoutY() - 100.0);

        }
        else {
            buttonCurrent.setLayoutY(buttonCurrent.getLayoutY() + 100.0);
            buttonLighting.setLayoutY(buttonLighting.getLayoutY() + 100.0);
            buttonSheetAmount.setLayoutY(buttonSheetAmount.getLayoutY() + 100.0);
        }
    }
    private void setLoginFormVisible(boolean flag) {
        singUp.setVisible(flag);
        logIn.setVisible(flag);
        fieldPassword.setVisible(flag);
        fieldLogIn.setVisible(flag);
    }

    private void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.setTitle("Attention");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button)
            ((Button) mouseEvent.getSource()).setTextFill(Color.SKYBLUE);
        if (mouseEvent.getSource() instanceof Label)
            ((Label) mouseEvent.getSource()).setTextFill(Color.SKYBLUE);
        if (mouseEvent.getSource() instanceof TextField||
                mouseEvent.getSource() instanceof ComboBox) {

            if (mouseEvent.getSource() instanceof TextField) {
                style = ((TextField) mouseEvent.getSource()).getStyle();
                TextField textField = (TextField) mouseEvent.getSource();
                textField.setStyle("-fx-background-color: #20d5f4;");
            }
            else {
                style = ((ComboBox) mouseEvent.getSource()).getStyle();
                ((ComboBox) mouseEvent.getSource()).setStyle("-fx-background-color: #20d5f4;");
            }
        }
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView imageView = (ImageView) mouseEvent.getSource();
            imageView.setImage(new Image("/WebDev/Buttons/Button_exit_push.png"));
        }
    }

    public void mouseReMoved(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button)
            ((Button) mouseEvent.getSource()).setTextFill(Color.BLACK);
        if (mouseEvent.getSource() instanceof Label)
            ((Label) mouseEvent.getSource()).setTextFill(color);
        if (mouseEvent.getSource() instanceof TextField ||
                mouseEvent.getSource() instanceof ComboBox) {
            if (mouseEvent.getSource() instanceof TextField) {
                ((TextField) mouseEvent.getSource()).setStyle("-fx-background-color: #b2ffe5;");
            }
            else {
                ((ComboBox) mouseEvent.getSource()).setStyle("-fx-background-color: #b2ffe5;");
            }
        }
    }

    public void actionLabel(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Label) {
            Parent parent = ((Label) mouseEvent.getSource()).getParent();
            Random random = new Random();
            int r, g, b;
            r = random.nextInt(255);
            g = random.nextInt(255);
            b = random.nextInt(255);
            if (parent.getId().equals("leftBar")) {
                System.out.println(parent.getId().equals("leftBar"));
                parent.getScene().setFill(Color.rgb(r, g, b));
            }
            color = Color.rgb(r, g, b);
        }
    }
}