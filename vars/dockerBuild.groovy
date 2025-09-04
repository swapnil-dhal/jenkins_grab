def dockerBuild(appname, appversion) {
    sh """
        docker build -t ${appname}:${appversion} .
    """
}
