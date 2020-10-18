package rtu.lab11;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class Exercise4 {
    private static final LinkedList<File> catalog = new LinkedList<>();

    public static void saveCatalog(String path) throws IOException {
        catalog.clear();
        final File currentDirectory = new File(path);
        if (!currentDirectory.isDirectory()) {
            throw new IOException("File with input name is not a directory!");
        }
        int i = 0;
        for (final String string : Objects.requireNonNull(currentDirectory.list())) {
            final File directory = new File(path + string);
            catalog.add(directory);
            if (i++ < 5) {
                System.out.println(directory.getAbsolutePath());
            }
        }
    }

    public static LinkedList<File> getCatalog() {
        return catalog;
    }
}
