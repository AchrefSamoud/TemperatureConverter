package Controllers;
import Model.TemperatureModel;
import Views.FahrenheitView;
import javafx.scene.input.KeyCode;
import javafx.util.converter.DoubleStringConverter;

/**
 * The FahrenheitController class is responsible for controlling the Fahrenheit view and updating the temperature model.
 */
// TemperatureConverterController.java





import annotations.DesignDecision;
@DesignDecision(roles= {"Controller", "View", "Subject", "Observer"})
public class FahrenheitController {
    private FahrenheitView view;
    private TemperatureModel model;
    private DoubleStringConverter converter;
    // Constructor
    public FahrenheitController(FahrenheitView view, TemperatureModel model) {
        this.converter = new DoubleStringConverter();
        this.view = view;
        this.model = model;
System.out.println("FahrenheitController created");
        // Event handler for Enter key press in the Fahrenheit text field
            view.getFahrenheitTextField().setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    String newValue = view.getFahrenheitTextField().getText();
                    if (!newValue.isEmpty()) {
                        model.setFahrenheit(converter.fromString(newValue));
                    }
                }
            });

            // Event handler for Raise button click
            view.getRaiseButton().setOnAction(e -> {
                double celsiusValue = Double.parseDouble(view.getFahrenheitTextField().getText());
                model.setFahrenheit(celsiusValue + 1);
            });

            // Event handler for Lower button click
            view.getLowerButton().setOnAction(event -> model.setCelsius(model.getCelsius() - 1));

            // Event handler for Enter key press in the Fahrenheit text field (duplicate code)
            view.getFahrenheitTextField().setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    String newValue = view.getFahrenheitTextField().getText();
                    if (!newValue.isEmpty()) {
                        model.setFahrenheit(converter.fromString(newValue));
                    }
                }
            });
    }
}






    //parr
    //yaaaaaaaa
    //
    //
    //
    //




    //yattata

    //Aaasa




    //ya semeah

    // ya behi

    //ya tahfounn

    //ya allaaah