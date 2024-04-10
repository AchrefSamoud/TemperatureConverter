import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.input.KeyCode;

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

        HBox buttonBox = new HBox(10, raiseButton, lowerButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox box = new VBox(10, fahrenheitField, buttonBox);
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

        // Listener to update the model when I hit enter in the text field
        fahrenheitField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String newValue = fahrenheitField.getText();
                if (!newValue.isEmpty()) {
                    model.setFahrenheit(converter.fromString(newValue));
                }
            }
        });
    }

    public VBox getView() {
        return view;
    }
}
