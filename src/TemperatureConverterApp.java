import Controllers.CelsiusController;
import Controllers.CelsiusSliderController;
import Controllers.FahrenheitController;
import Model.TemperatureModel;
import Views.CelsiusSliderView;
import Views.CelsiusView;
import Views.FahrenheitView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import annotations.DesignDecision;
public class TemperatureConverterApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an instance of the TemperatureModel class
        TemperatureModel model = new TemperatureModel();
        
        // Create instances of the CelsiusView, CelsiusController, FahrenheitView, and FahrenheitController classes
        CelsiusView celsiusView = new CelsiusView(model);
        CelsiusController celsiusController = new CelsiusController(celsiusView, model);
        FahrenheitView fahrenheitView = new FahrenheitView(model);
        FahrenheitController fahrenheitController = new FahrenheitController(fahrenheitView, model);
        
        // Create instances of the CelsiusSliderView and CelsiusSliderController classes
        CelsiusSliderView celsiusSliderView = new CelsiusSliderView(model);
        CelsiusSliderController celsiusSliderController = new CelsiusSliderController(celsiusSliderView, model);

        // Create a VBox layout container and add the views to it
        VBox root = new VBox(20, celsiusView, fahrenheitView, celsiusSliderView);
        root.setAlignment(Pos.CENTER);

        // Create a scene with the root container and set the stage's scene
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        
        // Set the title of the stage and show it
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}








