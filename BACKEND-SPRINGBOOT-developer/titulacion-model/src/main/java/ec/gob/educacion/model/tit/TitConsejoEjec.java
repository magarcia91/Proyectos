package ec.gob.educacion.model.tit;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by Marco on 15/01/2015.
 */
@Entity
@Table(name = "TIT_CONSEJO_EJEC")
@SequenceGenerator(name = "SEQ_TIT_AUTORIDAD_GEN", sequenceName = "SEQ_TIT_CONSEJO_EJEC", allocationSize = 1)

public class TitConsejoEjec implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "AUT_CODIGO", unique = true, nullable = false, scale = 0)
    @GeneratedValue(generator = "SEQ_TIT_AUTORIDAD_GEN", strategy = GenerationType.SEQUENCE)
    private Integer autCodigo;

    @Column(name = "AUT_CEDULA")
    private String autCedula;

    @Column(name = "AUT_NOMBRE")
    private String autNombre;

    @ManyToOne()
    @JoinColumn(name = "CAR_CODIGO")
    private TitCargo titCargo;

    @Column(name="COD_INSTITUCION")
    private Long codInstitucion;

    @Column(name="COD_INC_ANIO_LECTIVO")
    private Long codAnioLectivo;
	
	//sacara la descripción del cargo
	@Transient
	private String carNombreTransient;

    public TitConsejoEjec() {
    }

   /* public TitConsejoEjec(Integer autCodigo, String autCedula, 
    					String autNombre, TitCargo titCargo,
    					Long codInstitucion, Long codAnioLectivo) {
        this.autCodigo = autCodigo;
        this.autCedula = autCedula;
        this.autNombre = autNombre;
        this.titCargo = titCargo;
        this.codInstitucion = codInstitucion;
        this.codAnioLectivo = codAnioLectivo;
    }*/

    public Integer getAutCodigo() {
        return autCodigo;
    }

    public void setAutCodigo(Integer autCodigo) {
        this.autCodigo = autCodigo;
    }

    public String getAutCedula() {
        return autCedula;
    }

    public void setAutCedula(String autCedula) {
        this.autCedula = autCedula;
    }

    public String getAutNombre() {
        return autNombre;
    }

    public void setAutNombre(String autNombre) {
        this.autNombre = autNombre;
    }
    @JsonIgnore
    public TitCargo getTitCargo() {
        return titCargo;
    }

    public void setTitCargo(TitCargo titCargo) {
        this.titCargo = titCargo;
    }

  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitConsejoEjec that = (TitConsejoEjec) o;
        if (autCodigo != that.autCodigo) return false;
        if (autCedula != null ? !autCedula.equals(that.autCedula) : that.autCedula != null) return false;
        if (autNombre != null ? !autNombre.equals(that.autNombre) : that.autNombre != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (autCodigo ^ (autCodigo >>> 32));
        result = 31 * result + (autCedula != null ? autCedula.hashCode() : 0);
        result = 31 * result + (autNombre != null ? autNombre.hashCode() : 0);
        return result;
    }*/

	public Long getCodInstitucion() {
		return codInstitucion;
	}

	public void setCodInstitucion(Long codInstitucion) {
		this.codInstitucion = codInstitucion;
	}

	public Long getCodAnioLectivo() {
		return codAnioLectivo;
	}

	public void setCodAnioLectivo(Long codAnioLectivo) {
		this.codAnioLectivo = codAnioLectivo;
	}

	public String getCarNombreTransient() {
		carNombreTransient = titCargo == null ? "" : titCargo.getCarNombre();
		return carNombreTransient;
	}

	public void setCarNombreTransient(String carNombreTransient) {
		this.carNombreTransient = carNombreTransient;
	}
}