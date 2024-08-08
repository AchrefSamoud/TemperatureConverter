package Views;
import Model.TemperatureModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import annotations.DesignDecision;
@DesignDecision(roles= {"ObserverTemperatureConverter.Observer", "MVCTemperatureConverterApp.View"})
public class CelsiusSliderView extends VBox {

    private final Slider celsiusSlider;
    private final VBox view;

    /**
     * Constructs a CelsiusSliderView object with the specified TemperatureModel.
     * Initializes the Celsius slider with default values and sets up its properties.
     * Binds the value of the Celsius slider to the celsiusProperty of the TemperatureModel.
     * Adds the Celsius slider to the view.
     *
     * @param model the TemperatureModel to bind the Celsius slider value to
     */
    public CelsiusSliderView(TemperatureModel model) {

        celsiusSlider = new Slider(-100, 100, 0);
        celsiusSlider.setShowTickMarks(true);
        celsiusSlider.setShowTickLabels(true);
        celsiusSlider.setMajorTickUnit(20);
        celsiusSlider.setBlockIncrement(5);
        VBox box = new VBox(10, new Label("Celsius Slider"), celsiusSlider);
        box.setAlignment(Pos.CENTER);

        view = box;

        // Bindings
        celsiusSlider.valueProperty().bindBidirectional(model.celsiusProperty());

        getChildren().addAll(celsiusSlider);
    }

    /**
     * Returns the view component containing the Celsius slider.
     *
     * @return the view component
     */
    public VBox getView() {
        return view;
    }

    /**
     * Returns the Celsius slider.
     *
     * @return the Celsius slider
     */
    public Slider getCelsiusSlider() {
        return celsiusSlider;
    }
}
