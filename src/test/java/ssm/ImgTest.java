//package ssm;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.common.BitMatrix;
//
//import wh.util.MatrixToImageWriter;
//
//public class ImgTest {
//
//	@Test
//	public void img() {
//		try {
//		     String content = "https://qr.alipay.com/bax01872td6shmqp2i7p4026";
//		     String path = "D:";
//		     MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//
//		     Map hints = new HashMap();
//		     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//		     BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400,hints);
//		     File file1 = new File(path,"֧����ά��.jpg");
//		     MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);
//		 } catch (Exception e) {
//		     e.printStackTrace();
//		 }
//
//	}
//}
