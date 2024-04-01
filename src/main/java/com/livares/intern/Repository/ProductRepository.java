
package com.livares.intern.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.livares.intern.Model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}

