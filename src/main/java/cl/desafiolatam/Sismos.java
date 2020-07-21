package cl.desafiolatam;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Sismos {

	public String Fecha;
	public String Latitud;
	public String Longitud;
	public String Profundidad;
	public String Magnitud;
	public String Agencia;
	public String RefGeografica;
	public String FechaUpdate;

//	CONTRUCTOR SIN PARAMETROS
	public Sismos() {

	}

//	CONTRUCTOR SIN PARAMETROS
	public Sismos(String fecha, String latitud, String longitud, String profundidad, String magnitud, String agencia,
			String refGeografica, String fechaUpdate) {
		super();
		Fecha = fecha;
		Latitud = latitud;
		Longitud = longitud;
		Profundidad = profundidad;
		Magnitud = magnitud;
		Agencia = agencia;
		RefGeografica = refGeografica;
		FechaUpdate = fechaUpdate;
	}

//	GETTERS AND SETTERS
	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getLatitud() {
		return Latitud;
	}

	public void setLatitud(String latitud) {
		Latitud = latitud;
	}

	public String getLongitud() {
		return Longitud;
	}

	public void setLongitud(String longitud) {
		Longitud = longitud;
	}

	public String getProfundidad() {
		return Profundidad;
	}

	public void setProfundidad(String profundidad) {
		Profundidad = profundidad;
	}

	public String getMagnitud() {
		return Magnitud;
	}

	public void setMagnitud(String magnitud) {
		Magnitud = magnitud;
	}

	public String getAgencia() {
		return Agencia;
	}

	public void setAgencia(String agencia) {
		Agencia = agencia;
	}

	public String getRefGeografica() {
		return RefGeografica;
	}

	public void setRefGeografica(String refGeografica) {
		RefGeografica = refGeografica;
	}

	public String getFechaUpdate() {
		return FechaUpdate;
	}

	public void setFechaUpdate(String fechaUpdate) {
		FechaUpdate = fechaUpdate;
	}

//	METODO TOSTRING
	@Override
	public String toString() {
		return "Sismos en chile:  \nFecha: " + Fecha + "\nLatitud: " + Latitud + "\nLongitud: " + Longitud
				+ "\nProfundidad: " + Profundidad + "\nMagnitud: " + Magnitud + "\nAgencia: " + Agencia
				+ "\nRefGeografica: " + RefGeografica + "\nFechaUpdate: " + FechaUpdate + "\n"
				+ "*****************************" + "\n";
	}

//	METODO QUE ME RETORNA LOS SISMOS
	public List<Sismos> retornarSismos() {

		Client client = ClientBuilder.newClient();

//		Una vez que se tiene la instancia del Cliente, se puede crear un WebTarget utilizando el URI del recurso
//		web objetivo, en este caso es la ruta: https://jsonplaceholder.typicode.com/posts . De la cual
//		obtendremos las publicaciones (posts).
		WebTarget target = client.target("https://api.gael.cl/general/public/").path("sismos");

//		Se crea un generador de invocación de instancias con uno de los métodos de Jersey llamado
//		WebTarget.request():
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

//		Invocando GET, para consumir API. Método GET usado para obtener un recurso.
		Response respuestaSismos = invocationBuilder.get();

//		Para leer la respuesta y asignarla a una propiedad, se debe llamar al método readEntity.
		List<Sismos> listaSismos = respuestaSismos.readEntity(new GenericType<List<Sismos>>() {
		});

//    	retornamos la lista con los sismos 
		return listaSismos;
	}

	public void mostrarUltimoSismo(List<Sismos> listaSismos) {

		Optional<Sismos> optional = listaSismos.stream().findFirst();
		System.out.println("Ultimo sismo en chile: \n" + optional.get());

//		CON METODO ITERATOR
//		Iterator iter = listaSismos.iterator();//creamos un iterador
//		if (iter.hasNext()) {//devuelve un verdadero si hay elementos en la iteracion
//		       Object primero = iter.next();//retorna el siguiente valor en la iteraccion, en este caso el primero
//		       System.out.println("Ultimo sismo en chile: \n"+primero);//imprimimos el primer valor 
//		}

	}

}
