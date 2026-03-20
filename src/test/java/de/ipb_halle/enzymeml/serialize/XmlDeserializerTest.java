package de.ipb_halle.enzymeml.serialize;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlDeserializerTest {

    XmlDeserializer deserializer = new XmlDeserializer();

    @Test
    public void deserialize_fromMinimalDocumentXml_returnsMinimalDocument() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/xml/withMinimalDocument.xml"));

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
}
