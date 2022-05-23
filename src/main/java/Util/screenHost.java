package Util;

import view.windows;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class screenHost {
    public  byte[] doScreen(){
        Runtime runtime = Runtime.getRuntime();
        Process p = null;
        String dllPath = config.dllPath;
        if (dllPath == null){
            LogUtils.print("截图引擎调用失败，是否破坏了安装文件");
        }
        try {
            p = runtime.exec(dllPath);
            boolean alive = p.isAlive();
            if (alive){
                LogUtils.print("引擎调用成功");
                Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
                if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor)){
                    LogUtils.print("截图获取成功");
                    Image transferData = null;
                    try {
                        transferData = (Image) transferable.getTransferData(DataFlavor.imageFlavor);
                        int width = (int)(transferData.getWidth(null));
                        int height = (int)(transferData.getHeight(null));
                        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                        Graphics2D graphics = bufferedImage.createGraphics();
                        //重构图片
                        graphics.drawImage(transferData, 0, 0, width, height, null);
                        ByteArrayOutputStream bs =new ByteArrayOutputStream();
                        ImageOutputStream imOut;
                        imOut = ImageIO.createImageOutputStream(bs);
                        ImageIO.write(bufferedImage,"jpg",imOut);
                        byte[] bytes = bs.toByteArray();
                        LogUtils.print("图片大小为" + (bytes.length  / 8 )+ "byte");
                        return bytes;
                    } catch (UnsupportedFlavorException e) {
                        LogUtils.print("图片处理过程错误请重新截图");
                        e.printStackTrace();
                    }

                }else {
                    for (int i = 0; i < 10; i++) {
                        LogUtils.print("未能成功读取数据 请重新打开软件");
                    }
                }
            }else {
                LogUtils.print("引擎调用失败");
            }

        } catch (IOException e) {
            for (int i = 0; i < 10; i++) {
                LogUtils.print("引擎调用失败 重启系统");
            }

            e.printStackTrace();
        }
        return null;
    }
}
