package models.strategies;

import models.EMRCanvas;

import java.io.IOException;

public interface EMRCanvaToFileStrategy {
     void write(String path, EMRCanvas canva) throws IOException;
}
