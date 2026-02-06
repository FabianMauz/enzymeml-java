package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 * Definition of the Creator.
 *
 * The Creator object represents an individual author or contributor who has
 * participated in creating or modifying the EnzymeML Document. It captures
 * essential personal information such as their name and contact details,
 * allowing proper attribution and enabling communication with the document's
 * creators.
 *
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Creator {

    private final String givenName;
    private final String familyName;
    private final String email;

    public Creator(String givenName, String familyName, String email) throws ValidationException {
        if (givenName == null) {
            throw new ValidationException("Given name was null", null);
        }
        if (familyName == null) {
            throw new ValidationException("Family name was null", null);
        }
        if (email == null) {
            throw new ValidationException("Email was null", null);
        }
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getEmail() {
        return email;
    }
}
