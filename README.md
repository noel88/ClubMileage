## Club Mileage

---

- 리뷰에 따라 사용자의 포인트가 부여되는 API입니다.

#### Review
- 리뷰를 등록할 수 있습니다.
- 리뷰를 수정할 수 있습니다.
- 리뷰를 삭제할 수 있습니다.

#### Mileage
- 사용자의 현재 마일리지를 조회할 수 있습니다.


### Prerequisites
- Gradle 실행 시,
  - `Database`가 반드시 설정되어 있어야 합니다. (postgresql 13)
  - `Database` 주소는 `resouces > application.yml`를 참고해주세요.
- Docker-compose 실행 시,
  - `docker`가 설치되어 있어야 합니다.
  - `docker-compose`가 설치되어 있어야 합니다.

### Getting Started

---

#### Gradle

```
git clone https://github.com/your/your-project.git
cd your-project
./gradlew bootrun
```

#### Docker-compose

- 해당 프로젝트 Root 경로에서 아래의 `Command`를 실행해주세요.

```
git clone https://github.com/your/your-project.git
cd your-project
docker-compose up -d
```

### Usage

---

- 자세한 내용은 프로젝트 실행 후 [문서](http://localhost:9900/swagger-ui.html)를 참고하세요. 
