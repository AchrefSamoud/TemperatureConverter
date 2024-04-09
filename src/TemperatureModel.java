import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class TemperatureModel {
    private final DoubleProperty celsius = new SimpleDoubleProperty();
    private final DoubleProperty fahrenheit = new SimpleDoubleProperty();

    public TemperatureModel() {
        // Bindings for converting between Celsius and Fahrenheit
        celsius.addListener((observable, oldValue, newValue) ->
                fahrenheit.set(((double) newValue * 9 / 5) + 32));

        fahrenheit.addListener((observable, oldValue, newValue) ->
                celsius.set(((double) newValue - 32) * 5 / 9));
    }

    public double getCelsius() {
        return celsius.get();
    }

    public DoubleProperty celsiusProperty() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius.set(celsius);
    }

    public double getFahrenheit() {
        return fahrenheit.get();
    }

    public DoubleProperty fahrenheitProperty() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit.set(fahrenheit);
    }
}
