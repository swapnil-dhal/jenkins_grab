def call(){
       dir('/home/swapnil/Desktop/django-notes-app') {
           sh '''
                    pwd
                    ls -la
                    docker run -d -p 8000:8000 notes-app:latest
                '''
}
  echo "run completed"
}
