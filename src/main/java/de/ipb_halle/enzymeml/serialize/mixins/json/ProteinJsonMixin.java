package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ProteinJsonMixin {

    @JsonProperty("vessel_id")
    private String vesselId;
    @JsonProperty("ecnumber")
    private String ecNumber;
    @JsonProperty("organism_tax_id")
    private String organismTaxId;
}
