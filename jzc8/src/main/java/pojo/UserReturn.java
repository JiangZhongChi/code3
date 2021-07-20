package pojo;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-13-9:26
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 @ClassName UserReturn
 @Description
 @author rabbit
 @create 2021-07-13-9:26
 @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReturn {
    private Integer id;
    private String name;
    private String account;
    private Integer sex;
    private Timestamp createTime;
    private Timestamp updateTime;

}
