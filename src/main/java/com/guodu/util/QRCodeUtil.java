package com.guodu.util;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.guodu.pojo.equip.EquipInfo;

/**
 * 二维码工具类
 *
 */
public class QRCodeUtil {

    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸
    private static int QRCODE_SIZE = 300;
    // LOGO宽度
    private static final int WIDTH = 60;
    // 二维码宽度
    private final static int QRCODE_WIDTH = 300;
    // 二维码高度
    private final static int QRCODE_HEIGHT = 300;
    // LOGO高度

    private static final int HEIGHT = 60;

    private static BufferedImage createImage(String content, String imgPath,
                                             boolean needCompress) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        //int width = bitMatrix.getWidth();
       // int height = bitMatrix.getHeight();
       /* int width = 150;
        int height = 150;*/

        int[] rec = bitMatrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;
        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (bitMatrix.get(i + rec[0], j + rec[1])) {
                    resMatrix.set(i, j);
                }
            }
        }

        int width = resMatrix.getWidth();
        int height = resMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, resMatrix.get(x, y) == true ?
                        Color.BLACK.getRGB():Color.WHITE.getRGB());
            }
        }

       /* BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                        : 0xFFFFFFFF);
            }
        }*/
        // 插入图片
        //QRCodeUtil.insertImage(image, imgPath, needCompress);
        return image;
    }

    /**
     * 插入LOGO
     *
     * @param source
     * 二维码图片
     * @param imgPath
     * LOGO图片地址
     * @param needCompress
     * 是否压缩
     * @throws Exception
     */
    private static void insertImage(BufferedImage source, String imgPath,
                                    boolean needCompress) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            throw new Exception(""+imgPath+" 该文件不存在！");
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     * 内容
     * @param imgPath
     * LOGO地址
     * @param destPath
     * 存放目录
     * @param needCompress
     * 是否压缩LOGO
     * @throws Exception
     */
    public static BufferedImage encode(String content, String imgPath, String destPath,
                              boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath,
                needCompress);
        //mkdirs(destPath);
        //String file = new Random().nextInt(99999999)+"p.jpg";
       // ImageIO.write(image, FORMAT_NAME, new File(destPath+"/"+file));
        return image;
    }

    /**
     * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
     * @author lanyuan
     * Email: mmm333zzz520@163.com
     * @date 2013-12-11 上午10:16:36
     * @param destPath 存放目录
     */
    public static void mkdirs(String destPath) {
        File file =new File(destPath);
//当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     * 内容
     * @param imgPath
     * LOGO地址
     * @param destPath
     * 存储地址
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath)
            throws Exception {
        QRCodeUtil.encode(content, imgPath, destPath, false);
    }

    /**
     * 生成二维码
     *
     * @param content
     * 内容
     * @param destPath
     * 存储地址
     * @param needCompress
     * 是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String destPath,
                              boolean needCompress) throws Exception {
        QRCodeUtil.encode(content, null, destPath, needCompress);
    }

    /**
     * 生成二维码
     *
     * @param content
     * 内容
     * @param destPath
     * 存储地址
     * @throws Exception
     */
    public static void encode(String content, String destPath) throws Exception {
        QRCodeUtil.encode(content, null, destPath, false);
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     * 内容
     * @param imgPath
     * LOGO地址
     * @param output
     * 输出流
     * @param needCompress
     * 是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String imgPath,
                              OutputStream output, boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath,
                needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }

    /**
     * 生成二维码
     *
     * @param content
     * 内容
     * @param output
     * 输出流
     * @throws Exception
     */
    public static void encode(String content, OutputStream output)
            throws Exception {
        QRCodeUtil.encode(content, null, output, false);
    }

    /**
     * 解析二维码
     *
     * @param file
     * 二维码图片
     * @return
     * @throws Exception
     */
    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
                image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    /**
     * 解析二维码
     *
     * @param path
     * 二维码图片地址
     * @return
     * @throws Exception
     */
    public static String decode(String path) throws Exception {
        return QRCodeUtil.decode(new File(path));
    }

    /**
     * 给二维码下方添加说明文字
     * @param image 原二维码
     * @param note 说明文字
     * @return 带说明文字的二维码
     */
    public static BufferedImage addNote(BufferedImage image,String note){
        Image src = image.getScaledInstance(300, 350,Image.SCALE_DEFAULT);
        BufferedImage tag;
        if (note.length()<=16){
            tag = new BufferedImage(300, 322,BufferedImage.TYPE_INT_RGB);
        }else{
            tag = new BufferedImage(300, 345,BufferedImage.TYPE_INT_RGB);
        }
        Graphics g1 = tag.getGraphics();//设置低栏白边
        Graphics2D g2 = tag.createGraphics();//设置文字
        Font font = new Font("微软雅黑",Font.BOLD,18);
        g2.setFont(font);
        g2.setColor(Color.BLACK);
        if (note.length()<=16) {
            g1.fillRect(0, QRCODE_HEIGHT, QRCODE_WIDTH, 22);
            g2.drawString(note,QRCODE_WIDTH/2-note.length()*8-14, QRCODE_HEIGHT+font.getSize());
        }else{
            g1.fillRect(0, QRCODE_HEIGHT, QRCODE_WIDTH, 45);
            g2.drawString(note.substring(0, 16),5, QRCODE_HEIGHT+font.getSize());
            g2.drawString(note.substring(16,note.length()), QRCODE_WIDTH/2-(note.length()-16)*8-14, QRCODE_HEIGHT+font.getSize()*2+4);
        }
        g1.drawImage(src, 0, 0, null);
        g1.dispose();
        g2.dispose();
        g2.drawImage(src, 0, 10, null);
        image = tag;
        image.flush();
        return image;
    }

    public static BufferedImage QRCodeAddFont(BufferedImage img, EquipInfo equipInfo){
        int imageWidth = 400;
        int imageHeight = 500;
        BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();

        Font font = new Font("宋体", Font.BOLD, 14);
        graphics.setFont(font);
        graphics.setColor(new Color(255, 255, 255));
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setColor(new Color(0, 0, 0));
        //graphics.drawString(equipInfo.getAzddDdh(), 100, 350);

        // 计算文字长度，计算居中的x点坐标
        FontMetrics fm = graphics.getFontMetrics(font);
        int textWidth = fm.stringWidth(equipInfo.getAzddDdh());
        int widthX = (imageWidth - textWidth) / 2;
        // 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
        graphics.drawString(equipInfo.getAzddDdh(),widthX,340);

        //graphics.drawString(equipInfo.getAzddDdh(), 100, 350);
        graphics.drawString("装置："+equipInfo.getZzlx(), 20, 370);
        graphics.drawString("线路："+equipInfo.getSsqy()+equipInfo.getSsxl(), 20, 390);

        //graphics.drawString("地址:"+equipInfo.getXxwz(), 20, 410);
        //graphics.drawString("备注："+equipInfo.getBeizhu(), 20, 430);
        String xxwz = equipInfo.getXxwz();
        if(xxwz.length()>20){
            graphics.drawString("地址:"+xxwz.substring(0,16), 20, 410);
            graphics.drawString(xxwz.substring(16), 20, 430);
            String beizhu = equipInfo.getBeizhu();
            if(beizhu.length()>20){
                graphics.drawString("备注："+equipInfo.getBeizhu(), 20, 450);
                graphics.drawString(beizhu.substring(16), 20, 470);
            }
        }else{
            graphics.drawString("地址:"+xxwz, 20, 410);
            graphics.drawString("备注："+equipInfo.getBeizhu(), 20, 430);
        }
        graphics.drawImage(img, 45, 15, 300, 300, null);
        return image;
    }
}
