package ipbhalle.de.enzymeml.model;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public enum DataType {
    ABSORBANCE("absorbance"),
    AMOUNT("amount"),
    CONCENTRATION("concentration"),
    CONVERSION("conversion"),
    FLUORESCENCE("fluorescence"),
    PEAK_AREA("peakarea"),
    TRANSMITTANCE("transmittance"),
    TURNOVER("turnover"),
    YIELD("yield");

    private String name;

    private DataType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
