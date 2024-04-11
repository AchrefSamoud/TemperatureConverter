import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


public class CelsiusView {

    private final TextField celsiusField;
    private final Button raiseButton;
    private final Button lowerButton;
    private final VBox view;
    private final TemperatureController controller;

    public CelsiusView(TemperatureModel model, TemperatureController controller) {
        this.controller = controller;

        celsiusField = new TextField();
        celsiusField.setPromptText("Enter Celsius Temperature");

        raiseButton = new Button("Raise");
        lowerButton = new Button("Lower");

        HBox buttonBox = new HBox( 10, raiseButton, lowerButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox box = new VBox(10,new Label("Celsius Field"), celsiusField, buttonBox);
        box.setAlignment(Pos.CENTER);

        view = box;

        controller.attachCelsiusView(celsiusField, raiseButton, lowerButton);
    }

    public VBox getView() {
        return view;
    }
}
