# SW Java DevOps Practice

Java DevOps 실습 프로젝트입니다.

## 실습 내용

- Eclipse에서 Java 프로젝트 작성
- EGit을 이용한 GitHub 연동
- Branch 생성, Commit, Push, Pull Request, Merge 수행
- Jenkins와 GitHub Webhook 연동
- GitHub Push 발생 시 Jenkins Pipeline 자동 빌드
- JUnit 테스트 결과를 Jenkins Artifact로 저장
- 빌드 성공 또는 실패 시 이메일 알림 전송

## Tools

- Java
- Eclipse IDE
- EGit
- GitHub
- Jenkins
- Docker Desktop
- ngrok
- JUnit 5

## Jenkins Pipeline Stages

1. Checkout
2. Prepare
3. Build
4. Test
5. Post Actions

빌드 성공 시 JUnit 테스트 결과와 `test-output.txt`가 Jenkins Artifact로 저장됩니다.  
또한 Jenkins 이메일 설정이 완료된 경우 빌드 성공 또는 실패 결과가 이메일로 전송됩니다.

**테스팅**