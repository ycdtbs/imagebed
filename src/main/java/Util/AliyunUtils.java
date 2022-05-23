package Util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;

public class AliyunUtils {
    public  String upload(byte[] bytes,String fileName){

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ossconfig.endpoint, ossconfig.accessKeyId, ossconfig.keysecret);
        String fileLocation = ossconfig.objectName  +"/"+ fileName + ".jpg";
        System.out.println(fileLocation);
        try {
            PutObjectResult putObjectResult = ossClient.putObject(ossconfig.bucketName, fileLocation, new ByteArrayInputStream(bytes));
            System.out.println(putObjectResult);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
            return null;
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
            return null;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return fileLocation;
    }
}
