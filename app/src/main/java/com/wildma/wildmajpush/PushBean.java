package com.wildma.wildmajpush;

import java.io.Serializable;

/**
 * 极光推送实体类
 */
public class PushBean implements Serializable {

    /*后端自定义字段*/
    private String type;//消息类型
    private String title;//消息标题
    private String content;//消息内容
    //其他...


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
