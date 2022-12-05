import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanDoc {
    static Document document;
    static Map<String, Document> map = new HashMap<>();

    public static void main(String[] args) throws IOException {


        try (Scanner scannerLine = new Scanner(System.in)) {
            System.out.print("Enter path: > ");
            String scannerPathLine = scannerLine.nextLine();
//                    "C:\\Users\\Clay\\TMS School\\Lesson 16-17\\src\\Package";
            File pathFolder = new File(scannerPathLine);
            File[] files = pathFolder.listFiles();
            readFails(scannerPathLine, files);

        }
    }

    private static void readFails(String scannerPathLine, File[] files) throws IOException {
        if (files.length == 0) {
            System.out.println("You are don't have a files");
        } else {
            System.out.println("in Folder: ");
            List<String> pathFile = new ArrayList<>();
            String regexNameFile = "([A-Za-z0-9._%+-]+\\.txt)";

            for (int i = 0; i < files.length; i++) {
                System.out.println((i + 1) + ") " + files[i].getName());
                if (Pattern.matches(regexNameFile, files[i].getName())) {
                    pathFile.add(scannerPathLine + "\\" + files[i].getName());
                }
            }

            Scanner scannerInt = new Scanner(System.in);
            System.out.print("H.M. file scanning?: ");
            int scannerHMorALL = 0;
            if (scannerInt.hasNextInt()) {
                scannerHMorALL = Math.min(pathFile.size(), scannerInt.nextInt());
                for (int i = 0; i < scannerHMorALL; i++) {
                    Path path = Path.of(pathFile.get(i));
//                    System.out.println(path);
                    String text1 = String.valueOf(Files.readAllLines(path));
//                    System.out.println(text1);
                    document = new Document();

                    String regexDocNum = "((\\d{4}\\-[a-zA-Zа-яА-Я]{3}\\-){2}((\\d[a-zA-Zа-яА-Я]){2}))";
                    Pattern patternDocNum = Pattern.compile(regexDocNum);
                    Matcher matcherDocNum = patternDocNum.matcher(text1);
                    while (matcherDocNum.find()) {
                        document.listDocNumAdd(text1.substring(matcherDocNum.start(), matcherDocNum.end()));
                    }

                    String regexPhone = "(\\+\\(\\d{2}\\)\\d{7})";
                    Pattern patternPhone = Pattern.compile(regexPhone);
                    Matcher matcherPhone = patternPhone.matcher(text1);
                    while (matcherPhone.find()) {
                        document.listPhoneAdd(text1.substring(matcherPhone.start(), matcherPhone.end()));
                    }

                    String regexEmail = "([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6})";
                    Pattern patternEmail = Pattern.compile(regexEmail);
                    Matcher matcherEmail = patternEmail.matcher(text1);
                    while (matcherEmail.find()) {
                        document.listEmailAdd(text1.substring(matcherEmail.start(), matcherEmail.end()));
                    }
                    map.put(String.valueOf(path.getFileName()), document);

                }
            }
            int me = 0;
            for (Map.Entry entry : map.entrySet()) {
                System.out.println("\nMap " + me++);
                System.out.println(entry.getKey() + "\n" + entry.getValue());
            }
        }
    }
}