package pojo;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-12-10:07
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @ClassName Department
 @Description
 @author rabbit
 @create 2021-07-12-10:07
 @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String name;
    private Integer companyId;
    private Integer pId;
    private Integer status;
}
