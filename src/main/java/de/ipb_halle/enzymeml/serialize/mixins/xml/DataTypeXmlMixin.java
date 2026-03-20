package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public abstract class DataTypeXmlMixin {

    @JsonValue
    @Override
    public abstract String toString();
}
