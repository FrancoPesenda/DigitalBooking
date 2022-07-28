package com.franco.carsAPI.service.serviceInterface;

import java.util.List;

public interface ServiceInterface <E,I> {

    List<E> findAll() ;

    E findById( I id ) ;

    E save ( E entity ) ;

    String delete( I id ) ;

    Boolean exist( I id ) ;

}
