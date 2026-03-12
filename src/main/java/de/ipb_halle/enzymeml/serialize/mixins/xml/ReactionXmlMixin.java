package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.ipb_halle.enzymeml.serialize.ReactionXmlSerializer;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonSerialize(using = ReactionXmlSerializer.class)
public interface ReactionXmlMixin {
}
