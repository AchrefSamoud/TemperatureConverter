package Controllers;
import Views.CelsiusSliderView;
import Model.TemperatureModel;
/**
 * The CelsiusSliderController class is responsible for controlling the CelsiusSliderView
 * and updating the TemperatureModel based on the slider value.
 */

import annotations.DesignDecision;
@DesignDecision(roles= {"MVCTemperatureConverterApp.Controller"})
public class CelsiusSliderController {
    private CelsiusSliderView view;
    private TemperatureModel model;
    
    /**
     * Constructs a CelsiusSliderController with the specified view and model.
     * Binds the value property of the CelsiusSlider in the view to the celsiusProperty
     * in the model bidirectionally.
     * 
     * @param view The CelsiusSliderView to control.
     * @param model The TemperatureModel to update.
     */
    public CelsiusSliderController(CelsiusSliderView view, TemperatureModel model){
        this.view = view;
        this.model = model;
        view.getCelsiusSlider().valueProperty().bindBidirectional(model.celsiusProperty());
    }
}

