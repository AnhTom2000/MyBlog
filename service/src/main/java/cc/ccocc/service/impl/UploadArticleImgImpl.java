package cc.ccocc.service.impl;

import cc.ccocc.dto.UploadImgDTO;
import cc.ccocc.service.IUploadArticleImg;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import cc.ccocc.utils.upload.UploadUtils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;


/**
 * Created on 12:02  20/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("uploadArticleImgService")
public class UploadArticleImgImpl implements IUploadArticleImg {

    private static final SnowflakeIdGenerator SNOWFLAKE_ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    @Value("${uploadPath}")
    private String filePath;
    @Override
    public UploadImgDTO uploadArticleImage(MultipartFile file, HttpServletRequest request) {
        //生成一个全局唯一的雪花id
        Long snowId = SNOWFLAKE_ID_GENERATOR.generateId();
        String filename = file.getOriginalFilename();
        // 获取文件后缀名
        String suffix = filename.substring(filename.lastIndexOf("."));
        // 生成新文件的名字
        String fileName = snowId+"_"+ suffix;

         //1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKID8A3mKgxrlU1Rf2FJMMAnHajg9TalRiRy";
        String secretKey = "TK2Ys0zmT3HNHzZyBD5jEWcWHpFTs8D6";
        COSCredentials cred = new BasicCOSCredentials(secretId,secretKey);
        //设置时区
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        //生成客户端
        COSClient cosClient = new COSClient(cred,clientConfig);

        String bucket   = "weleness-1300955279";//存储桶名称，格式：BucketName-APPID

        File targetFile = new File(filePath,fileName);
        if(!targetFile.exists()){
            targetFile.getParentFile().mkdirs();
        }
        //保存文件
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //上传对象
        String key = "cdn/Blog/img/article/"+fileName;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, targetFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

            return UploadImgDTO.builder().success(1).message("上传成功").url(UploadUtils.comcatURL(fileName)).build();

    }
}
