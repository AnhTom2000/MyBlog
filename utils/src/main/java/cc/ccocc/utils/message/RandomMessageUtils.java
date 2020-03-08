package cc.ccocc.utils.message;

import java.util.Random;

/**
 * Created on 15:04  12/02/2020
 * Description:
 *
 * @author Weleness
 */

public class RandomMessageUtils {

    private static final  String[] message = {"恶意评论","随手一封","不小心的"};

    private static Random random = new Random();

    public static String getMessage(){
        return message[random.nextInt(message.length-1)];
    }
}
