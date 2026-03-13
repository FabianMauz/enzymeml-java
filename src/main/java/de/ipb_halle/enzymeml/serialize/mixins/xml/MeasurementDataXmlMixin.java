package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.DataType;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"species_id", "prepared", "initial", "data_unit", "data", "time", "time_unit", "data_type", "is_simulated"})
public interface MeasurementDataXmlMixin {

    @JacksonXmlProperty(localName = "prepared")
    Float getPrepared();

    @JacksonXmlProperty(localName = "initial")
    Float getInitial();

    @JacksonXmlProperty(localName = "species_id")
    String getSpeciesId();

    @JacksonXmlProperty(localName = "data_unit")
    UnitDefinition getDataUnit();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "data")
    List<Float> getData();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "time")
    List<Float> getTime();

    @JacksonXmlProperty(localName = "time_unit")
    UnitDefinition getTimeUnit();

    @JacksonXmlProperty(localName = "data_type")
    DataType getDataType();

    @JacksonXmlProperty(localName = "is_simulated")
    Boolean getIsSimulated();
}
