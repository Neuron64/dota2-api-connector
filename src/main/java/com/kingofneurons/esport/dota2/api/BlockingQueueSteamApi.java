package com.kingofneurons.esport.dota2.api;

import com.kingofneurons.esport.dota2.api.Filter.QueueFilter;
import com.kingofneurons.esport.dota2.util.DownloadJson;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BlockingQueueSteamApi {

    private static Logger log = Logger.getLogger(BlockingQueueSteamApi.class.getName());

    private QueueFilter queueFilter;
    private int countQueue = 0;
    private int countThread = 0;

    public BlockingQueueSteamApi(QueueFilter queueFilter) {
        this.queueFilter = queueFilter;
        tick();
    }

    public String getJson(String url) throws Exception {
        if(countThread > queueFilter.getMaxThreadAll())
            throw new IllegalStateException("Queue full");
        countThread++;
        synchronized (this) {
            while (!isFreePlace()) {
                Thread.sleep(100);
            }
            countQueue++;
        }
        countThread--;
        return DownloadJson.readUrl(url);
    }

    //Zeroing every  predetermined minute
    private void tick(){
        ScheduledExecutorService scheduler = Executors
                .newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                countQueue = 0;
            }
        }, 0, queueFilter.getWaitMillis(), TimeUnit.MILLISECONDS);
    }

    private boolean isFreePlace(){
        if(countQueue >= queueFilter.getMaxThreadPoolInMin()) return false;
        else return true;
    }
}
