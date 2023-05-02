package com.example.amusetravelproejct.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "item_ticket")
@Getter
@Setter
public class ItemTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    private String price;

    // item_ticket과 iteminfo는 N:1 관계 ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    // item_ticket과 payment_ticket은 1:N 관계
    @OneToMany(mappedBy = "itemTicket")
    private List<PaymentTicket> paymentTickets = new ArrayList<>();

}