/**
 * 
 */
package cn.sdcet.shop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.sdcet.shop.domain.Goods;


/**
 * @author Hongten
 * @created 2014-5-20
 */
public class PoiUtil {
    
    public void writeExcel(List<Goods> list, String path) throws Exception {
        if (list == null) {
            return;
        } else if (path == null || Common.EMPTY.equals(path)) {
            return;
        } else {
            String postfix = getPostfix(path);
            if (!Common.EMPTY.equals(postfix)) {
                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    writeXls(list, path);
                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    writeXlsx(list, path);
                }
            }else{
                System.out.println(path + Common.NOT_EXCEL_FILE);
            }
        }
    }
    
    public static String getPostfix(String path) {
        if (path == null || Common.EMPTY.equals(path.trim())) {
            return Common.EMPTY;
        }
        if (path.contains(Common.POINT)) {
            return path.substring(path.lastIndexOf(Common.POINT) + 1, path.length());
        }
        return Common.EMPTY;
    }

	/**
     * read the Excel file
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
    public List<Goods> readExcel(String path) throws IOException {
        if (path == null || Common.EMPTY.equals(path)) {
            return null;
        } else {
            String postfix = getPostfix(path);
            if (!Common.EMPTY.equals(postfix)) {
                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return readXls(path);
                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    return readXlsx(path);
                }
            } else {
                System.out.println(path + Common.NOT_EXCEL_FILE);
            }
        }
        return null;
    }

    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @return
     * @throws IOException
     */
    public List<Goods> readXlsx(String path) throws IOException {
        System.out.println(Common.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        Goods goods = null;
        List<Goods> list = new ArrayList<Goods>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    goods = new Goods();
                    XSSFCell gId = xssfRow.getCell(0);
                    XSSFCell gType = xssfRow.getCell(1);
                    XSSFCell gColor = xssfRow.getCell(2);
                    XSSFCell gSize = xssfRow.getCell(3);
                    XSSFCell gNum = xssfRow.getCell(4);
                    XSSFCell gPrice = xssfRow.getCell(5);
                    XSSFCell gSale = xssfRow.getCell(6);
                    XSSFCell gImage = xssfRow.getCell(7);
                    goods.setgId(getValue(gId));
                    goods.setgType(getValue(gType));
                    goods.setgColor(getValue(gColor));
                    goods.setgSize(getValue(gSize));
                    goods.setgNum(Double.valueOf(getValue(gNum)).intValue());
                    goods.setgPrice(Double.valueOf(getValue(gPrice)));
                    goods.setgSale(Double.valueOf(getValue(gSale)));
                    goods.setgImage(getValue(gImage));
                    list.add(goods);
                }
            }
        }
        return list;
    }

    /**
     * Read the Excel 2003-2007
     * @param path the path of the Excel
     * @return
     * @throws IOException
     */
    public List<Goods> readXls(String path) throws IOException {
        System.out.println(Common.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        Goods goods = null;
        List<Goods> list = new ArrayList<Goods>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            String[] options = { "gId", "gType", "gColor", "gSize","gNum","gPrice","gSale" };
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    goods = new Goods();
                    HSSFCell gId = hssfRow.getCell(0);
                    HSSFCell gType = hssfRow.getCell(1);
                    HSSFCell gColor = hssfRow.getCell(2);
                    HSSFCell gSize = hssfRow.getCell(3);
                    HSSFCell gNum = hssfRow.getCell(4);
                    HSSFCell gPrice = hssfRow.getCell(5);
                    HSSFCell gSale = hssfRow.getCell(6);
                    HSSFCell gImage = hssfRow.getCell(7);
                    goods.setgId(getValue(gId));
                    goods.setgType(getValue(gType));
                    goods.setgColor(getValue(gColor));
                    goods.setgSize(getValue(gSize));
                    goods.setgNum(Integer.valueOf(getValue(gNum)));
                    goods.setgPrice(Double.valueOf(getValue(gPrice)));
                    goods.setgSale(Double.valueOf(getValue(gSale)));
                    goods.setgImage(getValue(gImage));
                    list.add(goods);
                }
            }
        }
        return list;
    }

    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    
    public void writeXls(List<Goods> list, String path) throws Exception {
        if (list == null) {
            return;
        }
        int countColumnNum = list.size();
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet("goodsSheet");
        // option at first row.
        HSSFRow firstRow = sheet.createRow(0);
        HSSFCell[] firstCells = new HSSFCell[countColumnNum];
        String[] options = { "gId", "gType", "gColor", "gSize","gNum","gPrice","gSale" };
        for (int j = 0; j < options.length; j++) {
            firstCells[j] = firstRow.createCell(j);
            firstCells[j].setCellValue(new HSSFRichTextString(options[j]));
        }
        //
        for (int i = 0; i < countColumnNum; i++) {
            HSSFRow row = sheet.createRow(i + 1);
            Goods goods = list.get(i);
            for (int column = 0; column < options.length; column++) {
                HSSFCell gId = row.createCell(0);
                HSSFCell gType = row.createCell(1);
                HSSFCell gColor = row.createCell(2);
                HSSFCell gSize = row.createCell(3);
                HSSFCell gNum = row.createCell(4);
                HSSFCell gPrice = row.createCell(5);
                HSSFCell gSale = row.createCell(6);
                gId.setCellValue(goods.getgId());
                gType.setCellValue(goods.getgType());
                gColor.setCellValue(goods.getgColor());
                gSize.setCellValue(goods.getgSize());
                gNum.setCellValue(goods.getgNum());
                gPrice.setCellValue(goods.getgPrice());
                gSale.setCellValue(goods.getgSale());
            }
        }
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);
        System.out.println(Common.WRITE_DATA + path);
        book.write(os);
        os.close();
    }
    
    public void writeXlsx(List<Goods> list, String path) throws Exception {
        if (list == null) {
            return;
        }
        //XSSFWorkbook
        int countColumnNum = list.size();
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("goodsSheet");
        // option at first row.
        XSSFRow firstRow = sheet.createRow(0);
        XSSFCell[] firstCells = new XSSFCell[countColumnNum];
        String[] options = { "gId", "gType", "gColor", "gSize","gNum","gPrice","gSale","gImage" };
        for (int j = 0; j < options.length; j++) {
            firstCells[j] = firstRow.createCell(j);
            firstCells[j].setCellValue(new XSSFRichTextString(options[j]));
        }
        //
        for (int i = 0; i < countColumnNum; i++) {
            XSSFRow row = sheet.createRow(i + 1);
            Goods goods = list.get(i);
            for (int column = 0; column < options.length; column++) {
            	XSSFCell gId = row.createCell(0);
            	XSSFCell gType = row.createCell(1);
            	XSSFCell gColor = row.createCell(2);
            	XSSFCell gSize = row.createCell(3);
            	XSSFCell gNum = row.createCell(4);
            	XSSFCell gPrice = row.createCell(5);
            	XSSFCell gSale = row.createCell(6);
            	XSSFCell gImage = row.createCell(7);
                gId.setCellValue(goods.getgId());
                gType.setCellValue(goods.getgType());
                gColor.setCellValue(goods.getgColor());
                gSize.setCellValue(goods.getgSize());
                gNum.setCellValue(goods.getgNum());
                gPrice.setCellValue(goods.getgPrice());
                gSale.setCellValue(goods.getgSale());
                gImage.setCellValue(goods.getgImage());
            }
        }
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);
        System.out.println(Common.WRITE_DATA + path);
        book.write(os);
        os.close();
    }
}
class Common {

    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String LIB_PATH = "lib";
    public static final String GOODS_INFO_XLS_PATH = LIB_PATH + "/goods_info" + POINT + OFFICE_EXCEL_2003_POSTFIX;
    public static final String GOODS_INFO_XLSX_PATH = LIB_PATH + "/goods_info" + POINT + OFFICE_EXCEL_2010_POSTFIX;
    public static final String GOODS_INFO_XLS_OUT_PATH = "lib/goods_info_2003-2007.xls";
    public static final String GOODS_INFO_XLSX_OUT_PATH = "lib/goods_info_2010.xlsx";
    public static final String NOT_EXCEL_FILE = " : Not the Excel file!";
    public static final String PROCESSING = "Processing...";
    public static final String WRITE_DATA = "write data to file : ";

}