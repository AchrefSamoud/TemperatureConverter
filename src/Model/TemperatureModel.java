package Model;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * The TemperatureModel class represents a model for temperature conversion between Celsius and Fahrenheit.
 */



import annotations.DesignDecision;
@DesignDecision(roles= {"Model", "Subject"})
public class TemperatureModel {
    private final DoubleProperty celsius = new SimpleDoubleProperty();
    private final DoubleProperty fahrenheit = new SimpleDoubleProperty();

    /**
     * Constructs a TemperatureModel object.
     * Initializes the bindings for converting between Celsius and Fahrenheit.
     */
    public TemperatureModel() {
        celsius.addListener((observable, oldValue, newValue) ->
            fahrenheit.set((newValue.doubleValue() * 9 / 5) + 32));

        fahrenheit.addListener((observable, oldValue, newValue) ->
            celsius.set((newValue.doubleValue() - 32) * 5 / 9));
    }

    /**
     * Gets the value of temperature in Celsius.
     *
     * @return The value of temperature in Celsius.
     */
    public double getCelsius() {
        return celsius.get();
    }

    /**
     * Gets the property for temperature in Celsius.
     *
     * @return The property for temperature in Celsius.
     */
    public DoubleProperty celsiusProperty() {
        return celsius;
    }

    /**
     * Sets the value of temperature in Celsius.
     *
     * @param celsius The value of temperature in Celsius.
     */
    public void setCelsius(double celsius) {
        this.celsius.set(celsius);
    }

    /**
     * Gets the value of temperature in Fahrenheit.
     *
     * @return The value of temperature in Fahrenheit.
     */
    public double getFahrenheit() {
        return fahrenheit.get();
    }

    /**
     * Gets the property for temperature in Fahrenheit.
     *
     * @return The property for temperature in Fahrenheit.
     */
    public DoubleProperty fahrenheitProperty() {
        return fahrenheit;
    }

    /**
     * Sets the value of temperature in Fahrenheit.
     *
     * @param fahrenheit The value of temperature in Fahrenheit.
     */
    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit.set(fahrenheit);
    }
}
