package com.deeplify.tutorial.oauthlogin.api.entity.user;

import com.deeplify.tutorial.oauthlogin.oauth.entity.ProviderType;
import com.deeplify.tutorial.oauthlogin.oauth.entity.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User{
    @JsonIgnore
    @Id
    @Column(name = "user_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name = "user_id", length = 64, unique = true)
  //  @NotNull
    @Size(max = 64)
    private String userId;

    @Column(length = 100)
   // @NotNull
    @Size(max = 100)
    private String username;

    @JsonIgnore
    @Column(length = 128)
  //  @NotNull
    @Size(max = 128)
    private String password;

    @Column(length = 512, unique = true)
   // @NotNull
    @Size(max = 512)
    private String email;

    @Column(name = "email_verified_yn", length = 1)
   // @NotNull
    @Size(min = 1, max = 1)
    private String emailVerifiedYn;

    @Column(name = "profile_image_url", length = 512)
   // @NotNull
    @Size(max = 512)
    private String profileImageUrl;

    @Column(name = "provider_type", length = 20)
    @Enumerated(EnumType.STRING)
    //@NotNull
    private ProviderType providerType;

    @Column(name = "role_type", length = 20)
    @Enumerated(EnumType.STRING)
    //@NotNull
    private RoleType roleType;

    @Column
    private String introduce;

    @Column(name = "created_at")
   // @NotNull
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
  //  @NotNull
    private LocalDateTime modifiedAt;

    public User(
            @NotNull @Size(max = 64) String userId,
            @NotNull @Size(max = 100) String username,
            @NotNull @Size(max = 512) String email,
            @NotNull @Size(max = 1) String emailVerifiedYn,
            @NotNull @Size(max = 512) String profileImageUrl,
            @NotNull ProviderType providerType,
            @NotNull RoleType roleType,
            @NotNull LocalDateTime createdAt,
            @NotNull LocalDateTime modifiedAt
    ) {
        this.userId = userId;
        this.username = username;
        this.password = "NO_PASS";
        this.email = email != null ? email : "NO_EMAIL";
        this.emailVerifiedYn = emailVerifiedYn;
        this.profileImageUrl = profileImageUrl != null ? profileImageUrl : "";
        this.providerType = providerType;
        this.roleType = roleType;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
