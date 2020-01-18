package cc.ccocc.utils.idgenerater;

/**
 * Created on 20:32  18/01/2020
 * Description:
 *  雪花id生成器接口
 * @author Weleness
 */
public interface IdGenerator {
    /**
     * 生成ID
     * @return  long 类型的id
     */
    public abstract long generateId();
}
