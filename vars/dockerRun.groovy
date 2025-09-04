def call(appname, appversion) {
    sh """
        docker run -d -p 8000:8000 ${appname}:${appversion}
    """
}
