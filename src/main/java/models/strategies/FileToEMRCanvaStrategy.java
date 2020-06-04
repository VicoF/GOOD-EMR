package models.strategies;

import models.EMRCanvas;

import java.io.IOException;
/**
 *  Cette classe implémente le design pattern "Strategy Pattern" avec les classes TxtFileToEMRCanvaStrategy et XMLFileToEMRCanvaStrategy
 * @author Victor
 *
 */
public interface FileToEMRCanvaStrategy {
    void read(String path, EMRCanvas canva) throws IOException;
}
