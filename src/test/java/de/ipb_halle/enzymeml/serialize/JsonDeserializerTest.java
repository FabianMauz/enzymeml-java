package de.ipb_halle.enzymeml.serialize;

import de.ipb_halle.enzymeml.Tools;
import de.ipb_halle.enzymeml.model.Complex;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.EquationType;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.ModifierElement;
import de.ipb_halle.enzymeml.model.ModifierRole;
import de.ipb_halle.enzymeml.model.Parameter;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.ReactionElement;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import de.ipb_halle.enzymeml.model.Variable;
import de.ipb_halle.enzymeml.model.Vessel;
import de.ipb_halle.enzymeml.tools.PredefinedUnits;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class JsonDeserializerTest {

    JsonDeserializer deserializer = new JsonDeserializer();

    @Test
    public void deserialize_fromMinimalDocumentJson_returnMinimalDocument() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withMinimalDocument.json"));
        Assertions.assertEquals("Example Document", document.getName());
        Assertions.assertEquals("2.0", document.getVersion());
        Assertions.assertEquals(0, document.getCreators().size());
        Assertions.assertEquals(0, document.getComplexes().size());
        Assertions.assertEquals(0, document.getMeasurements().size());
        Assertions.assertEquals(0, document.getEquations().size());
        Assertions.assertEquals(0, document.getParameters().size());
        Assertions.assertEquals(0, document.getProteins().size());
        Assertions.assertEquals(0, document.getReactions().size());
        Assertions.assertEquals(0, document.getReferences().size());
        Assertions.assertEquals(0, document.getSmallMolecules().size());
        Assertions.assertEquals(0, document.getVessels().size());
        Assertions.assertNull(document.getCreated());
        Assertions.assertNull(document.getModified());
        Assertions.assertNull(document.getDescription());
    }

    @Test
    public void deserialize_fromDocumentJson_returnDocument() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withOneDocument.json"));
        Assertions.assertEquals("Example Document", document.getName());
        Assertions.assertEquals("2.0", document.getVersion());
        Assertions.assertEquals("2025-01-01", document.getCreated());
        Assertions.assertEquals("2024-01-01", document.getModified());
        Assertions.assertEquals("Description of document", document.getDescription());
        Assertions.assertEquals(2, document.getReferences().size());
        Assertions.assertTrue(document.getReferences().contains("ref-1"));
        Assertions.assertTrue(document.getReferences().contains("ref-2"));
    }

    @Test
    public void deserialize_fromMinimalEquationJson_returnDocumentWithEquation() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withMinimalEquation.json"));
        Assertions.assertEquals("Example Document", document.getName());
        Assertions.assertEquals(1, document.getSmallMolecules().size());
        SmallMolecule smallMolecule = document.getSmallMolecules().get(0);
        Assertions.assertEquals("Substrate", smallMolecule.getName());
        Assertions.assertEquals("s-1", smallMolecule.getId());
        Assertions.assertFalse(smallMolecule.isConstant());

        Assertions.assertEquals(1, document.getEquations().size());
        Equation equation = document.getEquations().get(0);
        Assertions.assertEquals("s-1", equation.getSpeciesId());
        Assertions.assertEquals(EquationType.ASSIGNMENT, equation.getEquationType());
        Assertions.assertEquals("k*s-1", equation.getEquation());
    }

    @Test
    public void deserialize_fromMinimalMeasurementJson_returnDocumentWithMeasurement() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withMinimalMeasurement.json"));
        Assertions.assertEquals(1, document.getMeasurements().size());
        Measurement measurement = document.getMeasurements().get(0);
        Assertions.assertEquals("mea-1", measurement.getId());
        Assertions.assertEquals("measurement-1", measurement.getName());
    }

    @Test
    public void deserialize_fromMinimalParameterJson_returnDocumentWithParameter() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withMinimalParameter.json"));
        Assertions.assertEquals(1, document.getParameters().size());
        Parameter parameter = document.getParameters().get(0);
        Assertions.assertEquals("para-1", parameter.getId());
        Assertions.assertEquals("parameter-1", parameter.getName());
        Assertions.assertEquals("µ", parameter.getSymbol());
    }

    @Test
    public void deserialize_fromComplexJson_returnDocumentWithComplex() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withOneComplex.json"));

        Assertions.assertEquals(1, document.getVessels().size());
        Vessel vessel = document.getVessels().get(0);
        Assertions.assertEquals("v-1", vessel.getId());
        Assertions.assertEquals("Vessel-001", vessel.getName());
        Assertions.assertEquals(40.0f, vessel.getVolume());
        Assertions.assertTrue(vessel.isConstant());
        Assertions.assertTrue(Tools.areUnitEqual(PredefinedUnits.milligram(), vessel.getUnit()));

        Assertions.assertEquals(1, document.getProteins().size());
        Protein protein = document.getProteins().get(0);
        Assertions.assertEquals("p-1", protein.getId());
        Assertions.assertEquals("proteinname-p-1", protein.getName());
        Assertions.assertTrue(protein.isConstant());
        Assertions.assertEquals("Test-Sequence", protein.getSequence());
        Assertions.assertEquals("test-organism", protein.getOrganism());
        Assertions.assertEquals(2, protein.getReferences().size());
        Assertions.assertTrue(protein.getReferences().contains("reference-001"));
        Assertions.assertTrue(protein.getReferences().contains("reference-002"));
        Assertions.assertEquals("v-1", protein.getVesselId());
        Assertions.assertEquals("1.1.1.1", protein.getEcNumber());
        Assertions.assertEquals("123", protein.getOrganismTaxId());

        Assertions.assertEquals(1, document.getComplexes().size());
        Complex complex = document.getComplexes().get(0);
        Assertions.assertEquals("c-1", complex.getId());
        Assertions.assertEquals("complex-name", complex.getName());
        Assertions.assertEquals("v-1", complex.getVesselId());
        Assertions.assertTrue(complex.isConstant());
        Assertions.assertEquals(2, complex.getParticipants().size());
        Assertions.assertTrue(complex.getParticipants().contains("sm-1"));
        Assertions.assertTrue(complex.getParticipants().contains("p-1"));

        Assertions.assertEquals(1, document.getSmallMolecules().size());
        SmallMolecule sm = document.getSmallMolecules().get(0);
        Assertions.assertEquals("sm-1", sm.getId());
        Assertions.assertEquals("sm-1-name", sm.getName());
        Assertions.assertTrue(sm.isConstant());
        Assertions.assertEquals("inchi", sm.getInchi());
        Assertions.assertEquals("inchiKey", sm.getInchiKey());
        Assertions.assertEquals("smiles", sm.getCanonicalSmiles());
        Assertions.assertEquals("v-1", sm.getVesselId());
        Assertions.assertEquals(1, sm.getSynonmousNames().size());
        Assertions.assertTrue(sm.getSynonmousNames().contains("synonym-1"));
        Assertions.assertEquals(2, sm.getReferences().size());
        Assertions.assertTrue(sm.getReferences().contains("ref-1"));
        Assertions.assertTrue(sm.getReferences().contains("ref-2"));
    }

    @Test
    public void deserialize_fromMinimalComplexJson_returnDocumentWithComplex() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withOneMinimalComplex.json"));
        Assertions.assertEquals(1, document.getComplexes().size());
        Complex complex = document.getComplexes().get(0);
        Assertions.assertEquals("c-1", complex.getId());
        Assertions.assertEquals("complex-name", complex.getName());
        Assertions.assertNull(complex.getVesselId());
        Assertions.assertFalse(complex.isConstant());
        Assertions.assertEquals(0, complex.getParticipants().size());
    }

    @Test
    public void deserialize_fromMinimalProteinJson_returnDocumentWithProtein() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withOneMinimalProtein.json"));
        Assertions.assertEquals(1, document.getProteins().size());
        Protein protein = document.getProteins().get(0);
        Assertions.assertEquals("p-1", protein.getId());
        Assertions.assertEquals("proteinname-p-1", protein.getName());
        Assertions.assertFalse(protein.isConstant());
        Assertions.assertNull(protein.getSequence());
        Assertions.assertNull(protein.getOrganism());
        Assertions.assertEquals(0, protein.getReferences().size());
        Assertions.assertNull(protein.getVesselId());
        Assertions.assertNull(protein.getEcNumber());
        Assertions.assertNull(protein.getOrganismTaxId());
    }

    @Test
    public void deserialize_fromMinimalReactionJson_returnDocumentWithReaction() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withOneMinimalReaction.json"));
        Assertions.assertEquals(1, document.getReactions().size());

        Reaction reaction = document.getReactions().get(0);
        Assertions.assertEquals("r-1", reaction.getId());
        Assertions.assertEquals("example-reaction-1", reaction.getName());
        Assertions.assertFalse(reaction.isReversible());
        Assertions.assertEquals(0, reaction.getModifiers().size());
        Assertions.assertEquals(0, reaction.getReactants().size());
        Assertions.assertEquals(0, reaction.getProducts().size());
        Assertions.assertNull(reaction.getKineticLaw());
    }

    @Test
    public void deserialize_fromMinimalSmallMoleculeJson_returnDocumentWithSmallMolecule() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withOneMinimalSmallMolecule.json"));

        Assertions.assertEquals(1, document.getSmallMolecules().size());
        SmallMolecule sm = document.getSmallMolecules().get(0);
        Assertions.assertEquals("sm-1", sm.getId());
        Assertions.assertEquals("Minimal-small-molecule", sm.getName());
        Assertions.assertTrue(sm.isConstant());
        Assertions.assertNull(sm.getInchi());
        Assertions.assertNull(sm.getInchiKey());
        Assertions.assertNull(sm.getCanonicalSmiles());
        Assertions.assertNull(sm.getVesselId());
        Assertions.assertEquals(0, sm.getSynonmousNames().size());
        Assertions.assertEquals(0, sm.getReferences().size());
    }

    @Test
    public void deserialize_fromParameterJson_returnDocumentWithParameter() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withOneParameter.json"));

        Assertions.assertEquals(1, document.getParameters().size());
        Parameter parameter = document.getParameters().get(0);
        Assertions.assertEquals("para-1", parameter.getId());
        Assertions.assertEquals("para-1-name", parameter.getName());
        Assertions.assertEquals("symbol of para-1", parameter.getSymbol());
        Assertions.assertEquals(20.0f, parameter.getValue(), 0.000001f);
        Assertions.assertTrue(Tools.areUnitEqual(PredefinedUnits.milligram(), parameter.getUnit()));
        Assertions.assertFalse(parameter.getFit());
        Assertions.assertEquals(3.0f, parameter.getStderr(), 0.000001f);
        Assertions.assertTrue(parameter.isConstant());
        Assertions.assertEquals(20.0f, parameter.getInitialValue(), 0.000001f);
        Assertions.assertEquals(21.0f, parameter.getUpperBound(), 0.000001f);
        Assertions.assertEquals(19.0f, parameter.getLowerBound(), 0.000001f);

    }

    @Test
    public void deserialize_fromProteinJson_returnDocumentWithProtein() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withOneProtein.json"));

        Assertions.assertEquals(1, document.getProteins().size());
        Protein protein = document.getProteins().get(0);
        Assertions.assertEquals("p-1", protein.getId());
        Assertions.assertEquals("proteinname-p-1", protein.getName());
        Assertions.assertTrue(protein.isConstant());
        Assertions.assertEquals("Test-Sequence", protein.getSequence());
        Assertions.assertEquals("test-organism", protein.getOrganism());
        Assertions.assertEquals(2, protein.getReferences().size());
        Assertions.assertTrue(protein.getReferences().contains("reference-001"));
        Assertions.assertTrue(protein.getReferences().contains("reference-002"));
        Assertions.assertEquals("v-1", protein.getVesselId());
        Assertions.assertEquals("1.1.1.1", protein.getEcNumber());
        Assertions.assertEquals("123", protein.getOrganismTaxId());
    }

    @Test
    public void deserialize_fromReactionJson_returnDocumentWithReaction() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/json/withOneReaction.json"));

        Assertions.assertEquals(1, document.getReactions().size());
        Assertions.assertEquals(3, document.getSmallMolecules().size());

        Reaction reaction = document.getReactions().get(0);
        Assertions.assertEquals("r-1", reaction.getId());
        Assertions.assertEquals("reaction-name-r-1", reaction.getName());
        Assertions.assertTrue(reaction.isReversible());
        Assertions.assertEquals(1, reaction.getReactants().size());
        ReactionElement reactant = reaction.getReactants().get(0);
        Assertions.assertEquals("s-1", reactant.getSpeciesId());
        Assertions.assertEquals(-1, reactant.getStoichiometry());
        ReactionElement product = reaction.getProducts().get(0);
        Assertions.assertEquals("p-1", product.getSpeciesId());
        Assertions.assertEquals(1, product.getStoichiometry());
        ModifierElement modifier = reaction.getModifiers().get(0);
        Assertions.assertEquals("m-1", modifier.getSpeciesId());
        Assertions.assertEquals(ModifierRole.SOLVENT, modifier.getRole());

        Equation equation = reaction.getKineticLaw();
        Assertions.assertEquals("k * substrateId", equation.getEquation());
        Assertions.assertEquals("p-1", equation.getSpeciesId());
        Assertions.assertEquals(EquationType.RATE_LAW, equation.getEquationType());

        Variable variable = equation.getVariables().get(0);
        Assertions.assertEquals("var-1", variable.getId());
        Assertions.assertEquals("description of k", variable.getName());
        Assertions.assertEquals("k", variable.getSymbol());

    }
}
