/*
 * Copyright (C) 2018 The TwoDragonLake Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twodragonlake.message;

import java.io.Serializable;

/**
 * 消息实体，消息有KEY 和content两部分组成， 注意：content必须实现序列化接口.
 *
 * @author : dingxiangyong
 * @version : 1.0
 * @since : 2016/7/28 13:40
 */
public class Message implements Serializable {

    private static final long serialVersionUID = -8657613687306891080L;

    /**
     * 消息唯一标识
     */
    private String key;

    /**
     * 消息具体内容
     */
    private Object content;

    /**
     * 执行失败次数
     */
    private Integer failTimes;

    public Message(String key, Object content) {
        super();
        this.key = key;
        this.content = content;
        this.failTimes = 0;
    }

    public Message() {
        super();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Integer getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(Integer failTimes) {
        this.failTimes = failTimes;
    }

    @Override
    public String toString() {
        return "Message [key=" +
                key +
                ", content=" +
                content +
                ", failTimes=" +
                failTimes +
                "]";
    }

}
