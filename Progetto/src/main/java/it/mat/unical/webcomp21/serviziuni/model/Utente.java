package it.mat.unical.webcomp21.serviziuni.model;

public class Utente {

	private String email;
	private String nome;
	private String cognome;
	private String password;
	private String username;
	private int permessi;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPermessi(int permessi) {
		this.permessi=permessi;
	}
	public int getPermessi() {
		return permessi;
	}
}
