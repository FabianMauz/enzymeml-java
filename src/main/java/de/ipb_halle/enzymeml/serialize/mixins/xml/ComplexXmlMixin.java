package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public interface ComplexXmlMixin {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "participants")
    public List<String> getParticipants();

    @JacksonXmlProperty(localName = "vessel_id")
    public String getVesselId();

}
