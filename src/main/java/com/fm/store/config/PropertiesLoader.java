package com.fm.store.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Loads data from external file.
 */
public class PropertiesLoader {

    private SecretsConfig secretsConfig;

    public PropertiesLoader() {
        Yaml yaml = new Yaml(new Constructor(SecretsConfig.class));

        String secretsFileName = "secrets.yml";
        try (InputStream inputStream = new FileInputStream(secretsFileName)) {
            secretsConfig = yaml.load(inputStream);
            System.out.println("loading configuration file");
        } catch (IOException e) {
            System.out.println("could not find file: " + secretsFileName);
        }
    }

    public SecretsConfig getSecretsConfig() {
        return secretsConfig;
    }
}
