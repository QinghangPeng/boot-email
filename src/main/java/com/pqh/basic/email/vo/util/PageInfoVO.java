package com.pqh.basic.email.vo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: PageInfo
 * @Description:
 * @Author: jackson
 * @Date: 2019/11/13 14:16
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@ApiModel("分页模型")
public class PageInfoVO {

    @ApiModelProperty("第几页")
    private Integer pageIndex = 1;

    @ApiModelProperty("每页大小")
    private Integer pageSize = 10;

    private Integer pageCount;

    private Long totalCount;

}
