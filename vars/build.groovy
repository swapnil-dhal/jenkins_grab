def call() {
    sh '''
            docker build -t notes-app .
    '''
}
