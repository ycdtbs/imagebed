package Util;

public class ossconfig {
    public static String endpoint = "";
    // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
    public static String accessKeyId = "";
    public static String keysecret = "";
    public static String bucketName = "";
    public static String objectName = "";

    public static String getEndpoint() {
        return endpoint;
    }

    public static void setEndpoint(String endpoint) {
        ossconfig.endpoint = endpoint;
    }

    public static String getAccessKeyId() {
        return accessKeyId;
    }

    public static void setAccessKeyId(String accessKeyId) {
        ossconfig.accessKeyId = accessKeyId;
    }

    public static String getKeysecret() {
        return keysecret;
    }

    public static void setKeysecret(String keysecret) {
        ossconfig.keysecret = keysecret;
    }

    public static String getBucketName() {
        return bucketName;
    }

    public static void setBucketName(String bucketName) {
        ossconfig.bucketName = bucketName;
    }

    public static String getObjectName() {
        return objectName;
    }

    public static void setObjectName(String objectName) {
        ossconfig.objectName = objectName;
    }
}
