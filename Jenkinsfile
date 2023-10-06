 pipeline {

    agent any
    environment {
        PROXY_CRED = credentials('PROXY_CREDENTIALS')
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
    }
}