package com.websystique.springmvc.entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class WriteExcel {

    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private String inputFile;

    public void createContent1(File file) throws IOException, WriteException {
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("ru", "RU"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Result", 0);
        WritableSheet excelSheet = workbook.getSheet(0);

        this.createHeader(excelSheet, 3);

        workbook.write();
        workbook.close();
    }

    public void setOutputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public ArrayList<Tour> write(int hotel, String excursion, String country, String wishes) throws IOException, WriteException {
        File file = new File(inputFile);
        createContent1(new File(inputFile+'1'));
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("ru", "RU"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Result", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel(excelSheet);
        ArrayList<Tour> tourList = createContent(excelSheet, hotel, excursion, country, wishes);

        workbook.write();
        workbook.close();
        return tourList;
    }

    private void createLabel(WritableSheet sheet)
            throws WriteException {
        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        times.setWrap(true);

        // create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(
                WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);
    }

    private WritableCellFormat getHeaderFormat() throws WriteException {

        WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
        cellFont.setColour(Colour.BLACK);

        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(Colour.WHITE);
        return cellFormat;
    }

    private WritableCellFormat getContactsFormat() throws WriteException {

        WritableFont cellFont = new WritableFont(WritableFont.TIMES, 10);
        cellFont.setColour(Colour.BLACK);

        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(Colour.GREY_25_PERCENT);
        return cellFormat;
    }

    private WritableCellFormat getCompanyNameFormat() throws WriteException {

        WritableFont cellFont = new WritableFont(WritableFont.TIMES, 14);
        cellFont.setColour(Colour.BLACK);

        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(Colour.ICE_BLUE);
        return cellFormat;
    }

    private void createHeader(WritableSheet sheet, int startColumn) throws WriteException {
        WritableCellFormat headerStyle = this.getHeaderFormat();
        WritableCellFormat contactStyle = this.getContactsFormat();

        sheet.setColumnView(startColumn+1, 25);
        sheet.setColumnView(startColumn+3, 16);
        sheet.setColumnView(startColumn+4, 25);

        this.addHeaderItem(sheet, startColumn, 0, "Company", headerStyle);
        this.addHeaderItem(sheet, startColumn+1, 0, "Top company", this.getCompanyNameFormat());

        this.addHeaderItem(sheet, startColumn, 1, "Company", headerStyle);
        this.addHeaderItem(sheet, startColumn+1, 1, "Client name", headerStyle);

        this.addHeaderItem(sheet, startColumn, 2, "Delivery", headerStyle);
        this.addHeaderItem(sheet, startColumn+1, 2, "01.03.2019", headerStyle);

        this.addHeaderItem(sheet, startColumn+3, 0, "position",headerStyle);
        this.addHeaderItem(sheet, startColumn+4, 0, "name",headerStyle);
        this.addHeaderItem(sheet, startColumn+5, 0, "phone",headerStyle);
        this.addHeaderItem(sheet, startColumn+6, 0, "fax",headerStyle);
        this.addHeaderItem(sheet, startColumn+7, 0, "skype",headerStyle);

        for(int i = 1; i < 3; i++){
            this.addHeaderItem(sheet, startColumn+3, i, "manager",contactStyle);
            this.addHeaderItem(sheet, startColumn+4, i, "Alex ",contactStyle);
            this.addHeaderItem(sheet, startColumn+5, i, "999-88-66",contactStyle);
            this.addHeaderItem(sheet, startColumn+6, i, "589-78-84",contactStyle);
            this.addHeaderItem(sheet, startColumn+7, i, "qwerty",contactStyle);
        }
    }

    private ArrayList<Tour> createContent(WritableSheet sheet, int hotel, String excursion, String country, String wishes) throws WriteException, RowsExceededException {
//        addCaption(sheet, 3, 3, "Tour number");
//        addCaption(sheet, 4, 3, "Tour cost");
//        addCaption(sheet, 5, 3, "Tour country");
//        addCaption(sheet, 6, 3, "Tour hotel");
//        addCaption(sheet, 7, 3, "Excursion included");

        ArrayList<Tour> tourList = new ArrayList<Tour>();
        ArrayList<Tour> resultTourList = new ArrayList<Tour>();
        tourList.add(new Tour("en","on",3,5500));
        tourList.add(new Tour("en",null,4,7800));
        tourList.add(new Tour("en","on",5,10000));
        tourList.add(new Tour("en","on",1,3000));
        tourList.add(new Tour("en","on",2,4400));
        tourList.add(new Tour("en",null,3,5500));
        tourList.add(new Tour("en",null,3,3600));
        tourList.add(new Tour("fr","on",3,9500));
        tourList.add(new Tour("fr",null,2,4400));
        tourList.add(new Tour("us","on",3,5500));
        tourList.add(new Tour("by","on",3,5500));
        tourList.add(new Tour("us",null,3,5500));

        addCaption(sheet, 8, 3, "Wishes");
        addLabel(sheet, 8, 4, wishes);
        int i = 4, number = 1;
        for (Tour temp : tourList){
            if(temp.fit(hotel, excursion, country)){
                addNumber(sheet, 3, i, number);
                addNumber(sheet, 4, i, temp.getCost());
                addLabel(sheet, 5, i, temp.getCountry());
                addNumber(sheet, 6, i, temp.getHotel());
                addLabel(sheet, 7, i, temp.getExcursion()==null ? "No": "Yes");
                i++;
                number++;
                resultTourList.add(temp);
            }
        }

        createHeader(sheet, 0);
        for (i = 1; i < 1; i++) {
            // First column
            addNumber(sheet, 0, i, i + 10);
            // Second column
            addNumber(sheet, 1, i, i * i);
        }
        return resultTourList;
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s)
            throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s, timesBoldUnderline);
        sheet.addCell(label);
    }

    private void addNumber(WritableSheet sheet, int column, int row,
                           Integer integer) throws WriteException, RowsExceededException {
        Number number;
        number = new Number(column, row, integer, times);
        sheet.addCell(number);
    }

    private void addHeaderItem(WritableSheet sheet, int column, int row, String text, WritableCellFormat style) throws WriteException {
        Label label;
        label = new Label(column, row, text,style);
        sheet.addCell(label);
    }

    private void addLabel(WritableSheet sheet, int column, int row, String s)
            throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        sheet.addCell(label);
    }

}
