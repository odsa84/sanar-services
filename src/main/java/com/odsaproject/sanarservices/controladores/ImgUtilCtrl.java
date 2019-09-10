/**
 * 
 */
package com.odsaproject.sanarservices.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.odsaproject.sanarservices.entidades.Categoria;

/**
 * @author Osvaldo
 *
 */
@RestController
//@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8101"})
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/imgutil", produces = "application/json")
public class ImgUtilCtrl {

	@PostMapping("/")
	public void pictureupload(@RequestParam("file") MultipartFile file, @RequestBody Categoria categoria) {

		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

	}

}
