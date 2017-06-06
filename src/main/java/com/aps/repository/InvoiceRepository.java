package com.aps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aps.domain.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
