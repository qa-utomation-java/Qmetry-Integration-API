# Qmetry-Integration-API
This API wraps Qmetry REST APIs to programmatically update test case results to Qmetry.  This API makes it very easy to integrate with Qmetry to publish test results. This would be ideal if you wanted a mechanism to update test results from your automated test scripts. 

Some Steps to execute before you can use the API:
1. Import all dependencies. I used gradle as my build tool and below is how my dependencies block looks: 

dependencies {
    compile group: 'com.sun.jersey', name: 'jersey-client', version: '1.18'
    compile group: 'com.google.code.gson', name: 'gson', version: '2.6.2'
}

2. Go to QmetryServer.java and update the BASEURL to the location where a Qmetry Instance is available. 
3. Go to QmetryPipeLine.java and update the LOGIN_ID, and PASSWORD fields with the credentials you use to access qmetry.  
4. Go to QmetryPipeLineExample.java and run the example to update test results for a test case. 
The method that is used to update a test case result is the following:
QmetryPipeLine.updateTestCaseResult(testSuiteRunId, entityId, testStatus)

testSuiteRunId - when a test suite is linked to a platform, the test suite run id can be retrieved from the Qmetry UI.  
entityId - this is the id of the actual test case
testStatus - available values are QmetryTestCase.PASS, QmetryTestCase.FAIL, QmetryTestCase.NOT_RUN, QmetryTestCase.BLOCKED, QmetryTestCase.NOT_APPLICABE

