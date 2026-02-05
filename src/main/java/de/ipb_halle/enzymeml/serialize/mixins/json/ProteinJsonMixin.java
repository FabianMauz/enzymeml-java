package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ProteinJsonMixin {

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
