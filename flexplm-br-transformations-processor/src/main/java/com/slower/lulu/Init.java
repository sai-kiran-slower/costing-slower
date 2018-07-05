package com.slower.lulu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Init {

    private static final Logger logger = LoggerFactory.getLogger("Init");

    public static void main(String[] args) {
        try {
            logger.info("Processing File: Style_1_FlexPLM.json");
            File file = new File("src/main/resources/sample/style/Style_1_FlexPLM.json");
            String absolutePath = file.getAbsolutePath();
            String fileContent = new String(Files.readAllBytes(Paths.get(absolutePath)), StandardCharsets.UTF_8);

            PayloadProcessor payloadProcessor = new PayloadProcessor();
            String brJsonStr = payloadProcessor.processStyle(fileContent);
            logger.info("Writing processed JSON into file: Style_1_BR_New.json");
            Files.write(Paths.get("src/main/resources/sample/style/Style_1_BR_New.json"), brJsonStr.getBytes());

            logger.info("");

            logger.info("Processing File: Color_1_FlexPLM.json");
            file = new File("src/main/resources/sample/color/Color_1_FlexPLM.json");
            absolutePath = file.getAbsolutePath();
            fileContent = new String(Files.readAllBytes(Paths.get(absolutePath)), StandardCharsets.UTF_8);

            brJsonStr = payloadProcessor.processColor(fileContent);
            logger.info("Writing processed JSON into file: Color_1_BR_New.json");
            Files.write(Paths.get("src/main/resources/sample/color/Color_1_BR_New.json"), brJsonStr.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
