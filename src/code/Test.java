package code;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Test {
	public static void main(String args[]) {
		int[] rgb = new int[3];
		int sum = 0;//��¼Ϊ�ڵ����ص�Ĵ���
		int x; //��¼��ά������ʼ������
		int y; //��¼��ά������ʼ������
		File file = new File("C:/lbb/��ά��.jpg");
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int width = bi.getWidth();
		int height = bi.getHeight();
//		int minx =75;
//		int miny =60;
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		System.out.println("width=" + width + ",height=" + height + ".");
		System.out.println("minx=" + minx + ",miniy=" + miny + ".");
		File wFile=new File("C:/lbb/test.txt");
		FileWriter fileWriter=null;
		try {
			fileWriter=new FileWriter(wFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				//��ԭ��Ӧ����
				int pixel = bi.getRGB(i, j);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				//��rgb��ֵд��txt�ļ�
				try {
					fileWriter.write("["+rgb[0]+" ");
					fileWriter.write(rgb[1]+" ");
					fileWriter.write(rgb[2]+"]");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (rgb[0]==0&&rgb[1]==0&&rgb[3]==0) {
					sum++;
					if (sum>60) {
						
					}
				}
//			96	System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")");

			}
		}

	}

}