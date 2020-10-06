package rtu.pract12.Documents;

import java.io.File;
import java.io.IOException;

public class CreateTextDocument implements ICreateDocument {
    @Override
    public IDocument createNew(File file) throws IOException {
        if (!file.exists() && file.createNewFile()) {
            return new TextDocument(file);
        }
        throw new IOException("Couldn't create file!");
    }

    @Override
    public IDocument createOpen(File file) throws IOException {
        if (file.isFile() && file.exists()) {
            return new TextDocument(file);
        }
        throw new IOException("Couldn't open file!");
    }
}
