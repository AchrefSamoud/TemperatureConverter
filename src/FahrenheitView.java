import javafx.util.converter.DoubleStringConverter;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class FahrenheitView {

    private final TextField fahrenheitField;
    private final Button raiseButton;
    private final Button lowerButton;
    private final VBox view;

    public FahrenheitView(TemperatureModel model) {
        
        fahrenheitField = new TextField();
        fahrenheitField.setPromptText("Enter Fahrenheit Temperature");

        raiseButton = new Button("Raise");
        lowerButton = new Button("Lower");

        VBox box = new VBox(10, fahrenheitField, raiseButton, lowerButton);
        box.setAlignment(Pos.CENTER);
        
        view = box;

        DoubleStringConverter converter = new DoubleStringConverter();
        
        raiseButton.setOnAction(e -> {
            double fahrenheitValue = Double.parseDouble(fahrenheitField.getText());
            model.setFahrenheit(fahrenheitValue + 1);
        });
        
        lowerButton.setOnAction(e -> {
            double fahrenheitValue = Double.parseDouble(fahrenheitField.getText());
            model.setFahrenheit(fahrenheitValue - 1);
        });

        // Listener to update the text field when the model changes
        model.fahrenheitProperty().addListener((observable, oldValue, newValue) -> {
            fahrenheitField.setText(converter.toString(newValue.doubleValue()));
        });

        // Listener to update the model when the text field changes
        fahrenheitField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                model.setFahrenheit(converter.fromString(newValue));
            }
        });
    }

    public VBox getView() {
        return view;
    }
}
