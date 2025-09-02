def call() {
    dir(django-notes-app){
    sh """
       docker run -d -p 8000:8000 notes-app:latest
    """
}}
