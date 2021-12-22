import { Component, OnInit } from '@angular/core';
import { Usuario } from 'app/entity/Usuario';
import { UsuarioService } from 'app/services/usuario.service';
import { OfertaEducativa } from 'app/enums/oferta-educativa.enum';
import { AuthService } from 'app/services/AuthService';
import { CabeceraRegistro } from 'app/entity/CabeceraRegistro';
import { Distrito } from 'app/entity/Distrito';
import { InsEducativa } from 'app/entity/InsEducativa';
import { ItemCatalogo } from 'app/entity/ItemCatalogo';
import Swal from 'sweetalert2';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { NivelRegistro } from 'app/entity/NivelRegistro';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-datos-docente',
  templateUrl: './datos-docente.component.html',
  styleUrls: ['./datos-docente.component.scss']
})
export class DatosDocenteComponent implements OnInit {
  //formulario
  formularioUsuario: FormGroup;
  //arreglos
  ofertasEducativas: any[];
  funcionesUsuario: any[];
  zonas: any[];
  provincias: any[];
  distritos: any[];  
  institucionesEducativas: any[];
  regimenes: any[];
  nivelesSubniveles: ItemCatalogo[];
  nivelesSubnivelesSeleccionados: ItemCatalogo[] = new Array();
  distritosSeleccionados: Distrito[] = new Array();
  grados: ItemCatalogo[];
  gradosSeleccionados: ItemCatalogo[] = new Array();
  areasAsignaturas: ItemCatalogo[];
  areasAsignaturasSeleccionadas: ItemCatalogo[] = new Array();
  nivelesRegistro: NivelRegistro[];
  filteredOptions: Observable<string[]>;
  distritosZona: Distrito[] = new Array();
  //objetos
  usuario: Usuario;
  cabeceraRegistro: CabeceraRegistro;
  distrito: Distrito;
  institucionEducativaLabel: InsEducativa;  
  //booleanos
  existeInstitucion: boolean;  
  habilitarSeleccionZonDisPro: boolean; 
  guardarActualizarFormulario: boolean;
  habilitaFunciones: boolean;
  habilitarNiveles: boolean;
  habilitarNuevosDistritos: boolean;
  //strings
  identificacionUsuario: string = '';
  nombresUsuario: string = '';
  nemonicoFuncionHabilitarIes:string;
  nemonicoAuditoresAsesores:string;
  mensajeValidacion: string;
  mensajes_validacion_formulario = {
    'correoInstitucional': [
      { type: 'required', message: 'Correo institucional es requerido.' },      
      { type: 'maxlength', message: 'El correo electrónico institucional no puede ser mayor a 70 caracteres.' },
      { type: 'pattern', message: 'Correo electrónico institucional no válido.' }
    ],
    'correoPersonal': [
      { type: 'required', message: 'Correo personal es requerido.' },      
      { type: 'maxlength', message: 'El correo electrónico personal no puede ser mayor a 70 caracteres.' },
      { type: 'pattern', message: 'Correo electrónico personal no válido.' }
    ],
    'celular': [
      { type: 'required', message: 'Celular es requerido.' },      
      { type: 'maxlength', message: 'El celular no puede ser mayor a 10 caracteres.' },
      { type: 'pattern', message: 'Celular no válido.' },
      { type: 'minlength', message: 'El celular no puede ser menor a 10 caracteres.' },
    ],
    'ofertaSeleccionada': [
      { type: 'required', message: 'Una oferta educativa es requerida.' }
    ],
    'cargoSeleccionado': [
      { type: 'required', message: 'Un cargo o función es requerido.' }
    ],
    'idZona': [
      { type: 'required', message: 'Una zona es requerida.' }
    ],
    'idProvincia': [
      { type: 'required', message: 'Una provincia es requerida.' }
    ],
    'idDistrito': [
      { type: 'required', message: 'Una distrito es requerido.' }
    ],
    'institucionEducativa': [
      { type: 'required', message: 'Una institución educativa es requerida.' }
    ],
    'regimen': [
      { type: 'required', message: 'Un régimen es requerido.' }
    ],
    }


  constructor(private usuarioService:UsuarioService, private authService: AuthService, private formBuilder: FormBuilder) {    
    this.formularioUsuario = this.formBuilder.group({
      correoInstitucional: new FormControl('', Validators.compose([        
        Validators.pattern('[a-zA-Z0-9.-_]{1,}@educacion.gob.ec'),
        Validators.maxLength(70)
      ])),
      correoPersonal: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$'),
        Validators.maxLength(70)
      ])),
      celular: new FormControl('', Validators.compose([
        Validators.required,
        Validators.maxLength(10),
        Validators.pattern('[0-9]*'),
        Validators.minLength(10)
      ])),      
      ofertaSeleccionada: new FormControl('', Validators.compose([Validators.required])),
      cargoSeleccionado: new FormControl('', Validators.compose([Validators.required])),
      idZona: new FormControl('', Validators.compose([Validators.required])),
      idProvincia: new FormControl('', Validators.compose([Validators.required])),
      idDistrito: new FormControl('', Validators.compose([Validators.required])),
      institucionEducativa: new FormControl('', Validators.compose([Validators.required])),
      regimen: new FormControl('', Validators.compose([Validators.required])),
      seleccionarTodasAreasAsignaturas: new FormControl()
    });
  }

  ngOnInit() {
    if (localStorage.getItem('token') === null) {
      localStorage.clear();
    }
    this.authService.validateLogin('datosDocente');

    if (this.authService.isLoggedIn()) {           
      this.nemonicoFuncionHabilitarIes = 'IEDUC';
      this.nemonicoAuditoresAsesores = 'AUDIT';
      this.distrito = new Distrito();      
      this.usuario = new Usuario;
      this.guardarActualizarFormulario = false;
      this.habilitaFunciones= false; 
      this.limpiarValores();
      this.listarOfertaEducativa();            
      this.listarZonas();
      this.getUsuario();    
      this.getCabeceraRegistro();                     
    }    
  }

  iniciarUbicacion(){    
    this.formularioUsuario.controls['correoInstitucional'].setValue(this.guardarActualizarFormulario?this.cabeceraRegistro.telUsuario.correoElectronico:this.usuario.correoElectronico);
    this.formularioUsuario.controls['correoPersonal'].setValue(this.guardarActualizarFormulario?this.cabeceraRegistro.telUsuario.correoPersonal:this.usuario.correoPersonal);
    this.formularioUsuario.controls['celular'].setValue(this.guardarActualizarFormulario?this.cabeceraRegistro.telUsuario.celular:this.usuario.celular);
    this.formularioUsuario.controls['idZona'].setValue(this.distrito.telProvincia.telZona.codZona);
    this.formularioUsuario.controls['idProvincia'].setValue(this.distrito.telProvincia.codProvincia);
    this.formularioUsuario.controls['idDistrito'].setValue(this.distrito.codDistrito);    
    this.listarProvincias(this.formularioUsuario.get('idZona').value);
    this.listarDistritos(this.formularioUsuario.get('idProvincia').value); 
  }

  iniciarFormularioEdicion(){
    this.iniciarUbicacion();    
    this.formularioUsuario.controls['ofertaSeleccionada'].setValue(this.ofertasEducativas.find(x => x.codItemCatalogo == this.cabeceraRegistro.telOfertaEducativa.codItemCatalogo)); 
    this.habilitaFunciones = this.cabeceraRegistro.telCargo!=null;
    if(this.habilitaFunciones){
      this.listarItemsFunciones(this.cabeceraRegistro.telOfertaEducativa.codItemCatalogo);      
    }
    if (this.existeInstitucion) {
      this.listarInstitucionesEducativas(this.distrito.codDistrito, this.cabeceraRegistro.telOfertaEducativa.nemonico);                  
    }
  }

  getUsuario(){
    this.usuarioService.getDatosUsuario().subscribe((res: any) => {      
      this.usuario = res;
      this.identificacionUsuario =  this.usuario.identificacion;
      this.nombresUsuario = this.usuario.nombresApellidos;
    });
  }

  getCabeceraRegistro(){
    this.usuarioService.getCabeceraRegistro().subscribe((res: any) => {
      this.cabeceraRegistro = res;
      if(this.cabeceraRegistro == null ){
        this.cabeceraRegistro = new CabeceraRegistro();                         
        this.cabeceraRegistro.telUsuario = this.usuario;
        this.getDistrito();                               
      }else{ 
        this.guardarActualizarFormulario = true;       
        this.existeInstitucion = this.cabeceraRegistro.telInsEducativa!= null;
        this.distrito = this.existeInstitucion? this.cabeceraRegistro.telInsEducativa.telDistrito:this.cabeceraRegistro.telDistritoCabecera;
        this.iniciarFormularioEdicion();
        this.listarNivelesGuardados();
        this.habilitarNuevosDistritos = this.cabeceraRegistro.telCargo != undefined && this.cabeceraRegistro.telCargo != null && this.cabeceraRegistro.telCargo.nemonico == this.nemonicoAuditoresAsesores;       
        if(this.habilitarNuevosDistritos){          
          this.listarDistritosGuardados();
        }        
      } 
    });
  }

  listarNivelesGuardados(){
    var nivelesRegistroGuardados: NivelRegistro[] = new Array();
    this.usuarioService.getNivelesRegistroGuardados(this.cabeceraRegistro.codCabeceraRegistro).subscribe((res: any) => {      
      nivelesRegistroGuardados = res; 
      if(nivelesRegistroGuardados.length != 0){
        this.separarNivelesGradosAsignaturas(nivelesRegistroGuardados);
      }          
    }); 
  }

  listarDistritosGuardados(){  
    this.distritosSeleccionados = new Array();
    this.usuarioService.getDistritosRegistroGuardados(this.cabeceraRegistro.codCabeceraRegistro).subscribe((res: any) => {            
      if(res.length != 0){
        res.forEach(element => {          
          this.distritosSeleccionados.push(element.telDistrito);
        });                        
      }
      this.listarDistritosAsesores(this.distrito.telProvincia.telZona.codZona);          
    }); 
  }

  separarNivelesGradosAsignaturas(nivelesRegistroGuardados: NivelRegistro[]){  
    var gradosFiltrados: ItemCatalogo[] = new Array();
    var nivelesFiltrados: ItemCatalogo[] = new Array();
    var asignaturasFiltradas: ItemCatalogo[] = new Array();
      if(this.cabeceraRegistro.telCargo != null){
        this.listarNivelesSubniveles(this.cabeceraRegistro.telCargo.codItemCatalogo);
      }else{
        this.listarNivelesSubniveles(this.cabeceraRegistro.telOfertaEducativa.codItemCatalogo);
      }
      //filtro los niveles, grados y asignaturas  
      nivelesRegistroGuardados.forEach(nivel => {
        if(nivel.telNivel != null){          
          nivelesFiltrados.push(nivel.telNivel);
        }
        if(nivel.telGrado != null){          
          gradosFiltrados.push(nivel.telGrado);
        }
        if(nivel.telAsignatura != null){          
          asignaturasFiltradas.push(nivel.telAsignatura);
        }          
      });      
      //limpiamos duplicados      
      this.nivelesSubnivelesSeleccionados = nivelesFiltrados.filter((v,i) => nivelesFiltrados.findIndex(item => item.codItemCatalogo == v.codItemCatalogo) === i);
      this.gradosSeleccionados = gradosFiltrados.filter((v,i) => gradosFiltrados.findIndex(item => item.codItemCatalogo == v.codItemCatalogo) === i);
      this.areasAsignaturasSeleccionadas = asignaturasFiltradas.filter((v,i) => asignaturasFiltradas.findIndex(item => item.codItemCatalogo == v.codItemCatalogo) === i);     
      //consultamos los grados
      this.nivelesSubnivelesSeleccionados.forEach(nivel => {
        this.listarGrados(nivel.codItemCatalogo);
      });
      //consultamos las asignaturas      
      this.gradosSeleccionados.forEach(grado => {        
        this.listarAreasAsignaturas(grado);
      });       
  }

  getDistrito(){
    this.usuarioService.getDistrito().subscribe((res: any) => {      
      this.distrito = res; 
      this.iniciarUbicacion();   
    });        
  }

  listarOfertaEducativa(){
    this.usuarioService.getOfertasEducativas().subscribe((res: any) => {
      this.ofertasEducativas = res;
    });
  }

  listarItemsFunciones(codigoItemCatalogo: any){
    this.usuarioService.getFuncionesCargos(codigoItemCatalogo).subscribe((res: any) => {
      this.funcionesUsuario = res;
      if (this.guardarActualizarFormulario) {
        this.formularioUsuario.controls['cargoSeleccionado'].setValue(this.funcionesUsuario.find(x => this.cabeceraRegistro.telCargo!=null && x.codItemCatalogo == this.cabeceraRegistro.telCargo.codItemCatalogo));
      }
    }); 
  }

  listarZonas(){
    this.usuarioService.getZonas().subscribe((res: any) => {
      this.zonas = res;
    });
  }

  listarProvincias(codigoZona: any){
    this.usuarioService.getProvincias(codigoZona).subscribe((res: any) => {
      this.provincias = res;
    });
  }

  listarDistritos(codigoProvincia: any){
    this.usuarioService.getDistritos(codigoProvincia).subscribe((res: any) => {
      this.distritos = res;
    });
  }

  listarInstitucionesEducativasWeb(codDistrito: any){
    var ofertaParametro  = this.formularioUsuario.get('ofertaSeleccionada').value;
    this.listarInstitucionesEducativas(codDistrito, ofertaParametro.nemonico);
  }

  listarInstitucionesEducativas(codigoDistrito: any, nemonicoOferta: any){
    this.listarRegimenes();
    this.usuarioService.getInstitucionesPorDistritoYOferta(codigoDistrito, nemonicoOferta).subscribe((res: any) => {
      this.institucionesEducativas = res;
      if (this.guardarActualizarFormulario){ 
        this.formularioUsuario.controls['institucionEducativa'].setValue(this.institucionesEducativas.find(x => this.cabeceraRegistro.telInsEducativa != undefined && x.codInsEducativa == this.cabeceraRegistro.telInsEducativa.codInsEducativa)); 
      }
      this.existeInstitucion=this.institucionesEducativas.length!=0;
    });
  }

  listarInstitucionesEducativasEspeciales(nemonicoOferta: any){
    this.listarRegimenes();
    this.usuarioService.getInstitucionesPorOferta(nemonicoOferta).subscribe((res: any) => {
      this.institucionesEducativas = res;
      this.existeInstitucion=this.institucionesEducativas.length!=0;
    });
  }

  listarRegimenes(){
    this.usuarioService.getRegimenes().subscribe((res: any) => {
      this.regimenes = res;
      if(this.guardarActualizarFormulario){
        this.formularioUsuario.controls['regimen'].setValue(this.regimenes.find(x => this.cabeceraRegistro.telRegimen != undefined && x.codItemCatalogo == this.cabeceraRegistro.telRegimen.codItemCatalogo));
      }
    });
  }

  listarDistritosAsesores(codigoZona: any){
    this.usuarioService.getDistritosPorZona(codigoZona).subscribe((res: any) => {
      this.distritosZona = res;
      //establecer el check de los niveles
      if(this.salvarActualizarCabecera){
        this.distritosSeleccionados.forEach((distritoSelec)=>this.distritosZona.forEach((distrito)=> {
              if(distritoSelec.codDistrito === distrito.codDistrito){
                distrito.check=true;
              }
            }
        ));
      }     
    }); 
  }

  listarNivelesSubniveles(codigoItemCatalogo: any){
    this.usuarioService.getNivelesSubniveles(codigoItemCatalogo).subscribe((res: any) => {
      this.nivelesSubniveles = res;
      //establecer el check de los niveles
      if(this.salvarActualizarCabecera){
        this.nivelesSubnivelesSeleccionados.forEach((nivelSelec)=>this.nivelesSubniveles.forEach((nivel)=> {
              if(nivelSelec.codItemCatalogo === nivel.codItemCatalogo){
                nivel.check=true;
              }
            }
        ));
      }     
    }); 
  }

  listarGrados(codigoItemCatalogo: any){
    this.usuarioService.getGrados(codigoItemCatalogo).subscribe((res: any) => {
      res.forEach(element => {
        this.grados.push(element);
      }); 
      //establecer el check de los grados
      if (this.salvarActualizarCabecera) {
        this.gradosSeleccionados.forEach((gradoSelec)=>this.grados.forEach((grado)=> {
              if(gradoSelec.codItemCatalogo === grado.codItemCatalogo){
                grado.check=true;
              }
            }
        ));
      }
      //ordenamos el arreglo
      this.grados.sort((a,b) => a.codItemCatalogo - b.codItemCatalogo);            
    }); 
  }

  listarAreasAsignaturas(gradoParam: any){
    this.usuarioService.getAreasAsignaturas(gradoParam.codItemCatalogo).subscribe((res: any) => {
      res.forEach(element => {
        var asignatura = element;
        asignatura.nombrePadre = gradoParam.nombre;
        this.areasAsignaturas.push(asignatura);
      });
      //establecemos el check de las asignaturas seleccionadas
      if (this.salvarActualizarCabecera) {
        this.areasAsignaturasSeleccionadas.forEach((asignaturaSelec)=>this.areasAsignaturas.forEach((asignatura)=> {
              if(asignaturaSelec.codItemCatalogo === asignatura.codItemCatalogo){
                asignatura.check=true;
              }
            }
        ));
      }
      //ordenamos el arreglo de forma alfabetica
      this.areasAsignaturas.sort((a,b) => a.nombre.localeCompare(b.nombre));
      //establecemos el check total
      this.formularioUsuario.controls['seleccionarTodasAreasAsignaturas'].setValue(this.areasAsignaturas.length == this.areasAsignaturasSeleccionadas.length);           
    });     
  }

  checkChangeNivel(event, nivel) {        
    if(event.checked) {
      this.listarGrados(nivel.codItemCatalogo);
      this.nivelesSubnivelesSeleccionados.push(nivel);
    } else {  
      this.grados = this.grados.filter((element) => nivel.codItemCatalogo != element.itemCatalogoPadre);         
      var asignaturasFiltradas = new Array();
      this.grados.forEach(grado => {
        this.areasAsignaturas.forEach(element => {
          if(grado.codItemCatalogo == element.itemCatalogoPadre){
            asignaturasFiltradas.push(element);
          }
        });        
      });
      this.areasAsignaturas = asignaturasFiltradas;
      this.nivelesSubnivelesSeleccionados = this.nivelesSubnivelesSeleccionados.filter((element) => element.codItemCatalogo != nivel.codItemCatalogo);                  
    }
  }  

  checkChangeGrado(event, grado) {    
    if(event.checked) {
      this.listarAreasAsignaturas(grado);
      this.gradosSeleccionados.push(grado);
    } else {      
      this.areasAsignaturas = this.areasAsignaturas.filter((element) => grado.codItemCatalogo != element.itemCatalogoPadre); 
      this.gradosSeleccionados = this.gradosSeleccionados.filter((element) => grado.codItemCatalogo != element.codItemCatalogo);      
    }
  }

  checkChangeAreaAsignatura(event, area) {    
    if(event.checked) {
      this.areasAsignaturasSeleccionadas.push(area);
    } else {
      this.areasAsignaturasSeleccionadas = this.areasAsignaturasSeleccionadas.filter((element) => area.codItemCatalogo != element.codItemCatalogo);       
    }
    //establecemos el check total
    this.formularioUsuario.controls['seleccionarTodasAreasAsignaturas'].setValue(this.areasAsignaturas.length == this.areasAsignaturasSeleccionadas.length);
  }

  checkAllAreaAsignaturas(event){    
    if(event.checked) {
      this.areasAsignaturasSeleccionadas = this.areasAsignaturas;
      this.putCheckAll(true);
    } else {
      this.areasAsignaturasSeleccionadas = new Array();
      this.putCheckAll(false);
    }
  }

  checkChangeDistritos(event, distrito) {    
    if(event.checked) {
      this.distritosSeleccionados.push(distrito);
    } else {
      this.distritosSeleccionados = this.distritosSeleccionados.filter((element) => distrito.codDistrito != element.codDistrito);       
    }    
  }

  putCheckAll(value){
    this.areasAsignaturas.forEach(element => {
      element.check=value;
    });
  }
  
  limpiarValores(){
    this.habilitaFunciones= false;
    this.habilitarSeleccionZonDisPro = true;
    this.habilitarNiveles = false;
    this.habilitarNuevosDistritos=false;    
    this.existeInstitucion=false;
    this.regimenes = new Array(); 
    this.nivelesSubniveles = new Array();
    this.nivelesSubnivelesSeleccionados = new Array();
    this.distritosZona =  new Array();
    this.distritosSeleccionados =  new Array();
    this.grados = new Array();
    this.gradosSeleccionados = new Array();
    this.areasAsignaturas = new Array();
    this.areasAsignaturasSeleccionadas = new Array(); 
    this.formularioUsuario.controls['institucionEducativa'].setValue(null);
    this.formularioUsuario.controls['regimen'].setValue(null);      
  }

  selectOferta(oferta: any){        
    this.limpiarValores(); 
    switch (oferta.nemonico) {
      case OfertaEducativa.educacion_ordinaria:
      case OfertaEducativa.educacion_especializada:      
      this.habilitaFunciones= true;  
      this.listarItemsFunciones(oferta.codItemCatalogo);
      this.listarInstitucionesEducativas(this.formularioUsuario.get('idDistrito').value, oferta.nemonico);                        
      break;
      case OfertaEducativa.educacion_ebja:
      this.existeInstitucion=true;
      //this.habilitarSeleccionZonDisPro = false; 
      this.listarInstitucionesEducativas(this.formularioUsuario.get('idDistrito').value, oferta.nemonico);
      break;    
      case OfertaEducativa.centros_privacion_libertad:      
      case OfertaEducativa.instituciones_nocturnas:
      case OfertaEducativa.educacion_virtual:
      this.existeInstitucion=true;
      //this.habilitarSeleccionZonDisPro = false; 
      this.listarInstitucionesEducativas(this.formularioUsuario.get('idDistrito').value, oferta.nemonico);
      break;      
      case OfertaEducativa.safpi:
      this.habilitarNiveles = true;     
      this.listarNivelesSubniveles(oferta.codItemCatalogo);
      break;
      case OfertaEducativa.nap:
      this.existeInstitucion=true;
      this.habilitarNiveles = true;      
      //this.habilitarSeleccionZonDisPro = false;       
      this.listarInstitucionesEducativas(this.formularioUsuario.get('idDistrito').value, oferta.nemonico);
      this.listarNivelesSubniveles(oferta.codItemCatalogo);
      break;
      case OfertaEducativa.colegios_arte:
        this.existeInstitucion=true;      
      //this.habilitarSeleccionZonDisPro = false; 
      this.listarInstitucionesEducativas(this.formularioUsuario.get('idDistrito').value, oferta.nemonico);
      break;      
    }
  }

  selectCargoFuncion(funcionParam: ItemCatalogo){
    this.formularioUsuario.controls['institucionEducativa'].setValue(null);
    this.formularioUsuario.controls['regimen'].setValue(null);    
    this.existeInstitucion= funcionParam.nemonico != undefined && funcionParam.nemonico == this.nemonicoFuncionHabilitarIes;
    if(this.existeInstitucion && this.institucionesEducativas == undefined){
      this.listarInstitucionesEducativas(this.formularioUsuario.get('idDistrito').value, this.formularioUsuario.get('ofertaSeleccionada').value.nemonico);
    }
    this.habilitarNuevosDistritos= funcionParam.nemonico != undefined && funcionParam.nemonico == this.nemonicoAuditoresAsesores;
    this.listarNivelesSubniveles(funcionParam.codItemCatalogo);
    if(this.habilitarNuevosDistritos){
      this.nivelesSubnivelesSeleccionados = new Array();
      this.nivelesSubniveles = new Array();
      this.listarDistritosAsesores(this.formularioUsuario.get('idZona').value);
    }else{
      this.distritosZona =  new Array();
      this.distritosSeleccionados =  new Array();
    }
  }

  selectInstitucionEducativa(institucionParametro: InsEducativa){
    this.institucionEducativaLabel = institucionParametro;
  }

  validarCampos(){
    this.mensajeValidacion='';
    var guardar = true;       
    if(this.nivelesSubniveles.length != 0 && this.nivelesSubnivelesSeleccionados.length == 0 ){
      guardar = false;
      this.mensajeValidacion='Seleccione mínimo un nivel o subnivel. Por favor verifique.';
    }else if(this.grados.length != 0 && this.gradosSeleccionados.length == 0 ){
      guardar = false;
      this.mensajeValidacion='Seleccione mínimo un grado. Por favor verifique.';
    }else if(this.areasAsignaturas.length != 0 && this.areasAsignaturasSeleccionadas.length == 0 ){
      guardar = false;
      this.mensajeValidacion='Seleccione mínimo un área o asignatura. Por favor verifique.';
    }else if(this.existeInstitucion && (this.formularioUsuario.get('institucionEducativa').value == undefined || this.formularioUsuario.get('regimen').value == undefined) ){
      guardar = false;
      this.mensajeValidacion='Institución educativa y régimen son campos obligatorios. Por favor verifique.';
    }else if(!this.formularioUsuario.get('correoPersonal').valid){
      guardar = false;
      this.mensajeValidacion='El campo correo electrónico personal presenta errores. Por favor verifique.';
    }else if(!this.formularioUsuario.get('celular').valid){
      guardar = false;
      this.mensajeValidacion='El campo celular presenta errores. Por favor verifique.';
    }else if(!this.formularioUsuario.get('correoInstitucional').valid){
      guardar = false;
      this.mensajeValidacion='El campo correo electrónico institucional presenta errores. Por favor verifique.';
    }else if(this.distritosZona.length != 0 && this.distritosSeleccionados.length == 0){
      guardar = false;
      this.mensajeValidacion='Seleccione mínimo un distrito. Por favor verifique.';
    }
    return guardar;
  }

  setearValoresCabeceraRegistro(){
    if(!this.guardarActualizarFormulario){
      this.cabeceraRegistro.codCabeceraRegistro=0;
    }        
    this.cabeceraRegistro.telUsuario.correoElectronico = this.formularioUsuario.get('correoInstitucional').value != undefined ? this.formularioUsuario.get('correoInstitucional').value: null;
    this.cabeceraRegistro.telUsuario.correoPersonal = this.formularioUsuario.get('correoPersonal').value != undefined ? this.formularioUsuario.get('correoPersonal').value: null;
    this.cabeceraRegistro.telUsuario.celular = this.formularioUsuario.get('celular').value != undefined ? this.formularioUsuario.get('celular').value: null;
    this.cabeceraRegistro.telOfertaEducativa = this.formularioUsuario.get('ofertaSeleccionada').value != undefined ? this.formularioUsuario.get('ofertaSeleccionada').value: null;
    this.cabeceraRegistro.telCargo = this.habilitaFunciones && this.formularioUsuario.get('cargoSeleccionado').value != undefined ? this.formularioUsuario.get('cargoSeleccionado').value: null;
    if(this.existeInstitucion && this.formularioUsuario.get('institucionEducativa').value != undefined){      
        this.cabeceraRegistro.telInsEducativa = this.formularioUsuario.get('institucionEducativa').value;
        this.cabeceraRegistro.telRegimen = this.formularioUsuario.get('regimen').value != undefined ? this.formularioUsuario.get('regimen').value: null;
    }else if (this.formularioUsuario.get('idDistrito').value != undefined) {      
      this.cabeceraRegistro.telDistritoCabecera = this.distritos.find(x => x.codDistrito == this.formularioUsuario.get('idDistrito').value);
      this.cabeceraRegistro.telInsEducativa = null;
      this.cabeceraRegistro.telRegimen = null;
    }else{
      this.cabeceraRegistro.telInsEducativa = null;
      this.cabeceraRegistro.telDistritoCabecera = null;
      this.cabeceraRegistro.telRegimen = null;
    }    
  }

  setearValoresNivelGradoAsignatura(){
    this.nivelesRegistro = new Array();
    var nuevosGradosInsertar: NivelRegistro[] = new Array();
    var nuevosNivelesInsertar: NivelRegistro[] = new Array();
    //agregamos las asignaturas
    this.areasAsignaturasSeleccionadas.forEach(asignatura => {
      var nivelRegistroObjeto: NivelRegistro = new NivelRegistro;
      nivelRegistroObjeto.telAsignatura = asignatura;
      this.nivelesRegistro.push(nivelRegistroObjeto);
    });
    //agregamos los grados
    this.gradosSeleccionados.forEach(grado => {
      var existeGrado = false;      
      this.nivelesRegistro.forEach(nivelRegistro => {
        if(nivelRegistro.telAsignatura.itemCatalogoPadre ==grado.codItemCatalogo){
          nivelRegistro.telGrado = grado;
          existeGrado = true;
        }
      });
      if(!existeGrado){
        var nivelRegistroObjeto: NivelRegistro = new NivelRegistro;
        nivelRegistroObjeto.telGrado = grado;
        nuevosGradosInsertar.push(nivelRegistroObjeto);
      }
    });
    nuevosGradosInsertar.forEach(element => {
      this.nivelesRegistro.push(element);
    });
    //agregamos los niveles
    this.nivelesSubnivelesSeleccionados.forEach(nivel => {   
      var existeNivel = false;     
      this.nivelesRegistro.forEach(nivelRegistro => {
        if(nivelRegistro.telGrado != undefined && nivelRegistro.telGrado.itemCatalogoPadre==nivel.codItemCatalogo){
          nivelRegistro.telNivel = nivel;
          existeNivel = true;
        }
      });
      if(!existeNivel){
        var nivelRegistroObjeto: NivelRegistro = new NivelRegistro;
        nivelRegistroObjeto.telNivel = nivel;
        nuevosNivelesInsertar.push(nivelRegistroObjeto);
      }
    });    
    nuevosNivelesInsertar.forEach(element => {
      this.nivelesRegistro.push(element);
    });
  }

  salvarActualizarCabecera(formulario){   
    //if(formulario.valid){          
      if(this.validarCampos()) { 
        this.setearValoresCabeceraRegistro();
        this.setearValoresNivelGradoAsignatura();               
        this.usuarioService.guardarCabeceraRegistro(this.cabeceraRegistro).subscribe((res: any) => {          
          if(res.codigoError === 0) {                      
            if(this.nivelesRegistro.length!=0){              
              this.saveNivelesRegistro();
            }else if(this.habilitarNuevosDistritos){              
              this.saveDistritosRegistro();
            }else{
              Swal.fire({
                title: 'Atención',
                text: "Registros guardados correctamente",
                icon: 'success',                
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Aceptar'
              }).then((result) => {
                  if (result.value) {
                    location.reload();
                  }
              });              
              //Swal.fire('Atención','Registros guardados correctamente','success');  
            }                   
          } else {
            Swal.fire('Atención','Error al guardar la cabecera del registro: '+res.mensaje+ '. Por favor intente más tarde o comuníquese con el administrador del sistema.','error');
          }
        });
      } else {
        Swal.fire('Atención',this.mensajeValidacion,'warning');
      }
   /* }else{
      Swal.fire('Atención','Existen campos obligatorios por llenar. Por favor verifique.','warning');
    }*/    
  }

  saveNivelesRegistro(){
    this.usuarioService.guardarNivelesRegistro(this.nivelesRegistro).subscribe((res: any) => {          
        if(res.codigoError === 0) {          
          //Swal.fire('Atención','Registros guardados correctamente','success');
          Swal.fire({
            title: 'Atención',
            text: "Registros guardados correctamente",
            icon: 'success',                
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Aceptar'
          }).then((result) => {
              if (result.value) {
                location.reload();
              }
          });            
        } else {
          Swal.fire('Atención','Error al guardar los niveles registrados: '+res.mensaje+ '. Por favor intente más tarde o comuníquese con el administrador del sistema.','error');
        }
    });
  }

  saveDistritosRegistro(){   
    var nuevosDistritosInsertar: any[] = new Array();    
    this.distritosSeleccionados.forEach(element => {
      var objeto = {telDistrito:element}; 
      nuevosDistritosInsertar.push(objeto);
    });  
    this.usuarioService.guardarDistritosRegistro(nuevosDistritosInsertar).subscribe((res: any) => {          
        if(res.codigoError === 0) {          
          //Swal.fire('Atención','Registros guardados correctamente','success');
          Swal.fire({
            title: 'Atención',
            text: "Registros guardados correctamente",
            icon: 'success',                
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Aceptar'
          }).then((result) => {
              if (result.value) {
                location.reload();
              }
          });            
        } else {
          Swal.fire('Atención','Error al guardar los distritos registrados: '+res.mensaje+ '. Por favor intente más tarde o comuníquese con el administrador del sistema.','error');
        }
    });
  }

}
