package models.strategies;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
/**
 * Interface qui permet de d�finir si une classe est serializable en XML
 * @author Victor
 *
 */
public interface XMLSerializable {
    String toXMLString();
}
