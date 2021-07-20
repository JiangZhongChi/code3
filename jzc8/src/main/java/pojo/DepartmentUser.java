package pojo;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-12-10:09
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @ClassName DepartmentUser
 @Description
 @author rabbit
 @create 2021-07-12-10:09
 @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUser {
    private Integer id;
    private Integer companyId;
    private Integer departmentId;
    private Integer userId;
    private Integer status;
}
