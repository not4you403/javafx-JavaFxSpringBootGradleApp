package de.wedasoft.entrypoint.fxmlconfig;

import javafx.fxml.FXMLLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FxmlLoader {

    private final ApplicationContext context;

    public FXMLLoader get(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean);
        loader.setLocation(getClass().getResource(fxmlPath));
        return loader;
    }

}
