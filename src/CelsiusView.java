
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javafx.util.converter.DoubleStringConverter;

/**
 * The CelsiusView class represents a view component for displaying and interacting with Celsius temperature values.
 * It extends the VBox class to organize its child nodes vertically.
 */


@designDecision(fragmentsNames = {"Celsius View ", "Clesius Observer"})
public class CelsiusView extends VBox {
    private TextField celsiusTextField;
    private Button raiseButton;
    private Button lowerButton;
    private DoubleStringConverter converter;

    /**
     * Constructs a new CelsiusView object with the specified TemperatureModel.
     *
     * @param model The TemperatureModel object to bind the view to.
     */
    public CelsiusView(TemperatureModel model) {
        Label celsiusLabel = new Label("Celsius:");
        celsiusTextField = new TextField();
        this.raiseButton = new Button("Raise");
        this.lowerButton = new Button("Lower");

        this.converter = new DoubleStringConverter();

        //yallaaaa
        //ooooo
        //tttttttt
        // Bind result label to model's Fahrenheit property
        model.celsiusProperty().addListener((observable, oldValue, newValue) ->
                celsiusTextField.setText(converter.toString(newValue.doubleValue())));

        getChildren().addAll(celsiusLabel, celsiusTextField, raiseButton, lowerButton);
    }

    /**
     * Returns the TextField component used for entering Celsius temperature values.
     *
     * @return The TextField component for Celsius temperature input.
     */
    public TextField getCelsiusTextField() {
        return celsiusTextField;
    }

    /**
     * Returns the Button component used for raising the Celsius temperature.
     *
     * @return The Button component for raising the Celsius temperature.
     */
    public Button getRaiseButton() {
        return raiseButton;
    }

    /**
     * Returns the Button component used for lowering the Celsius temperature.
     *
     * @return The Button component for lowering the Celsius temperature.
     */
    public Button getLowerButton() {
        return lowerButton;
    }
}
