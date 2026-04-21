package pl.coderslab.JUnits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlProcessor {

    public void processXmlFiles(String directoryPath) throws IOException {
        Path path = Paths.get(directoryPath);
        Files.list(path)
                .filter(filePath -> filePath.toString().endsWith(".xml"))
                .forEach(this::processXmlFile);
    }

    private void processXmlFile(Path path) {
        // Symulacja przetwarzania pliku XML
        System.out.println("Processing: " + path.getFileName());
        try {
            Thread.sleep(1000); // Symulacja czasochłonnego przetwarzania
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Processing interrupted", e);
        }
        System.out.println("Processed: " + path.getFileName());
    }
}