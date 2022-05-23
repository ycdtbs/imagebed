package Util;

public class config {
   public static String dllPath;
   public static String configPath;

    public String getDllPath() {
        return dllPath;
    }

    public void setDllPath(String dllPath) {
        this.dllPath = dllPath;
    }

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    @Override
    public String toString() {
        return "config{" +
                "dllPath='" + dllPath + '\'' +
                ", configPath='" + configPath + '\'' +
                '}';
    }
}
