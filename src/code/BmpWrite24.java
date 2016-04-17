package code;

/**
 * @author  LBB
 * @date ����ʱ�䣺2016��4��17�� ����10:15:29
 * @version 1.0 
 * @parameter 
 * @since  
 * @return 
 */
import java.awt.Color;  

public class BmpWrite24 {  
    /** 
     * ͼ���������� 
     */  
    private Color[][] pointArray;  
  
    /** 
     * ͼ�εĿ� 
     */  
    int width;  
  
    /** 
     * ͼ�εĸ� 
     */  
    int height;  
  
    /** 
     * BMPWrite�����������أ�����ͼ���������� 
     *  
     * @param pointArray 
     */  
    public BmpWrite24(Color[][] pointArray) {  
        this.pointArray = pointArray;  
        this.width = pointArray.length;  
        this.height = pointArray[0].length;  
        this.write();  
    }  
  
    /** 
     * �����ݴ����ڴ� 
     */  
    public void write() {  
        try {  
            // ����������ļ�����  
            java.io.FileOutputStream fos = new java.io.FileOutputStream(  
                    "F:\\BaiduYunDownload\\1.bmp");  
            // ����ԭʼ�������������  
            java.io.DataOutputStream dos = new java.io.DataOutputStream(fos);  
  
            // ���ļ�ͷ�ı�����ֵ  
            int bfType = 0x424d; // λͼ�ļ����ͣ�0��1�ֽڣ�  
            int bfSize = 54 + width * height * 3;// bmp�ļ��Ĵ�С��2��5�ֽڣ�  
            int bfReserved1 = 0;// λͼ�ļ������֣�����Ϊ0��6-7�ֽڣ�  
            int bfReserved2 = 0;// λͼ�ļ������֣�����Ϊ0��8-9�ֽڣ�  
            int bfOffBits = 54;// �ļ�ͷ��ʼ��λͼʵ������֮����ֽڵ�ƫ������10-13�ֽڣ�  
  
            // �������ݵ�ʱ��Ҫע��������������ڴ���Ҫռ�����ֽڣ�  
            // Ȼ����ѡ����Ӧ��д�뷽�������������Լ��������������  
            // �����ļ�ͷ����  
            dos.writeShort(bfType); // ����λͼ�ļ�����'BM'  
            dos.write(changeByte(bfSize),0,4); // ����λͼ�ļ���С  
            dos.write(changeByte(bfReserved1),0,2);// ����λͼ�ļ�������  
            dos.write(changeByte(bfReserved2),0,2);// ����λͼ�ļ�������  
            dos.write(changeByte(bfOffBits),0,4);// ����λͼ�ļ�ƫ����  
  
            // ����Ϣͷ�ı�����ֵ  
            int biSize = 40;// ��Ϣͷ������ֽ�����14-17�ֽڣ�  
            int biWidth = width;// λͼ�Ŀ�18-21�ֽڣ�  
            int biHeight = height;// λͼ�ĸߣ�22-25�ֽڣ�  
            int biPlanes = 1; // Ŀ���豸�ļ��𣬱�����1��26-27�ֽڣ�  
            int biBitcount = 24;// ÿ�����������λ����28-29�ֽڣ���������1λ��˫ɫ����4λ��16ɫ����8λ��256ɫ������24λ�����ɫ��֮һ��  
            int biCompression = 0;// λͼѹ�����ͣ�������0����ѹ������30-33�ֽڣ���1��BI_RLEBѹ�����ͣ���2��BI_RLE4ѹ�����ͣ�֮һ��  
            int biSizeImage = width * height;// ʵ��λͼͼ��Ĵ�С��������ʵ�ʻ��Ƶ�ͼ���С��34-37�ֽڣ�  
            int biXPelsPerMeter = 0;// λͼˮƽ�ֱ��ʣ�ÿ����������38-41�ֽڣ��������ϵͳĬ��ֵ  
            int biYPelsPerMeter = 0;// λͼ��ֱ�ֱ��ʣ�ÿ����������42-45�ֽڣ��������ϵͳĬ��ֵ  
            int biClrUsed = 0;// λͼʵ��ʹ�õ���ɫ���е���ɫ����46-49�ֽڣ������Ϊ0�Ļ���˵��ȫ��ʹ����  
            int biClrImportant = 0;// λͼ��ʾ��������Ҫ����ɫ��(50-53�ֽ�)�����Ϊ0�Ļ���˵��ȫ����Ҫ  
              
            // ��Ϊjava�Ǵ�˴洢����ôҲ����˵ͬ�����������  
            // ��������ǰ�С�˶�ȡ��������ǲ��ı���ֽ����ݵ�˳��Ļ�����ô�����Ͳ���������ȡ��  
            // �������ȵ��÷�����int����ת��Ϊ���byte���ݣ����Ұ�С�˴洢��˳��  
              
            // ������Ϣͷ����  
            dos.write(changeByte(biSize),0,4);// ������Ϣͷ���ݵ����ֽ���  
            dos.write(changeByte(biWidth),0,4);// ����λͼ�Ŀ�  
            dos.write(changeByte(biHeight),0,4);// ����λͼ�ĸ�  
            dos.write(changeByte(biPlanes),0,2);// ����λͼ��Ŀ���豸����  
            dos.write(changeByte(biBitcount),0,2);// ����ÿ������ռ�ݵ��ֽ���  
            dos.write(changeByte(biCompression),0,4);// ����λͼ��ѹ������  
            dos.write(changeByte(biSizeImage),0,4);// ����λͼ��ʵ�ʴ�С  
            dos.write(changeByte(biXPelsPerMeter),0,4);// ����λͼ��ˮƽ�ֱ���  
            dos.write(changeByte(biYPelsPerMeter),0,4);// ����λͼ�Ĵ�ֱ�ֱ���  
            dos.write(changeByte(biClrUsed),0,4);// ����λͼʹ�õ�����ɫ��  
            dos.write(changeByte(biClrImportant),0,4);// ����λͼʹ�ù�������Ҫ����ɫ��  
  
            // ��Ϊ��24λͼ������û����ɫ��  
            // ͨ����������λͼ����  
            // ���������ʱ��ע�⣬�ڼ�����ڴ���λͼ�����Ǵ����ң����µ���������ģ�  
            // Ҳ����˵ʵ��ͼ��ĵ�һ�еĵ����ڴ������һ��  
            for (int i = height - 1; i >= 0; i--) {  
                for (int j = 0; j < width; j++) {  
                    // ���ﻹ��Ҫע����ǣ�ÿ��������������RGB��ɫ������ɵģ�  
                    // ��������windows����ϵͳ����С�˴洢���Զ��ֽ��������á�  
                    int red = pointArray[i][j].getRed();// �õ�λͼ��ĺ�ɫ����  
                    int green = pointArray[i][j].getGreen();// �õ�λͼ�����ɫ����  
                    int blue = pointArray[i][j].getBlue();// �õ�λͼ�����ɫ����  
                    byte[] red1 = changeByte(red);  
                    byte[] green1 = changeByte(green);  
                    byte[] blue1 = changeByte(blue);  
                    dos.write(blue1,0,1);  
                    dos.write(green1,0,1);  
                    dos.write(red1,0,1);  
                }  
            }  
            //�ر����ݵĴ���  
            dos.flush();  
            dos.close();  
            fos.close();  
            System.out.println("success!!!");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * ��һ��int����תΪ��С��˳�����е��ֽ����� 
     * @param data int���� 
     * @return  ��С��˳�����е��ֽ����� 
     */  
    public byte[] changeByte(int data){  
        byte b4 = (byte)((data)>>24);  
        byte b3 = (byte)(((data)<<8)>>24);  
        byte b2= (byte)(((data)<<16)>>24);  
        byte b1 = (byte)(((data)<<24)>>24);  
        byte[] bytes = {b1,b2,b3,b4};  
        return bytes;  
    }  
}  