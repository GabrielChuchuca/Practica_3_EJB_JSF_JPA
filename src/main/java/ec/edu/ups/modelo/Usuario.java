package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cedula;
	
	private String nombre;
	private String apellido;
	
	@Column(unique = true)
	private String correo;
	
	private String password;
	private String rol;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FacturaCabecera> facturas;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Localidad> localidades;
    private boolean cambioPassword;
    private boolean activo;
    
    @Transient
    private boolean editable;
	
	public Usuario() {
		this.rol = "cliente";
        this.password = "12345";
        this.cambioPassword = false;
        this.activo = true;
        this.localidades = new ArrayList<>();
	}
	
    public Usuario(String cedula, String nombre, String apellido, String correo, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.rol = "cliente";
        this.activo = true;
        this.localidades = new ArrayList<>();
    }

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the facturas
	 */
	public List<FacturaCabecera> getFacturas() {
		return facturas;
	}

	/**
	 * @param facturas the facturas to set
	 */
	public void setFacturas(List<FacturaCabecera> facturas) {
		this.facturas = facturas;
	}

	/**
	 * @return the localidades
	 */
	public List<Localidad> getLocalidades() {
		return localidades;
	}

	/**
	 * @param localidades the localidades to set
	 */
	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}

	/**
	 * @return the cambioPassword
	 */
	public boolean isCambioPassword() {
		return cambioPassword;
	}

	/**
	 * @param cambioPassword the cambioPassword to set
	 */
	public void setCambioPassword(boolean cambioPassword) {
		this.cambioPassword = cambioPassword;
	}

	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * @return the editable
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * @param editable the editable to set
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public int hashCode() {
		int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cedula);
        return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
	}
	
    public void addLocalidad(Localidad localidad) {
        if (!this.localidades.contains(localidad)) {
            this.localidades.add(localidad);
            localidad.setUsuario(this);
        }
    }

    public void deleteLocalidad(Localidad localidad) {
        if (this.localidades.contains(localidad)) {
            this.localidades.remove(localidad);
            localidad.setUsuario(null);
        }
    }

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", password=" + password + ", rol=" + rol + ", cambioPassword="
				+ cambioPassword + ", activo=" + activo + ", editable=" + editable + "]";
	}
	
	
}