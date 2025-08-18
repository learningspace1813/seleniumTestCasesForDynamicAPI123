package HerokuTests;

import org.testng.Assert;

public class TestUtils {
    public static void validateEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void validateContains(String actual, String expectedPart, String message) {
        Assert.assertTrue(actual != null && actual.contains(expectedPart), message + " | Actual: " + actual);
    }

}


//import java.io.*;
//import java.nio.file.*;
//import java.util.zip.*;
//
//public class TestUtils {
//    public static void main(String[] args) {
//        String sourceDirPath = "herokuapp-tests"; // directory containing the Maven project
//        String zipFilePath = "herokuapp-tests.zip";
//
//        try {
//            zipDirectory(Paths.get(sourceDirPath), Paths.get(zipFilePath));
//            System.out.println("ZIP generated successfully: " + zipFilePath);
//        } catch (IOException e) {
//            System.err.println("Error generating ZIP: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    private static void zipDirectory(Path sourceDir, Path zipFile) throws IOException {
//        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile))) {
//            Files.walk(sourceDir).filter(path -> !Files.isDirectory(path)).forEach(path -> {
//                ZipEntry zipEntry = new ZipEntry(sourceDir.relativize(path).toString());
//                try {
//                    zos.putNextEntry(zipEntry);
//                    Files.copy(path, zos);
//                    zos.closeEntry();
//                } catch (IOException e) {
//                    throw new UncheckedIOException(e);
//                }
//            });
//        }
//    }
//}