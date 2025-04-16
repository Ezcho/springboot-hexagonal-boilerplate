# hex-user
User service based on hexagonal architecture

## SpringBoot에서 사용되는 Hexagonal Architecture 기반 유저관리 보일러 플레이트
**Hexagonal Architecture 기반 유저 관리 시스템**

> 도메인 순수성과 계층 간 분리를 강조한 구조적 백엔드 설계 예제입니다.  
> 유저 등록, 조회 등의 기본 기능을 바탕으로 도메인 주도 설계 감각을 훈련할 수 있습니다.

---

## 📁 프로젝트 구조
hex-user/ 
  ├── domain/ # 순수 도메인 모델, 포트, 유스케이스 
        │ 
        ├── model/ 
        │ 
        ├── port/ 
              │ 
              │ 
              ├── in/ 
              │ 
              │ 
              └── out/ 
              │ 
              └── service/ 
  ├── adapter/ 
        │ 
        ├── in/ 
        │ 
        │ 
        └── web/ # Controller, DTO, ExceptionHandler 
        │ 
        └── out/
        │ 
        └── persistence/ # JPA Entity, Repository Adapter 
        ├── config/ # 설정 (BeanConfig 등) 
  └── application/ # Application 실행 진입점

  
---

## 🚀 주요 기능

- 회원 등록 (이메일 + 비밀번호)
- 회원 목록 조회
- 비밀번호 유효성 정책 (길이, 조합, 특수문자 등)
- 글로벌 예외 처리 (`@RestControllerAdvice`)
- 계층 간 의존성 분리 (Hexagonal 구조 기반)

---

## 🔧 기술 스택

- Java 17
- Spring Boot 3.x
- Gradle
- JPA (Hibernate)
- MySQL
- Lombok
- Validation API (JSR 380)
- (선택) SpringDoc OpenAPI

---

## 🔒 비밀번호 정책

- 길이: 8~16자
- 영문 대문자, 소문자, 숫자, 특수문자 **각 1자 이상 포함**
- 공백 문자 불가
- (추후 연속 문자 제한, 금지 단어 포함 금지 등 확장 가능)



