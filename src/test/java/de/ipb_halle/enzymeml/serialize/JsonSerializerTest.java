package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.ipb_halle.enzymeml.model.Creator;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Protein;
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
    public void serialize_withTwoProteins_returnsCorrectJsonOfProteinExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "Vessel-001", 40, PredefinedUnits.milligram(), true));
        Protein p1 = new Protein("p-1", "protein-001", true);
        p1.addReference("reference-001");
        p1.addReference("reference-002");
        p1.addSequence("Test-Sequence");
        p1.setVesselId("v-1");
        p1.setOrganism("test-organism");
        p1.setOrganismTaxonomyId("123");
        p1.setEcNumber("1.1.1.1");
        document.addProtein(p1);

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/withOneProtein.json")))),
                jsonDocument);

    }
}
