package com.cos.miribogi.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    private String img;

    @ColumnDefault("0")
    private int count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy는 연관관계의 주인이 아닌 것(FK가 아님), DB에 컬럼을 만들지 않는다
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
