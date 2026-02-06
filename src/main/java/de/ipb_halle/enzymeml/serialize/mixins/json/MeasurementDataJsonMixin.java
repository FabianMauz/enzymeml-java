package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.DataType;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class MeasurementDataJsonMixin {

    @JsonProperty("species_id")
    private String speciesId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float prepared;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float initial;

    @JsonProperty("data_unit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UnitDefinition dataUnit;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<Float> data = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<Float> time = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("time_unit")
    private UnitDefinition timeUnit;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data_type")
    private DataType dataType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("is_simulated")
    private Boolean isSimulated;

}
