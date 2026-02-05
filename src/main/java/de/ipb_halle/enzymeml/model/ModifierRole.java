package de.ipb_halle.enzymeml.model;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public enum ModifierRole {

    ACTIVATOR("activator"),
    ADDITIVE("additive"),
    BIOCATALYST("biocatalyst"),
    BUFFER("buffer"),
    CATALYST("catalyst"),
    INHIBITOR("inhibitor"),
    SOLVENT("solvent");

    private String name;

    private ModifierRole(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
