package com.example.Utils;


import sun.awt.Graphics2Delegate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Random;

//验证码生成类
public class VerificationCode {
    /**
     * 随机生成验证码验证图片
     * 返回验证码的字符
     * @return randomCode
     */
    public static String createVerification() {
        //验证码图片宽度
        int width=100;
        //验证码图片高度
        int height=30;
        //验证码字符数
        int codeCount=4;
        //验证码字符字体大小
        int fontHeight=20;
        //第一个字符的x轴值，因为后面的字符坐标依次递增，所以它们的x轴值是codeX的倍数
        int codeX;  //15-20
        //codeY 验证字符的y轴值，因为并行所以值一样
        int codeY;  //15-30
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D gd = buffImg.createGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        //验证码中的字符从codeSequence数组中产生
        char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        // 将图像填充为白色
//        gd.setColor(Color.LIGHT_GRAY);
        //填充矩形
        gd.fillRect(0, 0, width, height);
        // 画边框设置为白色
        gd.setColor(Color.WHITE);
        //绘制矩形边框
        gd.drawRect(0, 0, width - 1, height - 1);
        // 随机产生16条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.GRAY);
        for (int i = 0; i < 16; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
            //多次测试发现codeX在15-20 codeY在15-30这个区间最佳
            codeX=random.nextInt(5)+15;
            codeY=random.nextInt(15)+15;
            //在for循环中设置字体 使每个字符的位置不同
            Font font = new Font("Courier", Font.PLAIN, fontHeight);
            // 设置字体。
            gd.setFont(font);
            // 得到随机产生的验证码数字。
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(strRand, (i + 1) * codeX, codeY);

            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
            try {
                ImageIO.write(buffImg,"jpeg",new FileOutputStream("images/verification.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //返回验证码的值
        return randomCode.toString();
    }

}
