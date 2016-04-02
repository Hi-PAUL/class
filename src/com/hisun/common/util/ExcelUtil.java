package com.hisun.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.hisun.common.bean.Result;

public class ExcelUtil
{

    /**
     * POI生成Excel文件
     * 
     */
    @SuppressWarnings("resource")
    public static byte[] createResultExcel(List<Result> list)
    {
        String[] title = { "序号", "学号", "班别", "姓名", "学期", "学科", "代号", "课时", "学分", "分数", "备注" };
        // 创建Excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表sheet
        HSSFSheet sheet = workbook.createSheet();
        // 设置单元格的宽度
        sheet.setDefaultColumnWidth(15);
        // 针对第个单元格 设置宽度
        sheet.setColumnWidth(0, 256 * 15);
        // 创建第一行
        HSSFRow row = sheet.createRow(0);
        // 定义单元格
        HSSFCell cell = null;

        // 插入第一行数据
        for (int i = 0; i < title.length; i++)
        {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        // 追加数据
        for (int i = 1; i <= list.size(); i++)
        {
            HSSFRow nextrow = sheet.createRow(i);
            HSSFCell cell2 = nextrow.createCell(0);
            cell2.setCellValue(i);

            cell2 = nextrow.createCell(1);
            cell2.setCellValue(list.get(i - 1).getStudentid());

            cell2 = nextrow.createCell(2);
            cell2.setCellValue(list.get(i - 1).getBanbie());

            cell2 = nextrow.createCell(3);
            cell2.setCellValue(list.get(i - 1).getName());

            cell2 = nextrow.createCell(4);
            cell2.setCellValue(list.get(i - 1).getSession());
            
            cell2 = nextrow.createCell(5);
            cell2.setCellValue(list.get(i - 1).getCoursename());
            
            cell2 = nextrow.createCell(6);
            cell2.setCellValue(list.get(i - 1).getCoursecode());
            
            cell2 = nextrow.createCell(7);
            cell2.setCellValue(list.get(i - 1).getCredit());
            
            cell2 = nextrow.createCell(8);
            cell2.setCellValue(list.get(i - 1).getPeriod());
            
            cell2 = nextrow.createCell(9);
            cell2.setCellValue(list.get(i - 1).getScores());
            
            cell2 = nextrow.createCell(10);
            cell2.setCellValue(list.get(i - 1).getRemark());
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try
        {
            workbook.write(os);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return os.toByteArray();
    }
}
