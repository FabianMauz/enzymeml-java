package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.BaseUnit;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public interface UnitDefinitionXmlMixin {

    @JacksonXmlProperty(isAttribute = true)
    String getId();

    @JacksonXmlProperty(isAttribute = true)
    String getName();

    @JacksonXmlProperty(localName = "BaseUnit")
    @JacksonXmlElementWrapper(localName = "base_units")
    List<BaseUnit> getBaseUnits();
}
