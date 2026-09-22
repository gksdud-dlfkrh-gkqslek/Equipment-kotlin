package com.bs.crudkotlin.Entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.checkerframework.checker.units.qual.t
import java.util.UUID

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @Column(length = 36)
    val id: String = UUID.randomUUID().toString(),

    @Column(nullable = true, unique = true)
    var phone: String,

    @Column(nullable = true)
    var password: String? = null,  // 암호화된 비밀번호 저장

    @Column(nullable = false, length = 50)
    var name: String,

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    var role: UserRole = UserRole.USER,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var approvalStatus: ApprovalStatus = ApprovalStatus.PENDING,

    @Column(unique = true, nullable = true)
    var kakaoId: String? = null

)
enum class UserRole {
    USER,   // 일반 사용자
    ADMIN   // 관리자
}
enum class ApprovalStatus {
    PENDING,     // 승인 대기
    APPROVED     // 승인 완료
}