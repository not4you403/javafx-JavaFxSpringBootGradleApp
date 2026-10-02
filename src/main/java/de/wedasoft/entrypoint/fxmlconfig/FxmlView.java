package de.wedasoft.entrypoint.fxmlconfig;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FxmlView {

    INITIAL("/fxml/login.fxml"),
    LOGIN("/fxml/login.fxml"),
    HOME("/fxml/home.fxml");

    private final String fxmlPath;

}