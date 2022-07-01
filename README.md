## Club Mileage

---

- Review 작성 후, 이벤트에 따라 사용자의 마일리지가 부여되거나 차감됩니다.
- 사용자의 포인트도 조회할 수 있습니다.

### Prerequisites
- Local Gradle 실행 시,
  - `Database`가 반드시 설정되어 있어야 합니다. (mysql 5.7 이상)
  - `Database` URL는 `resouces > application.yml`를 참고해주세요.
- Docker-compose 실행 시,
  - `docker`가 설치되어 있어야 합니다.
  - `docker-compose`가 설치되어 있어야 합니다.

### Getting Started

---

#### Gradle

```
git clone https://github.com/noel88/ClubMileage.git
cd ClubMileage
./gradlew bootrun
```

#### Docker-compose

```
git clone https://github.com/noel88/ClubMileage.git
cd ClubMileage
./gradlew assemble
docker-compose up -d --build
```

### Usage

---

- 자세한 내용은 프로젝트 실행 후 [문서](http://localhost:9900/swagger-ui.html)를 참고하세요. 
