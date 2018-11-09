
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="CLIENTE",schema="SAFE")
public class Cliente implements Serializable{
    @Id
    @Column(name="ID_CLIENTE")
    private long idcliente;
    
    @Column(name="RAZON_SOCIAL")
    private String razonsocial;
    
    @Column(name="RUT_CLIENTE")
    private String rutcliente;
    
    @Column(name="GIRO_CLIENTE")
    private String girocliente;
    
    @Column(name="DIRECCION_CLIENTE")
    private String direccioncliente;
    
    @Column(name="TEL_OFICINA")
    private String teloficina;
    
    @Column(name="NOMBRE_CONTACTO")
    private String nombrecontacto;
    
    @Column(name="FONO_CONTACTO")
    private String fonocontacto;
    
    @Column(name="MAIL_CONTACTO")
    private String mailcontacto;
    
    @Column(name="CARGO_CONTACTO")
    private String cargocontacto;
    
    @Column(name="OBSERVACIONES_CLIENTE")
    private String observacionescliente;
    
    @Column(name="ESTADO_CLIENTE")
    private long estadocliente;

    public long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getRutcliente() {
        return rutcliente;
    }

    public void setRutcliente(String rutcliente) {
        this.rutcliente = rutcliente;
    }

    public String getGirocliente() {
        return girocliente;
    }

    public void setGirocliente(String girocliente) {
        this.girocliente = girocliente;
    }

    public String getDireccioncliente() {
        return direccioncliente;
    }

    public void setDireccioncliente(String direccioncliente) {
        this.direccioncliente = direccioncliente;
    }

    public String getTeloficina() {
        return teloficina;
    }

    public void setTeloficina(String teloficina) {
        this.teloficina = teloficina;
    }

    public String getNombrecontacto() {
        return nombrecontacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = nombrecontacto;
    }

    public String getFonocontacto() {
        return fonocontacto;
    }

    public void setFonocontacto(String fonocontacto) {
        this.fonocontacto = fonocontacto;
    }

    public String getMailcontacto() {
        return mailcontacto;
    }

    public void setMailcontacto(String mailcontacto) {
        this.mailcontacto = mailcontacto;
    }

    public String getCargocontacto() {
        return cargocontacto;
    }

    public void setCargocontacto(String cargocontacto) {
        this.cargocontacto = cargocontacto;
    }

    public String getObservacionescliente() {
        return observacionescliente;
    }

    public void setObservacionescliente(String observacionescliente) {
        this.observacionescliente = observacionescliente;
    }

    public long getEstadocliente() {
        return estadocliente;
    }

    public void setEstadocliente(long estadocliente) {
        this.estadocliente = estadocliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idcliente=" + idcliente + ", razonsocial=" + razonsocial + ", rutcliente=" + rutcliente + ", girocliente=" + girocliente + ", direccioncliente=" + direccioncliente + ", teloficina=" + teloficina + ", nombrecontacto=" + nombrecontacto + ", fonocontacto=" + fonocontacto + ", mailcontacto=" + mailcontacto + ", cargocontacto=" + cargocontacto + ", observacionescliente=" + observacionescliente + ", estadocliente=" + estadocliente + '}';
    }
    
        
}
