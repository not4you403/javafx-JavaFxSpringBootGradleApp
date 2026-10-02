package de.wedasoft.entrypoint;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMain {

    static void main(String[] args) {
        Application.launch(JfxApplication.class, args);
    }

}
