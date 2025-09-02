def call() {
    sh '''
        echo "=== Starting Build Process ==="
        
        echo "=== Current Directory ==="
        pwd
        
        echo "=== Directory Contents ==="
        ls -la
        
        echo "=== Checking for Dockerfile ==="
        if [ -f "Dockerfile" ]; then
            echo "Dockerfile found, proceeding with build..."
            
            echo "=== Building Docker Image ==="
            docker build -t notes-app .
            
            echo "=== Build completed successfully ==="
            docker images | grep notes-app
        else
            echo "ERROR: Dockerfile not found!"
            echo "Available files:"
            find . -type f -name "*" | head -20
            exit 1
        fi
    '''
}
