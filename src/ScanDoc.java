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
        String textOut = "";
        System.out.println(text);
        String phone = "(\\+\\d{3}\\W\\d{2}\\W\\d{7})";
        String docName = "((\\d{4}\\-[a-zA-Zа-яА-Я]{3}\\-){2}((\\d[a-zA-Zа-яА-Я]){2}))";
        String email = "([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6})"; //bboyClay89@gmail.com
        String regexText = phone + "|" + docName + "|" + email;
        Pattern pattern = Pattern.compile(regexText);
        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            textOut += text.substring(matcher.start(), matcher.end()) + "\n";

//            System.out.println(text.substring(matcher.start(), matcher.end()));

        }
        System.out.println(textOut);

    }
}