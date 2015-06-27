package com.hanssonb.iplat.mainwindow;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainWindow extends JFrame implements ActionListener {
    private static final Logger LOGGER = LogManager.getLogger(MainWindow.class
            .getName());
    private JSplitPane splitPane;
    private JScrollPane scrollPane;
    private JPanel panel;
    private JButton addButton;
    private JCheckBox delayCheckBox;
    private JCheckBox interactiveCheckBox;
    private JCheckBox randomCheckBox;
    private JDesktopPane desktopPane;

    // CONSTANTS

    // SPLITPANE
    public static final int SPLITPANE_DIVIDER_LOCATION = 300;
    public static final int SPLITPANE_DIVIDER_SIZE = 8;

    // GRIDBAG CONSTRAINTS

    public static final int GRIDBAG_CONSTRAINTS_GRID_X = 0;
    public static final int GRIDBAG_CONSTRAINTS_GRID_Y = 1;

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        LOGGER.trace("Entering initComponents.");

        GridBagConstraints gridBagConstraints;

        splitPane = new JSplitPane();
        scrollPane = new JScrollPane();
        panel = new JPanel();
        addButton = new JButton();
        delayCheckBox = new JCheckBox();
        interactiveCheckBox = new javax.swing.JCheckBox();
        randomCheckBox = new javax.swing.JCheckBox();
        desktopPane = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        splitPane.setDividerLocation(SPLITPANE_DIVIDER_LOCATION);
        splitPane.setDividerSize(SPLITPANE_DIVIDER_SIZE);
        splitPane.setContinuousLayout(true);
        splitPane.setOneTouchExpandable(true);
        panel.setLayout(new java.awt.GridBagLayout());

        addButton.setText("Create New Frame");
        addButton
                .setToolTipText("Adds a new frame containing an universe into the desktop pane");
        addButton.addActionListener(this);

        panel.add(addButton, new java.awt.GridBagConstraints());

        delayCheckBox.setText("Resize Delayed");
        delayCheckBox
                .setToolTipText("Shows the effect of using a delayed resizing to the internal frames.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = GRIDBAG_CONSTRAINTS_GRID_X;
        gridBagConstraints.gridy = GRIDBAG_CONSTRAINTS_GRID_Y;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(delayCheckBox, gridBagConstraints);

        interactiveCheckBox.setSelected(true);
        interactiveCheckBox.setText("Interactive Cube");
        interactiveCheckBox
                .setToolTipText("Tests the use of AWT behaviors on the displayed component.");
        interactiveCheckBox.setBorder(javax.swing.BorderFactory
                .createEmptyBorder(0, 0, 0, 0));
        interactiveCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        interactiveCheckBox.addActionListener(this);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(interactiveCheckBox, gridBagConstraints);

        randomCheckBox.setText("Random start angle");
        randomCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,
                0, 0, 0));
        randomCheckBox.setEnabled(false);
        randomCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(randomCheckBox, gridBagConstraints);

        scrollPane.setViewportView(panel);

        splitPane.setLeftComponent(scrollPane);

        desktopPane.setBackground(new java.awt.Color(153, 153, 201));
        desktopPane.setPreferredSize(new java.awt.Dimension(300, 300));
        splitPane.setRightComponent(desktopPane);

        getContentPane().add(splitPane, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize();
        setBounds((screenSize.width - 1011) / 2, (screenSize.height - 733) / 2,
                1011, 733);
        LOGGER.trace("Leaving initComponents.");
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == addButton) {
            MainWindow.this.addButtonActionPerformed();
        } else if (evt.getSource() == interactiveCheckBox) {
            MainWindow.this.interactiveCheckBoxActionPerformed();
        }
    }// </editor-fold>//GEN-END:initComponents

    private void interactiveCheckBoxActionPerformed() {
        randomCheckBox.setEnabled(interactiveCheckBox.isSelected() ? false
                : true);
    }

    private void addButtonActionPerformed() {// GEN-FIRST:event_addButtonActionPerformed
        JInternalFrame iWorld;
        // we create an internal world to be added within the JDesktop.
        iWorld = new JInternalFrame();
        iWorld.setSize(256, 256);
        iWorld.setLocation(50, 50);
        iWorld.setResizable(true);
        desktopPane.add(iWorld);
        iWorld.setVisible(true);
    }// GEN-LAST:event_addButtonActionPerformed

}
