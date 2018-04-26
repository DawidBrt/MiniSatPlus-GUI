package gui;

import script.ScriptRunner;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class MenuPanel extends JPanel {

    public MenuPanel(int width, int height, ScriptRunner runner) {
        setPreferredSize(new Dimension(width, height));
        this.setLayout(null);

        JButton btnStart = new JButton("Start");
        JButton btnChooseFile = new JButton("Wybierz plik .opb");
        btnStart.setBounds(10, 10, 90, 20);
        btnChooseFile.setBounds(110, 10, 150, 20);
        btnStart.getModel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runner.runScript();
            }

        });
        btnChooseFile.getModel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.addChoosableFileFilter(new FileNameExtensionFilter("OPB", "opb"));
                jfc.setAcceptAllFileFilterUsed(true);
                int result = jfc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    System.out.println(selectedFile.getPath());
                    runner.setProblem(selectedFile.getPath());
                }
            }
        });
        add(btnStart);
        add(btnChooseFile);
    }
}