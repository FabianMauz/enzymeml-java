package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"id", "name", "volume", "constant", "unit"})
public interface VesselXmlMixin {

}
