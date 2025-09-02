def call(){

         dir('/home/swapnil/Desktop/django-notes-app') {
           sh '''
                    pwd
                    ls -la
                    docker build -t notes-app .
                '''
}
}
