package ipbhalle.de.enzymeml.model;

/**
 * Definition of a ModifierElement.
 *
 * The ModifierElement object represents a species that is not part of the
 * reaction but influences it.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ModifierElement {

    private final String speciesId;
    private final ModifierRole role;

    public ModifierElement(String speciesId, ModifierRole role) {
        this.speciesId = speciesId;
        this.role = role;
    }
}
