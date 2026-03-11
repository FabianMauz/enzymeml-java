package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.ipb_halle.enzymeml.model.BaseUnit;
import de.ipb_halle.enzymeml.model.Creator;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.model.UnitType;
import de.ipb_halle.enzymeml.model.Vessel;
import de.ipb_halle.enzymeml.serialize.mixins.xml.BaseUnitXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.CreatorXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.EnzymeMLDocumentXmlMixIn;
import de.ipb_halle.enzymeml.serialize.mixins.xml.UnitDefinitionXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.UnitTypeXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.VesselXmlMixin;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlSerializer {

    public String serialize(EnzymeMLDocument document) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.addMixIn(EnzymeMLDocument.class, EnzymeMLDocumentXmlMixIn.class);
        xmlMapper.addMixIn(Creator.class, CreatorXmlMixin.class);
        xmlMapper.addMixIn(UnitDefinition.class, UnitDefinitionXmlMixin.class);
        xmlMapper.addMixIn(BaseUnit.class, BaseUnitXmlMixin.class);
        xmlMapper.addMixIn(UnitType.class, UnitTypeXmlMixin.class);
        xmlMapper.addMixIn(Vessel.class, VesselXmlMixin.class);
        
        return xmlMapper.writeValueAsString(document);
    }
}
