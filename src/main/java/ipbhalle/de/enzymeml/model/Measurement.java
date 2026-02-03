package ipbhalle.de.enzymeml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Measurement.
 *
 * This object describes a single measurement, which includes time course data
 * of any type defined in DataTypes. It contains initial concentrations and
 * measurement data for all species involved in the experiment. Multiple
 * measurements can be grouped together using the group_id field to indicate
 * they are part of the same experimental series.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Measurement {

    private final String id;
    private final String name;
    private List<MeasurementData> speciesData = new ArrayList<>();
    private String groupId;
    private Float pH;
    private float temperature;
    private UnitDefinition temperatureUnit;

    public Measurement(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
