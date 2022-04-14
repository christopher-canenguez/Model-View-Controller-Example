package com.mycompany.javafx_mvc_example;

import com.mycompany.javafx_mvc_example.controller.AppController;
import com.mycompany.javafx_mvc_example.view.AppView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MVC_JavaFX_ExampleDriver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create View
        AppView mainView = new AppView();

        //Create Controller
        AppController controller = new AppController(mainView);

        //Show stage
        primaryStage.setTitle("MVC Example App");
        //primaryStage.getIcons().add(new Image(getClass().getResource("/img/EdenCodingIcon.png").toExternalForm()));
        primaryStage.setScene(new Scene(mainView.getView()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

