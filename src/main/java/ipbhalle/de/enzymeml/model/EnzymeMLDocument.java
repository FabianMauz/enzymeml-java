package ipbhalle.de.enzymeml.model;

import java.lang.reflect.Parameter;
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

    private String version;
    private String description;
    private String name;
    private String created;
    private String modified;
    private List<Creator> creators = new ArrayList<>();
    private List<Vessel> vessels = new ArrayList<>();
    private List<Protein> proteins = new ArrayList<>();
    private List<Complex> complexes = new ArrayList<>();
    private List<SmallMolecule> smallMolecules = new ArrayList<>();
    private List<Reaction> reactions = new ArrayList<>();
    private List<Measurement> measurements = new ArrayList<>();
    private List<Equation> equations = new ArrayList<>();
    private List<Parameter> parameters = new ArrayList<>();
    private List<String> references = new ArrayList<>();

}
