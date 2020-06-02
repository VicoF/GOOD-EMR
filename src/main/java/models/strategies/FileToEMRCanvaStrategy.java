package models.strategies;

import models.EMRCanvas;

import java.io.IOException;

public interface FileToEMRCanvaStrategy {
    void read(String path, EMRCanvas canva) throws IOException;
}
