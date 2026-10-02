package de.wedasoft.entrypoint;

import de.wedasoft.entrypoint.fxmlconfig.FxmlHandler;
import de.wedasoft.entrypoint.fxmlconfig.FxmlView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;

public class JfxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(SpringBootMain.class).run();
    }

    @Override
    public void stop() {
        applicationContext.close();
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Pane());
        String css = Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);

        FxmlHandler fxmlHandler = applicationContext.getBean(FxmlHandler.class);
        fxmlHandler.switchSceneRoot(primaryStage, FxmlView.INITIAL, null);

        primaryStage.show();
    }

}
