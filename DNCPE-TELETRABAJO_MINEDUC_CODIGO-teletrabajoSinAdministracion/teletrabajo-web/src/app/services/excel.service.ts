import { Injectable } from '@angular/core';
import { DatePipe } from '@angular/common';
import * as Excel from 'exceljs/dist/exceljs.min.js';
import * as fs from 'file-saver';

@Injectable()
export class ExcelService {

  constructor(private datePipe: DatePipe) {

  }

  async generateExcel(datos: any, header: any[]) {


    // const ExcelJS = await import('exceljs');
    // console.log(ExcelJS);
    // const Workbook: any = {};

    // Excel Title, Header, Data
    const title = 'Reporte';

    // Create workbook and worksheet
    const workbook = new Excel.Workbook()
    const worksheet = workbook.addWorksheet('Ganadores');


    // Add Row and formatting
    const titleRow = worksheet.addRow([title]);
    titleRow.font = { name: 'Comic Sans MS', family: 4, size: 16, underline: 'double', bold: true };
    worksheet.addRow([]);
    const subTitleRow = worksheet.addRow(['Date : ' + this.datePipe.transform(new Date(), 'medium')]);




    // Blank Row
    worksheet.addRow([]);

    // Add Header Row
    const headerRow = worksheet.addRow(header);

    // Cell Style : Fill and Border
    headerRow.eachCell((cell, number) => {
      cell.fill = {
        type: 'pattern',
        pattern: 'solid',
        fgColor: { argb: 'FFFFFF00' },
        bgColor: { argb: 'FF0000FF' }
      };
      cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } };
    });
    // worksheet.addRows(data);


    // Add Data and Conditional Formatting
    datos.forEach(d => {
      const row = worksheet.addRow(d);
    }

    );
    worksheet.addRow([]);



    // Generate Excel File with given name
    workbook.xlsx.writeBuffer().then((data: any) => {
      const blob = new Blob([data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
      fs.saveAs(blob, 'Reporte.xlsx');
    });

  }
}
