package ipbhalle.de.enzymeml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Measurement.
 *
 * This object describes a single entity of a measurement, which corresponds to
 * one species (Protein, Complex, SmallMolecule). It contains time course data
 * for that species, including the initial amount, prepared amount, and measured
 * data points over time. Endpoint data is treated as a time course data point
 * with only one data point.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class MeasurementData {

    private String speciesId;
    private Float prepared;
    private Float initial;
    private UnitDefinition dataUnit;
    private List<Float> data = new ArrayList<>();
    private List<Float> time = new ArrayList<>();
    private UnitDefinition timeUnit;
    private DataType dataType;
    private Boolean isSimulated;

    public MeasurementData(String speciesId) {
        this.speciesId = speciesId;
    }

}
