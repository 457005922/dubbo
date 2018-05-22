package wh.util;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ExcelUtil {
	private static Logger logger = Logger.getLogger(ExcelUtil.class);  
	
	private HSSFWorkbook 	workbook = null;
	@SuppressWarnings("unused")
	private HSSFSheet sheet = null;
	public HSSFWorkbook getWorkbook() {
		return workbook;
	}
	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}
	
	public ExcelUtil(HSSFWorkbook workbook) {
		this.workbook=workbook;
	}
	public ExcelUtil (HSSFWorkbook hssfWorkbook ,HSSFSheet sheet) {
		super();
		this.workbook = hssfWorkbook;
		this.sheet=sheet;
	}
	
//	public static void main(String[] args) throws IOException {  
//        //����Workbook������һ����������Ŷ�Ӧ��һ��Excel�ļ���  
//        //HSSFWorkbook��ʾ��xlsΪ��׺�����ļ�  
//        Workbook wb = new HSSFWorkbook();  
//        //���CreationHelper����,���Ӧ����һ��������  
//        CreationHelper helper = wb.getCreationHelper();  
//        //����Sheet��������(��ʾExcel��һ��Sheet)  
//        Sheet sheet1 = wb.createSheet("HSSF_Sheet_1");        
//        Sheet sheet2 = wb.createSheet("HSSF_Sheet_2");  
//        //Row��ʾһ��Cell��ʾһ��  
//        Row row = null;  
//        Cell cell = null;  
//        for(int i=0;i<60;i=i+2){  
//            //������sheet�ĵ�i��  
//            row = sheet1.createRow(i);  
//            //�����г����Զ�             
//            //row.setHeight((short)500);  
//            row.setHeightInPoints(20);  
//            //row.setZeroHeight(true);  
//            for(int j=0;j<25;j++){         
//                //����ÿ��sheetÿһ�еĿ��,�Զ�,������������ȷ��  
//                sheet2.autoSizeColumn(j+1, true);  
//                //����һ����������ʽ  
//                CellStyle cellStyle = ExcelUtil.createStyleCell(wb);  
//                //�����һ�е�ÿj��  
//                cell = row.createCell(j);  
//                if(j==0){  
//                    //���������ڵ�Ԫ�������λ��  
//                    cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle);  
//                    //�ȴ���������ʽ,���������ʽ�ӵ���Ԫ�����������  
//                    cellStyle.setFont(createFonts(wb));  
//                    //�������ʽ�ӵ���Ԫ������  
//                    cell.setCellStyle(cellStyle);                     
//                    //����Ԫ����ֵ  
//                    cell.setCellValue(true);  
//                }else if(j==1){  
//                    //���������ڵ�Ԫ�������λ��  
//                    cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle);  
//                    //���������ʽ�ĸ�ʽ(Format)  
//                    cellStyle = ExcelUtil.setCellFormat(helper,cellStyle, "#,##0.0000");                    
//                    //�ȴ���������ʽ,���������ʽ�ӵ���Ԫ�����������  
//                    cellStyle.setFont(createFonts(wb));  
//                    //�������ʽ�ӵ���Ԫ������  
//                    cell.setCellStyle(cellStyle);  
//                    //����Ԫ����ֵ  
//                    cell.setCellValue(new Double(2008.2008));  
//                }else if(j==2){  
//                    cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle);                      
//                    cellStyle.setFont(createFonts(wb));  
//                    cell.setCellStyle(cellStyle);  
//                    cell.setCellValue(helper.createRichTextString("RichString"+i+j));                     
//                }else if(j==3){  
//                    cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle);  
//                    cellStyle = ExcelUtil.setCellFormat(helper,cellStyle, "MM-yyyy-dd");  
//                    cell.setCellStyle(cellStyle);  
//                    cell.setCellValue(new Date());  
//                }else if(j==24){  
//                    cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle);  
//                    cellStyle.setFont(createFonts(wb));  
//                    //���ù�ʽ  
//                    cell.setCellFormula("SUM(E"+(i+1)+":X"+(i+1)+")");                    
//                }else{                    
//                    cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle);  
//                    cellStyle = ExcelUtil.setFillBackgroundColors(cellStyle,IndexedColors.ORANGE.getIndex(),IndexedColors.ORANGE.getIndex());  
//                    cell.setCellStyle(cellStyle);  
//                    cell.setCellValue(1);  
//                }  
//            }  
//        }  
        //���  
 /*       OutputStream os = new FileOutputStream(new File("D://SummaryHSSF.xls"));  
        wb.write(os);  
        os.close();       
    } */ 
    /** 
     * �߿� 
     * @param wb 
     * @return 
     */  
    public static CellStyle createStyleCell(Workbook wb){  
        CellStyle cellStyle = wb.createCellStyle();  
        //����һ����Ԫ��߿���ɫ  
        cellStyle.setBorderBottom(BorderStyle.NONE);  
        cellStyle.setBorderTop(BorderStyle.NONE);  
        cellStyle.setBorderLeft(BorderStyle.NONE);  
        cellStyle.setBorderRight(BorderStyle.NONE);  
        //����һ����Ԫ��߿���ɫ  
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());  
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());          
        return cellStyle;  
    }  
    
    /** 
     * ���������ڵ�Ԫ�������λ�� 
     * CellStyle.ALIGN_CENTER 
     * CellStyle.VERTICAL_CENTER 
     * @param cellStyle 
     * @param halign 
     * @param valign 
     * @return 
     */  
    public static CellStyle setCellStyleAlignment(CellStyle cellStyle){  
        //��������  
        cellStyle.setAlignment(HorizontalAlignment.GENERAL);  
        //��������  
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);  
        return cellStyle;  
    }  
    /** 
     * ��ʽ����Ԫ�� 
     * ��#,##0.00,m/d/yyȥHSSFDataFormat��XSSFDataFormat������ 
     * @param cellStyle 
     * @param fmt 
     * @return 
     */  
    public static CellStyle setCellFormat(CreationHelper helper,CellStyle cellStyle,String fmt){  
        //��������������������format  
        cellStyle.setDataFormat(helper.createDataFormat().getFormat(fmt));  
        return cellStyle;  
    }  
    /** 
     * ǰ���ͱ���������ɫ 
     * @param cellStyle 
     * @param bg IndexedColors.ORANGE.getIndex(); 
     * @param fg IndexedColors.ORANGE.getIndex(); 
     * @param fp CellStyle.SOLID_FOREGROUND 
     * @return 
     */  
    public static CellStyle setFillBackgroundColors(CellStyle cellStyle,short bg,short fg){  
        //cellStyle.setFillBackgroundColor(bg);  
        cellStyle.setFillForegroundColor(fg);  
//        cellStyle.setFillPattern(fp);  
        return cellStyle;  
    }  
    /** 
     * �������� 
     * @param wb 
     * @return 
     */  
    public static Font createFonts(Workbook wb){  
        //����Font����  
        Font font = wb.createFont();  
        //��������  
        font.setFontName("����");  
        //��ɫ  
        font.setColor(HSSFColor.BLUE.index);  
        //б��  
        font.setItalic(true);  
        //�����С  
        font.setFontHeight((short)300);  
        return font;  
    }  
    
    public static String DEFAULT_DATE_PATTERN="yyyy��MM��dd��";//Ĭ�����ڸ�ʽ
    public static int DEFAULT_COLOUMN_WIDTH = 17;


    /**
     * ����Excel 2007 OOXML (.xlsx)��ʽ
     * @param title ������
     * @param headMap ����-��ͷ
     * @param jsonArray ���ݼ�
     * @param datePattern ���ڸ�ʽ����nullֵ��Ĭ�� ������
     * @param colWidth �п� Ĭ�� ����17���ֽ�
     * @param out �����
     */
    public static void exportExcelX(String title,LinkedHashMap<String, String> headMap,JSONArray jsonArray,String datePattern,int colWidth, OutputStream out) {
        if(datePattern==null) datePattern = DEFAULT_DATE_PATTERN;
        // ����һ��������
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//����
        workbook.setCompressTempFiles(true);
        //��ͷ��ʽ
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.GENERAL);
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 15);
//        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // ��ͷ��ʽ
        CellStyle headerStyle = workbook.createCellStyle();
//        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(BorderStyle.MEDIUM);
        headerStyle.setBorderLeft(BorderStyle.MEDIUM);
        headerStyle.setBorderRight(BorderStyle.MEDIUM);
        headerStyle.setBorderTop(BorderStyle.MEDIUM);
        headerStyle.setAlignment(HorizontalAlignment.GENERAL);
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
//        headerFont.setBoldweight(BorderStyle.MEDIUM);
        headerStyle.setFont(headerFont);
        // ��Ԫ����ʽ
        CellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setAlignment(HorizontalAlignment.GENERAL);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        cellStyle.setFillBackgroundColor(HSSFColor.WHITE.index);
        Font cellFont = workbook.createFont();
//        cellFont.setBoldweight(HSSFFont��BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);
        // ����һ��(������)���
        SXSSFSheet sheet = workbook.createSheet();
        //�����п�
        int minBytes = colWidth<DEFAULT_COLOUMN_WIDTH?DEFAULT_COLOUMN_WIDTH:colWidth;//�����ֽ���
        int[] arrColWidth = new int[headMap.size()];
        // ������������,�Լ������п�
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        System.out.printf(headMap.keySet().toString());
        Iterator<String> iter = headMap.keySet().iterator();
        while (iter.hasNext()) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = headMap.get(fieldName);

            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] =  bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii,arrColWidth[ii]*256);
            sheet.setDefaultRowHeight((short)(30*15));
            ii++;
        }
        // �����������ݣ�����������
        int rowIndex = 0;

        SXSSFRow titleRow = sheet.createRow(0);//��ͷ rowIndex=0
        titleRow.createCell(0).setCellValue(title);
        titleRow.getCell(0).setCellStyle(titleStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

        SXSSFRow headerRow = sheet.createRow(1); //��ͷ rowIndex =1
        for(int i=0;i<headers.length;i++)
        {
            headerRow.createCell(i).setCellValue(headers[i]);
            headerRow.getCell(i).setCellStyle(headerStyle);
        }
        rowIndex = 2;//�������ݴ� rowIndex=2��ʼ
        if(jsonArray != null){
            for (Object obj : jsonArray) {
                if(rowIndex == 65535 || rowIndex == 0){
                    if ( rowIndex != 0 ) sheet = workbook.createSheet();//������ݳ����ˣ����ڵڶ�ҳ��ʾ

                    titleRow = sheet.createRow(0);//��ͷ rowIndex=0
                    titleRow.createCell(0).setCellValue(title);
                    titleRow.getCell(0).setCellStyle(titleStyle);
                    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

                    headerRow = sheet.createRow(1); //��ͷ rowIndex =1
                    for(int i=0;i<headers.length;i++)
                    {
                        headerRow.createCell(i).setCellValue(headers[i]);
                        headerRow.getCell(i).setCellStyle(headerStyle);

                    }
                    rowIndex = 2;//�������ݴ� rowIndex=2��ʼ
                }

                JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
                SXSSFRow dataRow = sheet.createRow(rowIndex);
                for (int i = 0; i < properties.length; i++)
                {
                    SXSSFCell newCell = dataRow.createCell(i);

                    Object o =  jo.get(properties[i]);
                    String cellValue = "";
                    if(o==null) cellValue = "";
                    else if(o instanceof Date) cellValue = new SimpleDateFormat(datePattern).format(o);
                    else cellValue = o.toString();

                    newCell.setCellValue(cellValue);
                    newCell.setCellStyle(cellStyle);
                }
                rowIndex++;
            }
        }
        // �Զ��������
        /*for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }*/
        try {
            workbook.write(out);
            workbook.close();
            workbook.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {
        int count = 100000;
        JSONArray ja = new JSONArray();
        for(int i=0;i<100000;i++){
            Student s = new Student();
            s.setName("POI"+i);
            s.setAge(i);
            s.setBirthday(new Date());
            s.setHeight(i);
            s.setWeight(i);
            s.setSex(i/2==0?false:true);
            ja.add(s);
        }
        LinkedHashMap<String,String> headMap = new LinkedHashMap<String,String>();
        headMap.put("name","����");
        headMap.put("age","����");
        headMap.put("birthday","����");
        headMap.put("height","���");
        headMap.put("weight","����");
        headMap.put("sex","�Ա�");

        String title = "����";
        /*
        OutputStream outXls = new FileOutputStream("E://a.xls");
        System.out.println("���ڵ���xls....");
        Date d = new Date();
        ExcelUtil.exportExcel(title,headMap,ja,null,outXls);
        System.out.println("��"+count+"������,ִ��"+(new Date().getTime()-d.getTime())+"ms");
        outXls.close();*/
        //
        OutputStream outXlsx = new FileOutputStream("E://b.xlsx");
        System.out.println("���ڵ���xlsx....");
        Date d2 = new Date();
        ExcelUtil.exportExcelX(title,headMap,ja,null,0,outXlsx);
        System.out.println("��"+count+"������,ִ��"+(new Date().getTime()-d2.getTime())+"ms");
        outXlsx.close();

    }
}


class Student {
    private String name;
    private int age;
    private Date birthday;
    private float height;
    private double weight;
    private boolean sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

