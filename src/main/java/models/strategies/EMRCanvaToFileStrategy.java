package models.strategies;

import models.EMRCanvas;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
/**
 *  Cette classe implémente le design pattern "Strategy Pattern" avec les classes EMRCanvaToTxtFileStrategy et EMRCanvaToXMLFileStrategy
 * @author Victor
 *
 */
public interface EMRCanvaToFileStrategy {
     void write(String path, EMRCanvas canva) throws IOException, ParserConfigurationException, TransformerException;
}
