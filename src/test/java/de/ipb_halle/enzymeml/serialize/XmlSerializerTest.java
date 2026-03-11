package de.ipb_halle.enzymeml.serialize;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.ipb_halle.enzymeml.model.Creator;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Vessel;
import de.ipb_halle.enzymeml.tools.PredefinedUnits;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlSerializerTest {

    XmlSerializer serializer = new XmlSerializer();

    @Test
    public void serialize_withMinimalExample_returnsCorrectXmlOfMinimalExample()
            throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        String xml = serializer.serialize(document);

        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withMinimalDocument.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }

    @Test
    public void serialize_withTwoCreators_returnsCorrectXmlExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addCreator(new Creator("user-1-gn", "user-1-fn", "user1@test.de"));
        document.addCreator(new Creator("user-2-gn", "user-2-fn", "user2@test.de"));
        String xml = serializer.serialize(document);
        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withTwoCreators.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }

    @Test
    public void serialize_withTwoVessels_returnsCorrectXmlExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "vessel-1", 1.1f, PredefinedUnits.liter(), true));
        document.addVessel(new Vessel("v-2", "vessel-2", 100, PredefinedUnits.mililiter(), true));
        String xml = serializer.serialize(document);

        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withTwoVessels.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }

    @Test
    public void serialize_withTwoProteins_returnsCorrectXmlExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "vessel-1", 1.1f, PredefinedUnits.liter(), true));

        Protein p1 = new Protein("p-1", "Protein-1", true);
        p1.addSequence("AAA..TTT");
        p1.setVesselId("v-1");
        p1.setEcNumber("1.2.3.4");
        p1.setOrganism("Human");
        p1.setOrganismTaxonomyId("123");
        p1.addReference("ref-1").addReference("ref-2");
        document.addProtein(p1);

        Protein p2 = new Protein("p-2", "Protein-2", false);
        p2.addSequence("XXX..YYY");
        p2.setVesselId("v-1");
        p2.setEcNumber("1.2.3.4");
        p2.setOrganism("Human");
        p2.setOrganismTaxonomyId("345");
        p2.addReference("ref-3").addReference("ref-4");
        document.addProtein(p2);

        String xml = serializer.serialize(document);
        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withTwoProteins.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }
}
