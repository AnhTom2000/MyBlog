package cc.ccocc.utils.upload;

/**
 * Created on 11:54  20/01/2020
 * Description:
 *
 * @author Weleness
 */

public class UploadUtils {

    //cos上传路径的前缀
   public static final String COS_URL = "https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/Blog/img/";

    // 返回拼接路径
    public static String comcatURL(String filename,String type){
        if(filename == null){
            throw new NullPointerException("图片的id为空");
        }
        return COS_URL.concat(type+"/").concat(filename);
    }


}
