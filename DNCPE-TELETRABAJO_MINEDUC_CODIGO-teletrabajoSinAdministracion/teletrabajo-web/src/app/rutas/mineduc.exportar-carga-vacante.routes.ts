export const RUTA_EXPORTAR_CARGA_VACANTE = {
    path: 'Administracion',
    children: [
        {
            path: 'vacantes',
            loadChildren:
                './pages/carga-vacante/modulo/carga-vacante.module#CargaVacanteModule'
        }
    ]
};
