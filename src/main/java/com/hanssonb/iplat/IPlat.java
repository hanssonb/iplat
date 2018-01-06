package com.hanssonb.iplat;

import java.awt.EventQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hanssonb.iplat.config.Config;
import com.hanssonb.iplat.configreader.ConfigReader;
import com.hanssonb.iplat.mainwindow.MainWindow;

/**
 * Main application!
 *
 */

public class IPlat {

    private static final Logger LOG = LogManager.getLogger(IPlat.class
            .getName());
    private IPlat() {
    }

    public static void main(String[] args) {
        LOG.trace("Entering main().");
        Config config = ConfigReader.readConfig("config.xml");
        LOG.trace("Config: " + "name=" + config.toString());
        LOG.trace("NAME = " + config.getName());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
        LOG.trace("Leaving main()");
    }
}