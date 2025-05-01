
# 🧱 Hexagonal Architecture - Spring Boot Boilerplate

> A lightweight, extensible template for building clean, testable Spring Boot applications based on **Hexagonal (Ports & Adapters) Architecture**.

---

## 📐 Overview

This repository provides a foundational structure for backend applications with strong architectural boundaries.

✅ Designed for **clarity**, **testability**, and **separation of concerns**  
✅ Easily extendable to support REST APIs, JWT authentication, database interaction, etc.  
✅ Ideal for teams adopting **DDD** or **clean architecture** principles

---

# 🧱 헥사고날 아키텍처 - Spring Boot 보일러플레이트

> 이 프로젝트는 Hexagonal Architecture (포트 & 어댑터 구조)를 기반으로 설계된 Spring Boot 백엔드 템플릿입니다.  
> **도메인 주도 설계(DDD)**, **관심사의 분리**, **테스트 용이성**을 중심으로, 확장 가능하고 유지보수가 쉬운 구조를 제공합니다.

---

## ✨ 주요 특징

- ✅ 도메인 로직과 어댑터 간 **명확한 아키텍처 경계**
- ✅ **REST API**, **JWT 인증**, **JPA 기반 DB 연동** 등 기능 확장에 용이
- ✅ **작은 규모의 프로젝트부터 엔터프라이즈 환경까지** 적용 가능

---


## 📁 Project Structure

```plaintext
src
└── main
    ├── java
    │   └── com.seouitech.user
    │       ├── adapter
    │       │   ├── in
    │       │   │   ├── config
    │       │   │   │   ├── SecurityConfig
    │       │   │   │   └── WebConfig
    │       │   │   ├── security
    │       │   │   │   └── JwtAuthenticationFilter
    │       │   │   └── web
    │       │   │       ├── controller
    │       │   │       │   ├── AuthController
    │       │   │       │   └── MemberController
    │       │   │       ├── dto
    │       │   │       │   ├── request //Some dtos using http request
    │       │   │       │   └── response //Some dtos using http response
    │       │   │       ├── handler
    │       │   │       │   ├── ErrorResponse
    │       │   │       │   └── GlobalExceptionHandler
    │       │   │       └── resolver
    │       │   │           ├── CurrentUserEmail
    │       │   │           └── CurrentUserEmailResolver
    │       │   └── out
    │       │       ├── exception
    │       │       │   └── InvalidTokenException
    │       │       ├── persistence
    │       │       │   ├── MemberJpaEntity
    │       │       │   ├── MemberJpaRepository
    │       │       │   └── MemberRepositoryAdapter
    │       │       └── security
    │       │           └── JwtProvider
    │       └── config
    │           └── BeanConfig
    └── domain
        ├── exceptions
        │   └── MemberNotFoundException
        ├── model
        │   ├── Member
        │   └── TokenBundle
        ├── port
        │   ├── in
        │   │   ├── AuthUseCase
        │   │   └── MemberUseCase
        │   └── out
        │       ├── JwtPort
        │       └── MemberRepository
        ├── service
        │   ├── command
        │   │   ├── CreateMemberCommand
        │   │   └── LoginCommand
        │   ├── policy
        │   │   └── PasswordPolicy
        │   ├── AuthService
        │   └── MemberService
        └── UserApplication
resources
├── static
├── templates
└── application.properties
```


## 🧱 Architecture

This project follows the **Hexagonal (Clean) Architecture**:


## 🛠 Tech Stack

- **Spring Boot 3.x.x**
- **Spring Security 6.x**
- **JPA (Hibernate)**
- **JWT (io.jsonwebtoken)**
- **Hexagonal Architecture**
- **Lombok**
- **Gradle**


## ✨ Features

- [x] 회원가입 및 로그인 (`/api/v1/auth`)
- [x] 간단한 유저 기능 (`/api/v1/members`)
- [x] JWT Access + Refresh 토큰 발급
- [x] JWT 기반 인증 필터
- [x] `@CurrentUserEmail` 커스텀 어노테이션으로 유저식별
- [x] 예외 처리: GlobalExceptionHandler
- [x] 도메인 중심 설계 및 예외 정의
- [x] `.gitignore`, `.properties`, 프로젝트 분리 구조


## 🛠️ Sample application.properties
```
# 📛 애플리케이션 이름
spring.application.name=hex-user

# 🗄️ 데이터베이스 연결 설정
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/your-db
spring.datasource.username=root
spring.datasource.password=your-password

# 🛠️ JPA Setting
spring.jpa.hibernate.ddl-auto=update         
spring.jpa.show-sql=true                    
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.show_sql=true

# 🧪 Spring Security Log Level(Optional)
logging.level.org.springframework.security=TRACE

# 🔐 JWT Setting
jwt.access-secret=YOUR_SECRET_ACCESS_KEY
jwt.refresh-secret=YOUR_SECRET_REFRESH_KEY
jwt.access-expiration-ms=86400000           
jwt.refresh-expiration-ms=604800000
```
## 🚀 Getting Started

```bash
# Clone the project
git clone https://github.com/Ezcho/hex-user.git

# Fill in secret keys in application.properties
vi src/main/resources/application.properties

# Build & run
./gradlew build
```

---

## 👤 Developer
#### 조동영(Ezcho): Seoultech, Computer Science, Seoul, Republic of Korea

Hexagonal Architecture 기반의 클린하고 유지보수 쉬운 Spring Boot 구조를 추구하며,  
실용적인 템플릿을 통해 팀과 개인 모두에게 도움이 되고자 이 프로젝트를 개발하였습니다.
누구나 자유롭게 포크하거나 개선해주시길 환영합니다

> 📬 이메일: ezcho886@naver.com  
> 💼 GitHub: [@ezcho](https://github.com/ezcho)  
