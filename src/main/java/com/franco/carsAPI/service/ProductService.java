package com.franco.carsAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franco.carsAPI.model.City;
import com.franco.carsAPI.model.Location;
import com.franco.carsAPI.model.Product;
import com.franco.carsAPI.model.Reservation;
import com.franco.carsAPI.model.DTOResponse.ProductDTO;
import com.franco.carsAPI.repository.ProductRepository;
import com.franco.carsAPI.repository.ReservationRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterfaceDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductService implements ServiceInterfaceDTO<Product,ProductDTO,Long> {

    @Autowired
    ProductRepository repository ;
    @Autowired
    ImageService imageService;
    @Autowired
    CityService cityService;
    @Autowired
    LocationService locationService;
    @Autowired
    CategoriesService categoriesService;
    @Autowired
    FeatureProductService featureProductService;
    @Autowired
    FeatureService featureService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    PolicyProductService policyProductService;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ObjectMapper objectMapper ;


    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }

    @Override
    public Product save(Product entity) {
        return repository.save(entity) ;
    }

    @Override
    public String delete(Long id) {
        if (this.exist(id)){
            repository.deleteById(id);
            return "Deleted" ;
        }
        throw new BadRequestException("El ID proveido no pertenece a ningun dato en la base de datos") ;

    }

    @Override
    public Boolean exist(Long id) {
        for (Product e : this.findAll()){
            if (e.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<ProductDTO> findAllDTO() {
        return this.toDTOList(this.findAll()) ;
    }

    @Override
    public ProductDTO findDTOById(Long id) {
        return this.toDTO(this.findById(id)) ;
    }

    @Override
    public ProductDTO toDTO(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescriptionTitle(),
                entity.getDescription(),
                categoriesService.toDTO(entity.getCategory()),
                locationService.toDTO(entity.getLocation()),
                scoreService.getScoreNumberOfTheProduct(entity.getId()),
                imageService.findByProductId(entity.getId()),
                featureProductService.findAllFeatureDTOByProductId(entity.getId()),
                policyProductService.findAllPolicyByProductId(entity.getId()),
                this.findAllReservationDate(entity.getId())
        );
    }

    @Override
    public Set<ProductDTO> toDTOSet(Set<Product> entitySet) {
        Set<ProductDTO> listDTO = new HashSet<>() ;
        for (Product e : entitySet
        ) {
            listDTO.add(this.toDTO(e)) ;
        }
        return listDTO;
    }

    @Override
    public List<ProductDTO> toDTOList(List<Product> entityList) {
        List<ProductDTO> listDTO = new ArrayList<>() ;
        for (Product e : entityList
        ) {
            listDTO.add(this.toDTO(e)) ;
        }
        return listDTO;
    }

    public Integer countByCategoryId( Long id ){
        return repository.countByCategoryId(id).get() ;
    }

    public List<Product> findAllProductByCategoryId( Long id ){
        return repository.findAllProductByCategoryId(id).get() ;
    }

    public List<Integer> findAllId(){
        return repository.findAllId().get() ;
    }

    public List<ProductDTO> findByCityName( String cityName ){
        //REVISAR
        List<ProductDTO> list = new ArrayList<>() ;
        for (City city : cityService.findCityByCityName(cityName)
        ) {
            for (Location location:city.getLocationSet()
                 ) {
                list.add(this.toDTO(location.getProduct())) ;
            }
        }
        return list ;
    }

    public List<ProductDTO> getRandomProducts( Integer amount ){

        List<ProductDTO> list = new ArrayList<>() ;
        List<Integer> listID = this.findAllId();
        int index ;
        for (int i = 0; i < amount; i++) {
            index = (int)(Math.random()*(listID.size())+0) ;
            list.add(this.findDTOById(Long.valueOf(listID.get(index)))) ;
            listID.remove(index) ;
        }
        return list ;
    }

    public Integer getCountOfCate( Long id ){
        return repository.countByCategoryId(id).get() ;
    }
    
    public List<ProductDTO> findProductByDate(LocalDate start , LocalDate finish ){
        List<ProductDTO> list = new ArrayList<>() ;
        boolean b ;
        for (Product product : this.findAll()
             ) {
            b = true ;
            for (Reservation r : product.getReservationSet()
                 ) {
                if (!(finish.isBefore(r.getStartDay()) || start.isAfter(r.getFinishDay()))){
                    b = false ;
                }
            }
            if (b){
                list.add(this.toDTO(product)) ;
            }
        }

        return list ;
    }
    //ARREGLAR
    public List<ProductDTO> findProductByDateAndCity(LocalDate start , LocalDate finish , String city ){
        List<ProductDTO> list = new ArrayList<>() ;
        Set<String> citys = new HashSet<>() ;
        boolean b ;
        for (ProductDTO pdto :this.findByCityName(city)
             ) {
            citys.add(pdto.getLocationDTO().getCity()) ;
        }
        for (ProductDTO p : this.findProductByDate(start,finish)){
            b = false ;
            for (String c : citys
                 ) {
                if (p.getLocationDTO().getCity().equals(c)){
                    b = true ;
                }
            }
            if (b){
                list.add(p) ;
            }
        }
        return list ;
    }

    public List<LocalDate> findAllReservationDate( Long id ){
        List<LocalDate> list = new ArrayList<>() ;
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start  ;
        LocalDate finish ;
        for (Reservation e : reservationRepository.findAllReservationByProductId(id)
             ) {
            start = e.getStartDay() ;
            finish = e.getFinishDay() ;
            while (!start.isAfter(finish)){
                list.add(start) ;
                start = start.plusDays(1) ;
            }
        }
        return list ;
    }

}
