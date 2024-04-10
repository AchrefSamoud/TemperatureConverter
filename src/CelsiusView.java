import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.input.KeyCode;

public class CelsiusView {

    private final TextField celsiusField;
    private final Button raiseButton;
    private final Button lowerButton;
    private final VBox view;

    public CelsiusView(TemperatureModel model) {
        celsiusField = new TextField();
        celsiusField.setPromptText("Enter Celsius Temperature");

        raiseButton = new Button("Raise");
        lowerButton = new Button("Lower");

        HBox buttonBox = new HBox(10, raiseButton, lowerButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox box = new VBox(10, celsiusField, buttonBox);
        box.setAlignment(Pos.CENTER);

        view = box;

        DoubleStringConverter converter = new DoubleStringConverter();

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
        });}

    public VBox getView() {
        return view;
    }
}
