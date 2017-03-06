package com.kingofneurons.esport.dota2.api.Filter;

public class QueueFilter {

    private long waitMillis;
    private int maxThreadPoolInMin;
    private int maxThreadAll;

    public QueueFilter() {
        this.waitMillis = 100;
        this.maxThreadPoolInMin = Integer.MAX_VALUE;
        this.maxThreadAll = Integer.MAX_VALUE;
    }

    public QueueFilter(long waitMillis, int maxThreadPoolInMin, int maxThreadAll) {
        if(waitMillis == 0 || maxThreadPoolInMin == 0 || maxThreadAll == 0)
            throw new NullPointerException("Fields QueueFilter must be not null");

        this.waitMillis = waitMillis;
        this.maxThreadPoolInMin = maxThreadPoolInMin;
        this.maxThreadAll = maxThreadAll;
    }

    public long getWaitMillis() {
        return waitMillis;
    }

    public void setWaitMillis(long waitMillis) {
        this.waitMillis = waitMillis;
    }

    public int getMaxThreadPoolInMin() {
        return maxThreadPoolInMin;
    }

    public void setMaxThreadPoolInMin(int maxThreadPoolInMin) {
        this.maxThreadPoolInMin = maxThreadPoolInMin;
    }

    public int getMaxThreadAll() {
        return maxThreadAll;
    }

    public void setMaxThreadAll(int maxThreadAll) {
        this.maxThreadAll = maxThreadAll;
    }

    @Override
    public String toString() {
        return "QueueFilter{" +
                "waitMillis=" + waitMillis +
                ", maxThreadPoolInMin=" + maxThreadPoolInMin +
                ", maxThreadAll=" + maxThreadAll +
                '}';
    }
}
