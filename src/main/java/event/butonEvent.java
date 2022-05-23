package event;

import Util.*;
import org.yaml.snakeyaml.Yaml;
import view.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.yaml.*;
public class butonEvent {
    private static byte[] imageInfo = null;
    public ActionListener screenEvent(){
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screenHost screenHost = new screenHost();
                byte[] bytes = screenHost.doScreen();
                imageInfo = bytes;
            }
        };
        return actionListener;
    }
    public ActionListener upFile(){
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imageInfo == null){
                    LogUtils.print("没有需要上传的文件哎");
                    JOptionPane.showMessageDialog(null, "没有文件");
                }else {
                    String configPath = config.configPath;
                    LogUtils.print("读取配置文件" + configPath);
                    File file = new File(configPath);
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        Yaml yaml = new Yaml();
                        Map obj = yaml.load(fileInputStream);
                        Map<String,Object> param = new HashMap<>();
                        //需要注意，此类加载器只能得到它的最顶层的key的值
                        Map<String,Object> params= (Map) obj.get("aliyun");
                        String endpoint = (String)params.get("endpoint");
                        String keyid = (String)params.get("keyid");
                        String keysecret = (String)params.get("keysecret");
                        String bucketname = (String)params.get("bucketname");
                        String objectname = (String)params.get("filehost");
                        if (endpoint == "" || keyid == "" || keysecret == "" || bucketname ==""){
                            LogUtils.print("配置文件内容错误请阅读文档---error");
                        }else {
                            ossconfig.setAccessKeyId(keyid);
                            ossconfig.setEndpoint(endpoint);
                            ossconfig.setKeysecret(keysecret);
                            ossconfig.setBucketName(bucketname);
                            ossconfig.setObjectName(objectname);
                            LogUtils.print("准备上传");
                            AliyunUtils aliyunUtils = new AliyunUtils();
                            String fileName = UUID.randomUUID().toString();
                            String upload = aliyunUtils.upload(imageInfo, fileName);
                            String url = "https://" + bucketname +"." +endpoint + "/" + upload;
                            LogUtils.print("上传成功 url已经放入剪贴板了");
                            LogUtils.print(url);
                            Transferable tText = new StringSelection(url);
                            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                            clip.setContents(tText, null);
                            JOptionPane.showMessageDialog(null, "上传成功 url放入剪贴板了");

                            // https://facesearch-hoom.oss-cn-hangzhou.aliyuncs.com/face/d9df28ac-6484-4e72-8897-2c97154ac0a8.jpg

                        }
                    } catch (FileNotFoundException ex) {
                        LogUtils.print("读取配置文件失败 请检查" + configPath + "文件是否存在");
                        ex.printStackTrace();
                    }


                }
            }
        };
        return actionListener;

    }
}
