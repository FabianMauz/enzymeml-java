package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ReactionElementJsonMixin {

    @JsonProperty("species_id")
    private String speciesId;
}
