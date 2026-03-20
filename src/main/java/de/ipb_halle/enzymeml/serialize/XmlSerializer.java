package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.tools.ObjectMapperFactory;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlSerializer {

    public String serialize(EnzymeMLDocument document) throws JsonProcessingException, ValidationException {

        XmlMapper xmlMapper = ObjectMapperFactory.createXmlMapper();

        String xmlString = xmlMapper.writeValueAsString(document);
        XmlSyntaxValidator.validateSyntax(xmlString, true);
        return xmlString;
    }
}
