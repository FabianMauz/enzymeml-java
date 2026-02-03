package ipbhalle.de.enzymeml.model;

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

    private final String given_name;
    private final String family_name;
    private final String email;

    public Creator(String given_name, String family_name, String email) {
        this.given_name = given_name;
        this.family_name = family_name;
        this.email = email;
    }

    public String getGiven_name() {
        return given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public String getEmail() {
        return email;
    }
}
