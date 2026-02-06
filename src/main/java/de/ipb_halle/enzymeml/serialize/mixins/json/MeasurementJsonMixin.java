package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.MeasurementData;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class MeasurementJsonMixin {

    @JsonProperty("species_data")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MeasurementData> speciesData;

    @JsonProperty("group_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String groupId;

    @JsonProperty("ph")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float pH;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float temperature;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("temperature_unit")
    private UnitDefinition temperatureUnit;

}
