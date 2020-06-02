package models.strategies;

import models.EMRCanvas;
import models.composants.Arrow;
import models.composants.EMRCategories;
import models.composants.EMRShape;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLFileToEMRCanvaStrategy implements FileToEMRCanvaStrategy {
    @Override
    public void read(String path, EMRCanvas canva) throws IOException {
        List<String> lines;
        ArrayList<EMRShape> shapes = new ArrayList<>();
        lines = Files.readAllLines(Paths.get(path));
        Pattern pattern;
        Matcher matcher;
        EMRShape shape;
        try {
            for (String line:
                    lines) {
                pattern = Pattern.compile("<(.*?) ");
                matcher = pattern.matcher(line);
                matcher.find();
                String className= matcher.group(1);

                Class<?> clazz = Class.forName(className);
                pattern = Pattern.compile("categorie=\"(.*?)\"");
                matcher = pattern.matcher(line);
                matcher.find();
                EMRCategories categorie = EMRCategories.valueOf(matcher.group(1));
                pattern = Pattern.compile("posX=\"(.*?)\"");
                matcher = pattern.matcher(line);
                matcher.find();
                double posX = Double.valueOf(matcher.group(1));
                pattern = Pattern.compile("posY=\"(.*?)\"");
                matcher = pattern.matcher(line);
                matcher.find();
                double posY = Double.valueOf(matcher.group(1));
                if (Arrow.class.isAssignableFrom(clazz)){
                    pattern = Pattern.compile("targetPosX=\"(.*?)\"");
                    matcher = pattern.matcher(line);
                    matcher.find();
                    double targetPosX = Double.valueOf(matcher.group(1));

                    pattern = Pattern.compile("targetPosY=\"(.*?)\"");
                    matcher = pattern.matcher(line);
                    matcher.find();
                    double targetPosY = Double.valueOf(matcher.group(1));
                    Constructor<?> constructor = clazz.getConstructor(EMRCategories.class, double.class,double.class, double.class,double.class);
                    shape = (Arrow) constructor.newInstance(categorie,posX,posY,targetPosX,targetPosY);
                }else {
                    Constructor<?> constructor = clazz.getConstructor(EMRCategories.class, double.class, double.class);
                    shape = (EMRShape) constructor.newInstance(categorie,posX,posY);
                }
                shapes.add(shape);

            }
            canva.setShapes(shapes);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IOException("Fichier invalide");
        }
    }
}
