package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.ipb_halle.enzymeml.factory.MeasurementFactory;
import de.ipb_halle.enzymeml.factory.ParameterFactory;
import de.ipb_halle.enzymeml.factory.ProteinFactory;
import de.ipb_halle.enzymeml.factory.ReactionFactory;
import de.ipb_halle.enzymeml.factory.SmallMoleculeFactory;
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
import java.io.File;
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
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withMinimalDocument.json")))),
                mapper.readTree(serializer.serialize(document)));
    }

    @Test
    public void serialize_withOneDocument_returnsCorrectJsonOfDocumentExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.setCreatedDate("2025-01-01");
        document.setDescription("Description of document");
        document.setModifiedDate("2024-01-01");
        document.addReference("ref-1");
        document.addReference("ref-2");

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneDocument.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withTwoCreators_returnsCorrectJsonOfCreatorExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addCreator(new Creator("given-name-001", "family-name-001", "test@mail.de"));
        document.addCreator(new Creator("given-name-002", "family-name-002", "test@mail.de"));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withTwoCreators.json")))),
                mapper.readTree(serializer.serialize(document)));
    }

    @Test
    public void serialize_withTwoVessels_returnsCorrectJsonOfVesselsExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "Vessel-001", 40, PredefinedUnits.milligram(), true));
        document.addVessel(new Vessel("v-2", "Vessel-002", 100, PredefinedUnits.microgram(), false));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withTwoVessels.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneProtein_returnsCorrectJsonOfProteinExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "Vessel-001", 40, PredefinedUnits.milligram(), true));
        document.addProtein(ProteinFactory.createNewProtein("p-1", "v-1"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneProtein.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneMinimalProtein_returnsCorrectJsonOfMinimalProteinExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addProtein(ProteinFactory.createMinimalProtein("p-1"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneMinimalProtein.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneMinimalSmallMolecule_returnsCorrectMinimalSmallMoleculeExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addSmallMolecule(new SmallMolecule("sm-1", "Minimal-small-molecule", true));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneMinimalSmallMolecule.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneSmallMolecule_returnsCorrectSmallMoleculeExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addVessel(new Vessel("v-1", "Vessel-001", 40, PredefinedUnits.milligram(), true));
        document.addSmallMolecule(SmallMoleculeFactory.createSmallMolecule("sm-1", "v-1"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneSmallMolecule.json")))),
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
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneComplex.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneMinimalComplex_returnsCorrectJsonOfMinimalComplexExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        Complex c1 = new Complex("c-1", "complex-name", false);
        document.addComplex(c1);

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneMinimalComplex.json")))),
                jsonDocument);

    }

    @Test
    public void serialize_withOneMinimalReaction_returnsCorrectJsonOfMinimalReactionExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        document.addReaction(new Reaction("r-1", "example-reaction-1", false));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneMinimalReaction.json")))),
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
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneReaction.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneMinimalMeasurement_returnsCorrectJsonOfMinimalMeasuremtExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        document.addMeasurement(new Measurement("mea-1", "measurement-1"));
        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withMinimalMeasurement.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withTwoMeasurement_returnsCorrectJsonOfMeasurementExample() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        document.addSmallMolecule(new SmallMolecule("s-1", "Substrate", false));
        document.addSmallMolecule(new SmallMolecule("p-1", "Product", false));
        Reaction reaction = new Reaction("r-1", "reaction-1", true);
        reaction.addReactant(new ReactionElement("s-1", -1));
        reaction.addProduct(new ReactionElement("p-1", 1));

        document.addReaction(reaction);

        document.addMeasurement(MeasurementFactory.createMeasurement("mea-1", "s-1", true));
        document.addMeasurement(MeasurementFactory.createMeasurement("mea-2", "p1-1", false));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withTwoMeasurement.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withMinimalParameter_returnsCorrectJsonOfMinimalParameter() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addParameter(new Parameter("para-1", "parameter-1", "µ"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withMinimalParameter.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withOneParameter_returnsCorrectJsonOfOneParameter() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addParameter(ParameterFactory.createParameter("para-1"));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withOneParameter.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_withMinimalEquation_returnsCorrectJsonOfMinimalEquation() throws ValidationException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");
        document.addSmallMolecule(new SmallMolecule("s-1", "Substrate", false));
        document.addEquation(new Equation("s-1", "k*s-1", EquationType.ASSIGNMENT));

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withMinimalEquation.json")))),
                jsonDocument);
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

        JsonNode jsonDocument = mapper.readTree(serializer.serialize(doc));
        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/strendaDB_5V5MWU.json")))),
                jsonDocument);
    }

    @Test
    public void serialize_ofCompleteDocument_returnsCorrectJson() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "roundhouse-tip")
                .setCreatedDate("2026-03-19")
                .setModifiedDate("2026-03-19")
                .setDescription("Roundhousetrip-description")
                .addComplex(
                        new Complex("co-1", "complex-1", false)
                                .setVesselId("v-1")
                                .addParticipant("sm-1").addParticipant("p-1"))
                .addCreator(new Creator("givenName", "familyName", "mail@test.de"))
                .addEquation(
                        new Equation("p-1", "exampleEquation", EquationType.ASSIGNMENT)
                                .addVariable(
                                        new Variable("k", "k-name", "k-symbol")))
                .addMeasurement(new Measurement("meas-1", "measurement-1").addSpeciesData(
                        new MeasurementData("p-1")
                                .addDataPoint(100f, 0)
                                .addDataPoint(90f, 1)
                                .setDataType(DataType.YIELD)
                                .setDataUnit(PredefinedUnits.microgram())
                                .setInitial(100f)
                                .setPrepared(100f)
                                .setSimulated(false)
                                .setTimeUnit(PredefinedUnits.second())
                )
                        .setGroupId("gr-1")
                        .setPH(7.1f)
                        .setTemperature(36f, PredefinedUnits.celsius())
                ).addParameter(
                        new Parameter("para-1", "parameter-1", "p_1")
                                .setConstant(Boolean.TRUE)
                                .setFit(false)
                                .setInitialValue(200f)
                                .setLowerBound(180f)
                                .setUpperBound(210f)
                                .setStdError(20f)
                                .setUnit(PredefinedUnits.milligram())
                                .setValue(198f)
                ).addProtein(new Protein("p-1", "protein-1", true)
                        .setEcNumber("1.2.3.4")
                        .setOrganism("ExampleOrganism")
                        .setOrganismTaxonomyId("123")
                        .setSequence("TAMMTGA")
                        .setVesselId("v-1")
                        .addReference("Ref-1")
                        .addReference("Ref-2")
                ).addReaction(
                        new Reaction("r-1", "reaction-1", false)
                                .setKineticLaw(
                                        new Equation("p-1", "exampleEquation-2", EquationType.RATE_LAW)
                                                .addVariable(new Variable("v-1", "variable-1", "Vmax"))
                                )
                                .addModifier(new ModifierElement("p-1", ModifierRole.BIOCATALYST))
                                .addReactant(new ReactionElement("sm-1", -1))
                                .addProduct(new ReactionElement("sm-2", 1))
                ).addReference("Document-reference-1")
                .addReference("Document-reference-1")
                .addSmallMolecule(
                        new SmallMolecule("sm-1", "small-molecule-1", true)
                                .setInchi("Ichi-sm1")
                                .setInchiKey("Inchi-key-sm1")
                                .setSmiles("Smiles-sm1")
                                .setVesselId("v-1")
                                .addReference("SM1-Ref")
                                .addSynonym("SM1-Syn-2")
                                .addSynonym("SM1-Syn-1")
                ).addSmallMolecule(
                        new SmallMolecule("sm-2", "small-molecule-2", true)
                                .setInchi("Ichi-sm2")
                                .setInchiKey("Inchi-key-sm2")
                                .setSmiles("Smiles-sm2")
                                .setVesselId("v-1")
                                .addReference("SM2-Ref")
                                .addSynonym("SM2-Syn-2")
                                .addSynonym("SM2-Syn-1")
                ).addVessel(
                        new Vessel("v-1", "vessel-1", 100, PredefinedUnits.milliliter(), true));
        JsonNode jsonDocument = mapper.readTree(serializer.serialize(document));

        Assertions.assertEquals(
                mapper.readTree(new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/json/withCompleteDocument.json")))),
                jsonDocument);
    }     
}
