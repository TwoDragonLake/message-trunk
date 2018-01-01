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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息监听器.
 *
 * @author : dingxiangyong
 * @version : 1.0
 * @since : 2016/3/12 21:28
 */
@Service
public class MessageMonitor {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取待处理消息个数
     */
    public int getMessageLeft(String messageType) {
        return redisUtil.rLength(messageType).intValue();
    }
}
