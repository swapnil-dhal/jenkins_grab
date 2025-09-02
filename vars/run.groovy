def call() {
    sh """
       docker run -d -p 8000:8000 notes-app:latest
    """
}
