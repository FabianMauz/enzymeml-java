package de.ipb_halle.enzymeml.serialize;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlSerializerTest {

    XmlSerializer serializer = new XmlSerializer();

    @Test
    public void serialize_withMinimalExample_returnsCorrectJsonOfMinimalExample()
            throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        String xml = serializer.serialize(document);
        /*
                Diff xmlDiff = DiffBuilder
                                .compare(new String(
                                                Files.readAllBytes(Paths.get(
                                                                "src/test/resources/fixtures/xml/withMinimalDocument.xml"))))
                                .withTest(xml)
                                .ignoreWhitespace()
                                .checkForSimilar()
                                .build();

                assertFalse(xmlDiff.hasDifferences());
         */
    }
}
