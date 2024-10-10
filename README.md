# 콘서트 예약 서비스

---

## 프로젝트 마일스톤

### 1주차
![1 주차 프로젝트 마일스톤](/image/milestone_first_week.png)

---

## [시퀀스 다이어그램](https://github.com/m5s3/consert-reservation/wiki/시퀀스-다이어그램)

---

## API 명세서
[API 명세서](https://github.com/m5s3/consert-reservation/wiki)

---

## 기본 패키지 구조
```
api/
  도메인/
    controller
      dto/
		  (request, response models)
	  usecase/
		  (Usecase = 각 비즈니스에 맞춰 component 조립)
domain/
	도메인/
		(Models)
		(Components)
		(Repositories)
		infrastructure/
```