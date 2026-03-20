package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.tools.ObjectMapperFactory;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author Fabian Mauz
 */
public class XmlDeserializer {

    public EnzymeMLDocument deserialize(String xmlString) throws ValidationException, JsonProcessingException {
        XmlMapper mapper = ObjectMapperFactory.createXmlMapper();

        EnzymeMLDocument document = mapper.readValue(xmlString, EnzymeMLDocument.class);
        return document;
    }

    public EnzymeMLDocument deserialize(File fileOfXml) throws ValidationException, IOException {
        String jsonFile = new String(Files.readAllBytes(fileOfXml.toPath()));
        return deserialize(jsonFile);
    }
}
