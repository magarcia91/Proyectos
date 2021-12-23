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
@Table(name = "TIT_CARGO")
@SequenceGenerator(name = "SEQ_TIT_CARGO_GEN", sequenceName = "SEQ_TIT_CARGO", allocationSize = 1)

public class TitCargo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer carCodigo;
    private String carNombre;
    private List<TitConsejoEjec> titAutoridad = new ArrayList<TitConsejoEjec>(0);

    public TitCargo() {
    }

   /* public TitCargo(Integer carCodigo, String carNombre, List<TitConsejoEjec> titAutoridad) {
        this.carCodigo = carCodigo;
        this.carNombre = carNombre;
        this.titAutoridad = titAutoridad;
    }*/

    @Id
    @Column(name = "CAR_CODIGO", unique = true, nullable = false, scale = 0)
    @GeneratedValue(generator = "SEQ_TIT_CARGO_GEN", strategy = GenerationType.SEQUENCE)
    public Integer getCarCodigo() {
        return carCodigo;
    }

    public void setCarCodigo(Integer carCodigo) {
        this.carCodigo = carCodigo;
    }

    @Column(name = "CAR_NOMBRE")
    public String getCarNombre() {
        return carNombre;
    }

    public void setCarNombre(String carNombre) {
        this.carNombre = carNombre;
    }

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "titCargo")
    @JsonIgnore
    public List<TitConsejoEjec> getTitAutoridad() {
        return titAutoridad;
    }

    public void setTitAutoridad(List<TitConsejoEjec> titAutoridad) {
        this.titAutoridad = titAutoridad;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitCargo titCargo = (TitCargo) o;

        if (carCodigo != titCargo.carCodigo) return false;
        if (carNombre != null ? !carNombre.equals(titCargo.carNombre) : titCargo.carNombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (carCodigo ^ (carCodigo >>> 32));
        result = 31 * result + (carNombre != null ? carNombre.hashCode() : 0);
        return result;
    }*/
}
