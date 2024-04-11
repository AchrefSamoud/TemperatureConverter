import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.control.Slider;

public class TemperatureController {

    private final TemperatureModel model;
    private final DoubleStringConverter converter;

    public TemperatureController(TemperatureModel model) {
        this.model = model;
        this.converter = new DoubleStringConverter();
    }

    public void attachCelsiusView(TextField celsiusField, Button raiseButton, Button lowerButton) {
        raiseButton.setOnAction(e -> {
            double celsiusValue = Double.parseDouble(celsiusField.getText());
            model.setCelsius(celsiusValue + 1);
        });

        lowerButton.setOnAction(e -> {
            double celsiusValue = Double.parseDouble(celsiusField.getText());
            model.setCelsius(celsiusValue - 1);
        });

        // Listener to update the text field when the model changes
        model.celsiusProperty().addListener((observable, oldValue, newValue) -> {
            celsiusField.setText(converter.toString(newValue.doubleValue()));
        });

        // Listener to update the model when the text field changes
        celsiusField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String newValue = celsiusField.getText();
                if (!newValue.isEmpty()) {
                    model.setCelsius(converter.fromString(newValue));
                }
            }
        });
    }

    public void attachFahrenheitView(TextField fahrenheitField, Button raiseButton, Button lowerButton) {
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
    public void attachCelsiusSliderView(Slider slider) {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            model.setCelsius(newValue.doubleValue());
        });
    }
}
