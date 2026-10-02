package de.wedasoft.entrypoint.fxmlconfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class FxmlHandler {

    private final FxmlLoader fxmlLoader;

    public Stage getStageBy(ActionEvent event) {
        return getStageBy(((Node) event.getSource()));
    }

    public Stage getStageBy(Node childNode) {
        return getStageBy(childNode.getScene());
    }

    public Stage getStageBy(Scene scene) {
        return (Stage) scene.getWindow();
    }

    public void switchSceneRoot(Stage stage, FxmlView fxmlView) {
        switchSceneRoot(stage, fxmlView, null);
    }

    public void switchSceneRoot(Stage stage, FxmlView fxmlView, @SuppressWarnings("rawtypes") Consumer initMethodOfController) {
        try {
            FXMLLoader loader = fxmlLoader.get(fxmlView.getFxmlPath());
            stage.getScene().setRoot(loader.load());
            Object viewController = loader.getController();
            if (initMethodOfController != null) {
                //noinspection unchecked
                initMethodOfController.accept(viewController);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}