import { Component, OnInit } from '@angular/core';
import { EncuestaService } from 'app/services/encuesta.service';
import { AuthService } from 'app/services/AuthService';
import Swal from 'sweetalert2';
import { AgendaService } from 'app/services/agenda.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { ListaEncuestasDialogComponent } from './dialog/lista-encuestas-dialog.component';

@Component({
  selector: 'app-encuesta',
  templateUrl: './encuesta.component.html',
  styleUrls: ['./encuesta.component.scss']
})
export class EncuestaComponent implements OnInit {
  //arreglos
  preguntas: any[];
  nombreEncuesta: String;
  descripcionEncuesta: String;
  existeEncuestaParametrizada: boolean; 
  listadoRespuestasGuardar: any[];
  autorizadoCompletarEncuesta: boolean;
  bloquearBotonGuardarEncuesta:boolean;
  estadoEncuesta:string; 

  constructor(private encuestaService:EncuestaService, 
    private authService: AuthService, 
    private agendaService: AgendaService, 
    public router: Router,
    public dialog: MatDialog) { }

  ngOnInit() {
    if (localStorage.getItem('token') === null) {
      localStorage.clear();
    }
    this.authService.validateLogin('encuesta');
    if (this.authService.isLoggedIn() && localStorage.getItem('cambioObligatorioClave') !== 'true') {
      this.validarCabeceraRegistro();      
    }
  }

  validarCabeceraRegistro() {
    this.agendaService.getCabecera().subscribe((res: any) => {      
      var cabecera = res;
      if(cabecera.oferta === null) {
        this.router.navigate(['datosDocente']);                
        Swal.fire({
          title: '¡Información personal pediente por completar!',
          text: "Por favor, registre sus datos.",
          icon: 'warning',                
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Aceptar'
        });
      }else if(localStorage.getItem('habilitadaEncuesta') == 'true' && cabecera.mostrarEncuesta){        
        if(localStorage.getItem('codigoEncuesta') != undefined && localStorage.getItem('codigoEncuesta') != 'null'){         
          this.estadoEncuesta = localStorage.getItem('estadoEncuesta');
          this.autorizadoCompletarEncuesta=true;
          this.bloquearBotonGuardarEncuesta = false;
          this.listarPreguntas();
        }else{          
          this.listaEncuestas();
        }
        
      }else{
        this.autorizadoCompletarEncuesta=false;
      }      
    });
  }

  listaEncuestas() { 
    localStorage.setItem('codigoEncuesta', null);
    localStorage.setItem('estadoEncuesta', null);
    localStorage.setItem('codigoEstadoEncuesta', null);   
    const dialogRef = this.dialog.open(ListaEncuestasDialogComponent, {
      data: {dashboard: false},     
      disableClose: true,
    });    
  }

  listarPreguntas(){    
    this.encuestaService.getPreguntas().subscribe((res: any) => {      
      this.preguntas = res.preguntas;
      this.cargarValidacionesPreguntasEncuesta();      
      this.nombreEncuesta = res.nombreEncuesta;
      this.descripcionEncuesta = res.descripcionEncuesta;
      this.existeEncuestaParametrizada = res.existeEncuestaParametrizada;      
    });
  }

  cargarValidacionesPreguntasEncuesta(){
    this.preguntas.forEach(pregunta=>{
      this.validacionesPreguntas(pregunta);
      if(pregunta.nemonico === 'MULT'){
        var codigosRespuesta: any[]= new Array();
        pregunta.respuestasOpcionMultiple.forEach(respuesta => {
          codigosRespuesta.push(respuesta.valorOpcion);
        });
        pregunta.codigosRespuestasOpcMultiple=codigosRespuesta;
      }
    });
  }


  //BLOQUE DE VALIDACIONES DE PREGUNTAS
  validacionesPreguntas(preguntaParametro:any){      
    preguntaParametro.sinRespuesta = false;
    preguntaParametro.valorInvalido = false;
    preguntaParametro.mensajeInvalido=null;
    this.validarPreguntasDependientes(preguntaParametro);
    this.limpiarPreguntasOpcionMultiple(preguntaParametro);
    this.validarPreguntasConRangoEstablecidoPorPadre(preguntaParametro);
  }
  

  validarPreguntasDependientes(preguntaParametro:any){
    if(preguntaParametro.habilitarPregunta!=null){
      this.preguntas.forEach(pregunta =>{                              
        if(this.existeCodigoPreguntaHabilitar(pregunta.codItemCatalogo, preguntaParametro.habilitarPregunta)){                          
          pregunta.preguntaDeshabilitada=preguntaParametro.valorHabilitante!=1;
          if(pregunta.preguntaDeshabilitada){
            this.resetearRespuesta(pregunta.respuesta);
          }                                  
        }
      });
    }
  }

  validarPreguntasConRangoEstablecidoPorPadre(preguntaParametro:any){
    if(preguntaParametro.nemonico == 'INT' || preguntaParametro.nemonico == 'DEC'){            
      var preguntasRangosPadre: any[] = this.preguntas.filter((pregunta) => pregunta.rangoValidacionEstablecidoPorPadre == preguntaParametro.codItemCatalogo);     
      if(preguntaParametro.respuesta!= undefined && preguntaParametro.respuesta!= null){
        preguntasRangosPadre.forEach(pregunta=>{
          pregunta.valorMinimo = preguntaParametro.valorMinimo;      
          pregunta.valorMaximo = (preguntaParametro.nemonico == 'INT')?preguntaParametro.respuesta.valorEntero:preguntaParametro.respuesta.valorDecimal;
        });        
      }   
    }
  }

  existeCodigoPreguntaHabilitar(codigoPreguntaActual:number, codigosPreguntasHabilitar:string){    
    var codigosHabilitar:string[] = codigosPreguntasHabilitar.split(",");    
    var filtroCodigos =   codigosHabilitar.find(x=> Number(x) == (codigoPreguntaActual));    
    return filtroCodigos!=undefined && filtroCodigos.length>0;
  }

  limpiarPreguntasOpcionMultiple(preguntaParametro:any){
    if(preguntaParametro.nemonico == 'OPC'){      
      var preguntaPadre =   this.preguntas.find(pregunta=> pregunta.codItemCatalogo == preguntaParametro.itemCatalogoPadre);
      if(preguntaPadre != undefined){
        var preguntasHijas: any[] = preguntaPadre.opcionesPregunta;
        preguntasHijas.forEach(hija =>{
          if(hija.codItemCatalogo != preguntaParametro.codItemCatalogo && hija.habilitarPregunta != null){
            var codigosHabilitar:string[] = hija.habilitarPregunta.split(",");
            codigosHabilitar.forEach(codigo=>{
              this.preguntas.forEach(pregunta=>{
                if(pregunta.codItemCatalogo == Number(codigo)){
                  pregunta.preguntaDeshabilitada=true;   
                  if(pregunta.nemonico === 'MULT'){
                    pregunta.codigosRespuestasOpcMultiple = new Array();
                  }else{
                    this.resetearRespuesta(pregunta.respuesta);
                  }                         
                }
              });
            })
          }
        });
      }      
    }
  }  

  resetearRespuesta(respuesta:any){
    respuesta.codRegistroEncuesta= 0;
    respuesta.telCabeceraRegistro= null;
    respuesta.telPregunta= null;
    respuesta.valorBooleano= null;
    respuesta.valorDecimal= null;
    respuesta.valorEntero= null;
    respuesta.valorTexto= null;
    respuesta.valorOpcion= null;
  }
  //FIN BLOQUE DE VALIDACIONES DE PREGUNTAS

  //BLOQUE DE VALIDACIONES DE RESPUESTAS
  validacionesRespuestas(){
    var totalPreguntasSinRespuesta:any = 0;
    var totalPreguntasInvalidas:any = 0;    
    this.preguntas.forEach(pregunta =>{      
      if(!pregunta.preguntaDeshabilitada){               
        if(this.existePreguntaSinRespuesta(pregunta)){
          pregunta.sinRespuesta = true;
          totalPreguntasSinRespuesta++;
        }else{ 
          pregunta.valorInvalido =  false;            
          pregunta.mensajeInvalido = null; 
          pregunta.sinRespuesta = false;                             
          if(pregunta.nemonico=='INT' || pregunta.nemonico=='DEC'){           
            this.cumpleConRangosEstablecidos(pregunta, pregunta.nemonico=='INT'?pregunta.respuesta.valorEntero:pregunta.respuesta.valorDecimal);
            if(!pregunta.valorInvalido){
              this.cumpleCondicionPreguntasConComplemento(pregunta);
            }            
          }                             
          if(pregunta.valorInvalido){
            totalPreguntasInvalidas++;
          }  
        }
      }      
    });    
    return totalPreguntasSinRespuesta>0 || totalPreguntasInvalidas>0;
  }

  existePreguntaSinRespuesta(pregunta: any){
    return pregunta.nemonico==='MULT'?pregunta.codigosRespuestasOpcMultiple.length==0:
    pregunta.respuesta.codRegistroEncuesta == 0 &&
    pregunta.respuesta.telCabeceraRegistro == null &&
    pregunta.respuesta.telPregunta == null &&
    pregunta.respuesta.valorBooleano == null&&
    pregunta.respuesta.valorDecimal == null&&
    pregunta.respuesta.valorEntero == null&&
    pregunta.respuesta.valorTexto == null&&
    pregunta.respuesta.valorOpcion == null; 
  }

  cumpleConRangosEstablecidos(pregunta: any, valorComparar: any){    
    pregunta.valorInvalido =  (valorComparar < pregunta.valorMinimo || valorComparar > pregunta.valorMaximo);            
    pregunta.mensajeInvalido= 'Valor inválido. Recuerde: La respuesta debe ser un número entero entre '+pregunta.valorMinimo+' y '+pregunta.valorMaximo+'.';          
  }

  cumpleCondicionPreguntasConComplemento(preguntaEvaluar: any){
    //validacion de complemento
    if(preguntaEvaluar.valorComplemento != null){
      var preguntaPadre =   this.preguntas.find(pregunta=> pregunta.codItemCatalogo == preguntaEvaluar.valorComplemento);
      if(preguntaPadre != undefined){                
        var complementos: any[] = this.preguntas.filter((elemento) => !elemento.preguntaDeshabilitada && elemento.valorComplemento == preguntaPadre.codItemCatalogo);
        if(complementos.length>0){
          var sumaComplemento: number = 0;
          complementos.forEach(preguntaComplementaria => sumaComplemento += (preguntaComplementaria.nemonico=='INT')?preguntaComplementaria.respuesta.valorEntero:preguntaComplementaria.respuesta.valorDecimal);
          var valorComparar:number = (preguntaPadre.nemonico=='INT')?preguntaPadre.respuesta.valorEntero:preguntaPadre.respuesta.valorDecimal;
          var complementoCorrecto:boolean = sumaComplemento == valorComparar;     
          if(!complementoCorrecto){            
            preguntaPadre.valorInvalido = true;
            preguntaPadre.mensajeInvalido= 'Existen preguntas asociadas que no cumplen con la condición de suma complementaria.';                     
            complementos.forEach(preguntaComplementaria => {
              preguntaComplementaria.valorInvalido = true;
              preguntaComplementaria.mensajeInvalido= 'Valor inválido. Recuerde: La suma total de las preguntas complementarias deben dar el valor de '+valorComparar+'.';
            });      
          }
        }
      }      
    }    
  }  
  //FIN BLOQUE DE VALIDACIONES DE RESPUESTAS
   

  recuperarRespuestas(){
    this.listadoRespuestasGuardar= new Array(); 
    this.preguntas.forEach(pregunta =>{
      if(!pregunta.preguntaDeshabilitada){         
        if(pregunta.nemonico=='MULT'){
          pregunta.codigosRespuestasOpcMultiple.forEach(codigoRespuesta => {
            var seleccionado = pregunta.respuestasOpcionMultiple.find(respuesta=> respuesta.valorOpcion == codigoRespuesta);
            if(seleccionado == undefined){
              var respuestaOpcionMultiple= {
                telPregunta: {codItemCatalogo: pregunta.codItemCatalogo},
                valorOpcion: codigoRespuesta
              };
              this.listadoRespuestasGuardar.push(respuestaOpcionMultiple);
            }else{
              seleccionado.telPregunta ={codItemCatalogo: pregunta.codItemCatalogo};
              this.listadoRespuestasGuardar.push(seleccionado);
            }            
          });
        }else{               
          pregunta.respuesta.telPregunta = {codItemCatalogo: pregunta.codItemCatalogo};        
          if(pregunta.nemonico=='INT'){
            pregunta.respuesta.valorEntero = parseInt(pregunta.respuesta.valorEntero);
          }
          this.listadoRespuestasGuardar.push(pregunta.respuesta);
        }
        
      }
    })
  }

  enviarEncuesta(){
    if(this.validacionesRespuestas()){
      Swal.fire('Atención','Existen preguntas sin contestar o erróneas. Por favor verifique.','warning');
    }else{      
      this.recuperarRespuestas();
      this.bloquearBotonGuardarEncuesta = true;
      var encuestaSalvar = {
        respuestas:this.listadoRespuestasGuardar,
        encuesta:{codCatalogo:Number(localStorage.getItem('codigoEncuesta'))},
        estadoEncuesta: (localStorage.getItem('codigoEstadoEncuesta') != undefined && localStorage.getItem('codigoEstadoEncuesta') != '0'? {codEncuestaEstado: Number(localStorage.getItem('codigoEstadoEncuesta'))}:null)
      };                
      this.encuestaService.guardarRespuestas(encuestaSalvar).subscribe((res: any) => {          
        if(res.codigoError === 0) {                                
          Swal.fire({
            title: 'Atención',
            text: "Preguntas guardadas correctamente",
            icon: 'success',                
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            allowOutsideClick: false,
            confirmButtonText: 'Aceptar'
          }).then((result) => {
            if (result.value) {
              localStorage.setItem('codigoEncuesta', null);
              localStorage.setItem('estadoEncuesta', null);
              localStorage.setItem('codigoEstadoEncuesta', null);
              location.reload();              
            }
          });                           
        } else {
          Swal.fire('Atención','Error al guardar las respuestas de la encuesta: '+res.mensaje+ '. Por favor intente más tarde o comuníquese con el administrador del sistema.','error');
        }
      });
    }    
  }

}
