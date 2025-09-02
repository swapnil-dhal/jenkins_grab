def call(String containerName = 'notes-app-container', String port = '8000') {
    sh """
        echo "=== Starting Application ==="
        
        echo "=== Checking if container already exists ==="
        if docker ps -a | grep -q ${containerName}; then
            echo "Stopping and removing existing container..."
            docker stop ${containerName} || true
            docker rm ${containerName} || true
        fi
        
        echo "=== Running Docker Container ==="
        docker run -d --name ${containerName} -p ${port}:8000 notes-app
        
        echo "=== Container started successfully ==="
        docker ps | grep notes-app
        
        echo "=== Application should be available at: ==="
        echo "http://localhost:${port}"
        echo "http://\$(hostname -I | awk '{print \$1}'):${port}"
        
        echo "=== Container logs (first 10 lines) ==="
        sleep 3
        docker logs ${containerName} | head -10 || true
    """
}
