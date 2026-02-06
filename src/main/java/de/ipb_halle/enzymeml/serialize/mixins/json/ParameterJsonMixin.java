package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.UnitDefinition;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ParameterJsonMixin {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String value;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UnitDefinition unit;

    @JsonProperty("initial_value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float initialValue;
    @JsonProperty("upper_bound")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float upperBound;

    @JsonProperty("lower_bound")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float lowerBound;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean fit;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float stderr;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean constant;
}
