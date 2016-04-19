
package code;

import java.io.File;
/** 
* 把一个文件夹中的文件复制到一个指定的文件夹
* @author 李冰冰
* @date 创建时间：2016年4月19日 下午7:15:46 
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
		/* 指定源exe文件的存放路径 */
		String str = "C:/lbb/二维码.bmp";
		/* 指定复制后的exe的目标路径 */
		String strs = "C:/lbb/copy.bmp";
		/* 创建输入和输出流 */
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			/* 将io流和文件关联 */
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
