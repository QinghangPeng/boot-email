package com.pqh.basic.email.util;

import com.pqh.basic.email.vo.MailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * @ClassName: MailUtil
 * @Description:
 * @Author: jackson
 * @Date: 2019/12/2 15:34
 * @Version: v1.0
 */
@Component
@Slf4j
public class MailUtil {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    /**
     *  发送简易邮件
     * @param mailVO
     * @param receivers
     */
    public void sendMail(MailVO mailVO,String[] receivers) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            helper.setFrom(sender);
            helper.setTo(receivers);
            helper.setSubject(mailVO.getSubject());
            helper.setText(mailVO.getText());

            mailSender.send(mimeMessage);
        } catch(Exception e) {
            log.error("sendMail error:{}",e);
        }
    }

    /**
     *  发送html格式的邮件
     * @param mailVO
     * @param receivers
     */
    public void sendMailHtml(MailVO mailVO,String[] receivers) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            helper.setFrom(sender);
            helper.setTo(receivers);
            helper.setSubject(mailVO.getSubject());
            helper.setText(mailVO.getText(),true);

            mailSender.send(mimeMessage);
        } catch(Exception e) {
            log.error("sendMailHtml error:{}",e);
        }
    }

    /**
     *  发送带附件的邮件
     * @param mailVO
     * @param receivers
     */
    public void sendMailAttachment(MailVO mailVO,String[] receivers) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

            helper.setFrom(sender);
            helper.setTo(receivers);
            helper.setSubject(mailVO.getSubject());
            helper.setText(mailVO.getText(),true);
            //增加附件名称和附件
            helper.addAttachment(mailVO.getAttachmentFilename(),mailVO.getFile());

            mailSender.send(mimeMessage);
        } catch(Exception e) {
            log.error("sendMailAttachment error:{}",e);
        }
    }

    /**
     *  发送带静态资源的邮件
     *  由于邮件服务商不同，可能有些邮件并不支持内联资源的展示
     *  在测试过程中，新浪邮件不支持，QQ邮件支持
     *  不支持不意味着发送不成功，而且内联资源在邮箱内无法正确加载
     * @param mailVO
     * @param receivers
     */
    public void sendMailInLine(MailVO mailVO,String[] receivers) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

            helper.setFrom(sender);
            helper.setTo(receivers);
            helper.setSubject(mailVO.getSubject());
            helper.setText(mailVO.getText(),true);
            //内联资源邮件需要确保先设置邮件正文，再设置内联资源的相关信息
            helper.addInline(mailVO.getContentId(),mailVO.getFile());

            mailSender.send(mimeMessage);
        } catch(Exception e) {
            log.error("sendMailInLine error:{}",e);
        }
    }

    /**
     *  模板邮件发送
     * @param mailVO
     * @param receivers
     */
    public void sendMailTemplate(MailVO mailVO,String[] receivers) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

            helper.setFrom(sender);
            helper.setTo(receivers);
            helper.setSubject(mailVO.getSubject());
            helper.setText(mailVO.getText(),true);

            mailSender.send(mimeMessage);
        } catch(Exception e) {
            log.error("sendMailInLine error:{}",e);
        }
    }

}
