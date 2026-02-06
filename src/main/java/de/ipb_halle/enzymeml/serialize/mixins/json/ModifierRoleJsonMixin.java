package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public abstract class ModifierRoleJsonMixin {

    @JsonValue
    @Override
    public abstract String toString();
}
