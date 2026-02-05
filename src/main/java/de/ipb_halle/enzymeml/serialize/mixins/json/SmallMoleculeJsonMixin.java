package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class SmallMoleculeJsonMixin {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("vessel_id")
    private String vesselId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("canonical_smiles")
    private String canonicalSmiles;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String inchi;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("inchikey")
    private String inchiKey;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("synonymous_names")
    private final List<String> synonmousNames = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<String> references = new ArrayList<>();
}
