package pojo;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-12-9:56
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 @ClassName Company
 @Description
 @author rabbit
 @create 2021-07-12-9:56
 @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private Integer id;
    private String companyName;
    private Timestamp createTime;
    private String version;
    private Integer status;
}
