package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ComplexJsonMixin {

    @JsonCreator
    public ComplexJsonMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("constant") boolean constant
    ) throws ValidationException {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("vessel_id")
    private String vesselId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> participants;
}
