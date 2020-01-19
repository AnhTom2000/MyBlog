package cc.ccocc.pojo;

import lombok.Data;

/**
 * Created on 22:17  18/01/2020
 * Description:
 *  分类表
 * @author Weleness
 *
 */
@Data
public class Category {

   private  static Category category = null;

    public static Category getInstance(){
        if(category==null){
            //加上同步锁，保证线程安全
            synchronized(Category.class){
               category = new Category();
            }
        }
        return category;
    }

    private Category(){}
    private  Integer categoryid; // 分类id
    private  String categoryname; // 分类名称
}
