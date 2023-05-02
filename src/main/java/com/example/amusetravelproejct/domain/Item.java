package com.example.amusetravelproejct.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "item")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class    Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;                // db의 고유 Id

    private Long itemCode;          // 상품 코드
    private String country;         // 나라
    private String city;            // 도시
    private String title;           // 상품 제목
    private Float rated;            // 모든 리뷰들 평점의 평균
    private Long startingPrice;     // 많은 상품 가격 중 가장 싼 것
    private Long maxPrice;          // 많은 상품 가격 중 가장 비싼 것
    private Long duration;          // 기간 (2박 3일 에서 3)
    private Long like_num;          // 좋아요 수

    // item와 ItemImg 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemImg> itemImg_list = new ArrayList<>();

    // item에는 여러개 아이콘 가능
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemIcon> itemIcon_list = new ArrayList<>();

    // item에는 여러개 티켓이 있다.
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemTicket> itemTickets = new ArrayList<>();

    // item에는 여러개 itemprice가 있다.
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPrice> itemPrices = new ArrayList<>();

    // 상품 상세 정보에서 상품 상세 내용에 여러가지 내용들이 들어갈 수 있다.
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemContent> itemContents = new ArrayList<>();

    // item와 item_course는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCourse> itemCourses = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemOtherContent> itemOtherContents = new ArrayList<>();


            // 위에는 상품 상페 페이지 api짜면서 새로 짠 코드입니다.
//------------------------------------------------------------------------------------------------------------------------------------------------------
            // 밑에는 기존의 코드입니다. 기존의 코드도 나중에 쓸 수 있으니 그대로 놔 두시고 만약 밑에 있는 내용을 api 만들 때 쓰셨다면
                    // 밑에 있는 거 지우시고 위에 작성해 주세여
                    // 나중에 밑에 있는 코드는 다 지울 생각입니다.!



    private String itemIntroduction;    // 상품 소개 (html)
    private Long usageTime;             //
    private String locationGuide;
    private Double Latitude;
    private Double Longitude;
    private String usageMethod;
    private String location;                    //
    private Double mapTopLeftLatitude;          // 지도 왼쪽 위 - 위도
    private Double mapTopLeftLongitude;         // 지도 왼쪽 위 - 경도
    private Double mapBottomRightLatitude;      // 지도 오른쪽 아래 - 위도
    private Double mapBottomRightLongitude;     // 지도 오른쪽 아래 - 경도

    // item와 category는 N:1 관계 ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // item와 item_option은 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemOption> itemOptions = new ArrayList<>();



    // item와 item_ticket과 는 1:N 관계


    // item와 estimate_contact는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstimateContact> estimateContacts = new ArrayList<>();

    // item와 item_price는 N:1 관계(수정)


    // item와 item_add_option는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemAddOption> itemAddOptions = new ArrayList<>();

    // item와 item_estimation는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemReview> itemReviews = new ArrayList<>();

    // item와 order_item는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    // item와 like_item는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeItem> likeItems = new ArrayList<>();

    // item와 paymentInfo는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentInfo> paymentInfos = new ArrayList<>();

    // item와 supervisor_info는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupervisorInfo> supervisorInfos = new ArrayList<>();

    // item와 item_introduction_image는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemIntroductionImage> itemIntroductionImages = new ArrayList<>();


}
