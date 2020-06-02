package models.strategies;

import models.EMRCanvas;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface EMRCanvaToFileStrategy {
     void write(String path, EMRCanvas canva) throws IOException, ParserConfigurationException, TransformerException;
}
