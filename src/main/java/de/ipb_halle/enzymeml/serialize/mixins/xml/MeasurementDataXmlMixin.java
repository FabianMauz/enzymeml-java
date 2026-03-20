package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.DataType;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"species_id", "prepared", "initial", "data_unit", "data", "time", "time_unit", "data_type", "is_simulated"})
public abstract class MeasurementDataXmlMixin {

    @JsonCreator
    public MeasurementDataXmlMixin(
            @JsonProperty("species_id") String kind
    ) throws ValidationException {
    }

    @JacksonXmlProperty(localName = "prepared")
    abstract Float getPrepared();

    @JacksonXmlProperty(localName = "initial")
    abstract Float getInitial();

    @JacksonXmlProperty(localName = "species_id")
    abstract String getSpeciesId();

    @JacksonXmlProperty(localName = "data_unit")
    abstract UnitDefinition getDataUnit();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "data")
    abstract List<Float> getData();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "time")
    abstract List<Float> getTime();

    @JacksonXmlProperty(localName = "time_unit")
    abstract UnitDefinition getTimeUnit();

    @JacksonXmlProperty(localName = "data_type")
    abstract DataType getDataType();

    @JacksonXmlProperty(localName = "is_simulated")
    abstract Boolean getIsSimulated();
}
