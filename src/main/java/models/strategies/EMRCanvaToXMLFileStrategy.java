package models.strategies;

import models.EMRCanvas;
import models.composants.EMRShape;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EMRCanvaToXMLFileStrategy implements EMRCanvaToFileStrategy{
    final String FILE_EXTENSION = ".xml";
    @Override
    public void write(String path, EMRCanvas canva) throws IOException {
        if(!path.endsWith(FILE_EXTENSION)){
            path+= FILE_EXTENSION;
        }
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (EMRShape shape: canva.getShapes()) {
            writer.write(shape.toXMLString()+"\n");
        }
        writer.close();

    }
}
