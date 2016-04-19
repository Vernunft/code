
package code;

import java.io.File;
/** 
* ��һ���ļ����е��ļ����Ƶ�һ��ָ�����ļ���
* @author �����
* @date ����ʱ�䣺2016��4��19�� ����7:15:46 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	public static void main(String[] args) {
		/* ָ��Դexe�ļ��Ĵ��·�� */
		String str = "C:/lbb/��ά��.bmp";
		/* ָ�����ƺ��exe��Ŀ��·�� */
		String strs = "C:/lbb/copy.bmp";
		/* �������������� */
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			/* ��io�����ļ����� */
			fis = new FileInputStream(str);

			fos = new FileOutputStream(strs);
			byte[] buf = new byte[1024 * 1024];
			int len;
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
