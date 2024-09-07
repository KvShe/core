package gb.core.homework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class Main {
    /**
     * Написать функцию, создающую резервную копию всех файлов в директории (без поддиректорий)
     * во вновь созданную папку ./ backup
     *
     * @param src директория в которой создаётся backup
     * @throws IOException
     */
    public static void backup(Path src) throws IOException {
        String pathCurrentFolder = "src\\gb\\core\\homework";
        File[] files = src.toFile().listFiles();
        if (files == null) return;

        File folder = new File(pathCurrentFolder + "\\backup");
        folder.mkdir();

        for (File file : files) {
            Files.copy(
                    file.toPath(),
                    new File(folder.toPath() + "\\" + file.getName()).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        }
    }

    /**
     * Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
     * и представляют собой, например, состояния ячеек поля для игры в крестики-нолики,
     * где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
     * Такое предположение позволит хранить в одном числе типа int всё поле 3 х 3.
     * Записать в файл 9 значений так, чтобы они заняли три байта
     *
     * @param numbers массив с данными для игры в крестики-нолики
     */
    public static void writeInFile(int[][] numbers) throws IOException {
        String path = "src\\gb\\core\\homework";
        Files.writeString(Path.of(path + "\\dest.txt"), Arrays.deepToString(numbers));
    }

    /**
     * Доработайте класс Tree и метод print который мы разработали на семинаре.
     * Ваш метод должен распечатать полноценное дерево директорий и файлов относительно корневой директории.
     * <p>
     * Выводит в консоль графическое отображение всех папок, подпапок и файлов, которые содержатся в указанной директории
     *
     * @param file   имя файла с которого начинает рисоваться дерево директорий
     * @param indent отступ
     * @param isLast даёт понять, является ли file последней папкой в директории
     */
    public static void printDirectoryTree(File file) {
        printDirectoryTree(file, "", true);
    }

    private static void printDirectoryTree(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null) return;

        int count = 0;
        for (File value : files) {
            printDirectoryTree(value, indent, count++ == files.length - 1);
        }
    }
}
