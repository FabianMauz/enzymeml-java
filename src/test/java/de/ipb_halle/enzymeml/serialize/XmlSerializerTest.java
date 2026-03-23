package de.ipb_halle.enzymeml.serialize;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.ipb_halle.enzymeml.model.BaseUnit;
import de.ipb_halle.enzymeml.model.Complex;
import de.ipb_halle.enzymeml.model.Creator;
import de.ipb_halle.enzymeml.model.DataType;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.EquationType;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.MeasurementData;
import de.ipb_halle.enzymeml.model.ModifierElement;
import de.ipb_halle.enzymeml.model.ModifierRole;
import de.ipb_halle.enzymeml.model.Parameter;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.ReactionElement;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.model.UnitType;
import de.ipb_halle.enzymeml.model.Variable;
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
    public void serialize_FullFlatDocument_returnsCorrectXmlOfExample()
            throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document")
                .addReference("DOI:12345.sd.pi")
                .addReference("UNIPROT:9374893js")
                .setCreatedDate("2026-03-20")
                .setDescription("A simple description")
                .setModifiedDate("2026-03-21");

        String xml = serializer.serialize(document);

        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withFullFlatDocument.xml"))))
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
        document.addVessel(new Vessel("v-2", "vessel-2", 100, PredefinedUnits.milliliter(), true));
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

    @Test
    public void serialize_withOneComplexReaction_returnsCorrectXmlExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        document.addVessel(new Vessel("v-1", "vessel-1", 1.1f, PredefinedUnits.liter(), true));
        document.addProtein(new Protein("p-1", "Protein-1", true));
        document.addSmallMolecule(new SmallMolecule("sm-1", "small-molecule-1", false));
        document.addSmallMolecule(new SmallMolecule("sm-2", "small-molecule-2", false));
        document.addSmallMolecule(new SmallMolecule("sm-3", "small-molecule-3", true));

        Reaction reaction = new Reaction("r-1", "reaction-1", true);
        reaction.addModifier(new ModifierElement("sm-3", ModifierRole.BUFFER));
        reaction.addModifier(new ModifierElement("p-1", ModifierRole.BIOCATALYST));
        reaction.addReactant(new ReactionElement("sm-1", -1));
        reaction.addProduct(new ReactionElement("sm-2", 1));
        Equation equation = new Equation("sm-1", "a=b*c", EquationType.ASSIGNMENT);
        equation.addVariable(new Variable("v-1", "variable-1", "b"));
        reaction.setKineticLaw(equation);
        document.addReaction(reaction);

        String xml = serializer.serialize(document);
        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withOneComplexReaction.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }

    @Test
    public void serialize_withOneMeasurement_returnsCorrectXmlExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        Measurement measurement = new Measurement("m-1", "measurement-1");
        measurement.setPH(7.3f);
        measurement.setTemperature(37.4f, PredefinedUnits.celsius());
        measurement.setGroupId("1");

        MeasurementData data1 = new MeasurementData("sm-1");
        data1.setDataType(DataType.AMOUNT);
        data1.addDataPoint(100.2f, 0);
        data1.addDataPoint(75.3f, 1);
        data1.addDataPoint(50.2f, 2);
        data1.setDataUnit(PredefinedUnits.liter());
        data1.setInitial(100.2f);
        data1.setPrepared(100.3f);
        data1.setSimulated(Boolean.TRUE);
        data1.setTimeUnit(PredefinedUnits.second());
        data1.setSimulated(false);

        measurement.addSpeciesData(data1);
        document.addMeasurement(measurement);
        document.addSmallMolecule(new SmallMolecule("sm-1", "small-molecule-1", false));

        String xml = serializer.serialize(document);
        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withOneMeasurement.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }

    @Test
    public void serialize_withTwoParameters_returnsCorrectXmlExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        Parameter para = new Parameter("p-1", "parameter-1", "p__1");
        para.setConstant(false);
        para.setFit(Boolean.TRUE);
        para.setInitialValue(24.2f);
        para.setLowerBound(23.1f);
        para.setUpperBound(25.1f);
        para.setUnit(PredefinedUnits.celsius());
        para.setValue(23.4f);
        para.setStdError(2.1f);

        document.addParameter(para);

        document.addParameter(new Parameter("p-2", "parameter-2", "p__2"));

        String xml = serializer.serialize(document);
        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withTwoParameter.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }

    @Test
    public void serialize_withOneEquation_returnsCorrectXmlExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        Equation equation = new Equation("sm-1", "a=b*c", EquationType.ASSIGNMENT);
        equation.addVariable(new Variable("v-1", "variable-1", "b"));
        document.addEquation(equation);

        String xml = serializer.serialize(document);
        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withOneEquation.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }

    //This test is based on real world data. Example is taken from the StrendaDB: 10.22011/strenda_db.5V5MWU
    @Test
    public void serialize_withStrendaDBExample_returnsCorrectXmlString() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "Human Neutrophil Elastase: Kinetics with Four Synthetic Substrates")
                .addReference("STRENDADB:5V5MWU")
                .addReference("DOI:10.22011/strenda_db.5V5MWU")
                .setCreatedDate("2016-05-18")
                .setDescription("""
                           Human Neutrophil Elastase: Kinetics with Four Synthetic Substrates. Methodolgy: The experiments described here have been published by Fr\u00fch, H., Kostoulas, G., Michel, B.A., and Baici, A. (1996). Human myeloblastin (leukocyte proteinase 3): Reactions with substrates, inactivators and activators in comparison with leukocyte elastase. Biol. Chem. 377, 579-586.
                           
                           The kinetic parameters of two fluorogenic and two chromogenic substrates were investigated under the strict control of experimental conditions to support their use in the investigation of enzyme-modifier interactions.
                           
                           NOTE 1: The buffer solution was 50 mM Na+/K+ phosphate prepared (and used) at 25\u00b0C by titrating a 50 mM solution of disodium hydrogen phosphate dihydrate with a 50 mM solution of potassium dihydrogen phosphate until the pH was 7.00. Ionic strength = 0.11 M, buffer capacity 0.029. Total phosphate species = 50.0 mM, Na+ = 60.3 mM, K+ = 19.8 mM.
                           
                           NOTE 2: Dimethyl sulfoxide was added to all solutions at a final concentration of 0.5% v/v to allow solubilization of compounds that were not perfectly water soluble. Even for water soluble substances the solvent was added in order to guarantee uniform conditions in the series of experiments.
                           
                           NOTE 3: The isoelectric point of neutrophil elastase is 10.5 and thus the protein is positively charged at neutral pH. To avoid loss of enzyme activity by non-specific interaction with vessel walls, 0.05% v/v Triton X-100 was also added to all solutions.
                           
                           Additional information:
                           
                           cellType:Polymorphonuclear leukocytes (neutrophils)
                           ptModification:no
                           expressedFromPlasmid:no
                           tissue: blood
                           localisation: Azurophil granules
                           default reaction: Hydrolysis of proteins, including elastin. Preferential cleavage Val! > Ala!
                           
                           """)
                .addProtein(new Protein("p-1", "Neutrophil elastase (Bone marrow serine protease) (Elastase-2) (Human leukocyte elastase) (HLE) (Medullasin) (PMN elastase)", true)
                        .setSequence("MTLGRRLACLFLACVLPALLLGGTALASEIVGGRRARPHAWPFMVSLQLRGGHFCGATLIAPNFVMSAAHCVANVNVRAVRVVLGAHNLSRREPTRQVFAVQRIFENGYDPVNLLNDIVILQLNGSATINANVQVAQLPAQGRRLGNGVQCLAMGWGLLGRNRGIASVLQELNVTVVTSLCRRSNVCTLVRGRQAGVCFGDSGSPLVCNGLIHGIASFVRGGCASGLYPDAFAPVAQFVNWIDSIIQRSEDNPCPHPRDPDPASRTH")
                        .setOrganism("Homo sapiens (Human)")
                        .setOrganismTaxonomyId("9606")
                        .setEcNumber("3.4.21.37")
                        .addReference("UNIPROT:P08246"))
                .addSmallMolecule(new SmallMolecule("sm-1", "Triton X-100", true)
                        .addReference("PUBCHEM-COMPOUND:5590")
                        .addReference("CHEBI:9750")
                        .setInchi("InChI=1S/C16H26O2/c1-15(2,3)12-16(4,5)13-6-8-14(9-7-13)18-11-10-17/h6-9,17H,10-12H2,1-5H3")
                        .addSynonym("2-[4-(2,4,4-trimethylpentan-2-yl)phenoxy]ethanol")
                        .setSmiles("CC(C)(C)CC(C)(C)C1=CC=C(C=C1)OCCO"))
                .addSmallMolecule(new SmallMolecule("sm-2", "Dimethyl sulfoxide", true)
                        .addReference("PUBCHEM-COMPOUND:679")
                        .addReference("CHEBI:28262")
                        .setInchi("InChI=1S/C2H6OS/c1-4(2)3/h1-2H3")
                        .addSynonym("methylsulfinylmethane")
                        .setSmiles("CS(=O)C"))
                .addSmallMolecule(new SmallMolecule("sm-3", "Methoxysuccinyl-Ala-Ala-Pro-Val-7-(4-methyl)coumarylamide", false))
                .addSmallMolecule(new SmallMolecule("sm-4", "Sodium/potassium phosphate", true))
                .addReaction(new Reaction("r-1", "", false)
                        .addModifier(new ModifierElement("sm-1", ModifierRole.ADDITIVE))
                        .addModifier(new ModifierElement("sm-2", ModifierRole.SOLVENT))
                        .addReactant(new ReactionElement("sm-3", -1))
                        .addModifier(new ModifierElement("sm-4", ModifierRole.BUFFER))
                        .addModifier(new ModifierElement("p-1", ModifierRole.BIOCATALYST)))
                .addMeasurement(new Measurement("m-1", "Kinetic parameters of MeO-Suc-AAPV-NMec")
                        .setPH(7.0f)
                        .setTemperature(25.0f, PredefinedUnits.celsius())
                        .addSpeciesData(new MeasurementData("p-1")
                                .setDataType(DataType.CONCENTRATION)
                                .setInitial(15.0f)
                                .setDataUnit(PredefinedUnits.nanoMolar()))
                        .addSpeciesData(new MeasurementData("sm-1")
                                .setDataType(DataType.CONCENTRATION)
                                .setInitial(0.77f)
                                .setDataUnit(PredefinedUnits.milliMolar())
                        ).addSpeciesData(new MeasurementData("sm-2")
                                .setDataType(DataType.CONCENTRATION)
                                .setInitial(70f)
                                .setDataUnit(PredefinedUnits.milliMolar()))
                        .addSpeciesData(new MeasurementData("sm-3")
                                .setDataType(DataType.CONCENTRATION)
                                .setInitial(.1f)
                                .setDataUnit(PredefinedUnits.milliMolar()))
                        .addSpeciesData(new MeasurementData("sm-4")
                                .setDataType(DataType.CONCENTRATION)
                                .setInitial(3f)
                                .setDataUnit(PredefinedUnits.milliMolar())))
                .addParameter(new Parameter("kcatOverKm", "specificityConstant", "kcatOverKm")
                        .setValue(15200.0f)
                        .setStdError(3500f)
                        .setUnit(new UnitDefinition("M-1_s-1", "perMolarPerSecond")
                                .addBaseUnit(new BaseUnit(UnitType.LITRE, 1, 1, 0))
                                .addBaseUnit(new BaseUnit(UnitType.MOLE, -1, 1, 0))
                                .addBaseUnit(new BaseUnit(UnitType.SECOND, -1, 1, 0))))
                .addParameter(new Parameter("kcat", "CatalyticConstant", "kcat")
                        .setValue(7.9f)
                        .setStdError(0.7f)
                        .setUnit(PredefinedUnits.perSecond()))
                .addParameter(new Parameter("km", "ConcentrationSE", "kcat")
                        .setValue(520f)
                        .setStdError(110f)
                        .setUnit(PredefinedUnits.microMolar()));

        XmlSerializer xmlSerializer = new XmlSerializer();
        String xml = xmlSerializer.serialize(doc);
        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/strendaDB_5V5MWU.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .normalizeWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }

    @Test
    public void serialize_withXmlReserverdCharsInReference_returnsCorrectXmlString() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addReference("<");
        document.addReference(">");
        document.addReference("&");
        document.addReference("\"");
        document.addReference("'");

        String xml = serializer.serialize(document);

        Diff xmlDiff = DiffBuilder
                .compare(new String(
                        Files.readAllBytes(Paths.get(
                                "src/test/resources/fixtures/xml/withReservedChars.xml"))))
                .withTest(xml)
                .ignoreWhitespace()
                .checkForSimilar()
                .build();

        Assertions.assertFalse(xmlDiff.hasDifferences());
    }
}
