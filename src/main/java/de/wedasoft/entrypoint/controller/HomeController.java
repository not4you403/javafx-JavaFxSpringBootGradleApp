package de.wedasoft.entrypoint.controller;

import de.wedasoft.entrypoint.fxmlconfig.FxmlHandler;
import de.wedasoft.entrypoint.fxmlconfig.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HomeController implements Initializable {

    private final FxmlHandler fxmlHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onBackButtonClick(ActionEvent event) {
        fxmlHandler.switchSceneRoot(fxmlHandler.getStageBy(event), FxmlView.LOGIN, null);
    }

}
