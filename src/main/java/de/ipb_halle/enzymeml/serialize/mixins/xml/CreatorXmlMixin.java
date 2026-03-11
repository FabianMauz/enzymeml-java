package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"givenName", "familyName", "email"})
public interface CreatorXmlMixin {

    @JacksonXmlProperty(localName = "given_name")
    String getGivenName();

    @JacksonXmlProperty(localName = "family_name")
    String getFamilyName();

    @JacksonXmlProperty(localName = "mail")
    String getEmail();

}
