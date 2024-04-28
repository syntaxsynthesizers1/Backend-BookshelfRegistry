package com.shelfscribe.backendbookshelfregistry.service.impl;

import com.shelfscribe.backendbookshelfregistry.dto.response.ApiResponse;
import com.shelfscribe.backendbookshelfregistry.dto.response.BookResponse;
import com.shelfscribe.backendbookshelfregistry.dto.response.FavouriteResponse;
import com.shelfscribe.backendbookshelfregistry.entity.Book;
import com.shelfscribe.backendbookshelfregistry.exceptions.CustomException;
import com.shelfscribe.backendbookshelfregistry.mapper.BookMapper;
import com.shelfscribe.backendbookshelfregistry.repository.BookRepository;
import com.shelfscribe.backendbookshelfregistry.repository.PurchaseRepository;
import com.shelfscribe.backendbookshelfregistry.service.FavouriteService;
import com.shelfscribe.backendbookshelfregistry.service.WalletService;
import com.shelfscribe.backendbookshelfregistry.user.User;
import com.shelfscribe.backendbookshelfregistry.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final PurchaseRepository purchaseRepository;

    @Override
    public ApiResponse<Object> createUserWallet(String userEmail) {
        var user = userRepository.findByEmail(userEmail).orElseThrow(() -> new CustomException("User does not exist. Please proceed to registeration"));

        user.setAccountName(user.getFirstName() + user.getLastName());
        user.setAccountNumber("0251561137");
        user.setBankName("Switch-Titan");
        User savedUser = userRepository.save(user);

        return new ApiResponse<Object>(
                true,
                "Wallet has been successfully created",
                null,
                null
        );
    }

    @Override
    public ApiResponse<Object> fundUserWallet(String userEmail, double amount) {
        var user = userRepository.findByEmail(userEmail).orElseThrow(() -> new CustomException("User does not exist. Please proceed to registeration"));

        user.setWalletBalance(user.getWalletBalance() + amount);
        User savedUser = userRepository.save(user);

        return new ApiResponse<Object>(
                true,
                "Wallet has been successfully funded",
                null,
                null
        );
    }
}
