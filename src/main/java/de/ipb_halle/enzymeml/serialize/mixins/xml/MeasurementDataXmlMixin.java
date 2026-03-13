package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"speciesId", "prepared", "initial", "dataUnit", "data", "time", "timeUnit", "dataType", "isSimulated"})
public interface MeasurementDataXmlMixin {

    @JacksonXmlProperty(localName = "species_id")
    public String getSpeciesId();

    @JacksonXmlProperty(localName = "data_unit")
    public UnitDefinition getDataUnit();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "data")
    public List<Float> getData();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "time")
    public List<Float> getTime();

    @JacksonXmlProperty(localName = "time_unit")
    public UnitDefinition getTimeUnit();

    @JacksonXmlProperty(localName = "data_type")
    public UnitDefinition getDataType();

    @JacksonXmlProperty(localName = "is_simulated")
    public UnitDefinition getIsSimulated();
}
