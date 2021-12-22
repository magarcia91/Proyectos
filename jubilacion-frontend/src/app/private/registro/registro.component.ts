import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Grado } from '../../core/models/interfaces/grado.model';
import { Nacionalidad } from '../../core/models/interfaces/nacionalidad.model';
import { Sede } from '../../core/models/interfaces/sede.model';
import { RegistroDataService } from '../../core/services/registro-data.service';
import Swal from 'sweetalert2';
import { AuthService } from 'src/app/core/services/authService';
import { EncuestaDataService } from '../../core/services/encuesta-data.service';
import { Observable } from 'rxjs';
import { start } from 'repl';
import { map, startWith } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { Etnia } from 'src/app/core/models/interfaces/etnia.model';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss']
})
export class RegistroComponent implements OnInit {

  public frmRegistroAsistencia: FormGroup;
  listaNacionalidades: Nacionalidad[] = [];
  listaSedes: Sede[] = [];
  listaGrados: Grado[] = [];
  listaEtnias: Etnia[]=[];
  filteredOptionsNacionalidad: Observable<Nacionalidad[]>;
  filteredOptionSedes: Observable<Sede[]>;
  filteredOptionEtnias: Observable<Etnia[]>;
  constructor(
    private readonly fb: FormBuilder,
    private _registroService: RegistroDataService,
    public authService: AuthService,
    private _encuestaService: EncuestaDataService,
    public spinner: NgxSpinnerService
  ) { }

  ngOnInit(): void {
    this.authService.validateLogin('private/registro');
    this.frmRegistroAsistencia = this.fb.group({
      documentoIdentidad: [null],
      nombre: [null, [Validators.required]],
      fechaNacimiento: [null, [Validators.required]],
      edad: [null],
      genero: [null, [Validators.required]],
      discapacidad: [null, [Validators.required]],
      nacionalidad: [null, [Validators.required]],
      etnia:[null],
      celular: [null, [Validators.required]],
      direccion:[null],
      movilidad:[null],
      conectividad:[null],
      vivienda:[null],
      cercania:[null],
      sede: [null, [Validators.required]],
      grado: [null, [Validators.required]],
      esMatriculado: [null, [Validators.required]],
      peso: [null],
      talla: [null],
      comidasAlDia: [null],
      visitaMedico: [null]

    });
    this.cargarNacionalidades();
    this.cargarSedes();
    this.cargarGrados();
    this.cargarEtnias();
  }

  buscarCedula() {
    let documento=this.frmRegistroAsistencia.get('documentoIdentidad').value;
    if (documento!=null && documento!="") {
      this.spinner.show();
    this._encuestaService.consultarEncuestaPorCedula(this.frmRegistroAsistencia.get('documentoIdentidad').value).subscribe(
      (estudiante: any) => {
        if (estudiante != null) {
          this.spinner.hide();
          Swal.fire('La identificación ya se encuentra registrada', '', 'info');

        } else {
          this._registroService.consultarCedula(this.frmRegistroAsistencia.get('documentoIdentidad').value).subscribe(cedulado => {
            if (cedulado[0]==null) {
              Swal.fire('No se encuentra la identificación ingresada', '', 'warning');
              this.spinner.hide();
            }else{
              let codSexo = null;
              if (cedulado[0].codSexo == 1) {
                codSexo = '1';
              }
              if (cedulado[0].codSexo == 2) {
                codSexo = '2';
              }
              let fecha = new Date(cedulado[0].fechaNacimiento);
              let nacimiento: Date = new Date(fecha.getUTCFullYear(), fecha.getUTCMonth(), fecha.getUTCDate());
              let timeDiff = Math.abs(Date.now() - nacimiento.getTime());
              let edadCalculada = Math.floor((timeDiff / (1000 * 3600 * 24)) / 365.25);
              let nombres: string = <string>cedulado[0].nombres;
              // let Nac:Nacionalidad={codigo:345,descripcion:"ECUADOR"};
              this.frmRegistroAsistencia.patchValue({
                nombre: nombres,
                fechaNacimiento: new Date(fecha.getUTCFullYear(), fecha.getUTCMonth(), fecha.getUTCDate()),
                edad: edadCalculada + " años",
                genero: codSexo,
                nacionalidad: "ECUADOR"
  
              });
            }
            
          });
          this.spinner.hide();
        }
      }
    );
    }
    

  }
  calcularEdad(event) {
    let fechaSeleccionada: Date = event.value;
    let timeDiff = Math.abs(Date.now() - fechaSeleccionada.getTime());
    let edadCalculada = Math.floor((timeDiff / (1000 * 3600 * 24)) / 365.25);
    this.frmRegistroAsistencia.patchValue({
      edad: edadCalculada + " años"
    });
  }
  cargarNacionalidades() {
    this._registroService.consultarNacionalidades().subscribe(nacionalidades => {
      this.listaNacionalidades = nacionalidades;
      this.filteredOptionsNacionalidad = this.frmRegistroAsistencia.get("nacionalidad").valueChanges
        .pipe(
          startWith(''),
          map(value => typeof value == 'string' ? value : value.descripcion),
          map(name => name ? this._filter(name) : this.listaNacionalidades.slice())
        );
    });
  }
  displayFn(nacionalidad: Nacionalidad): string {
    return nacionalidad && nacionalidad.descripcion ? nacionalidad.descripcion : '';
  }
  private _filter(name: string): Nacionalidad[] {
    const filterValue = name.toLowerCase();
    return this.listaNacionalidades.filter(option => option.descripcion.toLowerCase().indexOf(filterValue) === 0);
  }
  cargarSedes() {
    this._registroService.consultarSedes().subscribe(sedes => {
      this.listaSedes = sedes;
      this.filteredOptionSedes = this.frmRegistroAsistencia.get("sede").valueChanges
        .pipe(
          startWith(''),
          map(value => typeof value == 'string' ? value : value.sedNombre),
          map(name => name ? this._filterSede(name) : this.listaSedes.slice())
        );
    });
  }
  displayFnSede(sede: Sede): string {
    return sede && sede.sedNombre ? sede.sedNombre : '';
  }
  private _filterSede(name: string): Sede[] {
    const filterValue = name.toLowerCase();
    return this.listaSedes.filter(option => option.sedNombre.toLowerCase().indexOf(filterValue) === 0);
  }
  cargarGrados() {
    this._registroService.consultarGrados().subscribe(grados => {
      this.listaGrados = grados;
    });
  }
  cargarEtnias() {
    this._registroService.consultarEtnias().subscribe(etnias => {
      this.listaEtnias = etnias;
      this.filteredOptionEtnias = this.frmRegistroAsistencia.get("etnia").valueChanges
        .pipe(
          startWith(''),
          map(value => typeof value == 'string' ? value : value.descripcion),
          map(name => name ? this._filterEtnia(name) : this.listaEtnias.slice())
        );
    });
  }
  displayFnEtnia(etnia: Etnia): string {
    return etnia && etnia.descripcion ? etnia.descripcion : '';
  }
  private _filterEtnia(name: string): Etnia[] {
    const filterValue = name.toLowerCase();
    return this.listaEtnias.filter(option => option.descripcion.toLowerCase().indexOf(filterValue) === 0);
  }

  guardarRegistro() {
    let sexo = "";
    if (this.frmRegistroAsistencia.get("genero").value == 1) {
      sexo = "MASCULINO";
    } else {
      sexo = "FEMENINO";
    }
    let cedula = this.frmRegistroAsistencia.get("documentoIdentidad").value;
    let nacionalidad: string = this.frmRegistroAsistencia.get("nacionalidad").value;
    let nacionalidadSeleccionada = this.listaNacionalidades.find(nacionalidadBuscar => nacionalidadBuscar.descripcion === nacionalidad.toUpperCase());
    //etnia
    let etnia: string = this.frmRegistroAsistencia.get("etnia").value;
    let etniaSeleccionada=null;
    if (etnia!=null) {
      
     etniaSeleccionada = this.listaEtnias.find(etniaBuscar => etniaBuscar.descripcion.toUpperCase() === etnia.toUpperCase());
    } 
    let codigoEtnia=null;
    if (etniaSeleccionada != null) {
      codigoEtnia=etniaSeleccionada.codigo;
    } else {
      codigoEtnia=null;
    }
    
    if (nacionalidadSeleccionada != null) {

      let sede: string = this.frmRegistroAsistencia.get("sede").value;
      let sedeSeleccionada = this.listaSedes.find(sedeBuscar => sedeBuscar.sedNombre === sede.toUpperCase());
      if (sedeSeleccionada != null) {
        if (cedula != null && cedula != "") {
          this._encuestaService.consultarEncuestaPorCedula(this.frmRegistroAsistencia.get("documentoIdentidad").value).subscribe(
            (estudiante: any) => {
              if (estudiante != null) {
                Swal.fire('La identificación ya se encuentra registrada', '', 'error');
              } else { 
                this.spinner.show();
                let registro = {
                  documentoIdentidad: this.frmRegistroAsistencia.get("documentoIdentidad").value,
                  nombre: this.frmRegistroAsistencia.get("nombre").value,
                  fechaNacimiento: this.frmRegistroAsistencia.get("fechaNacimiento").value,
                  genero: sexo,
                  discapacidad: this.frmRegistroAsistencia.get("discapacidad").value,
                  nacionalidad: nacionalidadSeleccionada.codigo,
                  etnia:codigoEtnia,
                  celular: this.frmRegistroAsistencia.get("celular").value,
                  direccion: this.frmRegistroAsistencia.get("direccion").value,
                  movilidadHumana:this.frmRegistroAsistencia.get("movilidad").value,
                  conectividad:this.frmRegistroAsistencia.get("conectividad").value,
                  cambio_vivienda:this.frmRegistroAsistencia.get("vivienda").value,
                  IE_cerca:this.frmRegistroAsistencia.get("cercania").value,
                  sede: sedeSeleccionada.sedCodigo,
                  grado: this.frmRegistroAsistencia.get("grado").value,
                  esMatriculado: this.frmRegistroAsistencia.get("esMatriculado").value,
                  peso: this.frmRegistroAsistencia.get("peso").value,
                  talla: this.frmRegistroAsistencia.get("talla").value,
                  comidasAlDia: this.frmRegistroAsistencia.get("comidasAlDia").value,
                  visitaMedico: this.frmRegistroAsistencia.get("visitaMedico").value
                };

                this._registroService.guardarRegistro(registro).subscribe((respuesta: any) => {

                  this.limpiarFormulario();
                  this.spinner.hide();
                  Swal.fire('Información almacenada correctamente. Codigo: ' + respuesta.codigoRespuesta, '', 'success');
                }, (error) => {
                  this.spinner.hide();
                  Swal.fire('No se pudo almacenar la información', '', 'error');
                }

                );
              }
            });
        } else {
          this.spinner.show();
          let registro = {
            documentoIdentidad: null,
            nombre: this.frmRegistroAsistencia.get("nombre").value,
            fechaNacimiento: this.frmRegistroAsistencia.get("fechaNacimiento").value,
            genero: sexo,
            discapacidad: this.frmRegistroAsistencia.get("discapacidad").value,
            nacionalidad: nacionalidadSeleccionada.codigo,
            etnia:codigoEtnia,
            celular: this.frmRegistroAsistencia.get("celular").value,
            direccion: this.frmRegistroAsistencia.get("direccion").value,
            movilidadHumana:this.frmRegistroAsistencia.get("movilidad").value,
            conectividad:this.frmRegistroAsistencia.get("conectividad").value,
            cambio_vivienda:this.frmRegistroAsistencia.get("vivienda").value,
            IE_cerca:this.frmRegistroAsistencia.get("cercania").value,
            sede: sedeSeleccionada.sedCodigo,
            grado: this.frmRegistroAsistencia.get("grado").value,
            esMatriculado: this.frmRegistroAsistencia.get("esMatriculado").value,
            peso: this.frmRegistroAsistencia.get("peso").value,
            talla: this.frmRegistroAsistencia.get("talla").value,
            comidasAlDia: this.frmRegistroAsistencia.get("comidasAlDia").value,
            visitaMedico: this.frmRegistroAsistencia.get("visitaMedico").value
          };

          this._registroService.guardarRegistro(registro).subscribe((respuesta: any) => {

            this.limpiarFormulario();
            this.spinner.hide();
            Swal.fire('Información almacenada correctamente. Codigo: ' + respuesta.codigoRespuesta, '', 'success');
          }, (error) => {
            this.spinner.hide();
            Swal.fire('No se pudo almacenar la información', '', 'error');
          }

          );
        }

      } else {
        Swal.fire('La sede seleccionada no se encuentra registrada', '', 'error');
      }

    } else {
      Swal.fire('La Nacionalidad seleccionada no se encuentra registrada', '', 'error');
    }



  }
  limpiarFormulario() {
    this.frmRegistroAsistencia = this.fb.group({
      documentoIdentidad: [null],
      nombre: [null, [Validators.required]],
      fechaNacimiento: [null, [Validators.required]],
      edad: [null],
      genero: [null, [Validators.required]],
      discapacidad: [null, [Validators.required]],
      nacionalidad: [null, [Validators.required]],
      etnia:[null],
      celular: [null, [Validators.required]],
      direccion:[null],
      movilidad:[null],
      conectividad:[null],
      vivienda:[null],
      cercania:[null],
      sede: [null, [Validators.required]],
      grado: [null, [Validators.required]],
      esMatriculado: [null, [Validators.required]],
      peso: [null],
      talla: [null],
      comidasAlDia: [null],
      visitaMedico: [null]

    });
  }
}
