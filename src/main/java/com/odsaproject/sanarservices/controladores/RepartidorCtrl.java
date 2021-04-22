/**
 * 
 */
package com.odsaproject.sanarservices.controladores;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odsaproject.sanarservices.entidades.Repartidor;
import com.odsaproject.sanarservices.pojos.Login;
import com.odsaproject.sanarservices.servicios.RepartidorSrv;
import com.odsaproject.sanarservices.util.Encriptar;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/repartidor", produces = "application/json")
public class RepartidorCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private RepartidorSrv repartidorSrv;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Repartidor r) {
		
		return ResponseEntity.ok(repartidorSrv.crear(r));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Repartidor r) {
		
		return ResponseEntity.ok(repartidorSrv.crear(r));
	}

	@RequestMapping
	public List<Repartidor> listarTodo() {
		List<Repartidor> result = repartidorSrv.devolverTodo();
		
		return result;
	}
	
	@GetMapping("/id/{id}")
	public Repartidor devolverPorId(@PathVariable("id") Long id) {
		Optional<Repartidor> result = repartidorSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/vehiculo/{vehiculo}")
	public List<Repartidor> devolverPorVehiculo(@PathVariable("vehiculo") Long vehiculo) {
		List<Repartidor> result = repartidorSrv.devolverPorVehiculo(vehiculo);
			
		return result;
	}
	
	@GetMapping("/nombre/{nombre}")
	public List<Repartidor> devolverPorNombre(@PathVariable("nombre") String nombre) {
		List<Repartidor> result = repartidorSrv.devolverPorNombre(nombre);
			
		return result;
	}
	
	@GetMapping("/apellidos/{apellido}")
	public List<Repartidor> devolverPorApellidos(@PathVariable("apellido") String apellido) {
		List<Repartidor> result = repartidorSrv.devolverPorNombre(apellido);
			
		return result;
	}
	
	@GetMapping("/nombreApellidos/{nombre}/{apellido}")
	public List<Repartidor> devolverPorApellidos(@PathVariable("apellido") String nombre, @PathVariable("apellido") String apellido) {
		List<Repartidor> result = repartidorSrv.devolverPorNombreApellido(nombre, apellido);
			
		return result;
	}
	
	@GetMapping("/cedula/{cedula}")
	public Repartidor devolverPorCedula(@PathVariable("cedula") String cedula) {
		Optional<Repartidor> result = repartidorSrv.devolverPorCedula(cedula);
		if(!result.isPresent())
			LOGGER.error("No exsite la cédula: " + cedula);
			
		return result.orElse(null);
	}
	
	@GetMapping("/email/{mail}")
	public Repartidor devolverPorMail(@PathVariable("mail") String mail) {
		Optional<Repartidor> result = repartidorSrv.devolverPorEmail(mail);
		if(!result.isPresent())
			LOGGER.error("No exsite el correo: " + mail);
			
		return result.orElse(null);
	}
	
	@GetMapping("/telefono/{telefono}")
	public Repartidor devolverPorTelefono(@PathVariable("telefono") String telefono) {
		Optional<Repartidor> result = repartidorSrv.devolverPorTelefono(telefono);
		if(!result.isPresent())
			LOGGER.error("No exsite el telefono: " + telefono);
			
		return result.orElse(null);
	}
	
	@PostMapping("/onLine")
	public List<Repartidor> devolverOnline() {
		List<Repartidor> result = repartidorSrv.devolverOnLine();
		
		return result;
	}
	
	@PostMapping("/offLine")
	public List<Repartidor> devolverOffline() {
		List<Repartidor> result = repartidorSrv.devolverOffLine();
		
		return result;
	}
	
	@PostMapping("/login")
	public Repartidor login(@RequestBody Login login) {
		String passEncp = Encriptar.EncriptarMD5(login.getPassword());
		Optional<Repartidor> result = repartidorSrv.login(passEncp, login.getMail());
		if(!result.isPresent())
			LOGGER.error("Login incorrecto");
		
		return result.orElse(null);
	}

}
