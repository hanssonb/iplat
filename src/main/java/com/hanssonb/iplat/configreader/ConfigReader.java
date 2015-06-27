package com.hanssonb.iplat.configreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hanssonb.iplat.config.Config;

public class ConfigReader {
    static final String CONFIG = "config";

    static final String CONFIGVERSION = "version";
    static final String NAME = "name";
    static Config config = null;
    private static final Logger LOG = LogManager.getLogger(ConfigReader.class
            .getName());

    private ConfigReader() {
    }

    public static Config readConfig(String configFile) {
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(configFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            // read the XML document
            config = new Config();

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    LOG.trace("isStartElement");
                    StartElement startElement = event.asStartElement();
                    // If we have an item element, we create a new item
                    if (startElement.getName().getLocalPart() == (CONFIG)) {
                        LOG.trace("startElement.getname = CONFIG");

                        // We read the attributes from this tag and add the date
                        // attribute to our object
                        LOG.trace("startElement name=" + startElement.getName());
                        Iterator<Attribute> attributes = startElement
                                .getAttributes();
                        LOG.trace("isStartElement");
                        while (attributes.hasNext()) {
                            LOG.trace("attributes.hasNext");
                            Attribute attribute = attributes.next();
                            LOG.trace("attribute name=" + attribute.getName());
                            if (attribute.getName().toString()
                                    .equals(CONFIGVERSION)) {
                                config.setVersion(attribute.getValue());
                            }

                        }
                    }
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart()
                                .equals(NAME)) {
                            event = eventReader.nextEvent();
                            config.setName(event.asCharacters().getData());
                            continue;
                        }
                    }

                }
            }
        } catch (FileNotFoundException e) {
            LOG.info("EXCEPTION: " + e);
        } catch (XMLStreamException e) {
            LOG.info("EXCEPTION: " + e);
        }
        return config;

    }

}
