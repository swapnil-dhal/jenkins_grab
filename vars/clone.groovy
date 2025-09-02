def call() {
     echo "Cloning repository..."
    sh "git clone https://github.com/swapnil-dhal/django-notes-app.git"
     sh 'docker build -t notes-app .'
}
