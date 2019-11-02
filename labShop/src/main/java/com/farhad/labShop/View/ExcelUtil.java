package com.farhad.labShop.View;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    public  Workbook openWorkbook()  {
        Workbook workbook=null;
        ClassLoader classLoader=getClass().getClassLoader();
        URL excelFile =classLoader.getResource("labShop.xlsx");
        String excelAddress="D:\\java\\1.gitHub\\labshop\\labShop\\src\\main\\resources\\labshop.xlsx"; //excelFile.toString().substring(6);
        try {
            FileInputStream fileInputStream=new FileInputStream(new File(excelAddress));
             workbook=new XSSFWorkbook( fileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
     /*excel cell shoud not be empty otherwise iterator will skip it.*/
    public JsonObject readWorkbookToJson(){
        Workbook workbook=openWorkbook();
        Sheet sheet=workbook.getSheetAt(0);
        JsonObject allObjects= new JsonObject();

        List<List<String>> allData=new ArrayList<>();
        for(Row row : sheet){
            List<String> rowData=new ArrayList<>();
            for(Cell cell: row){
                switch (cell.getCellType()){
                    case STRING:
                        rowData.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        rowData.add(Double.toString(cell.getNumericCellValue()));
                        break;
                    case BOOLEAN: rowData.add(Boolean.toString(cell.getBooleanCellValue()));
                        break;
                    case FORMULA: rowData.add(cell.getCellFormula());
                        break;
                    default: rowData.add("2564");
                }
            }
            allData.add(rowData);
        }
        return toJson(allData);
    }
    private JsonObject toJson(List<List<String>> list){
        JsonObject allOjjects=new JsonObject();
        for(int i=1; i<list.size(); i++){
            JsonObject rowObject= new JsonObject();
            for(int j=0; j< list.get(0).size(); j++){
                rowObject.addProperty(list.get(0).get(j), list.get(i).get(j));
            }
            allOjjects.add("row "+i, rowObject);
        }
        System.out.println(allOjjects);
        return allOjjects;
    }
}
