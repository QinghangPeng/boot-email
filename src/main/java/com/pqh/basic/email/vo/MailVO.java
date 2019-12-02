package com.pqh.basic.email.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.FileSystemResource;

/**
 * @ClassName: MailVO
 * @Description:
 * @Author: jackson
 * @Date: 2019/12/2 15:30
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@ApiModel("邮件实体类")
public class MailVO {

    @ApiModelProperty("邮件主题")
    private String subject;

    @ApiModelProperty("邮件内容")
    private String text;

    @ApiModelProperty("附件")
    private FileSystemResource file;

    @ApiModelProperty("附件名称")
    private String attachmentFilename;

    @ApiModelProperty("内容ID，用于发送静态资源邮件时使用")
    private String contentId;

}
