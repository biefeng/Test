package com.biefeng.demo.pcl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.io.*;

public class PCLPrint {

    private static String uelS = "1B 25 2D  31 32 33 34 35 58";
    private static String lfS = "0A";
    private static String lf_cr_str = " \r\n";
    private static String prj_str = "@PJL ";
    private static String enter_cmd = "@PJL ENTER LANGUAGE = PCL";
    private static String comment_str = "@PJL COMMENT Beginning PostScript Job";
    private static String reset_cmd = "1B 45";

    private static byte esc_b = 27;
    private static byte[] uel_b = fromHexStrtoByteArr(uelS);
    private static byte[] lf_b = fromHexStrtoByteArr(lfS);
    private static byte[] lf_cr_b = lf_cr_str.getBytes();
    private static byte[] reset_cmd_b = fromHexStrtoByteArr(reset_cmd);

    public static byte[] fromHexStrtoByteArr(String byteArrStr) {
        String[] strs = byteArrStr.trim().replaceAll("[\\r\\n\\t\\s]+", " ").split(" ");
        byte[] bytes = new byte[strs.length];
        int index = 0;
        for (String s : strs) {
            byte b = (byte) (Integer.parseInt(s, 16) & 0xFF);
            bytes[index++] = b;
        }
        return bytes;
    }

    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    public static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.trim().replaceAll("[\\r\\n\\t\\s]+", " ").split(" ");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i], 16));
        }
        return sbu.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        PCLPrint pclPrint = new PCLPrint();
        byte[] data = pclPrint.getData(new FileInputStream("H:\\workspace\\idea\\Test\\src\\main\\java\\com\\biefeng\\demo\\pcl\\无标题.bmp"));
        System.out.println(data);

    }

    public void printBitMap(byte[] data) {
        for (byte b : data) {
            if (b != 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        

    }

    public void print(InputStream ins) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            init(baos);
            printJob(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printJob(ByteArrayOutputStream baos) {

    }

    public byte[] getData(InputStream ins) {
        try {
            BufferedImage srcImage = ImageIO.read(ins);
            DataBuffer dataBuffer = srcImage.getData().getDataBuffer();
            byte[] data = ((DataBufferByte) dataBuffer).getData();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void test() {
        try (FileOutputStream fos = new FileOutputStream("H:\\workspace\\idea\\Test\\src\\main\\java\\com\\biefeng\\demo\\pcl\\hhhhh.pcl")) {
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            init(bos);
            bos.write("````````PCL PRINT JOB``````````".getBytes());
            bos.write(esc_b);
            bos.write("E".getBytes());
            bos.write(uel_b);
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init(OutputStream os) throws IOException {
        os.write(uel_b);
        os.write(prj_str.getBytes());
        os.write(lf_cr_b);
        os.write(comment_str.getBytes());
        os.write(lf_cr_b);
        os.write(enter_cmd.getBytes());
        os.write(lf_cr_b);
        os.write(esc_b);
        os.write("E".getBytes());
    }


}
