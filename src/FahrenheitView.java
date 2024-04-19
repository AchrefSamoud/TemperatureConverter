import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.layout.VBox;

/**
 * The FahrenheitView class represents the view component of the temperature converter application
 * that is responsible for displaying the Fahrenheit temperature input field and buttons.
 */
public class FahrenheitView extends VBox {
    private TextField fahrenheitTextField;
    private Button raiseButton;
    private Button lowerButton;
    private DoubleStringConverter converter;

    /**
     * Constructs a new FahrenheitView object with the specified TemperatureModel.
     *
     * @param model the TemperatureModel object to bind the view components to
     */
    public FahrenheitView(TemperatureModel model) {    
        Label fahrenheitLabel = new Label("Fahrenheit:");
        fahrenheitTextField = new TextField();

        this.raiseButton = new Button("Raise");
        this.lowerButton = new Button("Lower");
        this.converter = new DoubleStringConverter();
        getChildren().addAll(fahrenheitLabel, fahrenheitTextField, raiseButton, lowerButton);

        // Bind result label to model's Fahrenheit property
        model.fahrenheitProperty().addListener((observable, oldValue, newValue) ->
            fahrenheitTextField.setText(converter.toString(newValue.doubleValue())));
    }

    /**
     * Returns the Fahrenheit temperature input field.
     *
     * @return the TextField object representing the Fahrenheit temperature input field
     */
    public TextField getFahrenheitTextField() {
        return fahrenheitTextField;
    }

    /**
     * Returns the "Raise" button.
     *
     * @return the Button object representing the "Raise" button
     */
    public Button getRaiseButton() {
        return raiseButton;
    }

    /**
     * Returns the "Lower" button.
     *
     * @return the Button object representing the "Lower" button
     */
    public Button getLowerButton() {
        return lowerButton;
    }
}
