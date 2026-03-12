package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.ipb_halle.enzymeml.model.BaseUnit;
import de.ipb_halle.enzymeml.model.Complex;
import de.ipb_halle.enzymeml.model.Creator;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.ReactionElement;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.model.UnitType;
import de.ipb_halle.enzymeml.model.Vessel;
import de.ipb_halle.enzymeml.serialize.mixins.xml.BaseUnitXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.ComplexXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.CreatorXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.EnzymeMLDocumentXmlMixIn;
import de.ipb_halle.enzymeml.serialize.mixins.xml.ProteinXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.ReactionElementXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.ReactionXmlMixin;
import de.ipb_halle.enzymeml.serialize.mixins.xml.SmallMoleculeXmlMixin;
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
        
        xmlMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        xmlMapper.addMixIn(EnzymeMLDocument.class, EnzymeMLDocumentXmlMixIn.class);
        xmlMapper.addMixIn(Creator.class, CreatorXmlMixin.class);
        xmlMapper.addMixIn(UnitDefinition.class, UnitDefinitionXmlMixin.class);
        xmlMapper.addMixIn(BaseUnit.class, BaseUnitXmlMixin.class);
        xmlMapper.addMixIn(UnitType.class, UnitTypeXmlMixin.class);
        xmlMapper.addMixIn(Vessel.class, VesselXmlMixin.class);
        xmlMapper.addMixIn(Protein.class, ProteinXmlMixin.class);
        xmlMapper.addMixIn(Complex.class, ComplexXmlMixin.class);
        xmlMapper.addMixIn(SmallMolecule.class, SmallMoleculeXmlMixin.class);
        xmlMapper.addMixIn(Reaction.class, ReactionXmlMixin.class);
        xmlMapper.addMixIn(ReactionElement.class, ReactionElementXmlMixin.class);

        return xmlMapper.writeValueAsString(document);
    }
}
