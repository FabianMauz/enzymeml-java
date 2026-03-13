package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.MeasurementData;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"id", "name", "speciesData", "groupId", "ph", "temperature", "temperatureUnit"})
public interface MeasurementXmlMixin {

    @JacksonXmlProperty(localName = "MeasurementData")
    @JacksonXmlElementWrapper(localName = "species_data")
    public List<MeasurementData> getSpeciesData();

    @JacksonXmlProperty(localName = "group_id")
    public String getGroupId();

    @JacksonXmlProperty(localName = "temperature_unit")
    public UnitDefinition getTemperatureUnit();

    @JacksonXmlProperty(localName = "ph")
    public Float getpH();
}
