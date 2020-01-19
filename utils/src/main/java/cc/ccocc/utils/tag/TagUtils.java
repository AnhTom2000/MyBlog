package cc.ccocc.utils.tag;

import cc.ccocc.pojo.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 15:06  19/01/2020
 * Description:
 *
 * @author Weleness
 */

public class TagUtils {
    public static Tag getTag(String tags, Long snowId) {
       return new Tag(snowId,tags);
    }

    public static List<String> stringToList_BLANK(String[] stayConver_String) {
        return new ArrayList<>(Arrays.asList(stayConver_String));
    }


    public static List<String> stringToList_COMMA(String[] stayConver_String) {
        return new ArrayList<>(Arrays.asList(stayConver_String));
    }
}
