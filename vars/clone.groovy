def call() {
     echo "Cloning repository..."
    sh "git clone https://github.com/swapnil-dhal/django-notes-app.git"
     sh 'docker build -t notes-app .'
     sh 'docker run -d -p 8000:8000 notes-app:latest'
}
