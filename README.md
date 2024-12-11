## Hexagonal Architecture with CQRS Pattern Sample

### 🚀 배경 

- Nettee 백엔드 팀의 프로젝트 방향성을 결정하기 위해 샘플 코드를 작성
- 헥사고날 아키텍처의 의미 수준과 구현 수준에 고찰을 하기 위함

### 📖 목차

1. [🧐 잠깐만 아키텍처가 뭔데?](#🧐잠깐만-아키텍처가-뭔데?)
2. [1️⃣ Hexagonal Architecture에 대해](#1️⃣-hexagonal-architecture에-대해)
3. [2️⃣ CQRS 패턴에 대해](#2️⃣-cqrs-패턴에-대해)   
4. [3️⃣ 폴더 구조](#3️⃣-폴더-구조)

### 🧐잠깐만 아키텍처가 뭔데?

'**Architecture**' 의 영단어 뜻은 ’건축학‘ 이라는 뜻을 가지며, 대한민국에서는 건축학을 그냥 건축학이라 부르지 영어로 잘 사용하지는 않는다. 

그에 반해, 아키텍처란 말은 IT 분야에 자주 쓰이는 용어다. 사전적 정의로 나무위키에 따르면 다음과 같다.

```
목표 대상의 구성과 동작 원리, 구성 요소 간의 관계 및 시스템 외부 환경과의 관계를 설명하는 설계도 - 출처 namuwiki
```

단순히 `목적성을 가진 설계`라고 생각하면 좋을 것 같다. IT에서는 `시스템`이란 단어가 너무 추상적이기에 보다 구체적인 `인간의 몸`을 생각해도 좋다.

인간이 걷고자 한다면 인간의 몸은 다리, 뼈, 근육, 신경 등의 구성 요소가 서로 유기적으로 연결되어야 걸을 수 있다. 신경과   

### 1️⃣ Hexagonal Architecture에 대해


### 2️⃣ CQRS 패턴에 대해


### 3️⃣ 폴더 구조 

- SRC 폴더 구조

```
├─main
│  ├─java
│     └─com
│         └─nettee
│             ├─adapter
│             │  ├─in
│             │  │  └─web
│             │  │      └─board
│             │  │          └─dto
│             │  ├─mapper
│             │  └─out
│             │      └─persistence
│             │          └─board
│             └─application
│                 ├─domain
│                 │  ├─board
│                 │  └─common
│                 ├─port
│                 ├─service
│                 └─usecase
```
