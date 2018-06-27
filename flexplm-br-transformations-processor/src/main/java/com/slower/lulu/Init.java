package com.slower.lulu;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Init {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/sample/Style_1_FlexPLM.json");
            String absolutePath = file.getAbsolutePath();
            String file_content = new String(Files.readAllBytes(Paths.get(absolutePath)), StandardCharsets.UTF_8);

            PayloadProcessor payloadProcessor = new PayloadProcessor();
            String br_json_str = payloadProcessor.processStyle(file_content);
            Files.write(Paths.get("src/main/resources/sample/Style_1_BR_New.json"), br_json_str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
