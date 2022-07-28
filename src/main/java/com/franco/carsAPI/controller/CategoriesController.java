package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.Category;
import com.franco.carsAPI.model.DTOResponse.CategoryDTO;
import com.franco.carsAPI.model.DTORequest.IncomeCategoryDTO;
import com.franco.carsAPI.service.CategoriesService;
import com.franco.carsAPI.service.ProductService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity ;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoriesController implements ControllerInterface<CategoryDTO , IncomeCategoryDTO , Long > {

    @Autowired
    private CategoriesService service;
    @Autowired
    private ProductService productService;

    Logger logger = LoggerFactory.getLogger(CategoriesController.class) ;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Categoria",
            notes = "Devuelve un Array con las Categorias de la base de datos")
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.ok(service.findAllDTO()) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Categoria",
            notes = "Devuelve una Categoria filtrado por ID ")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id del producto que estoy buscando encontrar",
                    example = "1",
                    required = true )
            @PathVariable Long id ){
        return ResponseEntity.ok(service.findDTOById(id)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Categoria",
            notes = "Devuelve una Categoria que se acaba de guardar")
    @PostMapping
    public ResponseEntity<CategoryDTO> save(
            @ApiParam(
                    name =  "Categoría",
                    type = "Category",
                    value = "\"title\": \"Titulo de la Categoría\",\n" +
                            "\"description\": \"Descripción de la categoría\",\n" +
                            "\"image\": \"URL de la imágen\"\n",
                    required = true)
            @RequestBody IncomeCategoryDTO inCategory){
        Category category = new Category() ;
        category.setSingularTitle(inCategory.getSingularTitle());
        category.setPluralTitle(inCategory.getPluralTitle());
        category.setImage(inCategory.getImage());
        return ResponseEntity.ok(service.toDTO(service.save(category))) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Categoria",
            notes = "Devuelve una Categoria que se acaba de modificar")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> modify(
            @PathVariable Long id,
            @ApiParam(
                    name =  "Categoría",
                    type = "Category",
                    value = "\"title\": \"Titulo de la Categoría\",\n" +
                            "\"description\": \"Descripción de la categoría\",\n" +
                            "\"image\": \"URL de la imágen\"\n",
                    required = true)
            @RequestBody IncomeCategoryDTO inCategory){
        Category category = new Category() ;
        category.setId(id);
        category.setSingularTitle(inCategory.getSingularTitle());
        category.setPluralTitle(inCategory.getPluralTitle());
        category.setImage(inCategory.getImage());
        return ResponseEntity.ok(service.toDTO(service.save(category))) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Mensaje",
            notes = "Devuelve un String deleted en caso de que se borro correctamente")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id de la categoria que estoy buscando borrar",
                    example = "1",
                    required = true )
            @PathVariable Long id ){

        return ResponseEntity.ok(service.delete(id));
    }

}
