package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
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
    private final List<MeasurementData> speciesData = new ArrayList<>();
    private String groupId;
    private Float pH;
    private float temperature;
    private UnitDefinition temperatureUnit;

    public Measurement(String id, String name) throws ValidationException {
        if (id == null) {
            throw new ValidationException("Id of measurement was null");
        }
        if (name == null) {
            throw new ValidationException("Name of measurement was null", "Measurement " + id);
        }
        this.id = id;
        this.name = name;
    }

    public Measurement addSpeciesData(MeasurementData data) {
        this.speciesData.add(data);
        return this;
    }

    public Measurement setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public Measurement setPH(Float phValue) {
        this.pH = phValue;
        return this;
    }

    public Measurement setTemperature(float tempValue, UnitDefinition unit) {
        this.temperature = tempValue;
        this.temperatureUnit = unit;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MeasurementData> getSpeciesData() {
        return speciesData;
    }

    public String getGroupId() {
        return groupId;
    }

    public Float getpH() {
        return pH;
    }

    public float getTemperature() {
        return temperature;
    }

    public UnitDefinition getTemperatureUnit() {
        return temperatureUnit;
    }

}
