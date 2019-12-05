package com.example.demo;

import lombok.Data;

import java.util.Date;

/**
 * @author xiaoh
 * @description: 本地队列消息实体
 * @date 2019/11/169:25
 */
@Data
public class BusinessEventMessage {
    /**
     * 观众用户的user_id
     */
    private Integer userId;

    /**
     * 直播间id
     */
    private Integer roomId;

    /**
     * 首次进入直播间时间
     */
    private Date gmtCreate;

    /**
     * 扩展字段json, 记录观众行为和时间
     */
    private String ext;
}
