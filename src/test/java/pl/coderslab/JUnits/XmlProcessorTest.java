package pl.coderslab.JUnits;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class XmlProcessorTest {


    @TempDir
    Path tempDir;

    @Test
    public void processXmlFilesWithTimeout() throws IOException {
        // given: plik XML
        Path xmlFile = tempDir.resolve("test.xml");
        Files.writeString(xmlFile, "<test>example</test>");

        XmlProcessor xmlProcessor = new XmlProcessor();

        // then: test limitu czasu
        assertTimeout(
                Duration.ofSeconds(5),
                () -> xmlProcessor.processXmlFiles(tempDir.toString())
        );
    }



}