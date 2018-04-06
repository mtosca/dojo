package harnesses;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ResourceLoader {
    public static byte[] getFileAsBytes(String fileName) throws IOException {
        byte [] xxx = getContent(fileName);
        return getContent(fileName);
    }

    public static String getFileAsString(String fileName) throws IOException {
        return new String( ResourceLoader.getFileAsBytes(fileName) );
    }

    private static byte[] getContent(String fileName) throws IOException {
        File file = getFileFromResources(fileName);
        return Files.readAllBytes(file.toPath());
    }

    private static File getFileFromResources(String fileName) {
        final ClassLoader classLoader = ResourceLoader.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

}
