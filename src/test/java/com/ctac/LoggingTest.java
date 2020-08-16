package com.ctac;


import org.testng.annotations.Test;

import listeners.LoggingUtils;
import rp.com.google.common.io.Files;
import rp.com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;

import java.io.File;
import java.io.IOException;

public class LoggingTest {

    @Test(priority = 1)
    private void logCss() throws IOException {
        File file = File.createTempFile("rp-test", ".css");
        Resources.asByteSource(Resources.getResource("files/css.css")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging CSS");
    }

    @Test(priority = 2)
    private void logPdf() throws IOException {
        File file = File.createTempFile("rp-test", ".pdf");
        Resources.asByteSource(Resources.getResource("files/GitNotesForProfessionals.pdf")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging PDF");
    }
    @Test(priority = 3)
    private void logHtml() throws IOException {
        File file = File.createTempFile("rp-test", ".html");
        Resources.asByteSource(Resources.getResource("files/html.html")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging HTML");
    }

    @Test(priority = 4)
    private void logJavascript() throws IOException {
        File file = File.createTempFile("rp-test", ".js");
        Resources.asByteSource(Resources.getResource("files/javascript.js")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging JS");
    }

    @Test(priority = 5)
    private void logPhp() throws IOException {
        File file = File.createTempFile("rp-test", ".php");
        Resources.asByteSource(Resources.getResource("files/php.php")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging php");
    }

    @Test(priority = 6)
    private void logPlain() throws IOException {
        File file = File.createTempFile("rp-test", ".txt");
        Resources.asByteSource(Resources.getResource("files/plain.txt")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging txt");
    }

    @Test(priority = 7)
    private void logCsv() throws IOException {
        File file = File.createTempFile("rp-test", ".csv");
        Resources.asByteSource(Resources.getResource("files/Test.csv")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging txt");
    }

    @Test(priority = 8)
    private void logCmd() throws IOException {
        File file = File.createTempFile("rp-test", ".cmd");
        Resources.asByteSource(Resources.getResource("files/Test.cmd")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging txt");
    }

    @Test(priority = 9)
    private void logPng() throws IOException {
        File file = File.createTempFile("rp-test", ".png");
        Resources.asByteSource(Resources.getResource("files/screenshot.png")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging PNG File");
    }


    @Test(priority = 10)
    private void logmp4() throws IOException {
        File file = File.createTempFile("rp-test", ".mp4");
            Resources.asByteSource(Resources.getResource("files/Zalenium_Recorded_Test.mp4")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging MP4 File");
    }
    /*
     * String img="pug/Capture.png"; LOGGER.info("RP_MESSAGE#BASE64#{}#{}",
     * BaseEncoding.base64().encode(Resources.asByteSource(Resources.getResource(img
     * )).read()));
     */

}
