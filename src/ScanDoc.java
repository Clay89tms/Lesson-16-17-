import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanDoc {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        System.out.print("ведите путь к файлу :\n> ");
        String path = "C:\\Users\\Clay\\TMS School\\Lesson 16-17\\src\\Package\\txt1.txt";
        System.out.println(path);
        List<String> list1 = Files.readAllLines(Path.of(path));

        list.addAll(list1);
        String text = list.toString();
        System.out.println(text);
        String regexText = "\\+\\d{3}\\W\\d{2}\\W\\d{7}";
        Pattern pattern = Pattern.compile(regexText);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        } else {
            System.out.println("нет телефона");
        }
    }
}
