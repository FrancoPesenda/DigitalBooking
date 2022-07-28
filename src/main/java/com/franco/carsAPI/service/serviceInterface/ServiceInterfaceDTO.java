package com.franco.carsAPI.service.serviceInterface;

import java.util.List;
import java.util.Set;

public interface ServiceInterfaceDTO<E,D,I> {

    List<E> findAll() ;

    E findById( I id ) ;

    E save ( E entity ) ;

    String delete( I id ) ;

    Boolean exist( I id ) ;

    List<D> findAllDTO () ;

    D findDTOById( I id ) ;

    D toDTO ( E entity ) ;

    Set<D> toDTOSet ( Set<E> entitySet ) ;

    List<D> toDTOList( List<E> entityList ) ;

}
