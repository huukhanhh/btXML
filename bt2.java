import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
}
//StudentListToXML
public class bt2  {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Khanh", 19, 4.0));
        students.add(new Student("Khanhhihi", 22, 4.0));
        students.add(new Student("Khanhhaha", 21, 3.6));

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("students");
            doc.appendChild(rootElement);

            for (Student student : students) {
                Element studentElement = doc.createElement("student");
                rootElement.appendChild(studentElement);

                Element nameElement = doc.createElement("name");
                nameElement.appendChild(doc.createTextNode(student.getName()));
                studentElement.appendChild(nameElement);

                Element ageElement = doc.createElement("age");
                ageElement.appendChild(doc.createTextNode(String.valueOf(student.getAge())));
                studentElement.appendChild(ageElement);

                Element gpaElement = doc.createElement("gpa");
                gpaElement.appendChild(doc.createTextNode(String.valueOf(student.getGpa())));
                studentElement.appendChild(gpaElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("students.xml"));
            transformer.transform(source, result);

            System.out.println("Danh sach sinh vien da duoc ghi vao file students.xml thanh cong.");
        } catch (Exception e) {
            System.out.println("Da xay ra loi ghi danh sach sinh vien vao file XML: " + e.getMessage());
        }
    }
}
