package com.uba.assetdisposal.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uba.assetdisposal.dto.ProductDTO;
import com.uba.assetdisposal.model.Product;
import com.uba.assetdisposal.repository.ProductRepository;
import com.uba.assetdisposal.tools.DateStringConverter;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	
	@PostMapping 							  
	public ResponseEntity<ProductDTO> postReport( HttpServletResponse response, @Valid ProductDTO productDTO, Errors errors ) throws IOException, ParseException {
		
		Product product = new Product ();
		product.setName( productDTO.getName() );
		product.setMaxDays( productDTO.getMaxDays() );
		product.setBidStart( DateStringConverter.stringToLocalDate( productDTO.getBidStart() ) );
		product.setBidEnd( DateStringConverter.stringToLocalDate( productDTO.getBidEnd() ) );
		product.setSolid( productDTO.getSolid() );
		product.setDescription( productDTO.getDescription() );
		product.setQuantity( productDTO.getQuantity() );
		product.setPrice( productDTO.getPrice() );
		product.setCurrentAmount( productDTO.getCurrentAmount() );
		product.setStartAmount( productDTO.getStartAmount() );
		product.setData( productDTO.getData() );
		
		return new ResponseEntity<>( new ProductDTO( productRepository.save(product) ), HttpStatus.OK);
	}

}
