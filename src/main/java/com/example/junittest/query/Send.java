package com.example.junittest.query;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chun.liu on 18-11-6.
 * 各种record执行类
 */
public class Send {

    private Rect mAccessRecordRunnable;
    private Rect.DoExce mAccessRecordThread;

    private BlockingQueue<ImagePojo> mAccessRecordQueue = new LinkedBlockingQueue<ImagePojo>(100000);

    public Send(HandlerServer accessRecordEventHandler) {
        mAccessRecordRunnable = new Rect(accessRecordEventHandler);
        mAccessRecordThread = mAccessRecordRunnable.new DoExce(mAccessRecordQueue);
        mAccessRecordThread.start();
    }

    /**
     * 过人日志处理接口
     */
    public void put(ImagePojo data) throws Exception {
        mAccessRecordQueue.put(data);
    }
}
