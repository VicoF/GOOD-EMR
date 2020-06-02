package models;

import java.io.IOException;

public interface WriteBehavior {
    void write(String path, Object objectToWrite) throws IOException;
}
