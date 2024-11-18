package com.snapmart.service;

import com.snapmart.dto.request.ProductRequest;
import com.snapmart.dto.response.ProductResponse;
import com.snapmart.exceptions.SellerNotFoundException;
import com.snapmart.model.Product;
import com.snapmart.model.Seller;
import com.snapmart.repository.ProductRepository;
import com.snapmart.repository.SellerRepository;
import com.snapmart.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;



    public ProductResponse setProduct(ProductRequest productRequest,String sellerEmail){

        Optional<Seller> optionalSeller=sellerRepository.findByEmail(sellerEmail);

        if(optionalSeller.isEmpty()){
            throw new SellerNotFoundException("OOPS  Invalid Seller Email!!!");
        }
        Seller seller=optionalSeller.get();
        Product product= ProductTransformer.productRequestToProduct(productRequest);
        product.setSeller(seller);

        seller.getProductList().add(product);

        Seller savedSeller=sellerRepository.save(seller);

        int size=seller.getProductList().size();

        Product newlyAddedProduct=seller.getProductList().get(size-1);

        return ProductTransformer.productToProductResponse(newlyAddedProduct);

    }
}
