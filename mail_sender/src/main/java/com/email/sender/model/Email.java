/*
 * package com.email.sender.model;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name="email") public class Email {
 * 
 * @Id
 * 
 * @GeneratedValue (strategy = GenerationType.AUTO) private long id; private
 * String destinatario; private String asunto; private String mensaje;
 * 
 * 
 * public Email(long id, String destinatario, String asunto, String mensaje) {
 * 
 * this.id = id; this.destinatario = destinatario; this.asunto = asunto;
 * this.mensaje = mensaje; }
 * 
 * public Email() { super(); }
 * 
 * 
 * public long getId() { return id; }
 * 
 * 
 * public void setId(long id) { this.id = id; }
 * 
 * 
 * public String getDestinatario() { return destinatario; }
 * 
 * 
 * public void setDestinatario(String destinatario) { this.destinatario =
 * destinatario; }
 * 
 * 
 * public String getAsunto() { return asunto; }
 * 
 * 
 * public void setAsunto(String asunto) { this.asunto = asunto; }
 * 
 * 
 * public String getMensaje() { return mensaje; }
 * 
 * 
 * public void setMensaje(String mensaje) { this.mensaje = mensaje; }
 * 
 * @Override public String toString() { return "Email [id=" + id +
 * ", destinatario=" + destinatario + ", asunto=" + asunto + ", mensaje=" +
 * mensaje + "]"; }
 * 
 * 
 * }
 */