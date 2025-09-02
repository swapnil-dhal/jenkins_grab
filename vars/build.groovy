def call() {
    dir(django-notes-app){
    sh '''
        docker build -t notes-app ./django-notes-app
    '''
}
}
