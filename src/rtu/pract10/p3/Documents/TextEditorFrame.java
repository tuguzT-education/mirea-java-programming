package rtu.pract10.p3.Documents;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class TextEditorFrame extends DocumentEditorFrame {
    private final JTextArea textArea;

    public TextEditorFrame() {
        super("Simple text editor");
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        addWorkComponent(scrollPane);

        iDocument = null;
        iCreateDocument = new CreateTextDocument();

        endInit();
    }

    @Override
    protected void actionOnNew(File file, boolean clearWork) throws IOException {
        iDocument = iCreateDocument.createNew(file);
        if (clearWork) {
            textArea.setText("");
        }
    }

    @Override
    protected void actionOnOpen(File file) throws IOException {
        iDocument = iCreateDocument.createOpen(file);
        textArea.setText(((TextDocument) iDocument).getText());
    }

    @Override
    protected void actionOnSave() {
        if (iDocument != null) {
            ((TextDocument) iDocument).setText(textArea.getText());
            iDocument.save();
        }
    }
}
