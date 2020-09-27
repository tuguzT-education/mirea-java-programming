package rtu.pract10.Documents;

import java.io.File;
import java.io.IOException;

public interface ICreateDocument {
    IDocument createNew(File file) throws IOException;

    IDocument createOpen(File file) throws IOException;
}
