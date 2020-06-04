package models.strategies;

import models.EMRCanvas;
import models.composants.EMRShape;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *  Cette classe implémente le design pattern "Strategy Pattern" avec les classes EMRCanvaToTxtFileStrategy et EMRCanvaToFileStrategy
 * @author Victor
 *
 */
public class EMRCanvaToTxtFileStrategy implements  EMRCanvaToFileStrategy {
    final String FILE_EXTENSION = ".txt";
    @Override
    public void write(String path, EMRCanvas canva) throws IOException {
        if(!path.endsWith(FILE_EXTENSION)){
            path+= FILE_EXTENSION;
        }
        BufferedWriter writer = null;
        File file = new File(path);
        writer = new BufferedWriter(new FileWriter(file));
        for (EMRShape shape: canva.getShapes()) {
            writer.write(shape.toString()+"\n");
        }
        writer.close();
    }
}
