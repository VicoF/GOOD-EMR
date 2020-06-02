package models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteToTextFileBehavior implements WriteBehavior{
    final String FILE_EXTENSION=".txt";
    @Override
    public void write(String path, Object objectToWrite) throws IOException {
        if (!path.endsWith(FILE_EXTENSION)){
            path+=FILE_EXTENSION;
        }
        FileOutputStream fout = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(objectToWrite);
    }
}
