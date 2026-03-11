package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public interface UnitTypeXmlMixin {

    @JsonValue
    @Override
    String toString();
}
