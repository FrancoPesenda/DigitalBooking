package com.franco.carsAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franco.carsAPI.model.Score;
import com.franco.carsAPI.model.DTOResponse.ScoreDTO;
import com.franco.carsAPI.repository.ScoreRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterfaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.*;

@Service
public class ScoreService implements ServiceInterfaceDTO<Score,ScoreDTO,Long> {

    @Autowired
    private ScoreRepository repository ;
    @Autowired
    private ObjectMapper objectMapper ;

    @Override
    public List<Score> findAll() {
        return repository.findAll();
    }

    @Override
    public Score findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }

    @Override
    public Score save(Score entity) {
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
        for (Score e : this.findAll()){
            if (e.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<ScoreDTO> findAllDTO() {
        return this.toDTOList(this.findAll()) ;
    }

    @Override
    public ScoreDTO findDTOById(Long id) {
        return this.toDTO(this.findById(id)) ;
    }

    @Override
    public ScoreDTO toDTO(Score entity) {
        return new ScoreDTO(
                this.getScoreNumberOfTheProduct(entity.getProduct().getId())
        );
    }

    @Override
    public Set<ScoreDTO> toDTOSet(Set<Score> entitySet) {
        Set<ScoreDTO> setDTO = new HashSet<>() ;
        for (Score e : entitySet
        ) {
            setDTO.add(this.toDTO(e)) ;
        }
        return setDTO ;
    }

    @Override
    public List<ScoreDTO> toDTOList(List<Score> entityList) {
        List<ScoreDTO> setDTO = new ArrayList<>() ;
        for (Score e : entityList
        ) {
            setDTO.add(this.toDTO(e)) ;
        }
        return setDTO ;
    }

    public Double getScoreNumberOfTheProduct( Long id ){
        Double total = 0.0 ;
        Integer totalScore = 0 ;
        for (Score score:repository.getAllScoreByProductId(id).get()
        ) {
            total += score.getScore() ;
            totalScore ++ ;
        }

        return (total/totalScore) ;
    }

}
