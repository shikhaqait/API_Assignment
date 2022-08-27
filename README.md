# API_Assignment

## Getting started
JAVA version : 1.8 or above
Maven version : 3.3 or above

## How to run test case
### To run all test cases
mvn clean test

### To run on local/specific URL
mvn clean test -Durl=<url>
for e.g. || for local server
mvn clean test -Durl=http://localhost:3000/

### For debug logs
mvn clean test -Ddebug=true

### For Report
Go to target > Surefire-reports > emailable-report.html

### For log file
Go to target > logs.log