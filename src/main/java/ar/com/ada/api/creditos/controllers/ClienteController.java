package ar.com.ada.api.creditos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.models.GenericResponse;
import ar.com.ada.api.creditos.services.ClienteService;

@RestController 
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> traerTodos(){
        return ResponseEntity.ok(service.traerTodos());  //devuelve 1 obj responseEntity.ok y el rdo es la lista de clientes
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
        service.crearCliente(cliente);  // solo llama al metodo
        GenericResponse respuesta = new GenericResponse();
        respuesta.isOk = true;
        respuesta.id = cliente.getClienteId();
        respuesta.message= "El cliente fue creado con éxito";
        return ResponseEntity.ok(respuesta);
    }

    
}
