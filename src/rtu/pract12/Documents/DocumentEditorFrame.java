package rtu.pract12.Documents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public abstract class DocumentEditorFrame extends JFrame {
    protected IDocument iDocument;
    protected ICreateDocument iCreateDocument;

    private final JMenuItem newMenuItem;
    private final JMenuItem openMenuItem;
    private final JMenuItem saveMenuItem;
    private final JMenuItem exitMenuItem;

    private final JPanel outerPanel;
    private final JPanel innerPanel;

    protected abstract void actionOnNew(File file, boolean clearWork) throws IOException;

    protected abstract void actionOnOpen(File file) throws IOException;

    protected abstract void actionOnSave();

    protected DocumentEditorFrame(String title) {
        super(title);
        setSize(500, 500);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        outerPanel = new JPanel(new BorderLayout());
        innerPanel = new JPanel(new BorderLayout());

        newMenuItem = new JMenuItem("New");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("Exit");

        createPanels();
        createMenuBar();
        addEventsToMenuItems();
    }

    protected final void addWorkComponent(Component component) {
        innerPanel.add(component, BorderLayout.CENTER);
    }

    protected void endInit() {
        setVisible(true);
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message,
                "Error!", JOptionPane.ERROR_MESSAGE);
    }

    private void createPanels() {
        outerPanel.setBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10));
        setContentPane(outerPanel);
        innerPanel.setBorder(BorderFactory.createTitledBorder("Work panel"));
        outerPanel.add(innerPanel, BorderLayout.CENTER);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void addEventsToMenuItems() {
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(
                        DocumentEditorFrame.this,
                        "Are you sure you want to exit?",
                        "Confirm your action",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    DocumentEditorFrame.this.dispose();
                }
            }
        });

        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser chooser = new JFileChooser();
                    int returnValue = chooser.showSaveDialog(DocumentEditorFrame.this);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        actionOnNew(chooser.getSelectedFile().getAbsoluteFile(), true);
                        innerPanel.setBorder(BorderFactory.createTitledBorder(
                                iDocument.getFile().getName()
                        ));
                    }
                } catch (IOException exception) {
                    showErrorMessage(exception.getMessage());
                }
            }
        });

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser chooser = new JFileChooser();
                    final int returnValue = chooser.showOpenDialog(DocumentEditorFrame.this);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        actionOnOpen(chooser.getSelectedFile().getAbsoluteFile());
                        innerPanel.setBorder(BorderFactory.createTitledBorder(
                                iDocument.getFile().getName()
                        ));
                    }
                } catch (IOException exception) {
                    showErrorMessage(exception.getMessage());
                }
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (iDocument != null && iDocument.getFile() != null) {
                    actionOnSave();
                } else try {
                    JFileChooser chooser = new JFileChooser();
                    final int returnValue = chooser.showSaveDialog(DocumentEditorFrame.this);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        actionOnNew(chooser.getSelectedFile().getAbsoluteFile(), false);
                        innerPanel.setBorder(BorderFactory.createTitledBorder(
                                iDocument.getFile().getName()
                        ));
                    }
                    actionOnSave();
                } catch (IOException exception) {
                    showErrorMessage(exception.getMessage());
                }
            }
        });
    }
}
