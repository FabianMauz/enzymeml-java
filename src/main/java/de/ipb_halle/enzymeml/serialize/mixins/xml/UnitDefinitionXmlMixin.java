package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.BaseUnit;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public abstract class UnitDefinitionXmlMixin {

    @JsonCreator
    public UnitDefinitionXmlMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name
    ) throws ValidationException {
    }

    @JacksonXmlProperty(isAttribute = true)
    abstract String getId();

    @JacksonXmlProperty(isAttribute = true)
    abstract String getName();

    @JacksonXmlProperty(localName = "BaseUnit")
    @JacksonXmlElementWrapper(localName = "base_units")
    abstract List<BaseUnit> getBaseUnits();
}
