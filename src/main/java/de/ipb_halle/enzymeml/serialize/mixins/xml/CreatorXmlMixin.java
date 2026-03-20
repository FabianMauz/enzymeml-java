package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"givenName", "familyName", "email"})
public abstract class CreatorXmlMixin {

    @JsonCreator
    public CreatorXmlMixin(
            @JsonProperty("given_name") String givenName,
            @JsonProperty("family_name") String familyName,
            @JsonProperty("mail") String email
    ) throws ValidationException {
    }

    @JacksonXmlProperty(localName = "given_name")
    abstract String getGivenName();

    @JacksonXmlProperty(localName = "family_name")
    abstract String getFamilyName();

    @JacksonXmlProperty(localName = "mail")
    abstract String getEmail();

}
