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

    private String id;
    private String name;
    private String symbol;
    private String value;
    private UnitDefinition unit;
    private Float initialValue;
    private Float upperBound;
    private Float lowerBound;
    private boolean fit;
    private Float stderr;
    private Boolean constant;
}
