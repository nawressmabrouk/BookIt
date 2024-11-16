package com.nawres.history;

import com.nawres.book.Book;
import com.nawres.common.BaseEntity;
import com.nawres.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity //this is the association entity between the user and the book 
public class BookTransactionHistory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;     // for user relationship

    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;     //for  book relationship


    private boolean returned;
    private boolean returnApproved;

}