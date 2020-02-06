package cc.ccocc.utils.upload;

import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

/**
 * Created on 21:30  05/02/2020
 * Description:
 * cos对象上传的工具类
 * @author Weleness
 */

public class CosUtils {
    
    private static final String SECRETID  = "AKID8A3mKgxrlU1Rf2FJMMAnHajg9TalRiRy";
    private static final String SECRETKEY = "TK2Ys0zmT3HNHzZyBD5jEWcWHpFTs8D6";

   private static final SnowflakeIdGenerator SNOWFLAKE_ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    public static String uploadCos(MultipartFile file, String filePath, String type) {
        //生成一个全局唯一的雪花id
        Long snowId = SNOWFLAKE_ID_GENERATOR.generateId();

        String filename = file.getOriginalFilename();
        // 获取文件后缀名
        String suffix = filename.substring(filename.lastIndexOf("."));
        // 生成新文件的名字
        String fileName = snowId + "_" + suffix;

        COSCredentials cred = new BasicCOSCredentials(SECRETID, SECRETKEY);
        //设置时区
        Region region = new Region("ap-guangzhou");
        //设置客户端时区
        ClientConfig clientConfig = new ClientConfig(region);
        //生成客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        //存储桶名称，格式：BucketName-APPID
        String bucket = "weleness-1300955279";

        File targetFile = new File(filePath, fileName);
        //如果目标文件夹不存在，则创建
        if (!targetFile.exists()) {
            targetFile.getParentFile().mkdirs();
        }
        //保存文件
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //上传对象
        String key = "cdn/Blog/img/" + type + "/" + fileName;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, targetFile);
        //上传对象结果集获取
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        return fileName;
    }

}
