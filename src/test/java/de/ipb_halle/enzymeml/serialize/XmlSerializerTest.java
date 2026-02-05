package de.ipb_halle.enzymeml.serialize;

import de.ipb_halle.enzymeml.serialize.XmlSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlSerializerTest {

    XmlSerializer serializer = new XmlSerializer();

    @Test
    public void serialize_withMinimalExample_returnsCorrectJsonOfMinimalExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

    }
}
