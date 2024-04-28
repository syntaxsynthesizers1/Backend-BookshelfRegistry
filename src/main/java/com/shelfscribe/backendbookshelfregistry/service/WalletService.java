package com.shelfscribe.backendbookshelfregistry.service;

import com.shelfscribe.backendbookshelfregistry.dto.response.ApiResponse;
import com.shelfscribe.backendbookshelfregistry.dto.response.FavouriteResponse;

import java.util.List;

public interface WalletService {

    ApiResponse<Object> createUserWallet(String userEmail);

    ApiResponse<Object> fundUserWallet(String userEmail, double amount);
}
