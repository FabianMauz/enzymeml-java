package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.MeasurementData;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"id", "name", "speciesData", "groupId", "ph", "temperature", "temperatureUnit"})
public abstract class MeasurementXmlMixin {

    @JsonCreator
    public MeasurementXmlMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name) throws ValidationException {
    }

    @JacksonXmlProperty(localName = "MeasurementData")
    @JacksonXmlElementWrapper(localName = "species_data")
    abstract public List<MeasurementData> getSpeciesData();

    @JacksonXmlProperty(localName = "group_id")
    abstract public String getGroupId();

    @JacksonXmlProperty(localName = "temperature_unit")
    abstract public UnitDefinition getTemperatureUnit();

    @JacksonXmlProperty(localName = "ph")
    abstract public Float getpH();
}
