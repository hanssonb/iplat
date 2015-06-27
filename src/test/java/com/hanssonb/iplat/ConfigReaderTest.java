package com.hanssonb.iplat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.hanssonb.iplat.config.Config;
import com.hanssonb.iplat.configreader.ConfigReader;

public class ConfigReaderTest {
    private static final Logger LOG = LogManager.getLogger(ConfigReaderTest.class
            .getName());

    @BeforeMethod
    public void setUp() {
        LOG.info("Entering @BeforeMethod setUp()");
        LOG.info("Leaving  @BeforeMethod setUp()");
    }

    @Test
    public void posReadTest() {
        LOG.info("Start test - posReadTest");
        Config config = ConfigReader.readConfig("config.xml");
        Assert.assertTrue(config.getName().equals("Bo Hansson"),
                "config.getnName is not receiving correct value!");
        LOG.info("End test - posReadTest");
    }

    @Test
    public void negReadTest() {
        LOG.info("Start test - negReadTest");
        Config config = ConfigReader.readConfig("config.xml");
        Assert.assertFalse(config.getName().equals("Bosse Hansson"),
                "config.getnName is not receiving correct value!");
        LOG.info("End test - negReadTest");
    }
}