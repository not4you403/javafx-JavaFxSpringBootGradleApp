package de.wedasoft.entrypoint.controller;


import de.wedasoft.entrypoint.fxmlconfig.FxmlHandler;
import de.wedasoft.entrypoint.fxmlconfig.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginController implements Initializable {

    private final FxmlHandler fxmlHandler;

    @FXML
    private Button myButton;

    @FXML
    private TextField myTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myTextField.setText("hello");
    }

    public void onMyButtonClick(ActionEvent event) {
        fxmlHandler.switchSceneRoot(fxmlHandler.getStageBy(event), FxmlView.HOME, null);
    }

}
