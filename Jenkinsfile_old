 pipeline {

    agent any

	triggers {
	     pollSCM('H/3 * * * *')
	}   
    environment {
        PROXY_CRED = credentials('PROXY_CREDENTIALS')
    }

	post {
		unsuccessful {
			mail to: 'igor.santos@philips.com',
			subject: "Completed Pipeline: ${currentBuild.fullDisplayName}",
			body: "The TIE build was completed with errors, please check: ${env.BUILD_URL}"
		}
	}    

    stages {
        stage("Build") {
            steps {
                sh "chmod +x gradlew"
                sh "./gradlew -Dhttp.proxyHost=${env.HTTP_PROXY_HOST} -Dhttp.proxyPort=${env.HTTP_PROXY_HOST_PORT} -Dhttps.proxyHost=${env.HTTPS_PROXY_HOST} -Dhttps.proxyPort=${env.HTTPS_PROXY_HOST_PORT} -Dhttps.proxyUser=$PROXY_CRED_USR -Dhttps.proxyPassword=$PROXY_CRED_PSW  -Dhttp.proxyUser=$PROXY_CRED_USR -Dhttp.proxyPassword=$PROXY_CRED_PSW -Dhttp.nonProxyHosts=${env.NON_PROXY_HOSTS} compileJava"
            }
        }
        stage("Unit Tests"){ 
            steps{
                sh "./gradlew test"
            }
        }
	    stage("Code coverage") {
			steps {
				sh "./gradlew jacocoTestReport"
					publishHTML (target: [
						reportDir: 'build/reports/jacoco/test/html',
						reportFiles: 'index.html',
						reportName: "JaCoCo Report"	])
				sh "./gradlew jacocoTestCoverageVerification"
			}
		}
		stage("Static code analysis") {
			steps {
				publishHTML (target: [
					reportDir: 'build/reports/checkstyle/',
					reportFiles: 'main.html',
					reportName: "Checkstyle Report"])				
				sh "./gradlew checkstyleMain"
			}
		}		
	}
}