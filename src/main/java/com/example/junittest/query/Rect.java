package com.example.junittest.query;

import java.util.concurrent.BlockingQueue;

public class Rect {

    private HandlerServer handlerServer;

    public Rect(HandlerServer handlerServer) {
        this.handlerServer = handlerServer;
    }

    public class DoExce extends Thread {

        BlockingQueue<ImagePojo> mAccessRecordQueue;
        private volatile boolean running = true;


        public DoExce(BlockingQueue<ImagePojo> accessRecordQueue) {
            this.mAccessRecordQueue = accessRecordQueue;
        }

        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (running) {
                try {
                    ImagePojo data = mAccessRecordQueue.take(); // 从队列中取一条记录
                    System.out.println(data.getId() + " wozuiniubi " + data.getName());
                } catch (Exception e) {
                    System.out.println(" 业务异常导致 消息处理失败！");
                    //running = false;
                }
            }
        }
    }

}
