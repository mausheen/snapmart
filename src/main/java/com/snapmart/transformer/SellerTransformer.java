package com.snapmart.transformer;

import com.snapmart.dto.request.SellerRequest;
import com.snapmart.dto.response.SellerResponse;
import com.snapmart.enums.AccountStatus;
import com.snapmart.enums.Gender;

import com.snapmart.model.Seller;

public class SellerTransformer {

    public static Seller sellerRequestToSeller(SellerRequest sellerRequest){
        return Seller.builder()
                .companyName(sellerRequest.getCompanyName())
                .email(sellerRequest.getEmail())
                .phone(sellerRequest.getPhone())
                .businessAddress(sellerRequest.getBusinessAddress())
                .bankDetails(sellerRequest.getBankDetails())
                .rating(sellerRequest.getRating())
                .accountStatus(AccountStatus.ACTIVE)
                .gender(Gender.MALE)
                .build();
    }



    public static SellerResponse sellerToSellerResponse(Seller seller){
        return SellerResponse.builder()
                .companyName(seller.getCompanyName())
                .email(seller.getEmail())
                .businessAddress(seller.getBusinessAddress())
                .phone(seller.getPhone())
                .build();
    }
}
