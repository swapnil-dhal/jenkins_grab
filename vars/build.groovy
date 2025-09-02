def call() {
    dir('django-notes-app'){
    sh '''
    ls -a
        docker build -t notes-app .
    '''
}
}
