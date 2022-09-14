package com.mobai.manager.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 邮件接收方类
 *
 * @author li.nan
 * @date 2022/9/13
 */
@Getter
@Setter
public class MailPO {
    private String[] to;
    private String message;
    private String cc;
    private String subject;
}
