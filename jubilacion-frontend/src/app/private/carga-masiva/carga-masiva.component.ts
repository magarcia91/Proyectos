import { Component, OnInit } from '@angular/core';
import { EncuestaDataService } from 'src/app/core/services/encuesta-data.service';
import { RegistroDataService } from 'src/app/core/services/registro-data.service';
import * as XLSX from 'xlsx';
import { Registro } from '../../core/models/interfaces/registro.model';
import { ViewChild } from '@angular/core';
import { ElementRef } from '@angular/core';
import Swal from 'sweetalert2';
import { EncuestaExcel } from 'src/app/core/models/interfaces/encuestaExcel.model';
import { EstudianteEncuesta } from 'src/app/core/models/interfaces/estudianteEncuesta.model';
import { Encuesta } from 'src/app/core/models/interfaces/encuesta.model';

@Component({
  selector: 'app-carga-masiva',
  templateUrl: './carga-masiva.component.html',
  styleUrls: ['./carga-masiva.component.scss']
})
export class CargaMasivaComponent implements OnInit {
  @ViewChild('myInput')
  myInputVariable: ElementRef;

  @ViewChild('myInputSocio')
  myInputVariableSocio: ElementRef;
  @ViewChild('myInputPedagogico')
  myInputVariablePedagogico: ElementRef;
  data:any;
  encuestasRegistradasSocio:any;
  encuestasRegistradasPedagogico:any;
  tipoSocioemocional=1;
  tipoPedagogico=2;
  constructor(
    private _registroService: RegistroDataService,
    private _encuestaService:EncuestaDataService
  ) { }
  
  ngOnInit(): void {
    this.data=null;
    this.encuestasRegistradasSocio=null;
    this.encuestasRegistradasPedagogico=null;
  }
  onFileChange(evt: any) {
    /* wire up file reader */
    const target: DataTransfer = <DataTransfer>evt.target;
    if (target.files.length !== 1) throw new Error('Cannot use multiple files');
    const reader: FileReader = new FileReader();
    reader.onload = (e: any) => {
      /* read workbook */
      const bstr: string = e.target.result;
      const wb: XLSX.WorkBook = XLSX.read(bstr, { type: 'binary' });

      // grab first sheet 
      const wsname: string = wb.SheetNames[10];
      
      const ws: XLSX.WorkSheet = wb.Sheets[wsname];
       /*save data */
       this.data =<Registro[]> XLSX.utils.sheet_to_json(ws, { header: 2 });
      
    };
    reader.readAsBinaryString(target.files[0]);
  }
  onFileChangeSocio(evt: any) {
    /* wire up file reader */
    const target: DataTransfer = <DataTransfer>evt.target;
    if (target.files.length !== 1) throw new Error('Cannot use multiple files');
    const reader: FileReader = new FileReader();
    reader.onload = (e: any) => {
      /* read workbook */
      const bstr: string = e.target.result;
      const wb: XLSX.WorkBook = XLSX.read(bstr, { type: 'binary' });

      // grab first sheet 
       const wsnameEncuesta: string = wb.SheetNames[10];
      const wsEncuesta: XLSX.WorkSheet = wb.Sheets[wsnameEncuesta];
      this.encuestasRegistradasSocio =<EncuestaExcel[]> XLSX.utils.sheet_to_json(wsEncuesta, { header: 2 });
      
    };
    reader.readAsBinaryString(target.files[0]);
  }
  onFileChangePedagogico(evt: any) {
    /* wire up file reader */
    const target: DataTransfer = <DataTransfer>evt.target;
    if (target.files.length !== 1) throw new Error('Cannot use multiple files');
    const reader: FileReader = new FileReader();
    reader.onload = (e: any) => {
      /* read workbook */
      const bstr: string = e.target.result;
      const wb: XLSX.WorkBook = XLSX.read(bstr, { type: 'binary' });

      // grab first sheet 
       const wsnameEncuesta: string = wb.SheetNames[12];
      const wsEncuesta: XLSX.WorkSheet = wb.Sheets[wsnameEncuesta];
      this.encuestasRegistradasPedagogico =<EncuestaExcel[]> XLSX.utils.sheet_to_json(wsEncuesta, { header: 2 });
      
    };
    reader.readAsBinaryString(target.files[0]);
  }
  reset() {
    this.data=null;
    console.log(this.myInputVariable.nativeElement.files);
    this.myInputVariable.nativeElement.value = "";
    console.log(this.myInputVariable.nativeElement.files);
  }
  resetSocio() {
    this.encuestasRegistradasSocio=null;
    console.log(this.myInputVariableSocio.nativeElement.files);
    this.myInputVariableSocio.nativeElement.value = "";
    console.log(this.myInputVariableSocio.nativeElement.files);
  }
  resetPedagogico() {
    this.encuestasRegistradasPedagogico=null;
    console.log(this.myInputVariablePedagogico.nativeElement.files);
    this.myInputVariablePedagogico.nativeElement.value = "";
    console.log(this.myInputVariablePedagogico.nativeElement.files);
  }
  enviarInformacion(){
    try { 
      let registrosIngresados=0;
      this.data.forEach(element => {
        let registro = {
          documentoIdentidad: element.documentoIdentidad,
          nombre: element.nombre,
          fechaNacimiento: element.fechaNacimiento,
          genero: element.genero,
          discapacidad: element.discapacidad,
          nacionalidad: element.nacionalidad,
          etnia:element.etnia,
          celular:element.celular,
          direccion: element.direccion,
          movilidadHumana:element.movilidadHumana,
          conectividad:element.conectividad,
          cambio_vivienda:element.cambio_vivienda,
          IE_cerca:element.IE_cerca,
          sede: element.sede,
          grado: element.grado,
          esMatriculado: element.esMatriculado,
          peso: element.peso,
          talla: element.talla,
          comidasAlDia: element.comidasAlDia,
          visitaMedico: element.visitaMedico,
          estIdentidad:element.id
        };
        this._registroService.guardarRegistroExcel(registro).subscribe((rest: any) => {
          //Swal.fire('Información almacenada correctamente. Codigo: ' + respuesta.codigoRespuesta, '', 'success');
        }, (error) => {
         // Swal.fire('No se pudo almacenar la información', '', 'error');
        });
        
        registrosIngresados++;
      });
      this.reset();
      if (registrosIngresados==0) {
        Swal.fire('Archivo sin información para registrar', '', 'warning');
      } else {
        Swal.fire("Registros ingresados correctamente!", '', 'success');
      }
     
    } catch (error) {
      Swal.fire('No se pudo almacenar la información', '', 'error');
    }
       
      
  }

  enviarInformacionSocio(){
    try { 
      let registrosIngresados=0;
      let estudiantesExcel=[];
      let respuestasAux:EncuestaExcel[]=[];
      this.encuestasRegistradasSocio.forEach(element => {
        let estudiante=estudiantesExcel.find(estudianteBuscar => estudianteBuscar === element.estCodigo);
        respuestasAux.push(element);
        if (estudiante==null) {
          estudiantesExcel.push(element.estCodigo);
        }
      });
      estudiantesExcel.forEach(estudianteIngreso => {
        this._encuestaService.consultarEncuestaPorIdentidad(estudianteIngreso).subscribe(
          (estudiante:any)=>{
            if(estudiante==null ){
              //Swal.fire('El estudiante no se encuentra registrado','','warning'); 
            }else{
              this._encuestaService.consultarEncuestaPorEstudiante(this.tipoSocioemocional,estudiante.estCodigo).subscribe(
                (encuestaEncontrada:EstudianteEncuesta[])=>{
                  if (encuestaEncontrada.length==0) {
                    let respuestasExcel:EncuestaExcel[]=[];
                    respuestasAux.forEach(encuestaRegistrada => {
                      if (encuestaRegistrada.estCodigo==estudianteIngreso) {
                        respuestasExcel.push(encuestaRegistrada);
                      }
                    });
                    respuestasExcel.forEach(respuestaPorEnviar => {
                      let respuestaEnviar={
                        encEstado:respuestaPorEnviar.encEstado,//estado activo
                        preCodigo:respuestaPorEnviar.preCodigo,
                        resCodigo:respuestaPorEnviar.resCodigo,
                        estCodigo:estudiante.estCodigo
                      }
                      this._encuestaService.guardarEncuesta(respuestaEnviar).subscribe(element=>{
                  
                      });
                    });
                   
                  } else {
                   //Swal.fire('El estudiante ya registra una encuesta','','warning');
                  }
                }
              );
            }
            
          }
        );
        registrosIngresados++;
      });

     
      this.resetSocio();
      if (registrosIngresados==0) {
        Swal.fire('Archivo sin información para registrar', '', 'warning');
      } else {
        Swal.fire("Encuestas ingresadas correctamente!", '', 'success');
      }
     
    } catch (error) {
      Swal.fire('No se pudo almacenar la información', '', 'error');
    } 
  }
  
  enviarInformacionPedagogico(){
    try { 
      let registrosIngresados=0;
      let estudiantesExcel=[];
      let respuestasAux:EncuestaExcel[]=[];
      this.encuestasRegistradasPedagogico.forEach(element => {
        let estudiante=estudiantesExcel.find(estudianteBuscar => estudianteBuscar === element.estCodigo);
        respuestasAux.push(element);
        if (estudiante==null) {
          estudiantesExcel.push(element.estCodigo);
        }
      });
     
      estudiantesExcel.forEach(estudianteIngreso => {
        this._encuestaService.consultarEncuestaPorIdentidad(estudianteIngreso).subscribe(
          (estudiante:any)=>{
            if(estudiante==null ){
              //Swal.fire('El estudiante no se encuentra registrado','','warning'); 
            }else{
              this._encuestaService.consultarEncuestaPorEstudiante(this.tipoPedagogico,estudiante.estCodigo).subscribe(
                (encuestaEncontrada:EstudianteEncuesta[])=>{
                  if (encuestaEncontrada.length==0) {
                    let respuestasExcel:EncuestaExcel[]=[];
                    respuestasAux.forEach(encuestaRegistrada => {
                      if (encuestaRegistrada.estCodigo==estudianteIngreso) {
                        respuestasExcel.push(encuestaRegistrada);
                      }
                    });
                    respuestasExcel.forEach(respuestaPorEnviar => {
                      let respuestaEnviar={
                        encEstado:respuestaPorEnviar.encEstado,//estado activo
                        preCodigo:respuestaPorEnviar.preCodigo,
                        resCodigo:respuestaPorEnviar.resCodigo,
                        estCodigo:estudiante.estCodigo
                      }
                      this._encuestaService.guardarEncuesta(respuestaEnviar).subscribe(element=>{
                  
                      });
                    });
                   
                  } else {
                   //Swal.fire('El estudiante ya registra una encuesta','','warning');
                  }
                }
              );
            }
            
          }
        );
        registrosIngresados++;
      });

     
      this.resetPedagogico();
      if (registrosIngresados==0) {
        Swal.fire('Archivo sin información para registrar', '', 'warning');
      } else {
        Swal.fire("Encuestas ingresadas correctamente!", '', 'success');
      }
     
    } catch (error) {
      Swal.fire('No se pudo almacenar la información', '', 'error');
    } 
  }
  
}
