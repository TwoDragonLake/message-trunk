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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * 消息总线，用于向消息总线存入消息.
 *
 * @author : dingxiangyong
 * @version : 1.0
 * @since : 2016/7/28 13:42
 */
@Service
public class MessageTrunk {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    @Qualifier(value = "messageTrunkTaskExecutor")
    private ThreadPoolTaskExecutor threadPool;

    /**
     * 失败重试次数，超过此值则不再重试，默认3次
     */
    private int failRetryTimes = 3;

    /**
     * 如果线程池满了，生产者暂停的时间，单位：S
     */
    private int threadPoolFullSleepSeconds = 1;

    public ThreadPoolTaskExecutor getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ThreadPoolTaskExecutor threadPool) {
        this.threadPool = threadPool;
    }

    public int getFailRetryTimes() {
        return failRetryTimes;
    }

    public void setFailRetryTimes(int failRetryTimes) {
        this.failRetryTimes = failRetryTimes;
    }

    public int getThreadPoolFullSleepSeconds() {
        return threadPoolFullSleepSeconds;
    }

    public void setThreadPoolFullSleepSeconds(int threadPoolFullSleepSeconds) {
        this.threadPoolFullSleepSeconds = threadPoolFullSleepSeconds;
    }

    /**
     * 推送消息
     */
    public void put(Message message) {
        redisUtil.rPush(message.getKey(), message, 0);
    }
}
