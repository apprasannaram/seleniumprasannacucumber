Fix summary for seleniumprasannacucumber project

1. Rename file named `gitignore` to `.gitignore` at project root.
2. Keep Jenkinsfile at root folder, same level as pom.xml. No extension.
3. Do not commit target/ and .idea/ folders. Remove them from git history/branch if already committed.
4. In Jenkins Pipeline from SCM, configure Branch Specifier as:
   */Feature
   or for all feature branches:
   */feature/*
5. Jenkins machine needs:
   - JDK 21 configured as JDK21 or update Jenkinsfile tool name.
   - Maven configured as Maven or update Jenkinsfile tool name.
   - Chrome installed on the Jenkins agent.
6. Run command used by pipeline:
   mvn clean test -Dbrowser=chrome -Dheadless=true
7. Reports expected:
   - target/surefire-reports/*.xml
   - target/cucumber-reports/cucumber.html
   - target/cucumber-reports/cucumber.json
