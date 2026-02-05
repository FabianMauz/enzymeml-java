package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ComplexJsonMixin {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("vessel_id")
    private String vesselId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> participants;
}
