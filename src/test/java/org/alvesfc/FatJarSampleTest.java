package org.alvesfc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FatJarSampleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldEncodeMessage() {
        String[] args = new String[]{"encode", "message"};
        FatJarSample.main(args);
        assertEquals("bWVzc2FnZQ==\n", outContent.toString());
    }

    @Test
    void shouldDecodeMessage() {
        String[] args = new String[]{"decode", "bWVzc2FnZQ=="};
        FatJarSample.main(args);
        assertEquals("message\n", outContent.toString());
    }

    @Test
    void shouldPrintInvalidCommand() {
        String[] args = new String[]{"invalid", "message"};
        FatJarSample.main(args);
        assertEquals("Invalid command. Please use encode or decode\n", outContent.toString());
    }

    @Test
    void shouldPrintPleaseProvideName() {
        String[] args = new String[]{};
        FatJarSample.main(args);
        assertEquals("Please provide a name as argument.  e.g. java -jar fat-jar-example.jar encode message\n", outContent.toString());
    }
}