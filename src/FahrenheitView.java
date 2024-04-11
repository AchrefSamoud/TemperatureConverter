import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FahrenheitView {

    private final TextField fahrenheitField;
    private final Button raiseButton;
    private final Button lowerButton;
    private final VBox view;
    private final TemperatureController controller;

    public FahrenheitView(TemperatureModel model, TemperatureController controller) {
        this.controller = controller;

        fahrenheitField = new TextField();
        fahrenheitField.setPromptText("Enter Fahrenheit Temperature");

        raiseButton = new Button("Raise");
        lowerButton = new Button("Lower");

        HBox buttonBox = new HBox(10, raiseButton, lowerButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox box = new VBox(10, fahrenheitField, buttonBox);
        box.setAlignment(Pos.CENTER);

        view = box;

        controller.attachFahrenheitView(fahrenheitField, raiseButton, lowerButton);
    }

    public VBox getView() {
        return view;
    }
}
