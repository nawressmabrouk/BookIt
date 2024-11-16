package com.nawres.book;

import java.beans.Transient;
import java.util.List;

import com.nawres.common.BaseEntity;
import com.nawres.feedback.Feedback;
import com.nawres.history.BookTransactionHistory;
import com.nawres.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {
    

    private String title;

    private String authorName;

    private String isbn;

    private String synopsis;

    private String bookCover;

    private boolean archived;

    private boolean shareable;

    @ManyToOne // many books can be assigned to one user
    @JoinColumn(name = "owner_id") // optional
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<Feedback> feedback;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

    @Transient // used to indicate that a particular field of an entity should not be persisted
               // to the database.
    public double getRate() {
        if (feedback.isEmpty() || feedback == null) {
            return 0;
        }

        var rate = this.feedback.stream()
                .mapToDouble(Feedback::getNote)
                .average()
                .orElse(0.0);
        double roundedRate = Math.round(rate * 10.0) / 10.0;

        return roundedRate;

    }
}