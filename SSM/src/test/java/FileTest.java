import java.io.File;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 23:52
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class FileTest {
    public static void main(String[] args) {
        File folder = new File("D:\\java\\huanjing\\tomcat7\\apache-tomcat-7.0.85\\webapps\\upload"); // 将"路径"替换为要查看的目录路径

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            System.out.println(files.length);
            for (File file : files) {
                if (file.isHidden()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("指定的路径不存在或者不是一个有效的目录！");
        }
    }
}
