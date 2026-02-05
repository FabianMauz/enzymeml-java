package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.BaseUnit;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class UnitDefinitionJsonMixin {

    @JsonProperty("base_units")
    private List<BaseUnit> baseUnits;
}
