// TemperatureConverterController.java
import javafx.scene.input.KeyCode;
import javafx.util.converter.DoubleStringConverter;


/**
 * The CelsiusController class is responsible for controlling the CelsiusView and updating the TemperatureModel based on user input.
 */
public class CelsiusController {
    private CelsiusView view;
    private TemperatureModel model;
    private DoubleStringConverter converter;

    /**
     * Constructs a CelsiusController object with the specified view and model.
     *
     * @param view  The CelsiusView object to be controlled.
     * @param model The TemperatureModel object to be updated.
     */
    public CelsiusController(CelsiusView view, TemperatureModel model) {
        this.converter = new DoubleStringConverter();
        this.view = view;
        this.model = model;

        // Set action for the raise button
        view.getRaiseButton().setOnAction(e -> {
            double celsiusValue = Double.parseDouble(view.getCelsiusTextField().getText());
            model.setCelsius(celsiusValue + 1);
        });

        // Set action for the lower button
        view.getLowerButton().setOnAction(event -> model.setCelsius(model.getCelsius() - 1));

        // Set action for the enter key press on the Celsius text field
        view.getCelsiusTextField().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String newValue = view.getCelsiusTextField().getText();
                if (!newValue.isEmpty()) {
                    model.setCelsius(converter.fromString(newValue));
                }
            }
        });
    }
}
   