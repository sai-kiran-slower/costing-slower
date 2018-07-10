package com.slower.lulu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Init {


    private static final Logger logger = LoggerFactory.getLogger("Init");

    public static void main(String[] args) {
        String parentDirPath = null;
        String srcFilePath = null;
        String destFilePath = null;
        String payloadType = null;
        try {
            parentDirPath = "src/main/resources/sample/style/";

//            srcFilePath = parentDirPath + "Style_1_FlexPLM.json";
//            destFilePath = parentDirPath + "Style_1_BR_Kafka.json";
//            payloadType = "STYLE";
//            processPayload(srcFilePath, destFilePath, payloadType);
//            srcFilePath = parentDirPath + "Style_2_FlexPLM.json";
//            destFilePath = parentDirPath + "Style_2_BR_Kafka.json";
//            payloadType = "STYLE";
//            processPayload(srcFilePath, destFilePath, payloadType);
            srcFilePath = parentDirPath + "Style_3_FlexPLM.json";
            destFilePath = parentDirPath + "Style_3_BR_Kafka.json";
            payloadType = "STYLE";
            processPayload(srcFilePath, destFilePath, payloadType);


            parentDirPath = "src/main/resources/sample/color/";

            srcFilePath = parentDirPath + "Color_1_FlexPLM.json";
            destFilePath = parentDirPath + "Color_1_BR_Kafka.json";
            payloadType = "COLOR";
            processPayload(srcFilePath, destFilePath, payloadType);
            srcFilePath = parentDirPath + "Color_2_FlexPLM.json";
            destFilePath = parentDirPath + "Color_2_BR_Kafka.json";
            payloadType = "COLOR";
            processPayload(srcFilePath, destFilePath, payloadType);
            srcFilePath = parentDirPath + "Color_3_FlexPLM.json";
            destFilePath = parentDirPath + "Color_3_BR_Kafka.json";
            payloadType = "COLOR";
            processPayload(srcFilePath, destFilePath, payloadType);
            srcFilePath = parentDirPath + "Color_4_FlexPLM.json";
            destFilePath = parentDirPath + "Color_4_BR_Kafka.json";
            payloadType = "COLOR";
            processPayload(srcFilePath, destFilePath, payloadType);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void processPayload(String srcFilePath, String destFilePath, String payloadType) throws Exception {
        PayloadProcessor payloadProcessor = new PayloadProcessor();
        String brJsonStr = null;
        String fileContent = getFileContent(srcFilePath);

        switch (payloadType.toUpperCase()) {
            case "STYLE":
                brJsonStr = payloadProcessor.processStyle(fileContent);
                break;
            case "COLOR":
                brJsonStr = payloadProcessor.processColor(fileContent);
                break;
        }

        writeContentToJSONFile(destFilePath, brJsonStr);
    }

    private static String getFileContent(String filePath) throws IOException {
        final File file = new File(filePath);
        final String srcFileName = file.getName();
        logger.info("Processing File: " + srcFileName);
        String absolutePath = file.getAbsolutePath();
        String fileContent = new String(Files.readAllBytes(Paths.get(absolutePath)), StandardCharsets.UTF_8);
        return fileContent;
    }

    private static void writeContentToJSONFile(String filePath, String fileContent) throws IOException {
        logger.info("Writing processed JSON into file: " + filePath);
        Files.write(Paths.get(filePath), fileContent.getBytes());
    }
}
