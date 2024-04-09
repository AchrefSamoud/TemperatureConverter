import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureConverterApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        TemperatureModel model = new TemperatureModel();

        CelsiusView celsiusView = new CelsiusView(model);
        FahrenheitView fahrenheitView = new FahrenheitView(model);
        CelsiusSliderView celsiusSliderView = new CelsiusSliderView();

        VBox root = new VBox(20, celsiusView.getView(), fahrenheitView.getView(), celsiusSliderView.getView());
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
