import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanIpAdress {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите Ip адресс для проверки в формате (ххх.ххх.ххх.ххх): \n> ");
            if (scanner.hasNextLine()) {
                String ip = scanner.nextLine();

                String regexIp = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])$";
                Pattern pattern = Pattern.compile(regexIp);
                Matcher matcher = pattern.matcher(ip);

                if (matcher.find()) {
                    System.out.println(ip.substring(matcher.start(), matcher.end()));
                } else {
                    System.out.println("не верный Ip адресс!");
                }
            }
        }
    }
}
