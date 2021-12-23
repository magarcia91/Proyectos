package ec.gob.educacion.model.tit;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 15/01/2015.
 */
@Entity
@Table(name = "TIT_PARTICIPACION_EST")
@SequenceGenerator(name = "SEQ_TIT_PARTICIPACION_EST_GEN", sequenceName = "SEQ_TIT_PARTICIPACION_EST", allocationSize = 1)

public class TitParticipacionEst implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer pesCodigo;
    private String pesNombre;
    private List<TitRefrendacion> titRefrendacion = new ArrayList<TitRefrendacion>(0);

    public TitParticipacionEst() {
    }

  /*  public TitParticipacionEst(long pesCodigo, String pesNombre, List<TitRefrendacion> titRefrendacion) {
        this.pesCodigo = pesCodigo;
        this.pesNombre = pesNombre;
        this.titRefrendacion = titRefrendacion;
    }*/

    @Id
    @Column(name = "PES_CODIGO", unique = true, nullable = false, scale = 0)
    @GeneratedValue(generator = "SEQ_TIT_PARTICIPACION_EST_GEN", strategy = GenerationType.SEQUENCE)
    public Integer getPesCodigo() {
        return pesCodigo;
    }

    public void setPesCodigo(Integer pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    @Column(name = "PES_NOMBRE")
    public String getPesNombre() {
        return pesNombre;
    }

    public void setPesNombre(String pesNombre) {
        this.pesNombre = pesNombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "titParticipacionEst")
    @JsonIgnore
    public List<TitRefrendacion> getTitRefrendacion() {
        return titRefrendacion;
    }

    public void setTitRefrendacion(List<TitRefrendacion> titRefrendacion) {
        this.titRefrendacion = titRefrendacion;
    }

  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitParticipacionEst that = (TitParticipacionEst) o;

        if (pesCodigo != that.pesCodigo) return false;
        if (pesNombre != null ? !pesNombre.equals(that.pesNombre) : that.pesNombre != null) return false;

        return true;
    }*/

   /* @Override
    public int hashCode() {
        int result = (int) (pesCodigo ^ (pesCodigo >>> 32));
        result = 31 * result + (pesNombre != null ? pesNombre.hashCode() : 0);
        return result;
    }*/
}
