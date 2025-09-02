def call() {
    sh """
        echo "Starting clone process..."
        rm -rf django-notes-app
        git clone https://github.com/swapnil-dhal/django-notes-app.git
        ls -la django-notes-app/
    """
}
