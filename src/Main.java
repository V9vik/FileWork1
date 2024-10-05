import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String gamesPath = "/Users/vovamyzikov/Games"; // У меня мак, так что если что измените путь к файлам

        File gamesDir = new File(gamesPath);
        if (!gamesDir.exists()) {
            gamesDir.mkdir();
            logToTempFile("Папка Games создана.");
        }

        String[] directories = {"src", "res", "savegames", "temp"};
        for (String dir : directories) {
            File directory = new File(gamesDir, dir);
            if (directory.mkdir()) {
                logToTempFile("Папка " + dir + " создана.");
            } else {
                logToTempFile("Не удалось создать папку " + dir + ".");
            }
        }

        String[] srcSubDirs = {"main", "test"};
        File srcDir = new File(gamesDir, "src");
        for (String subDir : srcSubDirs) {
            File directory = new File(srcDir, subDir);
            if (directory.mkdir()) {
                logToTempFile("Папка " + subDir + " в src создана.");
            } else {
                logToTempFile("Не удалось создать папку " + subDir + " в src.");
            }
        }

        String[] mainFiles = {"Main.java", "Utils.java"};
        File mainDir = new File(srcDir, "main");
        for (String fileName : mainFiles) {
            File file = new File(mainDir, fileName);
            try {
                if (file.createNewFile()) {
                    logToTempFile("Файл " + fileName + " создан.");
                } else {
                    logToTempFile("Не удалось создать файл " + fileName + ".");
                }
            } catch (IOException e) {
                logToTempFile("Ошибка при создании файла " + fileName + ": " + e.getMessage());
            }
        }

        String[] resSubDirs = {"drawables", "vectors", "icons"};
        File resDir = new File(gamesDir, "res");
        for (String subDir : resSubDirs) {
            File directory = new File(resDir, subDir);
            if (directory.mkdir()) {
                logToTempFile("Папка " + subDir + " в res создана.");
            } else {
                logToTempFile("Не удалось создать папку " + subDir + " в res.");
            }
        }

        File tempFile = new File(gamesDir, "temp/temp.txt");
        try {
            if (tempFile.createNewFile()) {
                logToTempFile("Файл temp.txt создан.");
            } else {
                logToTempFile("Не удалось создать файл temp.txt.");
            }
        } catch (IOException e) {
            logToTempFile("Ошибка при создании файла temp.txt: " + e.getMessage());
        }
    }

    private static void logToTempFile(String message) {
        try (FileWriter writer = new FileWriter("/Users/vovamyzikov/Games/temp/temp.txt", true)) { // Измените путь при необходимости
            writer.write(message + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в temp.txt: " + e.getMessage());
        }
    }
}