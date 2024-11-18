package com.snapmart.service;

import com.snapmart.dto.request.SellerRequest;
import com.snapmart.dto.response.SellerResponse;
import com.snapmart.model.Seller;
import com.snapmart.repository.SellerRepository;
import com.snapmart.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    public SellerResponse setSeller(SellerRequest sellerRequest){

        Seller seller= SellerTransformer.sellerRequestToSeller(sellerRequest);

        Seller savedSeller=sellerRepository.save(seller);
        SellerResponse sellerResponse=SellerTransformer.sellerToSellerResponse(savedSeller);

        return sellerResponse;


    }
}
