package de.ipb_halle.enzymeml.serialize;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.EquationType;
import de.ipb_halle.enzymeml.model.SmallMolecule;
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
    public void deserialize_ofMinimalDocument_returnMinimalDocument() throws ValidationException, IOException {
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
    public void deserialize_ofMinimalEquation_returnDocumentWithEquation() throws ValidationException, IOException {
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
}
