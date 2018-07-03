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
            System.out.println("Processing File: Style_1_FlexPLM.json");
            File file = new File("src/main/resources/sample/style/Style_1_FlexPLM.json");
            String absolutePath = file.getAbsolutePath();
            String file_content = new String(Files.readAllBytes(Paths.get(absolutePath)), StandardCharsets.UTF_8);

            PayloadProcessor payloadProcessor = new PayloadProcessor();
            String br_json_str = payloadProcessor.processStyle(file_content);
            System.out.println("Writing processed JSON into file: Style_1_BR_New.json");
            Files.write(Paths.get("src/main/resources/sample/style/Style_1_BR_New.json"), br_json_str.getBytes());

            System.out.println("");

            System.out.println("Processing File: Color_1_FlexPLM.json");
            file = new File("src/main/resources/sample/color/Color_1_FlexPLM.json");
            absolutePath = file.getAbsolutePath();
            file_content = new String(Files.readAllBytes(Paths.get(absolutePath)), StandardCharsets.UTF_8);

            br_json_str = payloadProcessor.processColor(file_content);
            System.out.println("Writing processed JSON into file: Color_1_BR_New.json");
            Files.write(Paths.get("src/main/resources/sample/color/Color_1_BR_New.json"), br_json_str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
