def call(String repoUrl = 'https://github.com/swapnil-dhal/django-notes-app.git', String branch = 'main') {
    sh """
        echo "=== Cloning Django Application from GitHub ==="
        git clone -b ${branch} ${repoUrl} .
        
        echo "=== Repository cloned successfully ==="
        ls -la
        
        echo "=== Git information ==="
        git log --oneline -5
    """
}
