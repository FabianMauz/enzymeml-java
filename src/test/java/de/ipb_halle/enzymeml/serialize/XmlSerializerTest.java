package de.ipb_halle.enzymeml.serialize;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.ipb_halle.enzymeml.model.Complex;
import de.ipb_halle.enzymeml.model.Creator;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.SmallMolecule;
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
        p1.setSequence("AAA..TTT");
        p1.setVesselId("v-1");
        p1.setEcNumber("1.2.3.4");
        p1.setOrganism("Human");
        p1.setOrganismTaxonomyId("123");
        p1.addReference("ref-1").addReference("ref-2");
        document.addProtein(p1);

        Protein p2 = new Protein("p-2", "Protein-2", false);
        p2.setSequence("XXX..YYY");
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

    @Test
    public void serialize_withTwoComplexes_returnsCorrectXmlExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "vessel-1", 1.1f, PredefinedUnits.liter(), true));

        Protein p1 = new Protein("p-1", "Protein-1", true);
        p1.setSequence("AAA..TTT");
        p1.setVesselId("v-1");
        p1.setEcNumber("1.2.3.4");
        p1.setOrganism("Human");
        p1.setOrganismTaxonomyId("123");
        p1.addReference("ref-1").addReference("ref-2");
        document.addProtein(p1);

        Protein p2 = new Protein("p-2", "Protein-2", false);
        p2.setSequence("XXX..YYY");
        p2.setVesselId("v-1");
        p2.setEcNumber("1.2.3.4");
        p2.setOrganism("Human");
        p2.setOrganismTaxonomyId("345");
        p2.addReference("ref-3").addReference("ref-4");
        document.addProtein(p2);

        Complex c1 = new Complex("c-1", "complex-1", true);
        c1.setVesselId("v-1");
        c1.addParticipant("p-1");
        c1.addParticipant("p-2");
        document.addComplex(c1);

        Complex c2 = new Complex("c-2", "complex-2", false);
        c2.setVesselId("v-1");
        c2.addParticipant("p-2");
        document.addComplex(c2);

        String xml = serializer.serialize(document);
        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withTwoComplexes.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }

    @Test
    public void serialize_withTwoSmallMolecules_returnsCorrectXmlExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "vessel-1", 1.1f, PredefinedUnits.liter(), true));

        SmallMolecule sm1 = new SmallMolecule("sm-1", "small-molecule-1", true);
        sm1.setVesselId("v-1").
                setSmiles("SMILES").setInchi("INCHI").setInchiKey("INCHIKEY")
                .addSynonym("Synonym-1").addSynonym("Synonym-2")
                .addReference("ref-1").addReference("ref-2");

        document.addSmallMolecule(sm1);

        SmallMolecule sm2 = new SmallMolecule("sm-2", "small-molecule-2", false);
        sm2.setVesselId("v-1").
                setSmiles("SMILES-2").setInchi("INCHI-2").setInchiKey("INCHIKEY-2")
                .addSynonym("Synonym-3").addSynonym("Synonym-4")
                .addReference("ref-3").addReference("ref-4");
        document.addSmallMolecule(sm2);

        String xml = serializer.serialize(document);
        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withTwoSmallMolecules.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());

    }
}
