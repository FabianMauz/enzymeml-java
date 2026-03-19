package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ProteinJsonMixin {

    @JsonCreator
    public ProteinJsonMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("constant") boolean constant
    ) throws ValidationException {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sequence;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("vessel_id")
    private String vesselId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ecnumber")
    private String ecNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("organism_tax_id")
    private String organismTaxId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String organism;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<String> references = new ArrayList<>();
}
