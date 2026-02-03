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
    private boolean fit;
    private Float stderr;
    private Boolean constant;

    public Parameter(String id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }
}
