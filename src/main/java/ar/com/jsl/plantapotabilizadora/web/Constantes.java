package ar.com.jsl.plantapotabilizadora.web;

public final class Constantes {

	public static final String URL_API = "/api";
	public static final String URL_API_VERSION = "/v1";
	public static final String URL_API_BASE = URL_API + URL_API_VERSION;

	public static final String URL_USUARIOS = URL_API_BASE + "/usuarios";
	public static final String URL_PERSONAL = URL_API_BASE + "/personal";
	public static final String URL_ESPECIALIDADES = URL_PERSONAL + "/especialidades";
	public static final String URL_CORE = URL_API_BASE + "/core";
	public static final String URL_LOGINOK = "/loginok";
	public static final String URL_AUTHINFO = "/authinfo";
	public static final String URL_LOGOUT = "/dologout";
	public static final String URL_DENY = "/deny";
	public static final String URL_TOKEN = "/authtoken";
}
