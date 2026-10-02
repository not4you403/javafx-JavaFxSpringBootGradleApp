### Description

A simple running application based on JavaFX, Spring Boot and Gradle.

### Used technologies

| Technology    | Version                |
|---------------|------------------------|
| Spring Boot   | 4.1.1                  |
| Java          | 25                     |
| JavaFX        | 25.0.4                 |
| JDK           | Open JDK 25.0.2        |
| Gradle        | 9.7.1 (Gradle Wrapper) |
| Module system | Non modular            |

### Older versions

All older versions are available as separate branches.

### Features

| Feature                                     | How to use                                                               |
|---------------------------------------------|--------------------------------------------------------------------------|
| Run the application in the IDE.             | Gradle task <code>runJfxSpringBootApp</code> or <code>bootRun</code>.    |
| Package as executable JAR.                  | Gradle task <code>packageAsExecutableJar</code> or <code>bootJar</code>. |
| Package as executable App Image (e.g. EXE). | Gradle task <code>packageAsAppImage</code>.                              |
| <hr>                                        | <hr>                                                                     |
| Dependency injection in Spring components.  | Standard ways available in Spring Boot.                                  |

### Example

#### Step 1: Define routes fors your created FXML files

    @Getter
    @RequiredArgsConstructor
    public enum FxmlView {
    
        INITIAL("/fxml/login.fxml"),
        LOGIN("/fxml/login.fxml"),
        HOME("/fxml/home.fxml");
    
        private final String fxmlPath;
    
    }

#### Step 2: Make the controller a Spring Boot bean

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

#### Step 3: Profit!

Profit.
