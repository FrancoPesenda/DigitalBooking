package com.franco.carsAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franco.carsAPI.model.DTORequest.ProductDTORequest;
import com.franco.carsAPI.model.DTOResponse.ProductDTO;
import com.franco.carsAPI.model.*;
import com.franco.carsAPI.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private CityService cityService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private FeatureProductService featureProductService ;
    @Autowired
    private FeatureService featureService ;
    @Autowired
    private PolicyProductService policyProductService ;
    @Autowired
    private PolicyService policyService ;
    @Autowired
    private ImageService imageService ;
    @Autowired
    private ObjectMapper objectMapper ;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Lista de Alojamientos",
            notes = "Devuelve todas los Alojamientos en la base de datos")
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.ok(service.toDTOList(service.findAll())) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve un Alojamiento",
            notes = "Devuelve un Alojamiento filtrada por su Id ")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id del Alojamiento que buscando encontrar",
                    example = "1",
                    required = true )
            @PathVariable Long id ){
        return ResponseEntity.ok(service.findDTOById(id)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve un Alojamiento",
            notes = "Devuelve un Alojamiento filtrada por el Id de su Categoria ")
    @GetMapping("/getProductByCategoryID/{id}")
    public ResponseEntity<List<ProductDTO>> getProductByCategory(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id de la Categoria del Alojamientto que buscando encontrar",
                    example = "1",
                    required = true )
            @PathVariable Long id ){
        return ResponseEntity.ok(service.toDTOList(service.findAllProductByCategoryId(id))) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve un Alojamiento",
            notes = "Devuelve un Alojamiento filtrada por el nombre de su Ciudad ")
    @GetMapping("/getProductByCityName/{name}")
    public ResponseEntity<List<ProductDTO>> findByCityName(
            @ApiParam(
                    name =  "name",
                    type = "String",
                    value = "Nombre del Alojamiento que buscando encontrar",
                    example = "Buenos Aires",
                    required = true )
            @PathVariable String name ){
        return ResponseEntity.ok(service.findByCityName(name)) ;
    }

    @GetMapping("/getRandom/{amount}")
    public ResponseEntity<List<ProductDTO>> getRandomProduct(
            @ApiParam(
                    name =  "amount",
                    type = "Integer",
                    value = "Cantidad de productos random que queremos",
                    example = "4",
                    required = true )
            @PathVariable Integer amount ){
        return ResponseEntity.ok(service.getRandomProducts(amount)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve la cantidad de Categorias",
            notes = "Devuelve la cantidad de categorias totales filtradas por su Id")
    @GetMapping("/getCountOfCate/{id}")
    public ResponseEntity<Integer> getCountOfCate(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id de la Categoria que quiero contar su total",
                    example = "1",
                    required = true )
            @PathVariable Long id ){
        return ResponseEntity.ok(service.getCountOfCate(id)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una lista de Alojamientos",
            notes = "Devuelve una lista de Alojamientos filtrada por fecha," +
                    " obteniendo los alojamientos libres en ese rango de fechas ")
    @GetMapping("/findProductForDate")
    public ResponseEntity<List<ProductDTO>> findProductByDate(
            @ApiParam(
                    name =  "start",
                    type = "LocalDate",
                    value = "Fecha de inicio a consultar disponibilidad",
                    example = "2022-02-10",
                    required = true )
            @RequestParam("start")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate start ,
            @ApiParam(
                    name =  "finish",
                    type = "LocalDate",
                    value = "Fecha de fin a consultar disponibilidad",
                    example = "2022-03-19",
                    required = true )
            @RequestParam("finish")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate finish ){
        return ResponseEntity.ok(service.findProductByDate(start,finish)) ;

    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una lista de Alojamientos",
            notes = "Devuelve una lista de Alojamientos filtrada por fecha y ciudad," +
                    " obteniendo los alojamientos libres en ese rango de fechas y ciudad ")
    @GetMapping("/findProductForDateAndCity")
    public ResponseEntity<List<ProductDTO>> findProductByDateAndCity(
            @ApiParam(
                    name =  "start",
                    type = "LocalDate",
                    value = "Fecha de inicio a consultar disponibilidad",
                    example = "2022-02-10",
                    required = true )
            @RequestParam("start")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate start ,
            @ApiParam(
                    name =  "finish",
                    type = "LocalDate",
                    value = "Fecha de fin a consultar disponibilidad",
                    example = "2022-03-19",
                    required = true )
            @RequestParam("finish")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate finish ,
            @ApiParam(
                    name =  "city",
                    type = "String",
                    value = "Ciudad a consultar disponibilidad",
                    example = "Córdoba",
                    required = true )
            @RequestParam("city")
                    String city
    ){
        return ResponseEntity.ok(service.findProductByDateAndCity(start,finish,city)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve un Alojamiento",
            notes = "Devuelve el Alojamiento que se acaba de guardar")
    @PostMapping
    public ResponseEntity<ProductDTO> save(
            @ApiParam(
                    name =  "entity",
                    type = "City",
                    value = "  \"name\": \"Nombre del alojamiento\",\n" +
                            "  \"descriptionTitle\": \"Titulo de la descripción del alojamiento\",\n" +
                            "  \"description\":\"Descripción del alojamiento\",\n" +
                            "  \"category\":Id de la categoría a la que pertenece,\n" +
                            "  \"address\":\"Dirección del alojamiento\",\n" +
                            "  \"addressNumber\":\"Numero de la direccón\",\n" +
                            "  \"latitude\":\"Latitud\",\n" +
                            "  \"longitude\":\"Longitud\",\n" +
                            "  \"city\":Id de la ciudad a la que pertenece\n",
                    required = true )
            @RequestBody ProductDTORequest entity ){
        //SET PRODUCT
        Product product = new Product() ;
        product.setName(entity.getName());
        product.setDescriptionTitle(entity.getDescriptionTitle());
        product.setDescription(entity.getDescription());
        product.setCategory(categoriesService.findById(entity.getCategory()));
        //SET THE NEW LOCATION
        if (!locationService.existByAdressNameAndNumber(entity.getAddress(),entity.getAddressNumber())) {
            Location location = new Location();
            location.setAddress(entity.getAddress());
            location.setAddressNumber(entity.getAddressNumber());
            location.setLongitude(entity.getLongitude());
            location.setLatitude(entity.getLatitude());
            location.setCity(cityService.findById(entity.getCity()));
            product.setLocation(locationService.save(location));
        }else{
            product.setLocation(locationService.findLocationByAddressAndAddressNumber(entity.getAddress(),entity.getAddressNumber()));
        }
        product = service.save(product) ;
        //SET FEATURE
        if(!(entity.getFeaturesArray().isEmpty()) && !(entity.getFeaturesArray() == null )) {
            for (Long id : entity.getFeaturesArray()
            ) {
                featureProductService.save(new FeatureProduct(product, featureService.findById(id)));
            }
        }
        //SET POLICY
        if(!(entity.getPolicyProductArray().isEmpty()) && !(entity.getPolicyProductArray() == null)) {
            for (PolicyProduct pp : entity.getPolicyProductArray()
            ) {
                policyProductService.save(new PolicyProduct(pp.getDescription(), product, policyService.findById(pp.getPolicy().getId())));
            }
        }
        //SET IMAGE
        if (!(entity.getImageArray().isEmpty() && !(entity.getImageArray() == null))) {
            assert entity.getImageArray() != null;
            for (Image i : entity.getImageArray()
            ) {
                imageService.save(new Image(i.getTitle(), i.getUrl(), product));
            }
        }
        return ResponseEntity.ok(service.toDTO(product)) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> modify(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id del producto que queremos modificar",
                    example = "1",
                    required = true )
            @PathVariable Long id,
            @ApiParam(
                    name =  "entity",
                    type = "City",
                    value = "  \"name\": \"Nombre del alojamiento\",\n" +
                            "  \"descriptionTitle\": \"Titulo de la descripción del alojamiento\",\n" +
                            "  \"description\":\"Descripción del alojamiento\",\n" +
                            "  \"category\":Id de la categoría a la que pertenece,\n" +
                            "  \"address\":\"Dirección del alojamiento\",\n" +
                            "  \"addressNumber\":\"Numero de la direccón\",\n" +
                            "  \"latitude\":\"Latitud\",\n" +
                            "  \"longitude\":\"Longitud\",\n" +
                            "  \"city\":Id de la ciudad a la que pertenece\n",
                    required = true )
            @RequestBody ProductDTORequest entity ){
        //SET PRODUCT
        Product product = new Product() ;
        product.setId(id);
        product.setName(entity.getName());
        product.setDescriptionTitle(entity.getDescriptionTitle());
        product.setDescription(entity.getDescription());
        product.setCategory(categoriesService.findById(entity.getCategory()));
        //SET THE NEW LOCATION
        if (!locationService.existByAdressNameAndNumber(entity.getAddress(),entity.getAddressNumber())) {
            Location location = new Location();
            location.setAddress(entity.getAddress());
            location.setAddressNumber(entity.getAddressNumber());
            location.setLongitude(entity.getLongitude());
            location.setLatitude(entity.getLatitude());
            location.setCity(cityService.findById(entity.getCity()));
            product.setLocation(locationService.save(location));
        }else{
            product.setLocation(locationService.findLocationByAddressAndAddressNumber(entity.getAddress(),entity.getAddressNumber()));
        }
        product = service.save(product) ;
        //SET FEATURE
        if(!(entity.getFeaturesArray().isEmpty()) && !(entity.getFeaturesArray() == null )) {
            for (Long idFeature : entity.getFeaturesArray()
            ) {
                featureProductService.save(new FeatureProduct(product, featureService.findById(idFeature)));
            }
        }
        //SET POLICY
        if(!(entity.getPolicyProductArray().isEmpty()) && !(entity.getPolicyProductArray() == null)) {
            for (PolicyProduct pp : entity.getPolicyProductArray()
            ) {
                policyProductService.save(new PolicyProduct(pp.getDescription(), product, policyService.findById(pp.getPolicy().getId())));
            }
        }
        //SET IMAGE
        if (!(entity.getImageArray().isEmpty() && !(entity.getImageArray() == null))) {
            assert entity.getImageArray() != null;
            for (Image i : entity.getImageArray()
            ) {
                imageService.save(new Image(i.getTitle(), i.getUrl(), product));
            }
        }
        return ResponseEntity.ok(service.toDTO(product)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id del producto que queremos borrar",
                    example = "1",
                    required = true )
            @PathVariable Long id ){
        return ResponseEntity.ok(service.delete(id));
    }

}
