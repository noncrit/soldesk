package com.kim.jul041.main;

import com.kim.http.client.HttpClient;

/*
Java
개발자들이 본인이 만들어 놓은 것들을 공유
단, 소스 코드 자체가 아닌 .jar 파일을 만들어서 공유
.jar 파일을 자동으로 관리해주는 시스템 : Maven
Maven 중앙 저장소 : Maven Repository

Maven 중앙 저장소의 .jar 파일을 컴퓨터의 Maven 로컬 저장소 : C:\Users\[사용자명].m2\repository

Maven 중앙 저장소에 없는 것들 : 로컬 저장소에 직접 저장!

Maven 새로고침 - Maven Repositories - Repository 우클릭 후 rebuild index

Mavn 사설 저장소에 우리만 가진 라이브러리를 등록 해보려함
프로젝트 우클릭 - import - maven 검색 - install or deploy 클릭
Browse -> 등록할 라이브러리 넣기 => Group id, Artifact id 설정 ( 추후 넣어둔 라이브러리 검색을 위한 인덱스 설정 ), 버전은 마음대로
Packaging = .jar
pom.xml 클릭 => dependencies 클릭 => add => Artifact Id 로 검색 => 선택 후 프로젝트에 추가

Maven Error
이클립스 종료 - 로컬 저장소 아예 지우기 - 이클립스 재시동 - 로컬에만 있던 개인 라이브러리 파일 다시 넣어주기

오늘부터 이클립스 재시동 할 때 꼭 해야하는 것(이클립스 켜기 전)
Spring workspace - .metadata/.plugin/.org.eclipse.org.eclipse.datatools.sqltools.result 폴더를 삭제
그 후에 이클립스 켜기

 */


public class MMain {
	HttpClient hc;
}
