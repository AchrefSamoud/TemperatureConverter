import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class CelsiusSliderView {

    private final Slider celsiusSlider;
    private final VBox view;
    private final TemperatureController controller;

    public CelsiusSliderView(TemperatureModel model, TemperatureController controller) {
        this.controller = controller;

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

        // Attach controller
        controller.attachCelsiusSliderView(celsiusSlider);
    }

    public VBox getView() {
        return view;
    }
}
