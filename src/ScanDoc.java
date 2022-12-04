import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanDoc {
    //    static List<String> list = new ArrayList<>();
    static Map<String, Document> map = new HashMap<>();

    //считать файл.     найти в файле.      создать док и записать туда совпадения.     сохранить в мапку кей(имя) вэлью(док).
    public static void main(String[] args) throws IOException {


        try (Scanner scannerLine = new Scanner(System.in)) {
            System.out.println("C:\\Users\\Clay\\TMS School\\Lesson 16-17\\src\\Package");
            System.out.print("Enter path: > ");
//            if (scannerLine.hasNextLine()) {
//                String scannerPathLine = scannerLine.nextLine();
            String scannerPathLine = "C:\\Users\\Clay\\TMS School\\Lesson 16-17\\src\\Package";
            File pathFolder = new File(scannerPathLine);
            File[] files = pathFolder.listFiles();
            findFile(scannerPathLine, files);


//            }
        } catch (NullPointerException e) {
        }
//        System.out.print("ведите путь к файлу :\n> ");
//        String path = "C:\\Users\\Clay\\TMS School\\Lesson 16-17\\src\\Package\\txt1.txt";
//        System.out.println(path);
//        List<String> list1 = Files.readAllLines(Path.of(path));
//
//        list.addAll(list1);
//        String text = list.toString();
//        String textOut = "";
//        System.out.println(text);
//        String phone = "(\\+\\d{3}\\W\\d{2}\\W\\d{7})";
        String docName = "((\\d{4}\\-[a-zA-Zа-яА-Я]{3}\\-){2}((\\d[a-zA-Zа-яА-Я]){2}))";
//        String email = "([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6})"; //bboyClay89@gmail.com
//        String regexText = phone + "|" + docName + "|" + email;
//        Pattern pattern = Pattern.compile(regexText);
//        Matcher matcher = pattern.matcher(text);
//
//
//        while (matcher.find()) {
//            textOut += text.substring(matcher.start(), matcher.end()) + "\n";

//            System.out.println(text.substring(matcher.start(), matcher.end()));

    }
//        System.out.println(textOut);
//
//    }

    private static void findFile(String scannerPathLine, File[] files) throws IOException {
        if (files.length == 0) {
            System.out.println("You are don't have a files");
        } else {
            System.out.println("in Folder: ");
            for (int i = 0; i < files.length; i++) {
                System.out.println((i + 1) + ") " + files[i].getName());
            }
            Scanner scannerInt = new Scanner(System.in);

            System.out.print("H.M. file scanning?: ");
            if (scannerInt.hasNextInt()) {
                int scannerHM = scannerInt.nextInt();
//                String regexNameFile = "([A-Za-z0-9._%+-]+\\.txt)";
                String regexDocNum = "((\\d{4}\\-[a-zA-Zа-яА-Я]{3}\\-){2}((\\d[a-zA-Zа-яА-Я]){2}))";
                String regexPhone = "(\\+\\W\\d{2}\\W\\d{7})";
                String regexEmail = "([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6})";
//                Pattern patternNameFile = Pattern.compile(regexNameFile);
                Pattern patternDocNum = Pattern.compile(regexDocNum);
                Pattern patternPhone = Pattern.compile(regexPhone);
                Pattern patternEmail = Pattern.compile(regexEmail);

                for (int i = 0; i < Math.min(files.length, scannerHM); i++) {
//                    Matcher matcherNameFile = patternNameFile.matcher(scannerPathLine + files[i]);
                    Matcher matcherDocNum = patternDocNum.matcher(scannerPathLine + files[i]);
                    Matcher matcherPhone = patternPhone.matcher(scannerPathLine + files[i]);
                    Matcher matcherEmail = patternEmail.matcher(scannerPathLine + files[i]);
                    Document document = new Document();
                    String path = (scannerPathLine + "\\" + files[i].getName());
                    System.out.println(path);
                    if (Pattern.matches(regexDocNum, path))
                        System.out.println();

                }
//                    System.out.println(files[i].getName());


            }

//            for (int i = 1; i < (files.length) && (scannerInt.hasNextInt()); i++) {
//                list = Files.readAllLines(Path.of(scannerPathLine + files[i - 1].getName()));
//            }
//
//            for (int i = 1; i < (files.length) && (scannerInt.hasNextInt()); i++) {
//                System.out.println(list);
//            }


//            System.out.println("READ ALL FILES");
//            for (int i = 0; i < files.length; i++) {
//                if (Pattern.matches(regexNameFile, files[i].getName())) {
//
//                }
//            }
//            for (int i = 0; i < files1.length; i++) {
//                System.out.println(i + ") " + files1[i].getName());
        }
    }
}

