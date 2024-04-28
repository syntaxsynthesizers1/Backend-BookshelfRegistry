package com.shelfscribe.backendbookshelfregistry.dto.request;

import com.shelfscribe.backendbookshelfregistry.entity.Book;
import com.shelfscribe.backendbookshelfregistry.user.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartReadingRequest {
    private Long bookId;
}
