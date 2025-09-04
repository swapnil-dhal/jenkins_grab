def call(credentialsId, appname, appversion) {
    withCredentials([usernamePassword(credentialsId: credentialsId, 
                                     usernameVariable: 'DOCKER_USER', 
                                     passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            docker tag ${appname}:${appversion} \$DOCKER_USER/${appname}:${appversion}
            docker push \$DOCKER_USER/${appname}:${appversion}
        """
    }
}
