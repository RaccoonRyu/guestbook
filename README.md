# Guestbook
Springboot, JPA, Thymeleaf를 사용하여 만드는 미니 방명록 프로젝트입니다.

목차
---
1. [버전정보](#버전정보)
2. [설정가이드](#설정가이드)
3. [실행](#실행)
4. [개발가이드](#개발가이드)

---

## 버전정보

- spring boot 2.5.12
- gradle 7.4.1
- libraries build.gradle 참조

---

## 설정가이드

### IDE 자동완성 대소문자 무시
- Intellij auto complete 대소문자 상관없이 동작 설정
    - File > Settings > Editor > General > Code Completion > Match case 체크해제

### IDE 인코딩설정
- Help > Edit Custom VM Options > -Dfile.encoding=UTF-8 추가 후 저장 / 재실행
- File > Settings > Editor > File Encodings > Global, Project Encoding 전부 UTF-8 설정
- Properties Files 부분도 UTF-8설정 (Transparent native-toascii conversion 체크) > Apply

---

## 실행

Thymeleaf로 간단한 화면을 표시하고 JPA를 사용하여 데이터를 CRUD하는 것이 주 목적이므로
별도의 실행 환경설정 없음

---

## 개발가이드

### 용어
- 한줄주석 : **//작성자 - 용도 및 설명** 형식의 주석

### 주석
- DTO, controller, service interface, dao 에 기본으로 기입
- 기타 라인별로 기입이 필요한 경우 **한줄주석** 사용
- 간편한 기입 방법은 해당 url 참조했음 https://jinsiri.tistory.com/558
```java
    // class, interface template
    /**
     * $class$
     * -
     *
     * @author $user$
     * @created $date$
     */

    // method template
    /**
     * $method$
     * -
     *
     * @author $user$
     * @created $date$
     */
```
### DTO
- DTO 생성시 필드명은 기본적으로 Database Table 컬럼 기준으로 작성 (under_score > camelCase 로 변경)
- Table 외의 추가적인 필드가 필요한 경우 하단에 모아서 정의하고, 한줄주석으로 용도 명시 했음

---