package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * EnzymeML V2 definition.
 *
 * The EnzymeMLDocument is the root object that serves as a container for all
 * components of an enzymatic experiment. It includes essential metadata about
 * the document itself, such as its title and creation/ modification dates, as
 * well as references to related publications and databases. Additionally, it
 * contains comprehensive information about the experimental setup, including
 * reaction vessels, proteins, complexes, small molecules, reactions,
 * measurements, equations, and parameters.
 *
 * @author Fabian Mauz
 */
public class EnzymeMLDocument {

    private final String version;
    private final String name;

    private String description;
    private String created;
    private String modified;
    private final List<Creator> creators = new ArrayList<>();
    private final List<Vessel> vessels = new ArrayList<>();
    private final List<Protein> proteins = new ArrayList<>();
    private final List<Complex> complexes = new ArrayList<>();
    private final List<SmallMolecule> smallMolecules = new ArrayList<>();
    private final List<Reaction> reactions = new ArrayList<>();
    private final List<Measurement> measurements = new ArrayList<>();
    private final List<Equation> equations = new ArrayList<>();
    private final List<Parameter> parameters = new ArrayList<>();
    private final List<String> references = new ArrayList<>();

    public EnzymeMLDocument(String version, String name) throws ValidationException {
        if (version == null) {
            throw new ValidationException("Version was null", "EnzymeMLDocument");
        }
        if (name == null) {
            throw new ValidationException("Name was null", "EnzymeMLDocument");
        }
        this.version = version;
        this.name = name;
    }

    public EnzymeMLDocument setDescription(String description) {
        this.description = description;
        return this;
    }

    public EnzymeMLDocument setCreatedDate(String createdDate) {
        this.created = createdDate;
        return this;
    }

    public EnzymeMLDocument setModifiedDate(String modifiedDate) {
        this.modified = modifiedDate;
        return this;
    }

    public EnzymeMLDocument addCreator(Creator creator) {
        this.creators.add(creator);
        return this;
    }

    public EnzymeMLDocument addVessel(Vessel vessel) {
        this.vessels.add(vessel);
        return this;
    }

    public EnzymeMLDocument addProtein(Protein protein) {
        this.proteins.add(protein);
        return this;
    }

    public EnzymeMLDocument addComplex(Complex complex) {
        this.complexes.add(complex);
        return this;
    }

    public EnzymeMLDocument addSmallMolecule(SmallMolecule sm) {
        this.smallMolecules.add(sm);
        return this;
    }

    public EnzymeMLDocument addReaction(Reaction reaction) {
        this.reactions.add(reaction);
        return this;
    }

    public EnzymeMLDocument addMeasurement(Measurement measurement) {
        this.measurements.add(measurement);
        return this;
    }

    public EnzymeMLDocument addEquation(Equation equation) {
        this.equations.add(equation);
        return this;
    }

    public EnzymeMLDocument addParameter(Parameter parameter) {
        this.parameters.add(parameter);
        return this;
    }

    public EnzymeMLDocument addReference(String reference) {
        this.references.add(reference);
        return this;
    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated() {
        return created;
    }

    public String getModified() {
        return modified;
    }

    public List<Creator> getCreators() {
        return creators;
    }

    public List<Vessel> getVessels() {
        return vessels;
    }

    public List<Protein> getProteins() {
        return proteins;
    }

    public List<Complex> getComplexes() {
        return complexes;
    }

    public List<SmallMolecule> getSmallMolecules() {
        return smallMolecules;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public List<String> getReferences() {
        return references;
    }

}
