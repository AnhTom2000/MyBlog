package cc.ccocc.pojo;

import lombok.Data;

/**
 * Created on 23:05  15/01/2020
 * Description:
 *
 * @author Weleness
 */
@Data
public class Tag {
    public Tag() {
    }

    public Tag(Long tag_id, String tag_name) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

    private  Long tag_id;
    private  String tag_name;
}
