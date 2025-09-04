# Jenkins Shared Library for Docker Operations

A collection of reusable Jenkins shared library functions for Docker-based CI/CD pipelines. These functions simplify Docker operations in Jenkins declarative pipelines by providing standardized methods for building, pushing, and running Docker containers.

## Overview

This shared library contains three core functions that handle the complete Docker workflow:
- **dockerBuild**: Build Docker images from Dockerfile
- **dockerPush**: Tag and push images to Docker registry
- **dockerRun**: Deploy containers from built images

## Functions

### dockerBuild.groovy
Builds a Docker image from the current directory's Dockerfile.

**Parameters:**
- `appname` (String): Name of the application/image
- `appversion` (String): Version tag for the image

**Usage:**
```groovy
dockerBuild('my-app', '1.0.0')
```

**What it does:**
- Executes `docker build` command with specified name and version
- Uses current directory (`.`) as build context

### dockerPush.groovy
Tags and pushes Docker image to a Docker registry (Docker Hub).

**Parameters:**
- `credentialsId` (String): Jenkins credentials ID for Docker registry authentication
- `appname` (String): Name of the application/image
- `appversion` (String): Version tag for the image

**Usage:**
```groovy
dockerPush('docker-hub-credentials', 'my-app', '1.0.0')
```

**What it does:**
- Securely retrieves Docker credentials from Jenkins
- Logs into Docker registry
- Tags the local image with registry username
- Pushes the tagged image to registry

### dockerRun.groovy
Runs a Docker container from the specified image.

**Parameters:**
- `appname` (String): Name of the application/image
- `appversion` (String): Version tag for the image

**Usage:**
```groovy
dockerRun('my-app', '1.0.0')
```

**What it does:**
- Runs container in detached mode (`-d`)
- Maps container port 8000 to host port 8000
- Suitable for web applications running on port 8000

## Setup Instructions

### 1. Jenkins Configuration
1. Go to **Manage Jenkins** → **Configure System**
2. Scroll to **Global Pipeline Libraries**
3. Add a new library with:
   - **Name**: `jenkins-docker-lib` (or your preferred name)
   - **Default version**: `main` (or your default branch)
   - **Retrieval method**: Modern SCM → Git
   - **Source Code Management**: Add your repository URL

### 2. Credentials Setup
Create Jenkins credentials for Docker registry:
1. Go to **Manage Jenkins** → **Credentials**
2. Add **Username with password** credential
3. Set ID (e.g., `docker-hub-credentials`)
4. Enter your Docker Hub username and password/token

## Pipeline Example

```groovy
@Library('jenkins-docker-lib') _

pipeline {
    agent any
    
    environment {
        APP_NAME = 'django-notes-app'
        APP_VERSION = "${BUILD_NUMBER}"
        DOCKER_CREDENTIALS = 'docker-hub-credentials'
    }
    
    stages {
        stage('Build') {
            steps {
                // Your build steps here
                echo 'Building application...'
            }
        }
        
        stage('Docker Build') {
            steps {
                dockerBuild("${APP_NAME}", "${APP_VERSION}")
            }
        }
        
        stage('Docker Push') {
            steps {
                dockerPush("${DOCKER_CREDENTIALS}", "${APP_NAME}", "${APP_VERSION}")
            }
        }
        
        stage('Deploy') {
            steps {
                dockerRun("${APP_NAME}", "${APP_VERSION}")
            }
        }
    }
}
```

## Features

- **Secure credential handling** using Jenkins credentials manager
- **Reusable functions** across multiple pipelines
- **Simple parameter-based configuration**

## Requirements

- Jenkins with Pipeline plugin
- Docker installed on Jenkins agents
- Docker registry credentials configured in Jenkins
- Applications with valid Dockerfile in repository root

## Notes

- The `dockerRun` function is configured for applications running on port 8000
- Modify port mappings in `dockerRun.groovy` if your application uses different ports
- Ensure your Jenkins agents have Docker daemon running


## Related Repository

This shared library is used in conjunction with: [Django Notes App CI/CD Pipeline](https://github.com/swapnil-dhal/django-notes-app)
