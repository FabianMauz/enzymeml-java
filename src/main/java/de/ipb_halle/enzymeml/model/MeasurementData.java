package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
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

    private final String speciesId;
    private Float prepared;
    private Float initial;
    private UnitDefinition dataUnit;
    private final List<Float> data = new ArrayList<>();
    private final List<Float> time = new ArrayList<>();
    private UnitDefinition timeUnit;
    private DataType dataType;
    private Boolean isSimulated;

    public MeasurementData(String speciesId) throws ValidationException {
        if (speciesId == null) {
            throw new ValidationException("SpeciesId of measurementData was null");
        }
        this.speciesId = speciesId;
    }

    public MeasurementData setPrepared(Float value) {
        this.prepared = value;
        return this;
    }

    public MeasurementData setInitial(Float value) {
        this.initial = value;
        return this;
    }

    public MeasurementData addDataPoint(float value, float time) {
        this.data.add(value);
        this.time.add(time);
        return this;
    }

    public MeasurementData setDataUnit(UnitDefinition unit) {
        this.dataUnit = unit;
        return this;
    }

    public MeasurementData setTimeUnit(UnitDefinition unit) {
        this.timeUnit = unit;
        return this;
    }

    public MeasurementData setDataType(DataType type) {
        this.dataType = type;
        return this;
    }

    public MeasurementData setSimulated(Boolean simulated) {
        this.isSimulated = simulated;
        return this;
    }

    public String getSpeciesId() {
        return speciesId;
    }

    public Float getPrepared() {
        return prepared;
    }

    public Float getInitial() {
        return initial;
    }

    public UnitDefinition getDataUnit() {
        return dataUnit;
    }

    public List<Float> getData() {
        return data;
    }

    public List<Float> getTime() {
        return time;
    }

    public UnitDefinition getTimeUnit() {
        return timeUnit;
    }

    public DataType getDataType() {
        return dataType;
    }

    public Boolean getIsSimulated() {
        return isSimulated;
    }

}
