def call(appname, appversion) {
    sh """
        docker build -t ${appname}:${appversion} .
    """
}
