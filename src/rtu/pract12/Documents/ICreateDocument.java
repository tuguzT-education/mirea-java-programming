package rtu.pract12.Documents;

import java.io.File;
import java.io.IOException;

public interface ICreateDocument {
    IDocument createNew(File file) throws IOException;

    IDocument createOpen(File file) throws IOException;
}
