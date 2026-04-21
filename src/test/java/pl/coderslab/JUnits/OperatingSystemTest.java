package pl.coderslab.JUnits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class OperatingSystemTest {

    @Test
    void testOnlyOnWindows() {
        assumeTrue(
                System.getProperty("os.name").contains("Mac OS")
        );

        // Dowolna asercja – wykona się TYLKO gdy asumpcja jest spełniona
        assertEquals(2 + 2, 4);
    }

}