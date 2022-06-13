package com.uba.assetdisposal.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String postReport( HttpServletResponse response, @Valid ProductDTO productDTO, Errors errors ) throws IOException, ParseException {	
		System.out.println("Got the Product");
		System.out.println( "Name : "+productDTO.getName() );
		System.out.println( "ProductDTO Bid Start : "+productDTO.getBidStart() );
		System.out.println( "ProductDTO Data : "+productDTO.getData() );
		
		Product product = new Product ();
		product.setName( productDTO.getName() );
		product.setMaxDays( productDTO.getMaxDays() );
		product.setBidStart( DateStringConverter.stringToLocalDate( productDTO.getBidStart() ) );
		System.out.println( "Product Bid Start : "+product.getBidStart() );
		product.setBidEnd( DateStringConverter.stringToLocalDate( productDTO.getBidEnd() ) );
		product.setSolid( productDTO.getSolid() );
		product.setDescription( productDTO.getDescription() );
		product.setQuantity( productDTO.getQuantity() );
		product.setPrice( productDTO.getPrice() );
		product.setCurrentAmount( productDTO.getCurrentAmount() );
		product.setStartAmount( productDTO.getStartAmount() );
		product.setData( productDTO.getData() );
		
		productRepository.save(product);
		
		System.out.println( productRepository.findById( product.getId() ).get().getData() );
		System.out.println( productRepository.findById( product.getId() ).get().getData().toString() );
		
		return null;
	}

}
