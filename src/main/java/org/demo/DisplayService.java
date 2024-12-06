package org.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@ApplicationScoped
public class DisplayService {


//    private ObjectMapper mapper = new ObjectMapper(new YAMLFactory());


    private static final Logger logger = LoggerFactory.getLogger(DisplayService.class);

    @ConfigProperty(name = "folder.path")
    public String folderPath;

    public void getISOMessageProcessor(@Observes StartupEvent startupEvent) throws IOException {

//        InputStream inputStream = getClass().getResourceAsStream(sb.toString());
//        elementDefinitionFile = mapper.readValue(inputStream,ElementDefinitionFile.class);
//        mapper.readValue(new FileReader(sb.toString()), ElementDefinitionFile.class);

        try (BufferedReader br = new BufferedReader(new FileReader(folderPath))) {
            String line;
            while ((line = br.readLine()) != null) {

                System.out.println(">>>>>>>>>>>>>>> " + line);
            }


        }


    }
}
