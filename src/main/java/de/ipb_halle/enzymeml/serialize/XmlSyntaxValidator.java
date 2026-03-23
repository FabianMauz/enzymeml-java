package de.ipb_halle.enzymeml.serialize;

import de.ipb_halle.enzymeml.validate.ValidationException;
import java.io.File;
import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlSyntaxValidator {

    public static void validateSyntax(String xmlString) throws ValidationException {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("src/main/resources/enzymeml-v2.xsd"));

            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new StringReader(xmlString)));
        } catch (Exception e) {
            throw new ValidationException("Error at xsd validation", e.getMessage());
        }
    }
}
