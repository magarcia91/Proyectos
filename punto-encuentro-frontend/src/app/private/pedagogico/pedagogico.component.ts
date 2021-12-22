import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/core/services/authService';
import Swal from 'sweetalert2';
import { Encuesta } from '../../core/models/interfaces/encuesta.model';
import { Pregunta } from '../../core/models/interfaces/pregunta.model';
import { Respuesta } from '../../core/models/interfaces/respuesta.model';
import { EncuestaDataService } from '../../core/services/encuesta-data.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { EstudianteEncuesta } from '../../core/models/interfaces/estudianteEncuesta.model';

@Component({
  selector: 'app-pedagogico',
  templateUrl: './pedagogico.component.html',
  styleUrls: ['./pedagogico.component.scss']
})
export class PedagogicoComponent implements OnInit {
  public frmPedagogico : FormGroup;

  listaPreguntas: Pregunta[]=[];
  tipoPedagogico=2; 
  constructor(
    private readonly fb:FormBuilder,
    private _encuestaService:EncuestaDataService,
    public authService: AuthService,
    public spinner: NgxSpinnerService
  ) { }

  ngOnInit(): void {
    this.authService.validateLogin('private/pedagogico');
    this.frmPedagogico = this.fb.group({
      opcion:[null],
      cedula:[null],
      codigoEstudiante:[null],
      nombres:[null],
      codigoGrado:[null],
      grado:[null],
      texto:[null],
      preguntas: new  FormArray([])
    });
  }
// assign the values
cargarPreguntasFrom(preCodigo, prePregunta,prePresentar) {
  return this.fb.group({
    preCodigo: [preCodigo],
    prePregunta: [prePregunta],
    prePresentar:[prePresentar],
    respuesta:[null],
    respuestaMultiple:new  FormArray([])
  })    
}

cargarCheckBox(resCodigo, resRespuesta) {
  return this.fb.group({
    resCodigo: [resCodigo],
    resRespuesta: [resRespuesta],
    estado:[false]
  })    
}
buscarEstudiante(){
  this.limpiarPreguntas();
  this.spinner.show();
  let opcion=this.frmPedagogico.get("opcion").value;
  if(opcion==1){
    this._encuestaService.consultarEncuestaPorCedula(this.frmPedagogico.get("cedula").value).subscribe(
      (estudiante:any)=>{
        if(estudiante==null ){
          this.spinner.hide();
          Swal.fire('El estudiante no se encuentra registrado','','warning'); 
        }else{
          this._encuestaService.consultarEncuestaPorEstudiante(this.tipoPedagogico,estudiante.estCodigo).subscribe(
            (encuestaEncontrada:EstudianteEncuesta[])=>{
              if (encuestaEncontrada.length==0) {
                this.frmPedagogico.patchValue({
                  codigoEstudiante:[estudiante.estCodigo], 
                  nombres:[estudiante.estNombre],
                  codigoGrado:[estudiante.codigo],
                  grado:[estudiante.descripcion]
                });
                this.cargarEncuestaPedagogica(estudiante.codigo);
               } else {
                this.spinner.hide();
                Swal.fire('El estudiante ya registra una encuesta','','warning');
               }
            }
          );

        }
        
      }
    );
  }
  if(opcion==0){
    this._encuestaService.consultarEncuestaPorCodigo(this.frmPedagogico.get("cedula").value).subscribe(
      (estudiante:any)=>{
        if(estudiante==null ){
          this.spinner.hide();
          Swal.fire('El estudiante no se encuentra registrado','','warning'); 
        }else{
          this._encuestaService.consultarEncuestaPorEstudiante(this.tipoPedagogico,estudiante.estCodigo).subscribe(
            (encuestaEncontrada:EstudianteEncuesta[])=>{
              if (encuestaEncontrada.length==0) {
                this.frmPedagogico.patchValue({
                  codigoEstudiante:[estudiante.estCodigo], 
                  nombres:[estudiante.estNombre],
                  codigoGrado:[estudiante.codigo],
                  grado:[estudiante.descripcion]
                });
                this.cargarEncuestaPedagogica(estudiante.codigo);
               } else {
                this.spinner.hide();
                Swal.fire('El estudiante ya registra una encuesta','','warning');
               }
            }
          );

        }
      }
    );
  }
  
}
cargarEncuestaPedagogica(id_grado:number){
  
 /* this._encuestaService.consultarTextoPorGrado(id_grado).subscribe(
    texto=>{
      this.frmPedagogico.patchValue({   
        texto:[texto[0].txt_texto]
      });
    }
  );*/
  this._encuestaService.consultarPreguntaPorTipoGrado(this.tipoPedagogico,id_grado).subscribe(
    preguntas=>{
      this.listaPreguntas=preguntas;
      const control = <FormArray>this.frmPedagogico.get('preguntas');
      control.clear();
      this.listaPreguntas.forEach(element => {
        
          control.push(this.cargarPreguntasFrom(element.preCodigo, element.prePregunta,element.prePresentar));
          this._encuestaService.consultarRespuestasPregunta(element.preCodigo).subscribe(
            respuesta=>{
              element.respuestas=respuesta;
            }
          );
        
       
        
      });
      this.spinner.hide();
    }
  );
 
}
 obtenerRespuestas(index:number) :Respuesta[]{

  return this.listaPreguntas[index].respuestas;
}
opcionMultiple(index:number) : boolean{
  let tipo=this.listaPreguntas[index].prePresentar;
  if (tipo==1) {
    return false;
  } else {
    if(tipo==0){

      const control = <FormArray>this.frmPedagogico.get("preguntas");
      const control1=<FormArray>control.at(index).get("respuestaMultiple");
      if(control1.length==0){
        let respuestas=this.listaPreguntas[index].respuestas
        if (respuestas!=null) {
          respuestas.forEach(element => {
            control1.push(this.cargarCheckBox(element.resCodigo,element.resRespuesta));
          });
        }
       
      }
   
       
       return true;
    }else
    {return false}
  }
}
getmultiples(index:number): FormArray {
  const control = <FormArray>this.frmPedagogico.get("preguntas");
  return control.at(index).get("respuestaMultiple") as FormArray;;
}
getPregunta(pregunta:number): String{
  let texto =this.listaPreguntas[pregunta].prePregunta;
  return texto;
}
getRespuesta(pregunta:number,respuesta:number): String{
  
  let respuestas =this.listaPreguntas[pregunta].respuestas
  let texto=respuestas[respuesta].resRespuesta;
  return texto;
}
guardarEncuesta(){
  let lista=this.frmPedagogico.get("preguntas").value;
  var codigoEstudiante:number=this.frmPedagogico.get("codigoEstudiante").value*1;
  let  jsonEnvio: Encuesta[]=[];
  lista.forEach(element => {
    
    if (element.prePresentar==1) {
      //console.log("idpregunta "+element.preCodigo+" respuesta "+element.respuesta);
      let respuestaObtenida={
        encEstado:1,//estado activo
        preCodigo:element.preCodigo,
        resCodigo:element.respuesta,
        estCodigo:codigoEstudiante
      }
      jsonEnvio.push(respuestaObtenida);
    } else {
      //console.log("multiple idpregunta "+element.preCodigo+" respuesta "+element.prePresentar);
      let multiples=element.respuestaMultiple;
      multiples.forEach(element1 => {
        
        if(element1.estado==true){
         // console.log("op "+element1.resCodigo+" es "+element1.estado);
          let respuestaObtenida={
            encEstado:1,//estado activo
            preCodigo:element.preCodigo,
            resCodigo:element1.resCodigo,
            estCodigo:codigoEstudiante
          }
          jsonEnvio.push(respuestaObtenida);
        }
      });
    }
    
  });
  try {
    jsonEnvio.forEach(elementjson => {
     // console.log("lista "+elementjson.resCodigo);
      this._encuestaService.guardarEncuesta(elementjson).subscribe(element=>{
        
      });
    });
    Swal.fire('Información almacenada correctamente.','','success');
    this.limpiarFormulario();
  } catch (error) {
    Swal.fire('No se pudo almacenar la información','','error');
  }
  
}
limpiarFormulario(){
  this.frmPedagogico = this.fb.group({
    opcion:[null],
    cedula:[null],
    codigoEstudiante:[null],
    nombres:[null],
    codigoGrado:[null],
    grado:[null],
    texto:[null],
    preguntas: new  FormArray([])
  });
}

limpiarPreguntas(){
  this.listaPreguntas=[];
  this.frmPedagogico.patchValue({
    codigoEstudiante:[null],
    nombres:[null],
    codigoGrado:[null],
    grado:[null],
    texto:[null],
    preguntas: []
  });
}
}
