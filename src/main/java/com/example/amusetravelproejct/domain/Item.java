package com.example.amusetravelproejct.domain;

import com.example.amusetravelproejct.config.resTemplate.CustomException;
import com.example.amusetravelproejct.config.resTemplate.ErrorCode;
import com.example.amusetravelproejct.domain.person_enum.DisplayStatus;
import com.example.amusetravelproejct.domain.person_enum.Grade;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "item")
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                    // db의 고유 Id

    @Column(unique = true)
    private String itemCode;            // 상품 코드
    private String country;             // 나라
    private String city;                // 시 (강원도 까지만 하기로 했습니다!)

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content_1;           // html을 String으로 바꾼 내용 1번째
    @Column(columnDefinition = "LONGTEXT")
    private String content_2;           // html을 String으로 바꾼 내용 2번째 취소 내용

    private Double rated;               // 모든 리뷰들 평점의 평균
    private Integer review_count;
    private Long startPrice;            // 관리자가 정하는 시작 가격
    private Integer duration;           // 기간 (2박 3일 에서 3)

    @ColumnDefault("0") //default 0
    private Integer like_num;           // 좋아요 수
    private Date startDate;             // 상품 게시 날짜 (없어도 됨)
    private Date endDate;               // 상품 내리는 날짜 (없어도 됨)

    @Column(columnDefinition = "LONGTEXT")
    private String adminContent;

    private Long grade;                // 등급 (일반, 프리미엄, VIP)
    private Integer viewCount;          // 조회수
    private DisplayStatus displayStatus; // 상품 노출 여부


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin")
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "update_admin")
    private Admin updateAdmin;

    // item와 category는 N:1 관계 ManyToOne

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemHashTag> itemHashTag_list = new ArrayList<>();

    // item와 ItemImg 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemImg> itemImg_list = new ArrayList<>();

    // item에는 여러개 아이콘 가능
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemIcon> itemIcon_list = new ArrayList<>();

    // item에는 여러개 티켓이 있다.
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemTicket> itemTickets = new ArrayList<>();

    // item와 item_course는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCourse> itemCourses = new ArrayList<>();

    // item와 item_hash_tag는 1:N 관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemHashTag> itemHashTags = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MainPage> mainPages = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemReview> itemReviews = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TargetUser> targetUsers = new ArrayList<>();

    // 로직
    public void plus_like(){
        this.like_num++;
    }

    public void minus_like(){
        this.like_num--;
    }

    private void ensureLikeOver0(){
        if(this.like_num < 0){
            throw new CustomException(ErrorCode.LIKE_UNDER_0);
        }
    }

}
