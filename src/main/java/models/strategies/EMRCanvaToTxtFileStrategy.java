package models.strategies;

import models.EMRCanvas;
import models.composants.EMRShape;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EMRCanvaToTxtFileStrategy implements  EMRCanvaToFileStrategy {
    @Override
    public void write(String path, EMRCanvas canva) throws IOException {
        BufferedWriter writer = null;
        File file = new File(path);
        writer = new BufferedWriter(new FileWriter(file));
        for (EMRShape shape: canva.getShapes()) {
            writer.write(shape.toString()+"\n");
        }
        writer.close();
    }
}
