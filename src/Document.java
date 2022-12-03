import java.util.ArrayList;
import java.util.List;

public class Document {


    private List<String> listDocNum = new ArrayList<>();
    private List<String> listPhone = new ArrayList<>();
    private List<String> listEmail = new ArrayList<>();

    public void listDocNumAdd(String line) {
        listDocNum.add(line);
    }

    public void listPhoneAdd(String line) {
        listPhone.add(line);
    }

    public void listEmailAdd(String line){
        listEmail.add(line);
    }

    public List<String> getListDocNum() {
        return listDocNum;
    }

    public List<String> getListPhone() {
        return listPhone;
    }

    public List<String> getListEmail() {
        return listEmail;
    }

    @Override
    public String toString() {
        return "DocNum: " + listDocNum +
                "\nPhone: " + listPhone +
                "\nEmail: " + listEmail;
    }
}
