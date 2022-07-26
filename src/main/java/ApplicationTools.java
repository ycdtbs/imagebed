import Util.config;
import org.yaml.snakeyaml.scanner.Constant;
import view.windows;

import java.io.*;

public class ApplicationTools {
    public static void main(String[] args) {
        // 加载配置文件
        String property = System.getProperty("user.dir");
        String dllPath = property + "\\dll" + "\\PrintScr.exe";
        config config = new config();
        config.setDllPath(dllPath);
        config.setConfigPath(property + "\\config.yml");
        System.out.println(config.toString());
        // 主启动类
        new windows().openWindows();
        System.out.println("修复");
        System.out.println("text");

    }
}
