package ipbhalle.de.enzymeml.model;

/**
 * Definition of a Parameter.
 *
 * This object describes parameters used in kinetic models, including estimated
 * values, bounds, and associated uncertainties. Parameters can represent rate
 * constants, binding constants, or other numerical values that appear in rate
 * equations or other mathematical expressions.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Parameter {

    private final String id;
    private final String name;
    private final String symbol;
    private String value;
    private UnitDefinition unit;
    private Float initialValue;
    private Float upperBound;
    private Float lowerBound;
    private Boolean fit;
    private Float stderr;
    private Boolean constant;

    public Parameter(String id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public Parameter setValue(String value) {
        this.value = value;
        return this;
    }

    public Parameter setUnit(UnitDefinition unit) {
        this.unit = unit;
        return this;
    }

    public Parameter setInitialValue(Float value) {
        this.initialValue = value;
        return this;
    }

    public Parameter setUpperBound(Float upperBound) {
        this.upperBound = upperBound;
        return this;
    }

    public Parameter setLowerBound(Float lowerBound) {
        this.lowerBound = lowerBound;
        return this;
    }

    public Parameter setFit(Boolean fit) {
        this.fit = fit;
        return this;
    }

    public Parameter setStdError(Float error) {
        this.stderr = error;
        return this;
    }

    public Parameter setConstant(Boolean constant) {
        this.constant = constant;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public UnitDefinition getUnit() {
        return unit;
    }

    public Float getInitialValue() {
        return initialValue;
    }

    public Float getUpperBound() {
        return upperBound;
    }

    public Float getLowerBound() {
        return lowerBound;
    }

    public Boolean getFit() {
        return fit;
    }

    public Float getStderr() {
        return stderr;
    }

    public Boolean getConstant() {
        return constant;
    }
}
