package gui;

import script.ScriptRunner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class MenuPanel extends JPanel {

    private JScrollPane jScrollPane;

    public MenuPanel(int width, int height, ScriptRunner runner) {
        setPreferredSize(new Dimension(width, height));
        this.setLayout(null);

        JButton btnStart = new JButton("Start");
        btnStart.setBounds(10, 10, 200, 20);

        JButton btnChooseFile = new JButton("Wybierz plik .opb");
        btnChooseFile.setBounds(220, 10, 200, 20);

        JButton btnManual = new JButton("Instrukcja");
        btnManual.setBounds(10, 40, 200, 20);

        JButton btnShowFile = new JButton("Wyświetl plik .opb");
        btnShowFile.setBounds(220, 40, 200, 20);

        JButton btnShowAns = new JButton("Wyświetl pełny wynik");
        btnShowAns.setBounds(10, 70, 200, 20);

        JButton btnLeaveMe = new JButton("Wyjdź");
        btnLeaveMe.setBounds(220, 70, 200, 20);

        btnStart.getModel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jScrollPane!=null){
                    remove(jScrollPane);
                }
                runner.runScript();
                JTextArea display = new JTextArea(runner.getResult());
                jScrollPane = new JScrollPane(display);
                jScrollPane.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                jScrollPane.setBounds(10, 100, 410, 65);
                add(jScrollPane);
                revalidate();
                repaint();
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

        btnManual.getModel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runner.geditProblem(0);
            }
        });

        btnShowFile.getModel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runner.geditProblem(1);
            }
        });

        btnShowAns.getModel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runner.geditProblem(2);
            }
        });

        btnLeaveMe.getModel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });

        add(btnStart);
        add(btnChooseFile);
        add(btnManual);
        add(btnShowFile);
        add(btnShowAns);
        add(btnLeaveMe);


    }
}