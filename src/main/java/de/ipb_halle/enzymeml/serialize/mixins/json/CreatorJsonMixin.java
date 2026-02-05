package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class CreatorJsonMixin {

    @JsonProperty("given_name")
    private String givenName;
    @JsonProperty("family_name")
    private String familyName;
    @JsonProperty("mail")
    private String email;
}
