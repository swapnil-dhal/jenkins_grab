def call(String containerName = 'notes-app-container', String port = '8000') {
    sh """
       docker run -d -p 8000:8000 notes-app:latest
    """
}
