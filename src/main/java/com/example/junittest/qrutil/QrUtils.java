package com.example.junittest.qrutil;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *  @dept 上海软件研发中心
 *  @description 二维码生成工具类
 *  @author HaoXin.Liu
 *  @date 2019/11/13 15:56
 **/
@Slf4j
public class QrUtils {

    public static void main(String[] args) {
        //生成链接
        String url = "http://ids.des-platform.com/download/des-platform-app.ipa";
        log.info("生成链接------->" + url);
        //配置生成路径
        String path = FileSystemView.getFileSystemView().getHomeDirectory() + File.separator + "testQrcode";
        log.info("生成路径------->" + path);
        //生成文件名称
        String fileName = "temp.jpg";
        log.info("文件名称------->" + fileName);
        String createPath = createQrCode(url, path, fileName);
        log.info("绝对地址是------->" + fileName);
    }

    /**
     * 创建二维码
     *
     * @dept 上海软件研发中心
     * @param url 图片链接
     * @param path 生成路径
     * @param fileName 文件名称
     * @return String 二维码生成路径
     * @author HaoXin.Liu
     * @date 2019/11/13 13:24
     **/
    public static String createQrCode(String url, String path, String fileName) {
        try {
            Map<EncodeHintType, String> hints = new HashMap<>();
            //设置二维码的编码类型
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            //设置生成二维码的大小
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 400, 400, hints);
            //生成文件名称
            File file = new File(path, fileName);
            //判断文件是否存在
            if (file.exists() || ((file.getParentFile().exists() || file.getParentFile().mkdirs()) && file.createNewFile())) {
                //生成二维码文件
                writeToFile(bitMatrix, "jpg", file);
                //反馈生成文件路径
                return file.getAbsolutePath();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 二维码生成规格
     *
     * @dept 上海软件研发中心
     * @param matrix 二维码生成大小，编码
     * @param format 生成二维码文件类型
     * @param file  二维码文件名称
     * @author HaoXin.Liu
     * @date 2019/11/13 13:29
     **/
    private static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        //把二维码转换成图片流属性
        BufferedImage image = toBufferedImage(matrix);
        //判断文件是否可以转换成文件流
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    private static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    /**
     * 将二维码属性转换成文件流
     *
     * @dept 上海软件研发中心
     * @param matrix 二维码类型变量
     * @author HaoXin.Liu
     * @date 2019/11/13 13:32
     **/
    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        //获得二维码的宽高
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        //创建图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //将二维码的像素点传递给图片，进行一一赋值
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        //返回图片流
        return image;
    }
}