package ipbhalle.de.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import ipbhalle.de.enzymeml.model.BaseUnit;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class UnitDefinitionJsonMixin {

    @JsonProperty("base_units")
    private List<BaseUnit> baseUnits;
}
