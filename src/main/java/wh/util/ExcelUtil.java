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
//        //创建Workbook对象（这一个对象代表着对应的一个Excel文件）  
//        //HSSFWorkbook表示以xls为后缀名的文件  
//        Workbook wb = new HSSFWorkbook();  
//        //获得CreationHelper对象,这个应该是一个帮助类  
//        CreationHelper helper = wb.getCreationHelper();  
//        //创建Sheet并给名字(表示Excel的一个Sheet)  
//        Sheet sheet1 = wb.createSheet("HSSF_Sheet_1");        
//        Sheet sheet2 = wb.createSheet("HSSF_Sheet_2");  
//        //Row表示一行Cell表示一列  
//        Row row = null;  
//        Cell cell = null;  
//        for(int i=0;i<60;i=i+2){  
//            //获得这个sheet的第i行  
//            row = sheet1.createRow(i);  
//            //设置行长度自动             
//            //row.setHeight((short)500);  
//            row.setHeightInPoints(20);  
//            //row.setZeroHeight(true);  
//            for(int j=0;j<25;j++){         
//                //设置每个sheet每一行的宽度,自动,根据需求自行确定  
//                sheet2.autoSizeColumn(j+1, true);  
//                //创建一个基本的样式  
//                CellStyle cellStyle = ExcelUtil.createStyleCell(wb);  
//                //获得这一行的每j列  
//                cell = row.createCell(j);  
//                if(j==0){  
//                    //设置文字在单元格里面的位置  
//                    cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle);  
//                    //先创建字体样式,并把这个样式加到单元格的字体里面  
//                    cellStyle.setFont(createFonts(wb));  
//                    //把这个样式加到单元格里面  
//                    cell.setCellStyle(cellStyle);                     
//                    //给单元格设值  
//                    cell.setCellValue(true);  
//                }else if(j==1){  
//                    //设置文字在单元格里面的位置  
//                    cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle);  
//                    //设置这个样式的格式(Format)  
//                    cellStyle = ExcelUtil.setCellFormat(helper,cellStyle, "#,##0.0000");                    
//                    //先创建字体样式,并把这个样式加到单元格的字体里面  
//                    cellStyle.setFont(createFonts(wb));  
//                    //把这个样式加到单元格里面  
//                    cell.setCellStyle(cellStyle);  
//                    //给单元格设值  
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
//                    //设置公式  
//                    cell.setCellFormula("SUM(E"+(i+1)+":X"+(i+1)+")");                    
//                }else{                    
//                    cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle);  
//                    cellStyle = ExcelUtil.setFillBackgroundColors(cellStyle,IndexedColors.ORANGE.getIndex(),IndexedColors.ORANGE.getIndex());  
//                    cell.setCellStyle(cellStyle);  
//                    cell.setCellValue(1);  
//                }  
//            }  
//        }  
        //输出  
 /*       OutputStream os = new FileOutputStream(new File("D://SummaryHSSF.xls"));  
        wb.write(os);  
        os.close();       
    } */ 
    /** 
     * 边框 
     * @param wb 
     * @return 
     */  
    public static CellStyle createStyleCell(Workbook wb){  
        CellStyle cellStyle = wb.createCellStyle();  
        //设置一个单元格边框颜色  
        cellStyle.setBorderBottom(BorderStyle.NONE);  
        cellStyle.setBorderTop(BorderStyle.NONE);  
        cellStyle.setBorderLeft(BorderStyle.NONE);  
        cellStyle.setBorderRight(BorderStyle.NONE);  
        //设置一个单元格边框颜色  
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());  
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());          
        return cellStyle;  
    }  
    
    /** 
     * 设置文字在单元格里面的位置 
     * CellStyle.ALIGN_CENTER 
     * CellStyle.VERTICAL_CENTER 
     * @param cellStyle 
     * @param halign 
     * @param valign 
     * @return 
     */  
    public static CellStyle setCellStyleAlignment(CellStyle cellStyle){  
        //设置上下  
        cellStyle.setAlignment(HorizontalAlignment.GENERAL);  
        //设置左右  
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);  
        return cellStyle;  
    }  
    /** 
     * 格式化单元格 
     * 如#,##0.00,m/d/yy去HSSFDataFormat或XSSFDataFormat里面找 
     * @param cellStyle 
     * @param fmt 
     * @return 
     */  
    public static CellStyle setCellFormat(CreationHelper helper,CellStyle cellStyle,String fmt){  
        //还可以用其它方法创建format  
        cellStyle.setDataFormat(helper.createDataFormat().getFormat(fmt));  
        return cellStyle;  
    }  
    /** 
     * 前景和背景填充的着色 
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
     * 设置字体 
     * @param wb 
     * @return 
     */  
    public static Font createFonts(Workbook wb){  
        //创建Font对象  
        Font font = wb.createFont();  
        //设置字体  
        font.setFontName("黑体");  
        //着色  
        font.setColor(HSSFColor.BLUE.index);  
        //斜体  
        font.setItalic(true);  
        //字体大小  
        font.setFontHeight((short)300);  
        return font;  
    }  
    
    public static String DEFAULT_DATE_PATTERN="yyyy年MM月dd日";//默认日期格式
    public static int DEFAULT_COLOUMN_WIDTH = 17;


    /**
     * 导出Excel 2007 OOXML (.xlsx)格式
     * @param title 标题行
     * @param headMap 属性-列头
     * @param jsonArray 数据集
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth 列宽 默认 至少17个字节
     * @param out 输出流
     */
    public static void exportExcelX(String title,LinkedHashMap<String, String> headMap,JSONArray jsonArray,String datePattern,int colWidth, OutputStream out) {
        if(datePattern==null) datePattern = DEFAULT_DATE_PATTERN;
        // 声明一个工作薄
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//缓存
        workbook.setCompressTempFiles(true);
        //表头样式
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.GENERAL);
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 15);
//        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 列头样式
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
        // 单元格样式
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
//        cellFont.setBoldweight(HSSFFont。BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);
        // 生成一个(带标题)表格
        SXSSFSheet sheet = workbook.createSheet();
        //设置列宽
        int minBytes = colWidth<DEFAULT_COLOUMN_WIDTH?DEFAULT_COLOUMN_WIDTH:colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
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
        // 遍历集合数据，产生数据行
        int rowIndex = 0;

        SXSSFRow titleRow = sheet.createRow(0);//表头 rowIndex=0
        titleRow.createCell(0).setCellValue(title);
        titleRow.getCell(0).setCellStyle(titleStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

        SXSSFRow headerRow = sheet.createRow(1); //列头 rowIndex =1
        for(int i=0;i<headers.length;i++)
        {
            headerRow.createCell(i).setCellValue(headers[i]);
            headerRow.getCell(i).setCellStyle(headerStyle);
        }
        rowIndex = 2;//数据内容从 rowIndex=2开始
        if(jsonArray != null){
            for (Object obj : jsonArray) {
                if(rowIndex == 65535 || rowIndex == 0){
                    if ( rowIndex != 0 ) sheet = workbook.createSheet();//如果数据超过了，则在第二页显示

                    titleRow = sheet.createRow(0);//表头 rowIndex=0
                    titleRow.createCell(0).setCellValue(title);
                    titleRow.getCell(0).setCellStyle(titleStyle);
                    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

                    headerRow = sheet.createRow(1); //列头 rowIndex =1
                    for(int i=0;i<headers.length;i++)
                    {
                        headerRow.createCell(i).setCellValue(headers[i]);
                        headerRow.getCell(i).setCellStyle(headerStyle);

                    }
                    rowIndex = 2;//数据内容从 rowIndex=2开始
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
        // 自动调整宽度
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
        headMap.put("name","姓名");
        headMap.put("age","年龄");
        headMap.put("birthday","生日");
        headMap.put("height","身高");
        headMap.put("weight","体重");
        headMap.put("sex","性别");

        String title = "测试";
        /*
        OutputStream outXls = new FileOutputStream("E://a.xls");
        System.out.println("正在导出xls....");
        Date d = new Date();
        ExcelUtil.exportExcel(title,headMap,ja,null,outXls);
        System.out.println("共"+count+"条数据,执行"+(new Date().getTime()-d.getTime())+"ms");
        outXls.close();*/
        //
        OutputStream outXlsx = new FileOutputStream("E://b.xlsx");
        System.out.println("正在导出xlsx....");
        Date d2 = new Date();
        ExcelUtil.exportExcelX(title,headMap,ja,null,0,outXlsx);
        System.out.println("共"+count+"条数据,执行"+(new Date().getTime()-d2.getTime())+"ms");
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

