def call() {
    sh """
        echo "=== Starting Clone Process ==="
        pwd
        echo "Current directory contents before clone:"
        ls -la
        
        echo "Removing existing directory..."
        rm -rf django-notes-app
        
        echo "Cloning repository..."
        git clone https://github.com/swapnil-dhal/django-notes-app.git
        
        echo "Verifying clone success..."
        if [ -d "django-notes-app" ]; then
            echo "✅ Clone successful!"
            echo "Contents of django-notes-app:"
            ls -la django-notes-app/
        else
            echo "❌ Clone failed!"
            exit 1
        fi
        echo "=== Clone Process Complete ==="
    """
}
