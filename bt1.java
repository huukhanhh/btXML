import java.io.File;

public class bt1 {
    public static void main(String[] args) {
        // Nhập đường dẫn thư mục
        String directoryPath = "C:\\Users\\ADMIN\\Desktop\\java\\btiostream\\src\\bt1";

        // Tạo đối tượng File từ đường dẫn thư mục
        File directory = new File(directoryPath);

        // Kiểm tra xem đường dẫn trỏ đến thư mục tồn tại không
        if (!directory.exists()) {
            System.out.println("Thư mục không tồn tại.");
            return;
        }

        // Liệt kê các tệp và thư mục trong thư mục
        listDirectoryContents(directory);
    }

    private static void listDirectoryContents(File directory) {
        // Kiểm tra xem đối tượng File là thư mục hay không
        if (directory.isDirectory()) {
            // In ra tên thư mục dưới dạng thẻ XML
            System.out.println("<" + directory.getName() + ">");

            // Liệt kê các tệp và thư mục bên trong
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Nếu là thư mục, gọi đệ quy để tiếp tục liệt kê
                        listDirectoryContents(file);
                    } else {
                        // Nếu là tệp, in ra tên tệp dưới dạng thẻ XML
                        System.out.println("<file>" + file.getName() + "</file>");
                    }
                }
            }

            // Đóng thẻ XML của thư mục
            System.out.println("</" + directory.getName() + ">");
        }
    }
}
