package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.ipb_halle.enzymeml.factory.MeasurementFactory;
import de.ipb_halle.enzymeml.factory.ProteinFactory;
import de.ipb_halle.enzymeml.factory.ReactionFactory;
import de.ipb_halle.enzymeml.factory.SmallMoleculeFactory;
import de.ipb_halle.enzymeml.model.Complex;
import de.ipb_halle.enzymeml.model.Creator;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.ReactionElement;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import de.ipb_halle.enzymeml.model.Vessel;
import de.ipb_halle.enzymeml.tools.PredefinedUnits;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class JsonSerializerTest {

    JsonSerializer serializer = new JsonSerializer(true, true);
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void serialize_withMinimalExample_returnsCorrectJsonOfMinimalExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/minimalExample.json")))),
                mapper.readTree(serializer.serialize(document)));
    }

    @Test
    public void serialize_withTwoCreators_returnsCorrectJsonOfCreatorExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addCreator(new Creator("given-name-001", "family-name-001", "test@mail.de"));
        document.addCreator(new Creator("given-name-002", "family-name-002", "test@mail.de"));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withTwoCreators.json")))),
                mapper.readTree(serializer.serialize(document)));
    }

    @Test
    public void serialize_withTwoVessels_returnsCorrectJsonOfVesselsExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "Vessel-001", 40, PredefinedUnits.milligram(), true));
        document.addVessel(new Vessel("v-2", "Vessel-002", 100, PredefinedUnits.microgram(), true));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withTwoVessels.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneProtein_returnsCorrectJsonOfProteinExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "Vessel-001", 40, PredefinedUnits.milligram(), true));
        document.addProtein(ProteinFactory.createNewProtein("p-1", "v-1"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneProtein.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneMinimalProtein_returnsCorrectJsonOfMinimalProteinExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addProtein(ProteinFactory.createMinimalProtein("p-1"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneMinimalProtein.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneMinimalSmallMolecule_returnsCorrectMinimalSmallMoleculeExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addSmallMolecule(new SmallMolecule("sm-1", "Minimal-small-molecule", true));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneMinimalSmallMolecule.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneSmallMolecule_returnsCorrectSmallMoleculeExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "Vessel-001", 40, PredefinedUnits.milligram(), true));
        document.addSmallMolecule(SmallMoleculeFactory.createSmallMolecule("sm-1", "v-1"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneSmallMolecule.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneComplex_returnsCorrectJsonOfComplexExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "Vessel-001", 40, PredefinedUnits.milligram(), true));

        document.addProtein(ProteinFactory.createNewProtein("p-1", "v-1"));
        document.addSmallMolecule(SmallMoleculeFactory.createSmallMolecule("sm-1", "v-1"));

        Complex c1 = new Complex("c-1", "complex-name", true);
        c1.addParticipant("sm-1").addParticipant("p-1").setVesselId("v-1");

        document.addComplex(c1);

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneComplex.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneMinimalComplex_returnsCorrectJsonOfMinimalComplexExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        Complex c1 = new Complex("c-1", "complex-name", true);
        document.addComplex(c1);

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneMinimalComplex.json")))),
                jsonDocument);

    }

    @Test
    public void serialize_withOneMinimalReaction_returnsCorrectJsonOfMinimalReactionExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        document.addReaction(new Reaction("r-1", "example-reaction-1", true));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneMinimalReactionExample.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneReaction_returnsCorrectJsonOfReactionExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addSmallMolecule(new SmallMolecule("s-1", "Substrate", false));
        document.addSmallMolecule(new SmallMolecule("p-1", "Product", false));
        document.addSmallMolecule(new SmallMolecule("m-1", "Modifier", true));

        document.addReaction(ReactionFactory.createReaction("r-1", "s-1", "p-1", "m-1"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneReaction.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneMinimalMeasurement_returnsCorrectJsonOfMinimalMeasuremtExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        document.addMeasurement(new Measurement("mea-1", "measurement-1"));
        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withMinimalMeasurement.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneMeasurement_returnsCorrectJsonOfMeasuremtExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        document.addSmallMolecule(new SmallMolecule("s-1", "Substrate", false));
        document.addSmallMolecule(new SmallMolecule("p-1", "Product", false));
        Reaction reaction = new Reaction("r-1", "reaction-1", true);
        reaction.addReactant(new ReactionElement("s-1", -1));
        reaction.addProduct(new ReactionElement("p-1", 1));

        document.addReaction(reaction);

        document.addMeasurement(MeasurementFactory.createMeasurement("mea-1", "s-1"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneMeasurement.json")))),
                jsonDocument);
    }

}
