package com.repository;

import com.model.FornecedorModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends MongoRepository<FornecedorModel, String> {
    FornecedorModel findByCnpj(String cnpj);
}