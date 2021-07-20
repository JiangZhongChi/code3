package pojo;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-12-10:17
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 @ClassName User
 @Description
 @author rabbit
 @create 2021-07-12-10:17
 @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String account;
    private String name;
    private Integer sex;
    private Integer companyId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer status;
}
