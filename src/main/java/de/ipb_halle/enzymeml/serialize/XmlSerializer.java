package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.ipb_halle.enzymeml.model.Creator;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.serialize.mixins.xml.CreatorXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.EnzymeMLDocumentXmlMixIn;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlSerializer {

    public String serialize(EnzymeMLDocument document) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.addMixIn(EnzymeMLDocument.class, EnzymeMLDocumentXmlMixIn.class);
        xmlMapper.addMixIn(Creator.class, CreatorXmlMixin.class);
        return xmlMapper.writeValueAsString(document);
    }
}
